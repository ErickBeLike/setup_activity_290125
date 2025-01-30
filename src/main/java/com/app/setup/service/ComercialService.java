package com.app.setup.service;

import com.app.setup.entity.Comercial;
import com.app.setup.repository.ComercialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComercialService {

    @Autowired
    private ComercialRepository comercialRepository; // Repositorio de Comercial

    // Obtener todos los comerciales
    public List<Comercial> obtenerTodosLosComerciales() {
        return comercialRepository.findAll();
    }

    // Buscar comercial por ID
    public Comercial buscarComercialPorId(Long idComercial) {
        return comercialRepository.findById(idComercial)
                .orElseThrow(() -> new RuntimeException("No se encontró un comercial para el ID: " + idComercial));
    }

    // Agregar un nuevo comercial
    public Comercial agregarComercial(Comercial comercial) {
        return comercialRepository.save(comercial);
    }

    // Actualizar un comercial existente
    public Comercial actualizarComercial(Long idComercial, Comercial comercialActualizado) {
        Comercial comercialExistente = comercialRepository.findById(idComercial)
                .orElseThrow(() -> new RuntimeException("No se encontró un comercial para el ID: " + idComercial));

        // Actualizar los campos del comercial existente
        comercialExistente.setNombre(comercialActualizado.getNombre());
        comercialExistente.setApellidoPa(comercialActualizado.getApellidoPa());
        comercialExistente.setApellidoMa(comercialActualizado.getApellidoMa());
        comercialExistente.setTelefono(comercialActualizado.getTelefono());
        comercialExistente.setCorreo(comercialActualizado.getCorreo());
        comercialExistente.setFechaContratacion(comercialActualizado.getFechaContratacion());
        comercialExistente.setImporteTotal(comercialActualizado.getImporteTotal());

        // Guardar los cambios
        return comercialRepository.save(comercialExistente);
    }

    // Eliminar un comercial por ID
    public void eliminarComercial(Long idComercial) {
        if (!comercialRepository.existsById(idComercial)) {
            throw new RuntimeException("No se encontró un comercial para el ID: " + idComercial);
        }

        comercialRepository.deleteById(idComercial);
    }
}
