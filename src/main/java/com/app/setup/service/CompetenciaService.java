package com.app.setup.service;

import com.app.setup.entity.Competencia;
import com.app.setup.repository.CompetenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetenciaService {

    @Autowired
    private CompetenciaRepository competenciaRepository; // Repositorio de Competencia

    // Obtener todas las competencias
    public List<Competencia> obtenerTodasLasCompetencias() {
        return competenciaRepository.findAll();
    }

    // Buscar competencia por ID
    public Competencia buscarCompetenciaPorId(Long idCompetencia) {
        return competenciaRepository.findById(idCompetencia)
                .orElseThrow(() -> new RuntimeException("No se encontró una competencia para el ID: " + idCompetencia));
    }

    // Agregar una nueva competencia
    public Competencia agregarCompetencia(Competencia competencia) {
        return competenciaRepository.save(competencia);
    }

    // Actualizar una competencia existente
    public Competencia actualizarCompetencia(Long idCompetencia, Competencia competenciaActualizada) {
        Competencia competenciaExistente = competenciaRepository.findById(idCompetencia)
                .orElseThrow(() -> new RuntimeException("No se encontró una competencia para el ID: " + idCompetencia));

        // Actualizar los campos de la competencia existente
        competenciaExistente.setNombreCompetencia(competenciaActualizada.getNombreCompetencia());
        competenciaExistente.setDescripcion(competenciaActualizada.getDescripcion());
        competenciaExistente.setFechaCreacion(competenciaActualizada.getFechaCreacion());

        // Guardar los cambios
        return competenciaRepository.save(competenciaExistente);
    }

    // Eliminar una competencia por ID
    public void eliminarCompetencia(Long idCompetencia) {
        if (!competenciaRepository.existsById(idCompetencia)) {
            throw new RuntimeException("No se encontró una competencia para el ID: " + idCompetencia);
        }

        competenciaRepository.deleteById(idCompetencia);
    }
}
