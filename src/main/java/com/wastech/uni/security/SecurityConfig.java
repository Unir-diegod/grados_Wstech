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

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomUserDetailsService customUserDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                // Recursos estáticos públicos
                .requestMatchers("/css/**", "/js/**", "/images/**", "/webjars/**").permitAll()
                // Rutas públicas para recuperación de contraseña
                .requestMatchers("/forgot-password", "/forgot-password/**", "/reset-password", "/reset-password/**").permitAll()
                .requestMatchers("/registro", "/registro/**").permitAll()
                // Control de roles
                .requestMatchers("/admin/**").hasRole("ADMINISTRADOR")
                .requestMatchers("/cliente/**").hasAnyRole("ADMINISTRADOR", "CLIENTE")
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
            // Deshabilitar CSRF temporalmente si fuera necesario, pero en Thymeleaf viene activado por defecto y funciona bien
            .csrf(csrf -> csrf.disable()); 

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
