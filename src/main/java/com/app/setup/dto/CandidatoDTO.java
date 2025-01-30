package com.app.setup.dto;

import com.app.setup.entity.Sede;

public class CandidatoDTO {

    private Long idCandidato;
    private Long idSede;
    private String nombre;
    private String apellidoPa;
    private String apellidoMa;
    private String telefono;
    private String correo;
    private String nivelEstudios;
    private String especializacion;

    public CandidatoDTO() {
    }

    public CandidatoDTO(Long idCandidato, Long idSede, String nombre, String apellidoPa, String apellidoMa, String telefono, String correo, String nivelEstudios, String especializacion) {
        this.idCandidato = idCandidato;
        this.idSede = idSede;
        this.nombre = nombre;
        this.apellidoPa = apellidoPa;
        this.apellidoMa = apellidoMa;
        this.telefono = telefono;
        this.correo = correo;
        this.nivelEstudios = nivelEstudios;
        this.especializacion = especializacion;
    }

    public Long getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(Long idCandidato) {
        this.idCandidato = idCandidato;
    }

    public Long getIdSede() {
        return idSede;
    }

    public void setIdSede(Long idSede) {
        this.idSede = idSede;
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

    public String getNivelEstudios() {
        return nivelEstudios;
    }

    public void setNivelEstudios(String nivelEstudios) {
        this.nivelEstudios = nivelEstudios;
    }

    public String getEspecializacion() {
        return especializacion;
    }

    public void setEspecializacion(String especializacion) {
        this.especializacion = especializacion;
    }
}
