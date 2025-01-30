package com.app.setup.controller;

import com.app.setup.entity.ProcesoCaptacion;
import com.app.setup.service.ProcesoCaptacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/procesos")
public class ProcesoCaptacionController {

    @Autowired
    private ProcesoCaptacionService procesoCaptacionService;

    // Obtener todos los procesos de captación
    @GetMapping
    public String listarProcesosCaptacion(Model model) {
        List<ProcesoCaptacion> listaProcesos = procesoCaptacionService.obtenerTodosLosProcesosCaptacion();
        model.addAttribute("procesos", listaProcesos);
        return "proceso-captacion"; // Redirige a proceso-captacion.html
    }

    // Mostrar formulario para agregar un nuevo proceso de captación
    @GetMapping("/nuevo")
    public String mostrarFormularioDeRegistro(Model model) {
        model.addAttribute("procesoCaptacion", new ProcesoCaptacion());
        return "proceso-captacion-formulario"; // Redirige a proceso-captacion-formulario.html
    }

    // Guardar un nuevo proceso de captación
    @PostMapping("/guardar")
    public String guardarProcesoCaptacion(@ModelAttribute ProcesoCaptacion procesoCaptacion) {
        procesoCaptacionService.agregarProcesoCaptacion(procesoCaptacion);
        return "redirect:/procesos"; // Redirige a la lista de procesos de captación
    }

    // Mostrar formulario para editar un proceso de captación existente
    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEdicion(@PathVariable Long id, Model model) {
        ProcesoCaptacion procesoCaptacion = procesoCaptacionService.buscarProcesoCaptacionPorId(id);
        model.addAttribute("procesoCaptacion", procesoCaptacion);
        return "proceso-captacion-formulario"; // Usa el mismo formulario para editar
    }

    // Guardar la edición de un proceso de captación
    @PostMapping("/actualizar/{id}")
    public String actualizarProcesoCaptacion(@PathVariable Long id, @ModelAttribute ProcesoCaptacion procesoCaptacion) {
        procesoCaptacionService.actualizarProcesoCaptacion(id, procesoCaptacion);
        return "redirect:/procesos"; // Redirige a la lista de procesos
    }

    // Eliminar un proceso de captación
    @GetMapping("/eliminar/{id}")
    public String eliminarProcesoCaptacion(@PathVariable Long id) {
        procesoCaptacionService.eliminarProcesoCaptacion(id);
        return "redirect:/procesos"; // Redirige a la lista de procesos
    }
}
