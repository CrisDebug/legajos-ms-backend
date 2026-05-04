package com.software.microservicio_legajo_backend.dto;

import java.time.LocalDateTime;

/**
 * DTO para recibir datos al crear o actualizar un Legajo.
 */
public class LegajoRequestDTO {

    private Long manualId;
    private String descripcionLegajo;
    private Long casilleroId;
    private LocalDateTime fechaInicioLegajo;
    private LocalDateTime fechaFinLegajo;

    public LegajoRequestDTO() {
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
}