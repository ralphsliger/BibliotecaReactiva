package com.example.BibliotecaRouter.usecaseCRUD;


import com.example.BibliotecaRouter.dto.RecursoBibliotecaDTO;
import com.example.BibliotecaRouter.mapper.RecursoBibliotecaMapper;
import com.example.BibliotecaRouter.repositories.RecursoBibliotecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class ConsultarRecursoBibliotecaIdUseCase {

    private final RecursoBibliotecaRepository repositorioRecursoBiblioteca;
    private  final RecursoBibliotecaMapper recursoBibliotecaMapper = new RecursoBibliotecaMapper() ;

    @Autowired
    public ConsultarRecursoBibliotecaIdUseCase(RecursoBibliotecaRepository repositorioRecursoBiblioteca) {
        this.repositorioRecursoBiblioteca = repositorioRecursoBiblioteca;

    }
    public Mono<RecursoBibliotecaDTO> apply(String id){
        var respuesta = repositorioRecursoBiblioteca.findById(id).map(recursoBibliotecaMapper.mapRecursoToDTO());
        return respuesta;
    }

}
