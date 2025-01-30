package com.app.setup.controller;

import com.app.setup.entity.Cliente;
import com.app.setup.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Mostrar todos los clientes en la tabla
    @GetMapping
    public String listarClientes(Model model) {
        List<Cliente> listaClientes = clienteService.obtenerTodosLosClientes();
        model.addAttribute("clientes", listaClientes);
        return "cliente"; // Redirige a cliente.html
    }

    // Mostrar formulario para agregar un nuevo cliente
    @GetMapping("/nuevo")
    public String mostrarFormularioDeRegistro(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cliente-formulario"; // Redirige a cliente-formulario.html
    }

    // Guardar un nuevo cliente
    @PostMapping("/guardar")
    public String guardarCliente(@ModelAttribute Cliente cliente) {
        clienteService.agregarCliente(cliente);
        return "redirect:/clientes"; // Redirige a la tabla después de guardar
    }

    // Mostrar formulario para editar un cliente existente
    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEdicion(@PathVariable Long id, Model model) {
        Cliente cliente = clienteService.buscarClientePorId(id);
        model.addAttribute("cliente", cliente);
        return "cliente-formulario"; // Usa el mismo formulario para editar
    }

    // Guardar la edición de un cliente
    @PostMapping("/actualizar/{id}")
    public String actualizarCliente(@PathVariable Long id, @ModelAttribute Cliente cliente) {
        clienteService.actualizarCliente(id, cliente);
        return "redirect:/clientes";
    }

    // Eliminar un cliente
    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
        return "redirect:/clientes";
    }
}
