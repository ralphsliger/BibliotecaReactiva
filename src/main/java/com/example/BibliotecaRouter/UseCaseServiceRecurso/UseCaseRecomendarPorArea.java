package com.example.BibliotecaRouter.UseCaseServiceRecurso;

import com.example.BibliotecaRouter.dto.RecursoBibliotecaDTO;
import com.example.BibliotecaRouter.mapper.RecursoBibliotecaMapper;
import com.example.BibliotecaRouter.repositories.RecursoBibliotecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Function;


@Service
@Validated
public class UseCaseRecomendarPorArea implements Function <String, Flux<RecursoBibliotecaDTO>> {

    private final RecursoBibliotecaRepository repositorioRecursoBiblioteca;
    private final RecursoBibliotecaMapper recursoBibliotecaMapper = new RecursoBibliotecaMapper();

    @Autowired
    public UseCaseRecomendarPorArea(RecursoBibliotecaRepository repositorioRecursoBiblioteca) {
        this.repositorioRecursoBiblioteca = repositorioRecursoBiblioteca;
    }


    @Override
    public Flux<RecursoBibliotecaDTO> apply(String IdArea) {
        return repositorioRecursoBiblioteca.findRecursoByIdArea(IdArea)
                .map(recursoBibliotecaMapper.mapRecursoToDTO());

    }

}
