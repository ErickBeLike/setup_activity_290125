package com.app.setup.service;

import com.app.setup.entity.Cliente;
import com.app.setup.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository; // Repositorio de Cliente

    // Obtener todos los clientes
    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepository.findAll();
    }

    // Buscar cliente por ID
    public Cliente buscarClientePorId(Long idCliente) {
        return clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("No se encontró un cliente para el ID: " + idCliente));
    }

    // Agregar un nuevo cliente
    public Cliente agregarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Actualizar un cliente existente
    public Cliente actualizarCliente(Long idCliente, Cliente clienteActualizado) {
        Cliente clienteExistente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("No se encontró un cliente para el ID: " + idCliente));

        // Actualizar los campos del cliente existente
        clienteExistente.setNombre(clienteActualizado.getNombre());
        clienteExistente.setApellidoPa(clienteActualizado.getApellidoPa());
        clienteExistente.setApellidoMa(clienteActualizado.getApellidoMa());
        clienteExistente.setPoblacion(clienteActualizado.getPoblacion());
        clienteExistente.setCodigoPostal(clienteActualizado.getCodigoPostal());
        clienteExistente.setDireccion(clienteActualizado.getDireccion());
        clienteExistente.setTelefono(clienteActualizado.getTelefono());
        clienteExistente.setPersonaContacto(clienteActualizado.getPersonaContacto());
        clienteExistente.setTelefonoContacto(clienteActualizado.getTelefonoContacto());
        clienteExistente.setCorreoContacto(clienteActualizado.getCorreoContacto());

        // Guardar los cambios
        return clienteRepository.save(clienteExistente);
    }

    // Eliminar un cliente por ID
    public void eliminarCliente(Long idCliente) {
        if (!clienteRepository.existsById(idCliente)) {
            throw new RuntimeException("No se encontró un cliente para el ID: " + idCliente);
        }

        clienteRepository.deleteById(idCliente);
    }
}
