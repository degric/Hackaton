package com.api.login.FilosofiaOrganizacional.Mapper;

import com.api.login.FilosofiaOrganizacional.DTO.ValoresDTO;
import com.api.login.FilosofiaOrganizacional.pojo.Valores;
import org.springframework.stereotype.Component;

@Component
public class ValoresMapper {

    public ValoresDTO toDTO(Valores entity) {
        ValoresDTO dto = new ValoresDTO();
        dto.setIdValores(entity.getIdValores());
        dto.setContenido(entity.getContenido());
        dto.setFecha(entity.getFecha());
        return dto;
    }

    public Valores toEntity(ValoresDTO dto) {
        Valores entity = new Valores();
        entity.setIdValores(dto.getIdValores());
        entity.setContenido(dto.getContenido());
        entity.setFecha(dto.getFecha());
        return entity;
    }
}
