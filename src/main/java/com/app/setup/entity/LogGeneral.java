package com.app.setup.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "logs_generales")
public class LogGeneral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String tabla;

    @Column(nullable = false)
    private Integer idRegistro;

    @Column(nullable = false, length = 10)
    private String operacion;

    @Column(nullable = false)
    private LocalDateTime fecha;

    public LogGeneral() {
    }

    public LogGeneral(String tabla, Integer idRegistro, String operacion, LocalDateTime fecha) {
        this.tabla = tabla;
        this.idRegistro = idRegistro;
        this.operacion = operacion;
        this.fecha = fecha;
    }

    @PrePersist
    public void prePersist() {
        if (this.fecha == null) {
            this.fecha = LocalDateTime.now();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public Integer getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
