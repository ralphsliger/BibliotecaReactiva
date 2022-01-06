package com.example.BibliotecaRouter.router;


import com.example.BibliotecaRouter.dto.AreaTematicaDTO;
import com.example.BibliotecaRouter.usecaseCRUD.ConsultarAreaTematicaIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ConsultarAreaTematicaPorIdRouter {

    @Bean
    public RouterFunction<ServerResponse>consultarAreaId(ConsultarAreaTematicaIdUseCase useCaseConsultarAreaId){
        return route(GET("/areatematica/consultar/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request->ServerResponse.ok()
                    .body(useCaseConsultarAreaId.apply(request.pathVariable("id")), AreaTematicaDTO.class));
    }
}
