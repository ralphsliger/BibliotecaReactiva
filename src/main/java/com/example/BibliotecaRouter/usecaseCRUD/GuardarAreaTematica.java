package com.example.BibliotecaRouter.usecaseCRUD;

import com.example.BibliotecaRouter.dto.AreaTematicaDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface GuardarAreaTematica {
    public Mono<AreaTematicaDTO> apply(AreaTematicaDTO areaTematicaDTO);
}
