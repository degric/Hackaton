package com.api.login.ManualDeCalidad.Mapper;

import com.api.login.ManualDeCalidad.DTO.ObjetivoManualDTO;
import com.api.login.ManualDeCalidad.pojo.ManualCalidad;
import com.api.login.ManualDeCalidad.pojo.ObjetivoManual;
import org.springframework.stereotype.Component;

@Component
public class ObjetivoManualMapper {

    public ObjetivoManualDTO toDTO(ObjetivoManual entity) {
        ObjetivoManualDTO dto = new ObjetivoManualDTO();
        dto.setIdObjetivoManual(entity.getIdObjetivoManual());
        dto.setObjetivo(entity.getObjetivo());
        dto.setIdManualCalidad(entity.getManualCalidad().getIdManualCalidad());
        return dto;
    }

    public ObjetivoManual toEntity(ObjetivoManualDTO dto, ManualCalidad manualCalidad) {
        ObjetivoManual entity = new ObjetivoManual();
        entity.setIdObjetivoManual(dto.getIdObjetivoManual());
        entity.setObjetivo(dto.getObjetivo());
        entity.setManualCalidad(manualCalidad);
        return entity;
    }
}

