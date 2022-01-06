package com.example.BibliotecaRouter.usecaseCRUD;


import com.example.BibliotecaRouter.dto.AreaTematicaDTO;
import com.example.BibliotecaRouter.mapper.AreaTematicaMapper;
import com.example.BibliotecaRouter.repositories.AreaTematicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;


@Service
@Validated
public class listarAreaTematicaUseCase implements Supplier<Flux<AreaTematicaDTO>>{

    private final AreaTematicaRepository repositorioAreaTematica;
    private final AreaTematicaMapper areaTematicaMapper;

    @Autowired
    public listarAreaTematicaUseCase(AreaTematicaRepository repositorioAreaTematica, AreaTematicaMapper areaTematicaMapper) {
        this.repositorioAreaTematica = repositorioAreaTematica;
        this.areaTematicaMapper = areaTematicaMapper;
    }

    @Override
    public Flux<AreaTematicaDTO> get() {
        var respuesta= repositorioAreaTematica.findAll().map(areaTematicaMapper.mapAreaToAreaDTO());
        return respuesta;
    }

}
