package com.api.login.ManualDeCalidad.Mapper;

import com.api.login.ManualDeCalidad.DTO.PlanificacionManualDTO;
import com.api.login.ManualDeCalidad.pojo.ManualCalidad;
import com.api.login.ManualDeCalidad.pojo.PlanificacionManual;
import org.springframework.stereotype.Component;

@Component
public class PlanificacionManualMapper {

    public PlanificacionManualDTO toDTO(PlanificacionManual entity) {
        PlanificacionManualDTO dto = new PlanificacionManualDTO();
        dto.setIdPlanificacionManual(entity.getIdPlanificacionManual());
        dto.setTitulo(entity.getTitulo());
        dto.setContenido(entity.getContenido());
        dto.setIdManualCalidad(entity.getManualCalidad().getIdManualCalidad());
        return dto;
    }

    public PlanificacionManual toEntity(PlanificacionManualDTO dto, ManualCalidad manualCalidad) {
        PlanificacionManual entity = new PlanificacionManual();
        entity.setIdPlanificacionManual(dto.getIdPlanificacionManual());
        entity.setTitulo(dto.getTitulo());
        entity.setContenido(dto.getContenido());
        entity.setManualCalidad(manualCalidad);
        return entity;
    }
}

