package com.example.BibliotecaRouter.usecaseCRUD;

import com.example.BibliotecaRouter.dto.RecursoBibliotecaDTO;
import reactor.core.publisher.Mono;

public interface GuardarRecursoBiblioteca {
    public Mono<RecursoBibliotecaDTO> apply(RecursoBibliotecaDTO recursoBibliotecaDTO);
}
