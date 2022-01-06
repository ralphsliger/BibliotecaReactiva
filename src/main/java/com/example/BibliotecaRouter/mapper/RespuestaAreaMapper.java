package com.example.BibliotecaRouter.mapper;

import com.example.BibliotecaRouter.dto.RecursoBibliotecaDTO;
import com.example.BibliotecaRouter.dto.RespuestaAreaDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

public class RespuestaAreaMapper {

    public Function<Flux<RecursoBibliotecaDTO>, RespuestaAreaDTO> recursoToRespuesta(Mono<String> tipoArea){
        return recursoFLux ->{
          RespuestaAreaDTO respuestaAreaDTO = new RespuestaAreaDTO();
          respuestaAreaDTO.setTipoArea(tipoArea);
          respuestaAreaDTO.setRecursos(recursoFLux);
          return respuestaAreaDTO;
        };
    }

}
