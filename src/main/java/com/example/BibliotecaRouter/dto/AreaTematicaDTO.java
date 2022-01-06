package com.example.BibliotecaRouter.dto;

import java.util.Objects;

public class AreaTematicaDTO {

    private String IdAreaTematica;
    private String categoriaAreaTematica;

    public AreaTematicaDTO(String idArea, String categoriaArea) {
        this.categoriaAreaTematica = categoriaArea;
        this.IdAreaTematica = idArea;
    }


    public String getIdAreaTematica() {
        return IdAreaTematica;
    }

    public void setIdAreaTematica(String idAreaTematica) {
        IdAreaTematica = idAreaTematica;
    }

    public String getCategoriaAreaTematica() {
        return categoriaAreaTematica;
    }

    public void setCategoriaAreaTematica(String categoriaAreaTematica) {
        this.categoriaAreaTematica = categoriaAreaTematica;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AreaTematicaDTO that = (AreaTematicaDTO) o;
        return Objects.equals(IdAreaTematica, that.IdAreaTematica) && Objects.equals(categoriaAreaTematica, that.categoriaAreaTematica);
    }

    @Override
    public int hashCode() {
        return Objects.hash(IdAreaTematica, categoriaAreaTematica);
    }

    @Override
    public String toString() {
        return "AreaTematicaDTO{" +
                "IdAreaTematica='" + IdAreaTematica + '\'' +
                ", categoriaAreaTematica='" + categoriaAreaTematica + '\'' +
                '}';
    }
}
