package com.example.BibliotecaRouter.UseCaseServiceRecurso;

import com.example.BibliotecaRouter.dto.RespuestaDTO;
import com.example.BibliotecaRouter.mapper.RecursoBibliotecaMapper;
import com.example.BibliotecaRouter.mapper.RespuestaRecursoMapper;
import com.example.BibliotecaRouter.repositories.RecursoBibliotecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Function;

@Service
@Validated
public class UseCasePrestarRecurso implements Function<String, Mono<RespuestaDTO>> {

    private Date objDate = new Date();
    private String strDateFormat = "hh: mm: ss a dd-MMM-aaaa";
    private SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
    private final RecursoBibliotecaRepository repositorioRecursoBiblioteca;
    private final RespuestaRecursoMapper respuestaRecursoMapper = new RespuestaRecursoMapper();
    private final RecursoBibliotecaMapper recursoBibliotecaMapper = new RecursoBibliotecaMapper();

    @Autowired
    public UseCasePrestarRecurso(RecursoBibliotecaRepository repositorioRecursoBiblioteca) {
        this.repositorioRecursoBiblioteca = repositorioRecursoBiblioteca;
    }

    @Override
    public Mono<RespuestaDTO> apply(String nombre) {
        var consulta = repositorioRecursoBiblioteca.findRecusoBynombre(nombre);
        var prestamoRecurso = consulta.flatMap(prestamo->{
            if (prestamo.getDisponible()){
                prestamo.setDisponible(false);
                prestamo.setFechaPrestamo(objSDF.format(objDate));
            }
            return repositorioRecursoBiblioteca.save(prestamo);
        });
        var respuestaDTO = prestamoRecurso.map(recursoBibliotecaMapper.mapRecursoToDTO()).map(respuestaRecursoMapper.mapperPrestarRecurso());

        var respuesta= consulta.map(recursoBibliotecaMapper.mapRecursoToDTO()).map(respuestaRecursoMapper.mapperPrestarRecurso()).map(prestamo ->{
            if (prestamo.getDisponible()){
                prestamo.setMensaje("el recuso fue prestado con exito");
                return prestamo;
            }else{
                prestamo.setMensaje("El recurso no esta disponible");
            }
            return prestamo;
        });
        return respuesta;

    }

}
