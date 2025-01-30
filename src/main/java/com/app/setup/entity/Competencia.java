package com.app.setup.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table
public class Competencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompetencia;

    @Column
    private String nombreCompetencia;
    @Column
    private String descripcion;
    @Column
    private LocalDateTime fechaCreacion;

    public Competencia() {
    }

    public Competencia(String nombreCompetencia, String descripcion, LocalDateTime fechaCreacion) {
        this.nombreCompetencia = nombreCompetencia;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
    }

    public Long getIdCompetencia() {
        return idCompetencia;
    }

    public void setIdCompetencia(Long idCompetencia) {
        this.idCompetencia = idCompetencia;
    }

    public String getNombreCompetencia() {
        return nombreCompetencia;
    }

    public void setNombreCompetencia(String nombreCompetencia) {
        this.nombreCompetencia = nombreCompetencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
