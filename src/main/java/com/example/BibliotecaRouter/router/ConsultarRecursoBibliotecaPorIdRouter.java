package com.example.BibliotecaRouter.router;

import com.example.BibliotecaRouter.dto.RecursoBibliotecaDTO;
import com.example.BibliotecaRouter.usecaseCRUD.ConsultarRecursoBibliotecaIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ConsultarRecursoBibliotecaPorIdRouter {

    @Bean
    public RouterFunction<ServerResponse>consultarRecursoId (ConsultarRecursoBibliotecaIdUseCase useCaseConsultarRecursoId){
        return  route(GET("/recurso/consultar/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request-> ServerResponse.ok()
                .body(useCaseConsultarRecursoId.apply(request.pathVariable("id")), RecursoBibliotecaDTO.class));
    }
}
