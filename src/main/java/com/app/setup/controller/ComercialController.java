package com.app.setup.controller;

import com.app.setup.entity.Comercial;
import com.app.setup.service.ComercialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/comerciales")
public class ComercialController {

    @Autowired
    private ComercialService comercialService;

    // Mostrar todos los comerciales en la tabla
    @GetMapping
    public String listarComerciales(Model model) {
        List<Comercial> listaComerciales = comercialService.obtenerTodosLosComerciales();
        model.addAttribute("comerciales", listaComerciales);
        return "comercial"; // Redirige a comercial.html
    }

    // Mostrar formulario para agregar un nuevo comercial
    @GetMapping("/nuevo")
    public String mostrarFormularioDeRegistro(Model model) {
        model.addAttribute("comercial", new Comercial());
        return "comercial-formulario"; // Redirige a comercial-formulario.html
    }

    // Guardar un nuevo comercial
    @PostMapping("/guardar")
    public String guardarComercial(@ModelAttribute Comercial comercial) {
        comercialService.agregarComercial(comercial);
        return "redirect:/comerciales"; // Redirige a la tabla después de guardar
    }

    // Mostrar formulario para editar un comercial existente
    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEdicion(@PathVariable Long id, Model model) {
        Comercial comercial = comercialService.buscarComercialPorId(id);
        model.addAttribute("comercial", comercial); // Solo pasa el objeto comercial
        return "comercial-formulario"; // Redirige al formulario
    }

    // Guardar la edición de un comercial
    @PostMapping("/actualizar/{id}")
    public String actualizarComercial(@PathVariable Long id, @ModelAttribute Comercial comercial) {
        comercialService.actualizarComercial(id, comercial);
        return "redirect:/comerciales";
    }

    // Eliminar un comercial
    @GetMapping("/eliminar/{id}")
    public String eliminarComercial(@PathVariable Long id) {
        comercialService.eliminarComercial(id);
        return "redirect:/comerciales";
    }
}
