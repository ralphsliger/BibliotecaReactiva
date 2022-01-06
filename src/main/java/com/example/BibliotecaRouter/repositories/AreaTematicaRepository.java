package com.example.BibliotecaRouter.repositories;

import com.example.BibliotecaRouter.models.AreaTematica;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface AreaTematicaRepository extends ReactiveMongoRepository<AreaTematica, String> {

}
