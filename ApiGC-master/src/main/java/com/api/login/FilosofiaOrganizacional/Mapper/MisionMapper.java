package com.api.login.FilosofiaOrganizacional.Mapper;

import com.api.login.FilosofiaOrganizacional.DTO.MisionDTO;
import com.api.login.FilosofiaOrganizacional.pojo.Mision;
import org.springframework.stereotype.Component;

@Component
public class MisionMapper {

    public MisionDTO toDTO(Mision entity) {
        MisionDTO dto = new MisionDTO();
        dto.setIdMision(entity.getIdMision());
        dto.setContenido(entity.getContenido());
        dto.setFecha(entity.getFecha());
        return dto;
    }

    public Mision toEntity(MisionDTO dto) {
        Mision entity = new Mision();
        entity.setIdMision(dto.getIdMision());
        entity.setContenido(dto.getContenido());
        entity.setFecha(dto.getFecha());
        return entity;
    }
}

