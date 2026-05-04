package com.software.microservicio_legajo_backend.service;

import com.software.microservicio_legajo_backend.client.CasilleroClient;
import com.software.microservicio_legajo_backend.entity.Legajo;
import com.software.microservicio_legajo_backend.exception.ResourceNotFoundException;
import com.software.microservicio_legajo_backend.repository.LegajoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LegajoServiceImpl implements LegajoService {

    private final LegajoRepository legajoRepository;
    private final CasilleroClient casilleroClient;

    public LegajoServiceImpl(LegajoRepository legajoRepository, CasilleroClient casilleroClient) {
        this.legajoRepository = legajoRepository;
        this.casilleroClient = casilleroClient;
    }

    @Override
    public List<Legajo> listarLegajos() {
        return legajoRepository.findAll();
    }

    @Override
    public Legajo obtenerLegajoPorId(Long id) {
        return legajoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Legajo no encontrado con ID: " + id));
    }

    @Override
    public Legajo crearLegajo(Legajo legajo) {

        if (!casilleroClient.existeCasillero(legajo.getCasilleroId())) {
            throw new ResourceNotFoundException("CASILLERO_NOT_FOUND");
        }

        legajo.setCreatedAt(LocalDateTime.now());
        legajo.setUpdatedAt(LocalDateTime.now());
        return legajoRepository.save(legajo);
    }

    @Override
    public Legajo actualizarLegajo(Long id, Legajo legajo) {

        Legajo legajoExistente = legajoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Legajo no encontrado con ID: " + id));

        legajoExistente.setManualId(legajo.getManualId());
        legajoExistente.setDescripcionLegajo(legajo.getDescripcionLegajo());
        legajoExistente.setCasilleroId(legajo.getCasilleroId());
        legajoExistente.setFechaInicioLegajo(legajo.getFechaInicioLegajo());
        legajoExistente.setFechaFinLegajo(legajo.getFechaFinLegajo());

        legajoExistente.setUpdatedAt(LocalDateTime.now());

        return legajoRepository.save(legajoExistente);
    }

    @Override
    public void eliminarLegajo(Long id) {

        Legajo legajoExistente = legajoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Legajo no encontrado con ID: " + id));

        legajoRepository.delete(legajoExistente);
    }
}