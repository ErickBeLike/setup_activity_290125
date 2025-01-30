package com.app.setup.controller;

import com.app.setup.entity.Sede;
import com.app.setup.service.SedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sedes")
public class SedeController {

    @Autowired
    private SedeService sedeService;

    // Mostrar todas las sedes en la tabla
    @GetMapping
    public String listarSedes(Model model) {
        List<Sede> listaSedes = sedeService.obtenerTodasLasSedes();
        model.addAttribute("sedes", listaSedes);
        return "sede"; // Redirige a sede.html
    }

    // Mostrar formulario para agregar una nueva sede
    @GetMapping("/nuevo")
    public String mostrarFormularioDeRegistro(Model model) {
        model.addAttribute("sede", new Sede());
        return "sede-formulario"; // Redirige a sede-formulario.html
    }

    // Guardar una nueva sede
    @PostMapping("/guardar")
    public String guardarSede(@ModelAttribute Sede sede) {
        sedeService.agregarSede(sede);
        return "redirect:/sedes"; // Redirige a la tabla después de guardar
    }

    // Mostrar formulario para editar una sede existente
    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEdicion(@PathVariable Long id, Model model) {
        Sede sede = sedeService.buscarSedePorId(id);
        model.addAttribute("sede", sede);
        return "sede-formulario"; // Usa el mismo formulario para editar
    }

    // Guardar la edición de una sede
    @PostMapping("/actualizar/{id}")
    public String actualizarSede(@PathVariable Long id, @ModelAttribute Sede sede) {
        sedeService.actualizarSede(id, sede);
        return "redirect:/sedes";
    }

    // Eliminar una sede
    @GetMapping("/eliminar/{id}")
    public String eliminarSede(@PathVariable Long id) {
        sedeService.eliminarSede(id);
        return "redirect:/sedes";
    }
}
