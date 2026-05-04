package com.software.microservicio_legajo_backend.config;

import com.software.microservicio_legajo_backend.security.JwtFilter;
import com.software.microservicio_legajo_backend.security.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // 🔐 Bean utilitario para validar tokens JWT (misma SECRET_KEY que Usuarios)
    @Bean
    public JwtUtil jwtUtil() {
        return new JwtUtil();
    }

    // 🛡️ Bean del filtro que intercepta requests y valida Bearer Token
    @Bean
    public JwtFilter jwtFilter(JwtUtil jwtUtil) {
        return new JwtFilter(jwtUtil);
    }

    // ⚙️ Configuración principal de seguridad
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, JwtFilter jwtFilter) throws Exception {

        return http
                // ❌ desactiva CSRF porque no usamos sesión, sino JWT stateless
                .csrf(csrf -> csrf.disable())

                // 🚫 no queremos sesiones (evita JSESSIONID)
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                // ❌ desactivar login por formulario (si no, Spring intenta generar sesión)
                .formLogin(form -> form.disable())

                // ❌ desactivar basic auth (si no, Spring puede pedir credenciales)
                .httpBasic(basic -> basic.disable())

                // 🛡️ reglas de acceso
                .authorizeHttpRequests(auth -> auth

                        // 🌍 endpoints públicos opcionales
                        .requestMatchers("/api/public/**").permitAll()

                        // 🔐 proteger endpoints de legajos
                        .requestMatchers("/legajos/**").authenticated()

                        // 🔒 cualquier otro endpoint también requiere token
                        .anyRequest().authenticated()
                )

                // 🔥 registrar el filtro JWT antes del filtro default de Spring
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)

                .build();
    }
}