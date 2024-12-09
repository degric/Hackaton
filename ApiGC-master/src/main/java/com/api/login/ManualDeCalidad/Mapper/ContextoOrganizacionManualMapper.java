package com.api.login.ManualDeCalidad.Mapper;

import com.api.login.ManualDeCalidad.DTO.ContextoOrganizacionManualDTO;
import com.api.login.ManualDeCalidad.pojo.ContextoOrganizacionManual;
import com.api.login.ManualDeCalidad.pojo.ManualCalidad;
import org.springframework.stereotype.Component;

@Component
public class ContextoOrganizacionManualMapper {

    public ContextoOrganizacionManualDTO toDTO(ContextoOrganizacionManual entity) {
        ContextoOrganizacionManualDTO dto = new ContextoOrganizacionManualDTO();
        dto.setIdContextoOrganizacionManual(entity.getIdContextoOrganizacionManual());
        dto.setTitulo(entity.getTitulo());
        dto.setContenido(entity.getContenido());
        dto.setIdManualCalidad(entity.getManualCalidad().getIdManualCalidad());
        return dto;
    }

    public ContextoOrganizacionManual toEntity(ContextoOrganizacionManualDTO dto, ManualCalidad manualCalidad) {
        ContextoOrganizacionManual entity = new ContextoOrganizacionManual();
        entity.setIdContextoOrganizacionManual(dto.getIdContextoOrganizacionManual());
        entity.setTitulo(dto.getTitulo());
        entity.setContenido(dto.getContenido());
        entity.setManualCalidad(manualCalidad);
        return entity;
    }
}

