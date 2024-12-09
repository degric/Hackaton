package com.api.login.Documentos.MinutaDeReunion.Mapper;

import com.api.login.Documentos.MinutaDeReunion.DTO.MinuReunParticipantesDTO;
import com.api.login.Documentos.MinutaDeReunion.Pojo.MinuReunParticipantes;
import com.api.login.Documentos.MinutaDeReunion.Pojo.MinutaReunion;
import org.springframework.stereotype.Component;

@Component
public class MinuReunParticipantesMapper {

    public MinuReunParticipantesDTO toDTO(MinuReunParticipantes entity) {
        MinuReunParticipantesDTO dto = new MinuReunParticipantesDTO();
        dto.setIdMinuReunParticipantes(entity.getIdMinuReunParticipantes());
        dto.setNombre(entity.getNombre());
        dto.setIdMinutaReunion(entity.getMinutaReunion().getIdMinutaReunion());
        return dto;
    }

    public MinuReunParticipantes toEntity(MinuReunParticipantesDTO dto, MinutaReunion minutaReunion) {
        MinuReunParticipantes entity = new MinuReunParticipantes();
        entity.setIdMinuReunParticipantes(dto.getIdMinuReunParticipantes());
        entity.setNombre(dto.getNombre());
        entity.setMinutaReunion(minutaReunion);
        return entity;
    }
}

