package com.software.microservicio_legajo_backend.service;

import com.software.microservicio_legajo_backend.entity.Legajo;

import java.util.List;

public interface LegajoService {

    List<Legajo> listarLegajos();

    Legajo obtenerLegajoPorId(Long id);

    Legajo crearLegajo(Legajo legajo);

    Legajo actualizarLegajo(Long id, Legajo legajo);

    void eliminarLegajo(Long id);
}
