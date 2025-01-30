package com.app.setup.controller;

import com.app.setup.entity.Sede;
import com.app.setup.service.SedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sedes")
public class SedeController {

    @Autowired
    private SedeService sedeService;

    // Obtener todas las sedes
    @GetMapping
    public List<Sede> obtenerTodasLasSedes() {
        return sedeService.obtenerTodasLasSedes();
    }

    // Buscar sede por ID
    @GetMapping("/{id}")
    public ResponseEntity<Sede> buscarSedePorId(@PathVariable Long id) {
        Sede sede = sedeService.buscarSedePorId(id);
        return ResponseEntity.ok(sede);
    }

    // Agregar una nueva sede
    @PostMapping
    public ResponseEntity<Sede> agregarSede(@RequestBody Sede sede) {
        Sede nuevaSede = sedeService.agregarSede(sede);
        return ResponseEntity.ok(nuevaSede);
    }

    // Actualizar una sede existente
    @PutMapping("/{id}")
    public ResponseEntity<Sede> actualizarSede(@PathVariable Long id, @RequestBody Sede sedeActualizada) {
        Sede sede = sedeService.actualizarSede(id, sedeActualizada);
        return ResponseEntity.ok(sede);
    }

    // Eliminar una sede por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSede(@PathVariable Long id) {
        sedeService.eliminarSede(id);
        return ResponseEntity.noContent().build();
    }
}
