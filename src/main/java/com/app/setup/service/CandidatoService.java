package com.app.setup.service;

import com.app.setup.entity.Candidato;
import com.app.setup.entity.Sede;
import com.app.setup.dto.CandidatoDTO;
import com.app.setup.repository.CandidatoRepository;
import com.app.setup.repository.SedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository; // Cambiar a CandidatoRepository

    @Autowired
    private SedeRepository sedeRepository; // Para obtener la Sede por ID

    // Obtener todos los candidatos
    public List<CandidatoDTO> obtenerTodosLosCandidatos() {
        return candidatoRepository.findAll().stream()
                .map(this::convertirAValorDTO)
                .collect(Collectors.toList());
    }

    // Buscar candidato por ID
    public CandidatoDTO buscarCandidatoPorId(Long idCandidato) {
        Candidato candidato = candidatoRepository.findById(idCandidato)
                .orElseThrow(() -> new RuntimeException("No se encontró un candidato para el ID: " + idCandidato));
        return convertirAValorDTO(candidato);
    }

    // Agregar un nuevo candidato
    public CandidatoDTO agregarCandidato(CandidatoDTO candidatoDTO) {
        Sede sede = sedeRepository.findById(candidatoDTO.getIdSede())
                .orElseThrow(() -> new RuntimeException("No se encontró una sede para el ID: " + candidatoDTO.getIdSede()));

        Candidato candidato = new Candidato();

        candidato.setIdSede(sede);
        candidato.setNombre(candidatoDTO.getNombre());
        candidato.setApellidoPa(candidatoDTO.getApellidoPa());
        candidato.setApellidoMa(candidatoDTO.getApellidoMa());
        candidato.setTelefono(candidatoDTO.getTelefono());
        candidato.setCorreo(candidatoDTO.getCorreo());
        candidato.setNivelEstudios(candidatoDTO.getNivelEstudios());
        candidato.setEspecializacion(candidatoDTO.getEspecializacion());

        Candidato candidatoGuardado = candidatoRepository.save(candidato);
        return convertirAValorDTO(candidatoGuardado);
    }

    // Actualizar un candidato existente
    public CandidatoDTO actualizarCandidato(Long idCandidato, CandidatoDTO candidatoDTO) {
        Candidato candidatoExistente = candidatoRepository.findById(idCandidato)
                .orElseThrow(() -> new RuntimeException("No se encontró un candidato para el ID: " + idCandidato));

        Sede sede = sedeRepository.findById(candidatoDTO.getIdSede())
                .orElseThrow(() -> new RuntimeException("No se encontró una sede para el ID: " + candidatoDTO.getIdSede()));

        // Actualizar los campos del candidato existente
        candidatoExistente.setIdSede(sede);
        candidatoExistente.setNombre(candidatoDTO.getNombre());
        candidatoExistente.setApellidoPa(candidatoDTO.getApellidoPa());
        candidatoExistente.setApellidoMa(candidatoDTO.getApellidoMa());
        candidatoExistente.setTelefono(candidatoDTO.getTelefono());
        candidatoExistente.setCorreo(candidatoDTO.getCorreo());
        candidatoExistente.setNivelEstudios(candidatoDTO.getNivelEstudios());
        candidatoExistente.setEspecializacion(candidatoDTO.getEspecializacion());

        // Guardar los cambios
        Candidato candidatoActualizado = candidatoRepository.save(candidatoExistente);
        return convertirAValorDTO(candidatoActualizado);
    }

    // Eliminar un candidato por ID
    public void eliminarCandidato(Long idCandidato) {
        if (!candidatoRepository.existsById(idCandidato)) {
            throw new RuntimeException("No se encontró un candidato para el ID: " + idCandidato);
        }
        candidatoRepository.deleteById(idCandidato);
    }

    // Convertir Candidato a CandidatoDTO
    private CandidatoDTO convertirAValorDTO(Candidato candidato) {
        CandidatoDTO candidatoDTO = new CandidatoDTO();
        candidatoDTO.setIdCandidato(candidato.getIdCandidato());
        candidatoDTO.setIdSede(candidato.getIdSede().getIdSede()); // Solo se pasa el ID de la Sede
        candidatoDTO.setNombre(candidato.getNombre());
        candidatoDTO.setApellidoPa(candidato.getApellidoPa());
        candidatoDTO.setApellidoMa(candidato.getApellidoMa());
        candidatoDTO.setTelefono(candidato.getTelefono());
        candidatoDTO.setCorreo(candidato.getCorreo());
        candidatoDTO.setNivelEstudios(candidato.getNivelEstudios());
        candidatoDTO.setEspecializacion(candidato.getEspecializacion());
        return candidatoDTO;
    }
}
