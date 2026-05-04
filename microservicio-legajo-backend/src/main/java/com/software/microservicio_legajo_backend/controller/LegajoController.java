package com.software.microservicio_legajo_backend.controller;

import com.software.microservicio_legajo_backend.dto.LegajoRequestDTO;
import com.software.microservicio_legajo_backend.dto.LegajoResponseDTO;
import com.software.microservicio_legajo_backend.entity.Legajo;
import com.software.microservicio_legajo_backend.mapper.LegajoMapper;
import com.software.microservicio_legajo_backend.service.LegajoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/legajos")
public class LegajoController {

    private final LegajoService legajoService;

    public LegajoController(LegajoService legajoService) {
        this.legajoService = legajoService;
    }

    // GET: listar todos los legajos
    @GetMapping
    public ResponseEntity<List<LegajoResponseDTO>> listarLegajos() {

        List<LegajoResponseDTO> lista = legajoService.listarLegajos()
                .stream()
                .map(LegajoMapper::toResponseDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(lista);
    }

    // GET: obtener legajo por ID
    @GetMapping("/{id}")
    public ResponseEntity<LegajoResponseDTO> obtenerLegajoPorId(@PathVariable Long id) {

        Legajo legajo = legajoService.obtenerLegajoPorId(id);

        return ResponseEntity.ok(LegajoMapper.toResponseDTO(legajo));
    }

    // POST: crear legajo
    @PostMapping
    public ResponseEntity<LegajoResponseDTO> crearLegajo(@RequestBody LegajoRequestDTO dto) {

        Legajo legajo = LegajoMapper.toEntity(dto);
        Legajo creado = legajoService.crearLegajo(legajo);

        return ResponseEntity.ok(LegajoMapper.toResponseDTO(creado));
    }

    // PUT: actualizar legajo
    @PutMapping("/{id}")
    public ResponseEntity<LegajoResponseDTO> actualizarLegajo(@PathVariable Long id,
                                                              @RequestBody LegajoRequestDTO dto) {

        Legajo legajo = LegajoMapper.toEntity(dto);
        Legajo actualizado = legajoService.actualizarLegajo(id, legajo);

        return ResponseEntity.ok(LegajoMapper.toResponseDTO(actualizado));
    }

    // DELETE: eliminar legajo
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarLegajo(@PathVariable Long id) {

        legajoService.eliminarLegajo(id);

        return ResponseEntity.ok("Legajo eliminado correctamente con ID: " + id);
    }
}