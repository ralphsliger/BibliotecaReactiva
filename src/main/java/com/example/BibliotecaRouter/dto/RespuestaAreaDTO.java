package com.example.BibliotecaRouter.dto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class RespuestaAreaDTO {
    private Mono<String> TipoArea;
    private Flux<RecursoBibliotecaDTO> recursos;

    public RespuestaAreaDTO() {
    }

    public Mono<String> getTipoArea() {
        return TipoArea;
    }

    public void setTipoArea(Mono<String> tipoArea) {
        TipoArea = tipoArea;
    }

    public Flux<RecursoBibliotecaDTO> getRecursos() {
        return recursos;
    }

    public void setRecursos(Flux<RecursoBibliotecaDTO> recursos) {
        this.recursos = recursos;
    }
}
