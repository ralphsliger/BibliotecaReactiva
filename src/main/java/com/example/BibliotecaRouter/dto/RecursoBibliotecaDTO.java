package com.example.BibliotecaRouter.dto;

import javax.validation.constraints.NotBlank;

public class RecursoBibliotecaDTO {

    private String idRecurso;

    @NotBlank
    private String tipoRecursoBiblioteca;
    private Boolean recursoDisponible;
    private String fechaPrestamoRecurso;
    @NotBlank
    private String nombreRecurso;
    @NotBlank
    private String idAreaTematica;

    public RecursoBibliotecaDTO() {
    }

    public RecursoBibliotecaDTO(String idRecurso, String tipoRecursoBiblioteca, Boolean recursoDisponible, String fechaPrestamoRecurso, String nombreRecurso, String idAreaTematica) {
        this.idRecurso = idRecurso;
        this.tipoRecursoBiblioteca = tipoRecursoBiblioteca;
        this.recursoDisponible = recursoDisponible;
        this.fechaPrestamoRecurso = fechaPrestamoRecurso;
        this.nombreRecurso = nombreRecurso;
        this.idAreaTematica = idAreaTematica;
    }

    public RecursoBibliotecaDTO(String tipoRecursoBiblioteca, Boolean recursoDisponible, String fechaPrestamoRecurso, String nombreRecurso, String idAreaTematica) {
        this.tipoRecursoBiblioteca = tipoRecursoBiblioteca;
        this.recursoDisponible = recursoDisponible;
        this.fechaPrestamoRecurso = fechaPrestamoRecurso;
        this.nombreRecurso = nombreRecurso;
        this.idAreaTematica = idAreaTematica;
    }

    public String getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(String idRecurso) {
        this.idRecurso = idRecurso;
    }

    public String getTipoRecursoBiblioteca() {
        return tipoRecursoBiblioteca;
    }

    public void setTipoRecursoBiblioteca(String tipoRecursoBiblioteca) {
        this.tipoRecursoBiblioteca = tipoRecursoBiblioteca;
    }

    public Boolean getRecursoDisponible() {
        return recursoDisponible;
    }

    public void setRecursoDisponible(Boolean recursoDisponible) {
        this.recursoDisponible = recursoDisponible;
    }

    public String getFechaPrestamoRecurso() {
        return fechaPrestamoRecurso;
    }

    public void setFechaPrestamoRecurso(String fechaPrestamoRecurso) {
        this.fechaPrestamoRecurso = fechaPrestamoRecurso;
    }

    public String getNombreRecurso() {
        return nombreRecurso;
    }

    public void setNombreRecurso(String nombreRecurso) {
        this.nombreRecurso = nombreRecurso;
    }

    public String getIdAreaTematica() {
        return idAreaTematica;
    }

    public void setIdAreaTematica(String idAreaTematica) {
        this.idAreaTematica = idAreaTematica;
    }

    public Boolean isRecursoDisponible() {
        return recursoDisponible;
    }


}
