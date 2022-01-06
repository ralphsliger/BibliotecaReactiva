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
public class UseCaseRecomendarPorTipoRecurso implements Function<String, Flux<RecursoBibliotecaDTO>> {
    private final RecursoBibliotecaMapper recursoBibliotecaMapper = new RecursoBibliotecaMapper();
    private final RecursoBibliotecaRepository repositorioRecursoBiblioteca;

    @Autowired
    public UseCaseRecomendarPorTipoRecurso(RecursoBibliotecaRepository repositorioRecursoBiblioteca) {
        this.repositorioRecursoBiblioteca = repositorioRecursoBiblioteca;
    }

    @Override
    public Flux<RecursoBibliotecaDTO> apply(String tipoRecurso) {
        var tipo = repositorioRecursoBiblioteca.findRecursoBytipoRecurso(tipoRecurso).map(recursoBibliotecaMapper.mapRecursoToDTO());
        return tipo;
    }
}
