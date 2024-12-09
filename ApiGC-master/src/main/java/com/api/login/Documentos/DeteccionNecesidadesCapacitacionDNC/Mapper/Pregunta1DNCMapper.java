package com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Mapper;

import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.DTO.Pregunta1DNCDTO;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Pojo.DetecionNeCaDNC;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Pojo.Pregunta1DNC;
import org.springframework.stereotype.Component;

@Component
public class Pregunta1DNCMapper {

    public Pregunta1DNCDTO toDTO(Pregunta1DNC entity) {
        Pregunta1DNCDTO dto = new Pregunta1DNCDTO();
        dto.setIdPreguntas1DNC(entity.getIdPreguntas1DNC());
        dto.setContenido1(entity.getContenido1());
        dto.setContenido2(entity.getContenido2());
        dto.setContenido3(entity.getContenido3());
        dto.setIdDetecionNeCaDNC(entity.getDetecionNeCaDNC().getIdDetecionNeCaDNC());
        return dto;
    }

    public Pregunta1DNC toEntity(Pregunta1DNCDTO dto, DetecionNeCaDNC detecionNeCaDNC) {
        Pregunta1DNC entity = new Pregunta1DNC();
        entity.setIdPreguntas1DNC(dto.getIdPreguntas1DNC());
        entity.setContenido1(dto.getContenido1());
        entity.setContenido2(dto.getContenido2());
        entity.setContenido3(dto.getContenido3());
        entity.setDetecionNeCaDNC(detecionNeCaDNC);
        return entity;
    }
}
