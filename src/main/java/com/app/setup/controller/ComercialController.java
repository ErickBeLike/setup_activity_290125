package com.app.setup.controller;

import com.app.setup.entity.Comercial;
import com.app.setup.service.ComercialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comerciales")
public class ComercialController {

    @Autowired
    private ComercialService comercialService;

    @GetMapping
    public List<Comercial> obtenerTodosLosComerciales() {
        return comercialService.obtenerTodosLosComerciales();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comercial> buscarComercialPorId(@PathVariable Long id) {
        Comercial comercial = comercialService.buscarComercialPorId(id);
        return ResponseEntity.ok(comercial);
    }

    @PostMapping
    public Comercial agregarComercial(@RequestBody Comercial comercial) {
        return comercialService.agregarComercial(comercial);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comercial> actualizarComercial(@PathVariable Long id, @RequestBody Comercial comercial) {
        Comercial comercialActualizado = comercialService.actualizarComercial(id, comercial);
        return ResponseEntity.ok(comercialActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarComercial(@PathVariable Long id) {
        comercialService.eliminarComercial(id);
        return ResponseEntity.noContent().build();
    }
}
