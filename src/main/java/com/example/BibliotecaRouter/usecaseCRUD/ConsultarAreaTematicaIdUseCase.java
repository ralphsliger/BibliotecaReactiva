package com.example.BibliotecaRouter.usecaseCRUD;

import com.example.BibliotecaRouter.dto.AreaTematicaDTO;
import com.example.BibliotecaRouter.mapper.AreaTematicaMapper;
import com.example.BibliotecaRouter.repositories.AreaTematicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@Validated
public class ConsultarAreaTematicaIdUseCase implements Function<String, Mono<AreaTematicaDTO>> {
    private final AreaTematicaRepository repositorioAreaTematica;
    private  final AreaTematicaMapper areaTematicaMapper;

    @Autowired
    public ConsultarAreaTematicaIdUseCase(AreaTematicaRepository repositorioAreaTematica, AreaTematicaMapper areaTematicaMapper) {
        this.repositorioAreaTematica = repositorioAreaTematica;
        this.areaTematicaMapper = areaTematicaMapper;
    }

    @Override
    public Mono<AreaTematicaDTO> apply(String id) {
        var respuesta = repositorioAreaTematica.findById(id).map(areaTematicaMapper.mapAreaToAreaDTO());
        return respuesta;
    }
}
