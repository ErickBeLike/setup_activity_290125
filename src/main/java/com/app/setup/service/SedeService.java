package com.app.setup.service;

import com.app.setup.entity.Sede;
import com.app.setup.repository.SedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SedeService {

    @Autowired
    private SedeRepository sedeRepository; // Cambiar a SedeRepository

    // Obtener todas las sedes
    public List<Sede> obtenerTodasLasSedes() {
        return sedeRepository.findAll();
    }

    // Buscar sede por ID
    public Sede buscarSedePorId(Long idSede) {
        return sedeRepository.findById(idSede)
                .orElseThrow(() -> new RuntimeException("No se encontró una sede para el ID: " + idSede));
    }

    // Agregar una nueva sede
    public Sede agregarSede(Sede sede) {
        return sedeRepository.save(sede);
    }

    // Actualizar una sede existente
    public Sede actualizarSede(Long idSede, Sede sedeActualizada) {
        Sede sedeExistente = sedeRepository.findById(idSede)
                .orElseThrow(() -> new RuntimeException("No se encontró una sede para el ID: " + idSede));

        // Actualizar los campos de la sede existente
        sedeExistente.setTelefono(sedeActualizada.getTelefono());
        sedeExistente.setPoblacion(sedeActualizada.getPoblacion());
        sedeExistente.setCodigoPostal(sedeActualizada.getCodigoPostal());
        sedeExistente.setDireccion(sedeActualizada.getDireccion());
        sedeExistente.setFechaInauguracion(sedeActualizada.getFechaInauguracion());
        sedeExistente.setNombreResponsable(sedeActualizada.getNombreResponsable());

        // Guardar los cambios
        return sedeRepository.save(sedeExistente);
    }

    // Eliminar una sede por ID
    public void eliminarSede(Long idSede) {
        if (!sedeRepository.existsById(idSede)) {
            throw new RuntimeException("No se encontró una sede para el ID: " + idSede);
        }

        sedeRepository.deleteById(idSede);
    }
}
