package com.app.setup.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table
public class Comercial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComercial;

    @Column
    private String nombre;
    @Column
    private String apellidoPa;
    @Column
    private String apellidoMa;
    @Column
    private String telefono;
    @Column
    private String correo;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaContratacion;
    @Column(precision = 10, scale = 2)
    private BigDecimal importeTotal;

    public Comercial() {
    }

    public Comercial(String nombre, String apellidoPa, String apellidoMa, String telefono, String correo, LocalDate fechaContratacion, BigDecimal importeTotal) {
        this.nombre = nombre;
        this.apellidoPa = apellidoPa;
        this.apellidoMa = apellidoMa;
        this.telefono = telefono;
        this.correo = correo;
        this.fechaContratacion = fechaContratacion;
        this.importeTotal = importeTotal;
    }

    public Long getIdComercial() {
        return idComercial;
    }

    public void setIdComercial(Long idComercial) {
        this.idComercial = idComercial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPa() {
        return apellidoPa;
    }

    public void setApellidoPa(String apellidoPa) {
        this.apellidoPa = apellidoPa;
    }

    public String getApellidoMa() {
        return apellidoMa;
    }

    public void setApellidoMa(String apellidoMa) {
        this.apellidoMa = apellidoMa;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public BigDecimal getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(BigDecimal importeTotal) {
        this.importeTotal = importeTotal;
    }
}
