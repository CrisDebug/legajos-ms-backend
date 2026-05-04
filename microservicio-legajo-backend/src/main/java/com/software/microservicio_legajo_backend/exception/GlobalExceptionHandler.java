package com.software.microservicio_legajo_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Manejador global de excepciones para toda la aplicación.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Maneja cuando un recurso no existe (ejemplo: Legajo no encontrado).
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> manejarResourceNotFound(ResourceNotFoundException ex) {

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("timestamp", LocalDateTime.now());
        respuesta.put("status", HttpStatus.NOT_FOUND.value());
        respuesta.put("error", "NOT FOUND");
        respuesta.put("message", ex.getMessage());

        return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);
    }

    /**
     * Manejo genérico de cualquier otro error inesperado.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> manejarErroresGenerales(Exception ex) {

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("timestamp", LocalDateTime.now());
        respuesta.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        respuesta.put("error", "INTERNAL SERVER ERROR");
        respuesta.put("message", ex.getMessage());

        return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}