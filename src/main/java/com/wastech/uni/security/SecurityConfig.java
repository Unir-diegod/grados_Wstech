package com.wastech.uni.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomUserDetailsService customUserDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                // Recursos estáticos públicos
                .requestMatchers("/css/**", "/js/**", "/images/**", "/img/**", "/webjars/**").permitAll()
                // Rutas públicas para recuperación de contraseña y APIs
                .requestMatchers("/api/auth/login").permitAll()
                .requestMatchers("/forgot-password", "/forgot-password/**", "/reset-password", "/reset-password/**").permitAll()
                .requestMatchers("/registro", "/registro/**").permitAll()
                // Control de roles
                .requestMatchers("/admin/**").hasRole("ADMINISTRADOR")
                .requestMatchers("/cliente/**").hasAnyRole("ADMINISTRADOR", "CLIENTE")
                // Rutas de API protegidas
                .requestMatchers("/api/sensores/lectura").authenticated()
                .requestMatchers("/api/protected").authenticated()
                .requestMatchers("/api/**").authenticated()
                // Todas las demás rutas requieren autenticación
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")          // Ruta personalizada para el formulario
                .loginProcessingUrl("/login") // Ruta a la que se hace POST (la maneja Spring Security)
                .defaultSuccessUrl("/dashboard", true) // A dónde redirigir al entrar exitosamente
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout") // A dónde redirigir al salir
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
            )
            .exceptionHandling(eh -> eh
                .authenticationEntryPoint((request, response, authException) -> {
                    String uri = request.getRequestURI();
                    if (uri.contains("/api/sensores/lectura")) {
                        response.setStatus(jakarta.servlet.http.HttpServletResponse.SC_UNAUTHORIZED); // 401 Unauthorized
                        response.setContentType("application/json;charset=UTF-8");
                        response.getWriter().write("{\"error\": \"Unauthorized - Token JWT no provisto o expirado\"}");
                    } else if (uri.contains("/api/protected")) {
                        response.setStatus(jakarta.servlet.http.HttpServletResponse.SC_FORBIDDEN); // 403 Forbidden
                        response.setContentType("application/json;charset=UTF-8");
                        response.getWriter().write("{\"error\": \"Forbidden - No tienes acceso a este recurso protegido\"}");
                    } else if (uri.startsWith("/api/")) {
                        response.setStatus(jakarta.servlet.http.HttpServletResponse.SC_UNAUTHORIZED); // 401 Unauthorized standard
                        response.setContentType("application/json;charset=UTF-8");
                        response.getWriter().write("{\"error\": \"Unauthorized\"}");
                    } else {
                        response.sendRedirect("/login");
                    }
                })
            )
            .csrf(csrf -> csrf.disable())
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    /**
     * Configura el proveedor de autenticación para que use nuestra BD a través de CustomUserDetailsService.
     */
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(customUserDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);
        return authProvider;
    }
}

