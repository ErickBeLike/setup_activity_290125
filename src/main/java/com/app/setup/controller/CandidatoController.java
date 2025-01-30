package com.app.setup.controller;

import com.app.setup.dto.CandidatoDTO;
import com.app.setup.entity.Sede;
import com.app.setup.service.CandidatoService;
import com.app.setup.service.SedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/candidatos")
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;

    @Autowired
    private SedeService sedeService;

    // Mostrar todos los candidatos en la tabla
    @GetMapping
    public String listarCandidatos(Model model) {
        List<CandidatoDTO> listaCandidatos = candidatoService.obtenerTodosLosCandidatos();
        model.addAttribute("candidatos", listaCandidatos);
        return "candidato"; // Redirige a candidato.html
    }

    // Mostrar formulario para agregar un nuevo candidato
    @GetMapping("/nuevo")
    public String mostrarFormularioDeRegistro(Model model) {
        model.addAttribute("candidato", new CandidatoDTO());

        // Obtener todas las sedes y pasarlas al formulario
        List<Sede> listaSedes = sedeService.obtenerTodasLasSedes();
        model.addAttribute("sedes", listaSedes);

        return "candidato-formulario"; // Redirige a candidato-formulario.html
    }

    // Guardar un nuevo candidato
    @PostMapping("/guardar")
    public String guardarCandidato(@ModelAttribute CandidatoDTO candidatoDTO) {
        candidatoService.agregarCandidato(candidatoDTO);
        return "redirect:/candidatos"; // Redirige a la tabla después de guardar
    }

    // Mostrar formulario para editar un candidato existente
    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEdicion(@PathVariable Long id, Model model) {
        CandidatoDTO candidatoDTO = candidatoService.buscarCandidatoPorId(id);
        model.addAttribute("candidato", candidatoDTO);

        // Obtener todas las sedes y pasarlas al formulario
        List<Sede> listaSedes = sedeService.obtenerTodasLasSedes();
        model.addAttribute("sedes", listaSedes);

        return "candidato-formulario"; // Usa el mismo formulario para editar
    }

    // Guardar la edición de un candidato
    @PostMapping("/actualizar/{id}")
    public String actualizarCandidato(@PathVariable Long id, @ModelAttribute CandidatoDTO candidatoDTO) {
        candidatoService.actualizarCandidato(id, candidatoDTO);
        return "redirect:/candidatos";
    }

    // Eliminar un candidato
    @GetMapping("/eliminar/{id}")
    public String eliminarCandidato(@PathVariable Long id) {
        candidatoService.eliminarCandidato(id);
        return "redirect:/candidatos";
    }
}
