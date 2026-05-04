package com.software.microservicio_legajo_backend.dto;

import java.time.LocalDateTime;

/**
 * DTO para devolver información del Legajo al cliente.
 */
public class LegajoResponseDTO {

    private Long id;
    private Long manualId;
    private String descripcionLegajo;
    private Long casilleroId;
    private LocalDateTime fechaInicioLegajo;
    private LocalDateTime fechaFinLegajo;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public LegajoResponseDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getManualId() {
        return manualId;
    }

    public void setManualId(Long manualId) {
        this.manualId = manualId;
    }

    public String getDescripcionLegajo() {
        return descripcionLegajo;
    }

    public void setDescripcionLegajo(String descripcionLegajo) {
        this.descripcionLegajo = descripcionLegajo;
    }

    public Long getCasilleroId() {
        return casilleroId;
    }

    public void setCasilleroId(Long casilleroId) {
        this.casilleroId = casilleroId;
    }

    public LocalDateTime getFechaInicioLegajo() {
        return fechaInicioLegajo;
    }

    public void setFechaInicioLegajo(LocalDateTime fechaInicioLegajo) {
        this.fechaInicioLegajo = fechaInicioLegajo;
    }

    public LocalDateTime getFechaFinLegajo() {
        return fechaFinLegajo;
    }

    public void setFechaFinLegajo(LocalDateTime fechaFinLegajo) {
        this.fechaFinLegajo = fechaFinLegajo;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}