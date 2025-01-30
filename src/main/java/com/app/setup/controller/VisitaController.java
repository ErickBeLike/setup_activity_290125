package com.app.setup.controller;

import com.app.setup.dto.VisitaDTO;
import com.app.setup.entity.Comercial;
import com.app.setup.service.ComercialService;
import com.app.setup.service.VisitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/visitas")
public class VisitaController {

    @Autowired
    private VisitaService visitaService;

    @Autowired
    private ComercialService comercialService;

    // Obtener todas las visitas
    @GetMapping
    public String listarVisitas(Model model) {
        List<VisitaDTO> listaVisitas = visitaService.obtenerTodasLasVisitas();
        model.addAttribute("visitas", listaVisitas);
        return "visita"; // Redirige a visita.html
    }

    // Mostrar formulario para agregar una nueva visita
    @GetMapping("/nuevo")
    public String mostrarFormularioDeRegistro(Model model) {
        model.addAttribute("visita", new VisitaDTO());

        // Obtener todos los comerciales y pasarlos al formulario
        List<Comercial> listaComerciales = comercialService.obtenerTodosLosComerciales();
        model.addAttribute("comerciales", listaComerciales);

        return "visita-formulario"; // Redirige a visita-formulario.html
    }

    // Guardar una nueva visita
    @PostMapping("/guardar")
    public String guardarVisita(@ModelAttribute VisitaDTO visitaDTO) {
        visitaService.agregarVisita(visitaDTO);
        return "redirect:/visitas"; // Redirige a la lista de visitas después de guardar
    }

    // Mostrar formulario para editar una visita existente
    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEdicion(@PathVariable Long id, Model model) {
        VisitaDTO visita = visitaService.buscarVisitaPorId(id);
        model.addAttribute("visita", visita);

        // Obtener todos los comerciales y pasarlos al formulario
        List<Comercial> listaComerciales = comercialService.obtenerTodosLosComerciales();
        model.addAttribute("comerciales", listaComerciales);

        return "visita-formulario"; // Usa el mismo formulario para editar
    }

    // Guardar la edición de una visita
    @PostMapping("/actualizar/{id}")
    public String actualizarVisita(@PathVariable Long id, @ModelAttribute VisitaDTO visitaDTO) {
        visitaService.actualizarVisita(id, visitaDTO);
        return "redirect:/visitas"; // Redirige a la lista de visitas
    }

    // Eliminar una visita
    @GetMapping("/eliminar/{id}")
    public String eliminarVisita(@PathVariable Long id) {
        visitaService.eliminarVisita(id);
        return "redirect:/visitas"; // Redirige a la lista de visitas
    }
}
