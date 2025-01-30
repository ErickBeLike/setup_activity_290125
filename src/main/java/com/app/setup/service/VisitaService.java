package com.app.setup.service;

import com.app.setup.entity.Visita;
import com.app.setup.entity.Comercial;
import com.app.setup.dto.VisitaDTO; // Asegúrate de tener el DTO de Visita
import com.app.setup.repository.VisitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VisitaService {

    @Autowired
    private VisitaRepository visitaRepository; // Repositorio de Visita

    @Autowired
    private ComercialService comercialService; // Servicio para manejar la entidad Comercial

    // Obtener todas las visitas
    public List<VisitaDTO> obtenerTodasLasVisitas() {
        List<Visita> visitas = visitaRepository.findAll();
        return visitas.stream()
                .map(this::convertirAVisitaDTO)
                .collect(Collectors.toList());
    }

    // Buscar visita por ID
    public VisitaDTO buscarVisitaPorId(Long idVisita) {
        Visita visita = visitaRepository.findById(idVisita)
                .orElseThrow(() -> new RuntimeException("No se encontró una visita para el ID: " + idVisita));
        return convertirAVisitaDTO(visita);
    }

    // Agregar una nueva visita
    public VisitaDTO agregarVisita(VisitaDTO visitaDTO) {
        Comercial comercial = comercialService.buscarComercialPorId(visitaDTO.getIdComercial()); // Obtener el comercial asociado

        Visita visita = new Visita(
                comercial,
                visitaDTO.getFecha(),
                visitaDTO.getComentarios(),
                visitaDTO.getCodigoPropuesta()
        );

        Visita visitaGuardada = visitaRepository.save(visita);
        return convertirAVisitaDTO(visitaGuardada);
    }

    // Actualizar una visita existente
    public VisitaDTO actualizarVisita(Long idVisita, VisitaDTO visitaDTO) {
        Visita visitaExistente = visitaRepository.findById(idVisita)
                .orElseThrow(() -> new RuntimeException("No se encontró una visita para el ID: " + idVisita));

        // Actualizar los campos de la visita existente
        Comercial comercial = comercialService.buscarComercialPorId(visitaDTO.getIdComercial());
        visitaExistente.setIdComercial(comercial);
        visitaExistente.setComentarios(visitaDTO.getComentarios());
        visitaExistente.setCodigoPropuesta(visitaDTO.getCodigoPropuesta());

        Visita visitaActualizada = visitaRepository.save(visitaExistente);
        return convertirAVisitaDTO(visitaActualizada);
    }

    // Eliminar una visita por ID
    public void eliminarVisita(Long idVisita) {
        if (!visitaRepository.existsById(idVisita)) {
            throw new RuntimeException("No se encontró una visita para el ID: " + idVisita);
        }

        visitaRepository.deleteById(idVisita);
    }

    // Método para convertir Visita a VisitaDTO
    private VisitaDTO convertirAVisitaDTO(Visita visita) {
        return new VisitaDTO(
                visita.getIdVisita(),
                visita.getIdComercial().getIdComercial(),
                visita.getFecha(),
                visita.getComentarios(),
                visita.getCodigoPropuesta()
        );
    }
}
