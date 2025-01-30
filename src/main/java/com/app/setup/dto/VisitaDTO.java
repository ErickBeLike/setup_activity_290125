package com.app.setup.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class VisitaDTO {

    private Long idVisita;
    private Long idComercial;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;
    private String comentarios;
    private int codigoPropuesta;

    public VisitaDTO() {
    }

    public VisitaDTO(Long idVisita, Long idComercial, LocalDate fecha, String comentarios, int codigoPropuesta) {
        this.idVisita = idVisita;
        this.idComercial = idComercial;
        this.fecha = fecha;
        this.comentarios = comentarios;
        this.codigoPropuesta = codigoPropuesta;
    }

    public Long getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(Long idVisita) {
        this.idVisita = idVisita;
    }

    public Long getIdComercial() {
        return idComercial;
    }

    public void setIdComercial(Long idComercial) {
        this.idComercial = idComercial;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public int getCodigoPropuesta() {
        return codigoPropuesta;
    }

    public void setCodigoPropuesta(int codigoPropuesta) {
        this.codigoPropuesta = codigoPropuesta;
    }
}
