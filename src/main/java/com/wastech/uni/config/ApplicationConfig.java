package com.wastech.uni.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Configuración central de la aplicación Wastech.
 *
 * Esta clase contiene beans de infraestructura reutilizables por toda la aplicación.
 * Se irá expandiendo a medida que se implemente la seguridad, MQTT y otras integraciones.
 *
 * TODO (próximos sprints):
 *  - Agregar configuración de MQTT
 *  - Agregar configuración de JWT
 *  - Agregar beans de mapeo (ModelMapper / MapStruct)
 */
@Configuration
public class ApplicationConfig {

    /**
     * Bean de BCrypt para el hasheo de contraseñas.
     * Disponible como dependencia inyectable en toda la aplicación.
     * Se utilizará en el sprint de implementación de login.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
