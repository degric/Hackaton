package com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Mapper;


import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.DTO.Preguntas2DNCDTO;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Pojo.DetecionNeCaDNC;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Pojo.Preguntas2DNC;
import org.springframework.stereotype.Component;

@Component
public class Preguntas2DNCMapper {

    public Preguntas2DNCDTO toDTO(Preguntas2DNC entity) {
        Preguntas2DNCDTO dto = new Preguntas2DNCDTO();
        dto.setIdPreguntas2DNC(entity.getIdPreguntas2DNC());
        dto.setContenido1(entity.getContenido1());
        dto.setContenido2(entity.getContenido2());
        dto.setContenido3(entity.getContenido3());
        dto.setIdDetecionNeCaDNC(entity.getDetecionNeCaDNC().getIdDetecionNeCaDNC());
        return dto;
    }

    public Preguntas2DNC toEntity(Preguntas2DNCDTO dto, DetecionNeCaDNC detecionNeCaDNC) {
        Preguntas2DNC entity = new Preguntas2DNC();
        entity.setIdPreguntas2DNC(dto.getIdPreguntas2DNC());
        entity.setContenido1(dto.getContenido1());
        entity.setContenido2(dto.getContenido2());
        entity.setContenido3(dto.getContenido3());
        entity.setDetecionNeCaDNC(detecionNeCaDNC);
        return entity;
    }
}

