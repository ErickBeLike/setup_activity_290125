package com.app.setup.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table
public class Sede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSede;

    @Column
    private String telefono;
    @Column
    private String poblacion;
    @Column
    private String codigoPostal;
    @Column
    private String direccion;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaInauguracion;
    @Column
    private String nombreResponsable;

    public Sede() {
    }

    public Sede(String telefono, String poblacion, String codigoPostal, String direccion, LocalDate fechaInauguracion, String nombreResponsable) {
        this.telefono = telefono;
        this.poblacion = poblacion;
        this.codigoPostal = codigoPostal;
        this.direccion = direccion;
        this.fechaInauguracion = fechaInauguracion;
        this.nombreResponsable = nombreResponsable;
    }

    @PrePersist
    public void prePersist() {
        // Si fechaContratacion no está establecida, la asigna con la fecha actual
        if (this.fechaInauguracion == null) {
            this.fechaInauguracion = LocalDate.now();
        }
    }

    public Long getIdSede() {
        return idSede;
    }

    public void setIdSede(Long idSede) {
        this.idSede = idSede;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechaInauguracion() {
        return fechaInauguracion;
    }

    public void setFechaInauguracion(LocalDate fechaInauguracion) {
        this.fechaInauguracion = fechaInauguracion;
    }

    public String getNombreResponsable() {
        return nombreResponsable;
    }

    public void setNombreResponsable(String nombreResponsable) {
        this.nombreResponsable = nombreResponsable;
    }
}
