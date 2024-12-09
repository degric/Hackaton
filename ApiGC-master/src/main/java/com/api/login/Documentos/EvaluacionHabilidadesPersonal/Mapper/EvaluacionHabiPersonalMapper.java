package com.api.login.Documentos.EvaluacionHabilidadesPersonal.Mapper;

import com.api.login.Documentos.EvaluacionHabilidadesPersonal.DTO.EvaluacionHabiPersonalDTO;
import com.api.login.Documentos.EvaluacionHabilidadesPersonal.Pojo.EvaluacionHabiPersonal;
import org.springframework.stereotype.Component;

@Component
public class EvaluacionHabiPersonalMapper {

    public EvaluacionHabiPersonalDTO toDTOEHaPe(EvaluacionHabiPersonal entity){
        EvaluacionHabiPersonalDTO dto = new EvaluacionHabiPersonalDTO();

        dto.setIdEvaluacionHabiPersonal(entity.getIdEvaluacionHabiPersonal());
        dto.setCoDocumento(entity.getCoDocumento());
        dto.setNoRevision(entity.getNoRevision());
        dto.setFechaEmicion(entity.getFechaEmicion());
        dto.setFechaRevision(entity.getFechaRevision());
        return dto;
    }

    public EvaluacionHabiPersonal toEntityEHaPe(EvaluacionHabiPersonalDTO dto){
        EvaluacionHabiPersonal entity = new EvaluacionHabiPersonal();

        entity.setIdEvaluacionHabiPersonal(dto.getIdEvaluacionHabiPersonal());
        entity.setCoDocumento(dto.getCoDocumento());
        entity.setNoRevision(dto.getNoRevision());
        entity.setFechaEmicion(dto.getFechaEmicion());
        entity.setFechaRevision(dto.getFechaRevision());

        return entity;
    }

}
