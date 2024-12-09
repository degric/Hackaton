package com.api.login.ManualDeCalidad.Mapper;

import com.api.login.ManualDeCalidad.DTO.IntroduccionManualDTO;
import com.api.login.ManualDeCalidad.pojo.IntroduccionManual;
import com.api.login.ManualDeCalidad.pojo.ManualCalidad;
import org.springframework.stereotype.Component;

@Component
public class IntroduccionManualMapper {

    public IntroduccionManualDTO toDTO(IntroduccionManual entity) {
        IntroduccionManualDTO dto = new IntroduccionManualDTO();
        dto.setIdIntroduccionManual(entity.getIdIntroduccionManual());
        dto.setTitulo(entity.getTitulo());
        dto.setContenido(entity.getContenido());
        dto.setIdManualCalidad(entity.getManualCalidad().getIdManualCalidad());
        return dto;
    }

    public IntroduccionManual toEntity(IntroduccionManualDTO dto, ManualCalidad manualCalidad) {
        IntroduccionManual entity = new IntroduccionManual();
        entity.setIdIntroduccionManual(dto.getIdIntroduccionManual());
        entity.setTitulo(dto.getTitulo());
        entity.setContenido(dto.getContenido());
        entity.setManualCalidad(manualCalidad);
        return entity;
    }
}

