package com.app.setup.entity;

import jakarta.persistence.*;

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
    private LocalDateTime fechaInauguracion;
    @Column
    private String nombreResponsable;

    public Sede() {
    }

    public Sede(String telefono, String poblacion, String codigoPostal, String direccion, LocalDateTime fechaInauguracion, String nombreResponsable) {
        this.telefono = telefono;
        this.poblacion = poblacion;
        this.codigoPostal = codigoPostal;
        this.direccion = direccion;
        this.fechaInauguracion = fechaInauguracion;
        this.nombreResponsable = nombreResponsable;
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

    public LocalDateTime getFechaInauguracion() {
        return fechaInauguracion;
    }

    public void setFechaInauguracion(LocalDateTime fechaInauguracion) {
        this.fechaInauguracion = fechaInauguracion;
    }

    public String getNombreResponsable() {
        return nombreResponsable;
    }

    public void setNombreResponsable(String nombreResponsable) {
        this.nombreResponsable = nombreResponsable;
    }
}
