package com.example.BibliotecaRouter.router;


import com.example.BibliotecaRouter.UseCaseServiceRecurso.UseCaseConsultarIsDisponible;
import com.example.BibliotecaRouter.dto.RespuestaDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ConsultarDisponibilidadRecursoBibliotecaRouter {

    @Bean
    public RouterFunction<ServerResponse> consultarDiponiblidadRecurso(UseCaseConsultarIsDisponible caseConsultarDisponibilidadRecurso){
        return route(GET("/recurso/consultar/disponibilidad/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request ->ServerResponse.ok()
                        .body(caseConsultarDisponibilidadRecurso.apply(request.pathVariable("id")), RespuestaDTO.class));
    }

}
