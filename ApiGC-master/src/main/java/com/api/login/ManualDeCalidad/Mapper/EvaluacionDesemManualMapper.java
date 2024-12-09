package com.api.login.ManualDeCalidad.Mapper;

import com.api.login.ManualDeCalidad.DTO.EvaluacionDesemManualDTO;
import com.api.login.ManualDeCalidad.pojo.EvaluacionDesemManual;
import com.api.login.ManualDeCalidad.pojo.ManualCalidad;
import org.springframework.stereotype.Component;

@Component
public class EvaluacionDesemManualMapper {

    public EvaluacionDesemManualDTO toDTO(EvaluacionDesemManual entity) {
        EvaluacionDesemManualDTO dto = new EvaluacionDesemManualDTO();
        dto.setIdEvaluacionDesemManual(entity.getIdEvaluacionDesemManual());
        dto.setTitulo(entity.getTitulo());
        dto.setContenido(entity.getContenido());
        dto.setIdManualCalidad(entity.getManualCalidad().getIdManualCalidad());
        return dto;
    }

    public EvaluacionDesemManual toEntity(EvaluacionDesemManualDTO dto, ManualCalidad manualCalidad) {
        EvaluacionDesemManual entity = new EvaluacionDesemManual();
        entity.setIdEvaluacionDesemManual(dto.getIdEvaluacionDesemManual());
        entity.setTitulo(dto.getTitulo());
        entity.setContenido(dto.getContenido());
        entity.setManualCalidad(manualCalidad);
        return entity;
    }
}

