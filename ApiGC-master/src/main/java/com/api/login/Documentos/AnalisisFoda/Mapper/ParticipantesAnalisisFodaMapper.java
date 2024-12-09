package com.api.login.Documentos.AnalisisFoda.Mapper;

import com.api.login.Documentos.AnalisisFoda.DTO.ParticipantesAnalisisFodaDTO;
import com.api.login.Documentos.AnalisisFoda.Pojo.AnalisisFoda;
import com.api.login.Documentos.AnalisisFoda.Pojo.ParticipantesAnalisisFoda;
import org.springframework.stereotype.Component;

@Component
public class ParticipantesAnalisisFodaMapper {

    public ParticipantesAnalisisFodaDTO toDTO(ParticipantesAnalisisFoda entity) {
        ParticipantesAnalisisFodaDTO dto = new ParticipantesAnalisisFodaDTO();
        dto.setIdParticipantesAnalisisFoda(entity.getIdParticipantesAnalisisFoda());
        dto.setNombre(entity.getNombre());
        dto.setPuesto(entity.getPuesto());
        dto.setIdAnalisisFoda(entity.getAnalisisFoda().getIdAnalisisFoda());
        return dto;
    }

    public ParticipantesAnalisisFoda toEntity(ParticipantesAnalisisFodaDTO dto, AnalisisFoda analisisFoda) {
        ParticipantesAnalisisFoda entity = new ParticipantesAnalisisFoda();
        entity.setIdParticipantesAnalisisFoda(dto.getIdParticipantesAnalisisFoda());
        entity.setNombre(dto.getNombre());
        entity.setPuesto(dto.getPuesto());
        entity.setAnalisisFoda(analisisFoda);
        return entity;
    }
}

