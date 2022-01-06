package com.example.BibliotecaRouter.mapper;

import com.example.BibliotecaRouter.dto.RecursoBibliotecaDTO;
import com.example.BibliotecaRouter.dto.RespuestaDTO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Function;


public class RespuestaRecursoMapper {

    private Date objDate = new Date();
    private  String strDateFormat = "hh: mm: ss a dd-MMM-aaaa";
    private SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);

    public Function<RecursoBibliotecaDTO, RespuestaDTO> mapperPrestarRecurso(){
        return recurso ->{
            RespuestaDTO respuestaDTO = new RespuestaDTO();
            String mensaje = "";
            respuestaDTO.setMensaje(mensaje);
            respuestaDTO.setDisponible(recurso.isRecursoDisponible());
            respuestaDTO.setFechaPrestamo(recurso.getFechaPrestamoRecurso());
            respuestaDTO.setNombre(recurso.getNombreRecurso());
            return respuestaDTO;

        };
    }
    public Function<RecursoBibliotecaDTO, RespuestaDTO>mapperConsultarRecurso(){
        return recurso ->{
            RespuestaDTO respuestaDTO = new RespuestaDTO();
            String mensaje = recurso.isRecursoDisponible()?"El recurso se encuentra disponible para prestamo" : "El recurso no se encuntra disponibles";
            respuestaDTO.setMensaje(mensaje);
            respuestaDTO.setDisponible(recurso.isRecursoDisponible());
            respuestaDTO.setFechaPrestamo(recurso.getFechaPrestamoRecurso());
            respuestaDTO.setNombre((recurso.getNombreRecurso()));
            return respuestaDTO;

        };
    }
}
