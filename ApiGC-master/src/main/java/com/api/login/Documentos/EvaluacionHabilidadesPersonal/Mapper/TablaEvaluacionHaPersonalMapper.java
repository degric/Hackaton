package com.api.login.Documentos.EvaluacionHabilidadesPersonal.Mapper;

import com.api.login.Documentos.EvaluacionHabilidadesPersonal.DTO.TablaEvaluacionHaPersonalDTO;
import com.api.login.Documentos.EvaluacionHabilidadesPersonal.Pojo.EvaluacionHabiPersonal;
import com.api.login.Documentos.EvaluacionHabilidadesPersonal.Pojo.TablaEvaluacionHaPersonal;
import org.springframework.stereotype.Component;

@Component
public class TablaEvaluacionHaPersonalMapper {
    public TablaEvaluacionHaPersonalDTO toDTODaEvaPer(TablaEvaluacionHaPersonal entity){
        TablaEvaluacionHaPersonalDTO dto = new TablaEvaluacionHaPersonalDTO();
        dto.setIdTablaEvaluacionHaPersonal(entity.getIdTablaEvaluacionHaPersonal());
        dto.setPuntoEvaluar(entity.getPuntoEvaluar());
        dto.setOpcion(entity.getOpcion());
        dto.setIdEvaluacionHabiPersonal(entity.getEvaluacionHabiPersonal().getIdEvaluacionHabiPersonal());
        return dto;
    }

    public TablaEvaluacionHaPersonal toEntityDaEvaPer(TablaEvaluacionHaPersonalDTO dto, EvaluacionHabiPersonal evaluacionHabiPersonal){
        TablaEvaluacionHaPersonal entity = new TablaEvaluacionHaPersonal();
        entity.setIdTablaEvaluacionHaPersonal(dto.getIdTablaEvaluacionHaPersonal());
        entity.setPuntoEvaluar(dto.getPuntoEvaluar());
        entity.setOpcion(dto.getOpcion());
        entity.setEvaluacionHabiPersonal(evaluacionHabiPersonal);
        return entity;
    }


}

