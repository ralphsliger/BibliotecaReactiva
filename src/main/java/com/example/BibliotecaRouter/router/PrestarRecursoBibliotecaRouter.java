package com.example.BibliotecaRouter.router;

import com.example.BibliotecaRouter.UseCaseServiceRecurso.UseCasePrestarRecurso;
import com.example.BibliotecaRouter.dto.RespuestaDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class PrestarRecursoBibliotecaRouter {

    @Bean
    public RouterFunction<ServerResponse> prestarRecurso(UseCasePrestarRecurso useCasePrestarRecurso){
       return route(PUT("/recurso/prestar/{nombre}").and(accept(MediaType.APPLICATION_JSON)),
               request-> ServerResponse.ok()
                    .body(useCasePrestarRecurso.apply(request.pathVariable("nombre")), RespuestaDTO.class));
    }
}
