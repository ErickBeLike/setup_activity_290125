package com.app.setup.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
public class Visita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVisita;

    @ManyToOne
    @JoinColumn
    private Comercial idComercial;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;
    @Column
    private String comentarios;
    @Column
    private int codigoPropuesta;

    public Visita() {
    }

    public Visita(Comercial idComercial, LocalDate fecha, String comentarios, int codigoPropuesta) {
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

    public Comercial getIdComercial() {
        return idComercial;
    }

    public void setIdComercial(Comercial idComercial) {
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
