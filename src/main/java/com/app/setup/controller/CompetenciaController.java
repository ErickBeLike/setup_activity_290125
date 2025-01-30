package com.app.setup.controller;

import com.app.setup.entity.Competencia;
import com.app.setup.service.CompetenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/competencias")
public class CompetenciaController {

    @Autowired
    private CompetenciaService competenciaService;

    // Mostrar todas las competencias en la tabla
    @GetMapping
    public String listarCompetencias(Model model) {
        List<Competencia> listaCompetencias = competenciaService.obtenerTodasLasCompetencias();
        model.addAttribute("competencias", listaCompetencias);
        return "competencia"; // Redirige a competencia.html
    }

    // Mostrar formulario para agregar una nueva competencia
    @GetMapping("/nuevo")
    public String mostrarFormularioDeRegistro(Model model) {
        model.addAttribute("competencia", new Competencia());
        return "competencia-formulario"; // Redirige a competencia-formulario.html
    }

    // Guardar una nueva competencia
    @PostMapping("/guardar")
    public String guardarCompetencia(@ModelAttribute Competencia competencia) {
        competenciaService.agregarCompetencia(competencia);
        return "redirect:/competencias"; // Redirige a la tabla después de guardar
    }

    // Mostrar formulario para editar una competencia existente
    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEdicion(@PathVariable Long id, Model model) {
        Competencia competencia = competenciaService.buscarCompetenciaPorId(id);
        model.addAttribute("competencia", competencia);
        return "competencia-formulario"; // Usa el mismo formulario para editar
    }

    // Guardar la edición de una competencia
    @PostMapping("/actualizar/{id}")
    public String actualizarCompetencia(@PathVariable Long id, @ModelAttribute Competencia competencia) {
        competenciaService.actualizarCompetencia(id, competencia);
        return "redirect:/competencias";
    }

    // Eliminar una competencia
    @GetMapping("/eliminar/{id}")
    public String eliminarCompetencia(@PathVariable Long id) {
        competenciaService.eliminarCompetencia(id);
        return "redirect:/competencias";
    }
}
