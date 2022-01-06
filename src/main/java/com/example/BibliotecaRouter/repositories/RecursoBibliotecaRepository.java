package com.example.BibliotecaRouter.repositories;

import com.example.BibliotecaRouter.models.RecursoBiblioteca;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RecursoBibliotecaRepository extends ReactiveMongoRepository<RecursoBiblioteca, String> {

    Flux<RecursoBiblioteca> findRecursoByIdArea(String id);
    Flux<RecursoBiblioteca> findRecursoBytipoRecurso(String tipo);
    Mono<RecursoBiblioteca> findRecusoBynombre(String nombre);
}
