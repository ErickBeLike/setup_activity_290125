package com.app.setup.controller;

import com.app.setup.dto.CandidatoDTO;
import com.app.setup.service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidatos")
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;

    // Obtener todos los candidatos
    @GetMapping
    public List<CandidatoDTO> obtenerTodosLosCandidatos() {
        return candidatoService.obtenerTodosLosCandidatos();
    }

    // Buscar candidato por ID
    @GetMapping("/{id}")
    public ResponseEntity<CandidatoDTO> buscarCandidatoPorId(@PathVariable Long id) {
        CandidatoDTO candidatoDTO = candidatoService.buscarCandidatoPorId(id);
        return ResponseEntity.ok(candidatoDTO);
    }

    // Agregar un nuevo candidato
    @PostMapping
    public ResponseEntity<CandidatoDTO> agregarCandidato(@RequestBody CandidatoDTO candidatoDTO) {
        CandidatoDTO nuevoCandidato = candidatoService.agregarCandidato(candidatoDTO);
        return ResponseEntity.ok(nuevoCandidato);
    }

    // Actualizar un candidato existente
    @PutMapping("/{id}")
    public ResponseEntity<CandidatoDTO> actualizarCandidato(@PathVariable Long id, @RequestBody CandidatoDTO candidatoDTO) {
        CandidatoDTO candidatoActualizado = candidatoService.actualizarCandidato(id, candidatoDTO);
        return ResponseEntity.ok(candidatoActualizado);
    }

    // Eliminar un candidato por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCandidato(@PathVariable Long id) {
        candidatoService.eliminarCandidato(id);
        return ResponseEntity.noContent().build();
    }
}
