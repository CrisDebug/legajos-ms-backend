package com.software.microservicio_legajo_backend.mapper;

import com.software.microservicio_legajo_backend.dto.LegajoRequestDTO;
import com.software.microservicio_legajo_backend.dto.LegajoResponseDTO;
import com.software.microservicio_legajo_backend.entity.Legajo;

public class LegajoMapper {

    // Convierte RequestDTO a Entity (para crear o actualizar)
    public static Legajo toEntity(LegajoRequestDTO dto) {

        Legajo legajo = new Legajo();
        legajo.setManualId(dto.getManualId());
        legajo.setDescripcionLegajo(dto.getDescripcionLegajo());
        legajo.setCasilleroId(dto.getCasilleroId());
        legajo.setFechaInicioLegajo(dto.getFechaInicioLegajo());
        legajo.setFechaFinLegajo(dto.getFechaFinLegajo());

        return legajo;
    }

    // Convierte Entity a ResponseDTO (para devolver al cliente)
    public static LegajoResponseDTO toResponseDTO(Legajo legajo) {

        LegajoResponseDTO dto = new LegajoResponseDTO();
        dto.setId(legajo.getId());
        dto.setManualId(legajo.getManualId());
        dto.setDescripcionLegajo(legajo.getDescripcionLegajo());
        dto.setCasilleroId(legajo.getCasilleroId());
        dto.setFechaInicioLegajo(legajo.getFechaInicioLegajo());
        dto.setFechaFinLegajo(legajo.getFechaFinLegajo());
        dto.setCreatedAt(legajo.getCreatedAt());
        dto.setUpdatedAt(legajo.getUpdatedAt());

        return dto;
    }
}