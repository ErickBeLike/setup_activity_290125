package com.app.setup.controller;

import com.app.setup.entity.ProcesoCaptacion;
import com.app.setup.service.ProcesoCaptacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/procesos")
public class ProcesoCaptacionController {

    @Autowired
    private ProcesoCaptacionService procesoCaptacionService;

    @GetMapping
    public List<ProcesoCaptacion> obtenerTodosLosProcesosCaptacion() {
        return procesoCaptacionService.obtenerTodosLosProcesosCaptacion();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProcesoCaptacion> buscarProcesoCaptacionPorId(@PathVariable Long id) {
        ProcesoCaptacion procesoCaptacion = procesoCaptacionService.buscarProcesoCaptacionPorId(id);
        return ResponseEntity.ok(procesoCaptacion);
    }

    @PostMapping
    public ProcesoCaptacion agregarProcesoCaptacion(@RequestBody ProcesoCaptacion procesoCaptacion) {
        return procesoCaptacionService.agregarProcesoCaptacion(procesoCaptacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProcesoCaptacion> actualizarProcesoCaptacion(@PathVariable Long id, @RequestBody ProcesoCaptacion procesoCaptacion) {
        ProcesoCaptacion procesoCaptacionActualizado = procesoCaptacionService.actualizarProcesoCaptacion(id, procesoCaptacion);
        return ResponseEntity.ok(procesoCaptacionActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProcesoCaptacion(@PathVariable Long id) {
        procesoCaptacionService.eliminarProcesoCaptacion(id);
        return ResponseEntity.noContent().build();
    }
}
