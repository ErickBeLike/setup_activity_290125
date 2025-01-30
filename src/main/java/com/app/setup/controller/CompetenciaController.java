package com.app.setup.controller;

import com.app.setup.entity.Competencia;
import com.app.setup.service.CompetenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competencias")
public class CompetenciaController {

    @Autowired
    private CompetenciaService competenciaService;

    @GetMapping
    public List<Competencia> obtenerTodasLasCompetencias() {
        return competenciaService.obtenerTodasLasCompetencias();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Competencia> buscarCompetenciaPorId(@PathVariable Long id) {
        Competencia competencia = competenciaService.buscarCompetenciaPorId(id);
        return ResponseEntity.ok(competencia);
    }

    @PostMapping
    public Competencia agregarCompetencia(@RequestBody Competencia competencia) {
        return competenciaService.agregarCompetencia(competencia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Competencia> actualizarCompetencia(@PathVariable Long id, @RequestBody Competencia competencia) {
        Competencia competenciaActualizada = competenciaService.actualizarCompetencia(id, competencia);
        return ResponseEntity.ok(competenciaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCompetencia(@PathVariable Long id) {
        competenciaService.eliminarCompetencia(id);
        return ResponseEntity.noContent().build();
    }
}
