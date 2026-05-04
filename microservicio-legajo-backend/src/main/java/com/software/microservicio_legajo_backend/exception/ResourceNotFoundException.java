package com.software.microservicio_legajo_backend.exception;

/**
 * Excepción personalizada para cuando no se encuentra un recurso en la BD.
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}