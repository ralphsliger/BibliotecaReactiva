package com.example.BibliotecaRouter.router;


import com.example.BibliotecaRouter.dto.RecursoBibliotecaDTO;
import com.example.BibliotecaRouter.usecaseCRUD.CrearRecursoBibliotecaUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CrearRecursoBibliotecaRouter {

    @Bean
    public RouterFunction<ServerResponse> crearRecurso(CrearRecursoBibliotecaUseCase useCaseCrearRecurso) {
        return route(POST("/recurso/crear").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(RecursoBibliotecaDTO.class)
                        .flatMap(questionDTO -> useCaseCrearRecurso.apply(questionDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result))
                        )

        );
    }
}
