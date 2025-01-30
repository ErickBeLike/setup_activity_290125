package com.app.setup.controller;

import com.app.setup.dto.VisitaDTO;
import com.app.setup.service.VisitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visitas")
public class VisitaController {

    @Autowired
    private VisitaService visitaService;

    // Obtener todas las visitas
    @GetMapping
    public List<VisitaDTO> obtenerTodasLasVisitas() {
        return visitaService.obtenerTodasLasVisitas();
    }

    // Buscar visita por ID
    @GetMapping("/{id}")
    public ResponseEntity<VisitaDTO> buscarVisitaPorId(@PathVariable Long id) {
        VisitaDTO visita = visitaService.buscarVisitaPorId(id);
        return ResponseEntity.ok(visita);
    }

    // Agregar una nueva visita
    @PostMapping
    public ResponseEntity<VisitaDTO> agregarVisita(@RequestBody VisitaDTO visitaDTO) {
        VisitaDTO nuevaVisita = visitaService.agregarVisita(visitaDTO);
        return ResponseEntity.ok(nuevaVisita);
    }

    // Actualizar una visita existente
    @PutMapping("/{id}")
    public ResponseEntity<VisitaDTO> actualizarVisita(@PathVariable Long id, @RequestBody VisitaDTO visitaDTO) {
        VisitaDTO visitaActualizada = visitaService.actualizarVisita(id, visitaDTO);
        return ResponseEntity.ok(visitaActualizada);
    }

    // Eliminar una visita por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVisita(@PathVariable Long id) {
        visitaService.eliminarVisita(id);
        return ResponseEntity.noContent().build();
    }
}
