package com.api.login.Documentos.MinutaDeReunion.Mapper;

import com.api.login.Documentos.MinutaDeReunion.DTO.MinuReunPuntosTratarDTO;
import com.api.login.Documentos.MinutaDeReunion.Pojo.MinuReunPuntosTratar;
import com.api.login.Documentos.MinutaDeReunion.Pojo.MinutaReunion;
import org.springframework.stereotype.Component;

@Component
public class MinuReunPuntosTratarMapper {

    public MinuReunPuntosTratarDTO toDTO(MinuReunPuntosTratar entity) {
        MinuReunPuntosTratarDTO dto = new MinuReunPuntosTratarDTO();
        dto.setIdMinuReunPuntosTratar(entity.getIdMinuReunPuntosTratar());
        dto.setPunto(entity.getPunto());
        dto.setIdMinutaReunion(entity.getMinutaReunion().getIdMinutaReunion());
        return dto;
    }

    public MinuReunPuntosTratar toEntity(MinuReunPuntosTratarDTO dto, MinutaReunion minutaReunion) {
        MinuReunPuntosTratar entity = new MinuReunPuntosTratar();
        entity.setIdMinuReunPuntosTratar(dto.getIdMinuReunPuntosTratar());
        entity.setPunto(dto.getPunto());
        entity.setMinutaReunion(minutaReunion);
        return entity;
    }
}

