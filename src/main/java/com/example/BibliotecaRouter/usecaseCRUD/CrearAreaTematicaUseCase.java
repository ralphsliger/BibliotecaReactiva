package com.example.BibliotecaRouter.usecaseCRUD;

import com.example.BibliotecaRouter.dto.AreaTematicaDTO;
import com.example.BibliotecaRouter.mapper.AreaTematicaMapper;
import com.example.BibliotecaRouter.repositories.AreaTematicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class CrearAreaTematicaUseCase implements GuardarAreaTematica {
    private final AreaTematicaRepository repositorioAreaTematica;
    private final AreaTematicaMapper areaTematicaMapper;

    @Autowired
    public CrearAreaTematicaUseCase(AreaTematicaRepository repositorioAreaTematica, AreaTematicaMapper areaTematicaMapper) {
        this.repositorioAreaTematica = repositorioAreaTematica;
        this.areaTematicaMapper = areaTematicaMapper;

    }

    @Override
    public Mono<AreaTematicaDTO> apply(AreaTematicaDTO areaTematicaDTO) {
        var respuesta = repositorioAreaTematica
                .save(areaTematicaMapper.mapperToArea(null)
                        .apply(areaTematicaDTO))
                .map(areaTematicaMapper.mapAreaToAreaDTO());
        return respuesta;
    }
}
