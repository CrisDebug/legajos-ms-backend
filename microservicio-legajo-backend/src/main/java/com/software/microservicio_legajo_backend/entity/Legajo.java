package com.software.microservicio_legajo_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Entity que representa la tabla LEGAJO en la base de datos Oracle.
 */
@Entity
@Table(name = "LEGAJO")
public class Legajo {

    /**
     * ID autogenerado (IDENTITY en Oracle).
     * Se mapea con la columna ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Campo manualId (columna MANUAL_ID).
     */
    @Column(name = "MANUAL_ID")
    private Long manualId;

    /**
     * Descripción del legajo (columna DESCRIPCION_LEGAJO).
     */
    @Column(name = "DESCRIPCION_LEGAJO")
    private String descripcionLegajo;

    /**
     * Referencia lógica hacia CASILLERO (no es FK en microservicios).
     * Columna CASILLERO_ID.
     */
    @Column(name = "CASILLERO_ID")
    private Long casilleroId;

    /**
     * Fecha de inicio del legajo (columna FECHA_INICIO_LEGAJO).
     */
    @Column(name = "FECHA_INICIO_LEGAJO")
    private LocalDateTime fechaInicioLegajo;

    /**
     * Fecha de fin del legajo (columna FECHA_FIN_LEGAJO).
     */
    @Column(name = "FECHA_FIN_LEGAJO")
    private LocalDateTime fechaFinLegajo;

    /**
     * Fecha de creación del registro.
     * Oracle lo llena con DEFAULT SYSTIMESTAMP.
     */
    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    /**
     * Fecha de última actualización.
     * Oracle lo llena con DEFAULT SYSTIMESTAMP.
     */
    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;

    /**
     * Constructor vacío requerido por JPA.
     */
    public Legajo() {
    }

    // ==========================
    // GETTERS Y SETTERS
    // ==========================

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