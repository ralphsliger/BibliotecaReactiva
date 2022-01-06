package com.example.BibliotecaRouter.router;

import com.example.BibliotecaRouter.UseCaseServiceRecurso.UseCaseRecomendarPorArea;
import com.example.BibliotecaRouter.dto.RecursoBibliotecaDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RecomendarPorAreaTematicaRouter {

    @Bean
    public RouterFunction<ServerResponse> RecomendarArea(UseCaseRecomendarPorArea useCaseRecomendarPorArea){
        return route(GET("/areatematica/recomendar/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request-> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(useCaseRecomendarPorArea.apply(request.pathVariable("id")),RecursoBibliotecaDTO.class)));
    }
}
