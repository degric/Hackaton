package com.api.login.ManualDeCalidad.Mapper;

import com.api.login.ManualDeCalidad.DTO.OperacionManualDTO;
import com.api.login.ManualDeCalidad.pojo.ManualCalidad;
import com.api.login.ManualDeCalidad.pojo.OperacionManual;
import org.springframework.stereotype.Component;

@Component
public class OperacionManualMapper {

    public OperacionManualDTO toDTO(OperacionManual entity) {
        OperacionManualDTO dto = new OperacionManualDTO();
        dto.setIdOperacionManual(entity.getIdOperacionManual());
        dto.setTitulo(entity.getTitulo());
        dto.setContenido(entity.getContenido());
        dto.setIdManualCalidad(entity.getManualCalidad().getIdManualCalidad());
        return dto;
    }

    public OperacionManual toEntity(OperacionManualDTO dto, ManualCalidad manualCalidad) {
        OperacionManual entity = new OperacionManual();
        entity.setIdOperacionManual(dto.getIdOperacionManual());
        entity.setTitulo(dto.getTitulo());
        entity.setContenido(dto.getContenido());
        entity.setManualCalidad(manualCalidad);
        return entity;
    }
}

