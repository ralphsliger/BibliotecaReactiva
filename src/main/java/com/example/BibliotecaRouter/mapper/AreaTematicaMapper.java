package com.example.BibliotecaRouter.mapper;

import com.example.BibliotecaRouter.dto.AreaTematicaDTO;
import com.example.BibliotecaRouter.models.AreaTematica;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AreaTematicaMapper {


    public Function<AreaTematicaDTO, AreaTematica> mapperToArea(String id){
        return  updateArea ->{
            var area = new AreaTematica();
            area.setIdArea(id);
            area.setCategoriaArea(updateArea.getCategoriaAreaTematica());
            return area;
        };
    }

    public Function<AreaTematica, AreaTematicaDTO> mapAreaToAreaDTO(){
        return entity -> new AreaTematicaDTO(entity.getIdArea(),entity.getCategoriaArea());
    }


}
