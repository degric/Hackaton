package com.api.login.Documentos.MinutaDeReunion.Mapper;

import com.api.login.Documentos.MinutaDeReunion.DTO.MinuReunDatosDTO;
import com.api.login.Documentos.MinutaDeReunion.Pojo.MinuReunDatos;
import com.api.login.Documentos.MinutaDeReunion.Pojo.MinutaReunion;
import org.springframework.stereotype.Component;

@Component
public class MinuReunDatosMapper {

    public MinuReunDatosDTO toDTO(MinuReunDatos entity) {
        MinuReunDatosDTO dto = new MinuReunDatosDTO();
        dto.setIdMinuReunDatos(entity.getIdMinuReunDatos());
        dto.setFecha(entity.getFecha());
        dto.setDepartamento(entity.getDepartamento());
        dto.setAsuntoATratar(entity.getAsuntoATratar());
        dto.setIdMinutaReunion(entity.getMinutaReunion().getIdMinutaReunion());
        return dto;
    }

    public MinuReunDatos toEntity(MinuReunDatosDTO dto, MinutaReunion minutaReunion) {
        MinuReunDatos entity = new MinuReunDatos();
        entity.setIdMinuReunDatos(dto.getIdMinuReunDatos());
        entity.setFecha(dto.getFecha());
        entity.setDepartamento(dto.getDepartamento());
        entity.setAsuntoATratar(dto.getAsuntoATratar());
        entity.setMinutaReunion(minutaReunion);
        return entity;
    }
}

