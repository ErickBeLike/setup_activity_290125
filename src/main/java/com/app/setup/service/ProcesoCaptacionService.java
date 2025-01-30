package com.app.setup.service;

import com.app.setup.entity.ProcesoCaptacion;
import com.app.setup.repository.ProcesoCaptacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcesoCaptacionService {

    @Autowired
    private ProcesoCaptacionRepository procesoCaptacionRepository; // Repositorio de ProcesoCaptacion

    // Obtener todos los procesos de captación
    public List<ProcesoCaptacion> obtenerTodosLosProcesosCaptacion() {
        return procesoCaptacionRepository.findAll();
    }

    // Buscar un proceso de captación por ID
    public ProcesoCaptacion buscarProcesoCaptacionPorId(Long idProcesoCaptacion) {
        return procesoCaptacionRepository.findById(idProcesoCaptacion)
                .orElseThrow(() -> new RuntimeException("No se encontró un proceso de captación para el ID: " + idProcesoCaptacion));
    }

    // Agregar un nuevo proceso de captación
    public ProcesoCaptacion agregarProcesoCaptacion(ProcesoCaptacion procesoCaptacion) {
        return procesoCaptacionRepository.save(procesoCaptacion);
    }

    // Actualizar un proceso de captación existente
    public ProcesoCaptacion actualizarProcesoCaptacion(Long idProcesoCaptacion, ProcesoCaptacion procesoCaptacionActualizado) {
        ProcesoCaptacion procesoCaptacionExistente = procesoCaptacionRepository.findById(idProcesoCaptacion)
                .orElseThrow(() -> new RuntimeException("No se encontró un proceso de captación para el ID: " + idProcesoCaptacion));

        // Actualizar los campos del proceso de captación existente
        procesoCaptacionExistente.setTipo(procesoCaptacionActualizado.getTipo());
        procesoCaptacionExistente.setFechaInicio(procesoCaptacionActualizado.getFechaInicio());
        procesoCaptacionExistente.setFechaFin(procesoCaptacionActualizado.getFechaFin());

        // Guardar los cambios
        return procesoCaptacionRepository.save(procesoCaptacionExistente);
    }

    // Eliminar un proceso de captación por ID
    public void eliminarProcesoCaptacion(Long idProcesoCaptacion) {
        if (!procesoCaptacionRepository.existsById(idProcesoCaptacion)) {
            throw new RuntimeException("No se encontró un proceso de captación para el ID: " + idProcesoCaptacion);
        }

        procesoCaptacionRepository.deleteById(idProcesoCaptacion);
    }
}
