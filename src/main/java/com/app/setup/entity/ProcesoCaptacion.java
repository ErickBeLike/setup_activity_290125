package com.app.setup.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class ProcesoCaptacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProcesoCaptacion;

    @Column
    private String tipo;
    @Column
    private Date fechaInicio;
    @Column
    private Date fechaFin;

    public ProcesoCaptacion() {
    }

    public ProcesoCaptacion(String tipo, Date fechaInicio, Date fechaFin) {
        this.tipo = tipo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Long getIdProcesoCaptacion() {
        return idProcesoCaptacion;
    }

    public void setIdProcesoCaptacion(Long idProcesoCaptacion) {
        this.idProcesoCaptacion = idProcesoCaptacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
}
