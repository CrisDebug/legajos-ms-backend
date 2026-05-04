package com.software.microservicio_legajo_backend.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class CasilleroClient {

    private final WebClient webClient;

    public CasilleroClient(WebClient casilleroWebClient) {
        this.webClient = casilleroWebClient;
    }

    public boolean existeCasillero(Long id) {
        try {
            webClient.get()
                    .uri("/casilleros/{id}", id)
                    .retrieve()
                    .toBodilessEntity()
                    .block();

            return true;

        } catch (Exception e) {
            return false;
        }
    }
}