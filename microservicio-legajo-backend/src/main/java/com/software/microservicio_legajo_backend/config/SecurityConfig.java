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
import org.springframework.web.cors.CorsConfiguration;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import java.util.List;

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
                
                
                //cors security
                        .cors(cors -> cors.configurationSource(corsConfigurationSource()))

                // 🛡️ reglas de acceso
                .authorizeHttpRequests(auth -> auth

                        // 🌍 endpoints públicos opcionales
                        .requestMatchers("/api/public/**").permitAll()

                        // 🔐 proteger endpoints de legajos
                        .requestMatchers("/api/legajos/**").authenticated()

                        // 🔒 cualquier otro endpoint también requiere token
                        .anyRequest().authenticated()
                        
                )

                // 🔥 registrar el filtro JWT antes del filtro default de Spring
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)

                .build();
    }
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowedOriginPatterns(List.of("*")); // Angular
        configuration.setAllowedMethods(List.of("GET","POST","PUT","DELETE","OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(false);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}