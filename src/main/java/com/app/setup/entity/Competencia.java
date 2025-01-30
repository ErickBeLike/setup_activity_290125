package com.app.setup.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaCreacion;

    public Competencia() {
    }

    public Competencia(String nombreCompetencia, String descripcion, LocalDate fechaCreacion) {
        this.nombreCompetencia = nombreCompetencia;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
    }

    @PrePersist
    public void prePersist() {
        // Si fechaContratacion no está establecida, la asigna con la fecha actual
        if (this.fechaCreacion == null) {
            this.fechaCreacion = LocalDate.now();
        }
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

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
