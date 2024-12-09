package com.api.login.ManualDeCalidad.Mapper;

import com.api.login.ManualDeCalidad.DTO.LiderazgoManualDTO;
import com.api.login.ManualDeCalidad.pojo.LiderazgoManual;
import com.api.login.ManualDeCalidad.pojo.ManualCalidad;
import org.springframework.stereotype.Component;

@Component
public class LiderazgoManualMapper {

    public LiderazgoManualDTO toDTO(LiderazgoManual entity) {
        LiderazgoManualDTO dto = new LiderazgoManualDTO();
        dto.setIdLiderazgoManual(entity.getIdLiderazgoManual());
        dto.setTitulo(entity.getTitulo());
        dto.setContenido(entity.getContenido());
        dto.setIdManualCalidad(entity.getManualCalidad().getIdManualCalidad());
        return dto;
    }

    public LiderazgoManual toEntity(LiderazgoManualDTO dto, ManualCalidad manualCalidad) {
        LiderazgoManual entity = new LiderazgoManual();
        entity.setIdLiderazgoManual(dto.getIdLiderazgoManual());
        entity.setTitulo(dto.getTitulo());
        entity.setContenido(dto.getContenido());
        entity.setManualCalidad(manualCalidad);
        return entity;
    }
}

