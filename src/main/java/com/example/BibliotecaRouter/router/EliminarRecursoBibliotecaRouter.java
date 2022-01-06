package com.example.BibliotecaRouter.router;

import com.example.BibliotecaRouter.dto.RecursoBibliotecaDTO;
import com.example.BibliotecaRouter.usecaseCRUD.EliminarRecursoBibliotecaUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class EliminarRecursoBibliotecaRouter {

    @Bean
    public RouterFunction<ServerResponse> eliminarRecurso(EliminarRecursoBibliotecaUseCase useCaseEliminarRecurso){
        return route(DELETE("/recurso/eliminar/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request-> ServerResponse.ok()
        .body(useCaseEliminarRecurso.eliminarRecurso(request.pathVariable("id")), RecursoBibliotecaDTO.class));
    }

}
