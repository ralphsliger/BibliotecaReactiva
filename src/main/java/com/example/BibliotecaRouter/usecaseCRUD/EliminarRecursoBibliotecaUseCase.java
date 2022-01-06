package com.example.BibliotecaRouter.usecaseCRUD;


import com.example.BibliotecaRouter.mapper.RecursoBibliotecaMapper;
import com.example.BibliotecaRouter.repositories.RecursoBibliotecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class EliminarRecursoBibliotecaUseCase {
    private final RecursoBibliotecaRepository repositorioRecursoBiblioteca;
    private final RecursoBibliotecaMapper recursoBibliotecaMapper;

    @Autowired
    public EliminarRecursoBibliotecaUseCase(RecursoBibliotecaRepository repositorioRecursoBiblioteca, RecursoBibliotecaMapper recursoBibliotecaMapper) {
        this.repositorioRecursoBiblioteca = repositorioRecursoBiblioteca;
        this.recursoBibliotecaMapper = recursoBibliotecaMapper;
    }

    public Mono<Void> eliminarRecurso(String id){
        return repositorioRecursoBiblioteca.deleteById(id);
    }


}
