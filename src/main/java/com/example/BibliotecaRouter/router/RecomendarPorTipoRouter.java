package com.example.BibliotecaRouter.router;

import com.example.BibliotecaRouter.UseCaseServiceRecurso.UseCaseRecomendarPorTipoRecurso;
import com.example.BibliotecaRouter.dto.RecursoBibliotecaDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class RecomendarPorTipoRouter {

    @Bean
    public RouterFunction<ServerResponse> recomendarPorTipoRecurso(UseCaseRecomendarPorTipoRecurso useCaseRecomendarPorTipoRecurso) {
        return route(GET("/tipo/recomendar/porTipo/{tipo}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .body(useCaseRecomendarPorTipoRecurso.apply(request.pathVariable("tipo")), RecursoBibliotecaDTO.class));
    }
}
