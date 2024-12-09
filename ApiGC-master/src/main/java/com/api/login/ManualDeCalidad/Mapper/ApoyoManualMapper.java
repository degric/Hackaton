package com.api.login.ManualDeCalidad.Mapper;

import com.api.login.ManualDeCalidad.DTO.ApoyoManualDTO;
import com.api.login.ManualDeCalidad.pojo.ApoyoManual;
import com.api.login.ManualDeCalidad.pojo.ManualCalidad;
import org.springframework.stereotype.Component;

@Component
public class ApoyoManualMapper {

    public ApoyoManualDTO toDTO(ApoyoManual entity) {
        ApoyoManualDTO dto = new ApoyoManualDTO();
        dto.setIdApoyoManual(entity.getIdApoyoManual());
        dto.setTitulo(entity.getTitulo());
        dto.setContenido(entity.getContenido());
        dto.setIdManualCalidad(entity.getManualCalidad().getIdManualCalidad());
        return dto;
    }

    public ApoyoManual toEntity(ApoyoManualDTO dto, ManualCalidad manualCalidad) {
        ApoyoManual entity = new ApoyoManual();
        entity.setIdApoyoManual(dto.getIdApoyoManual());
        entity.setTitulo(dto.getTitulo());
        entity.setContenido(dto.getContenido());
        entity.setManualCalidad(manualCalidad);
        return entity;
    }
}
