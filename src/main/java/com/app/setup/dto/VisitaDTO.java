package com.app.setup.dto;

import com.app.setup.entity.Comercial;

import java.util.Date;

public class VisitaDTO {

    private Long idVisita;
    private Long idComercial;
    private Date fecha;
    private String comentarios;
    private int codigoPropuesta;

    public VisitaDTO() {
    }

    public VisitaDTO(Long idVisita, Long idComercial, Date fecha, String comentarios, int codigoPropuesta) {
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
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
