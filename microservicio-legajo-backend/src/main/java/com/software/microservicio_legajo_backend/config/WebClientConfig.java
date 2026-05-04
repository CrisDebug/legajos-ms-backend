package com.software.microservicio_legajo_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class WebClientConfig {

    @Bean
    public WebClient casilleroWebClient() {
    return WebClient.builder()
            .baseUrl("http://casilleros-service:8082")
            .build();
    }
    // @Bean
    // public WebClient casilleroWebClient() {
    //     return WebClient.builder()
    //             .baseUrl("http://localhost:8082")
    //             .build();
    // }
}