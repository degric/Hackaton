package com.api.login.ManualDeCalidad.Mapper;

import com.api.login.ManualDeCalidad.DTO.MejoraManualDTO;
import com.api.login.ManualDeCalidad.pojo.ManualCalidad;
import com.api.login.ManualDeCalidad.pojo.MejoraManual;
import org.springframework.stereotype.Component;

@Component
public class MejoraManualMapper {

    public MejoraManualDTO toDTO(MejoraManual entity) {
        MejoraManualDTO dto = new MejoraManualDTO();
        dto.setIdMejora(entity.getIdMejora());
        dto.setTitulo(entity.getTitulo());
        dto.setContenido(entity.getContenido());
        dto.setIdManualCalidad(entity.getManualCalidad().getIdManualCalidad());
        return dto;
    }

    public MejoraManual toEntity(MejoraManualDTO dto, ManualCalidad manualCalidad) {
        MejoraManual entity = new MejoraManual();
        entity.setIdMejora(dto.getIdMejora());
        entity.setTitulo(dto.getTitulo());
        entity.setContenido(dto.getContenido());
        entity.setManualCalidad(manualCalidad);
        return entity;
    }
}

