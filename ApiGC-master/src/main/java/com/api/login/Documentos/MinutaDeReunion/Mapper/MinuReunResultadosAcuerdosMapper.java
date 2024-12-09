package com.api.login.Documentos.MinutaDeReunion.Mapper;

import com.api.login.Documentos.MinutaDeReunion.DTO.MinuReunResultadosAcuerdosDTO;
import com.api.login.Documentos.MinutaDeReunion.Pojo.MinuReunResultadosAcuerdos;
import com.api.login.Documentos.MinutaDeReunion.Pojo.MinutaReunion;
import org.springframework.stereotype.Component;

@Component
public class MinuReunResultadosAcuerdosMapper {

    public MinuReunResultadosAcuerdosDTO toDTO(MinuReunResultadosAcuerdos entity) {
        MinuReunResultadosAcuerdosDTO dto = new MinuReunResultadosAcuerdosDTO();
        dto.setIdMinuReunResultadosAcuerdos(entity.getIdMinuReunResultadosAcuerdos());
        dto.setContenido(entity.getContenido());
        dto.setIdMinutaReunion(entity.getMinutaReunion().getIdMinutaReunion());
        return dto;
    }

    public MinuReunResultadosAcuerdos toEntity(MinuReunResultadosAcuerdosDTO dto, MinutaReunion minutaReunion) {
        MinuReunResultadosAcuerdos entity = new MinuReunResultadosAcuerdos();
        entity.setIdMinuReunResultadosAcuerdos(dto.getIdMinuReunResultadosAcuerdos());
        entity.setContenido(dto.getContenido());
        entity.setMinutaReunion(minutaReunion);
        return entity;
    }
}

