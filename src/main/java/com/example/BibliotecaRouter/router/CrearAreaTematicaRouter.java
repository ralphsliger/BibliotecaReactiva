package com.example.BibliotecaRouter.router;


import com.example.BibliotecaRouter.dto.AreaTematicaDTO;
import com.example.BibliotecaRouter.usecaseCRUD.CrearAreaTematicaUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CrearAreaTematicaRouter {

    @Bean
    public RouterFunction<ServerResponse> crearArea (CrearAreaTematicaUseCase useCaseCrearArea) {
        return route(POST("/areatematica/crear").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(AreaTematicaDTO.class)
                        .flatMap(questionDTO -> useCaseCrearArea.apply(questionDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result))
                        )

        );
    }
}