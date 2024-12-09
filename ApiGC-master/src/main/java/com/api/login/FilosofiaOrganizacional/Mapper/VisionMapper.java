package com.api.login.FilosofiaOrganizacional.Mapper;

import com.api.login.FilosofiaOrganizacional.DTO.VisionDTO;
import com.api.login.FilosofiaOrganizacional.pojo.Vision;
import org.springframework.stereotype.Component;

@Component
public class VisionMapper {

    public VisionDTO toDTO(Vision entity) {
        VisionDTO dto = new VisionDTO();
        dto.setIdVision(entity.getIdVision());
        dto.setContenido(entity.getContenido());
        dto.setFecha(entity.getFecha());
        return dto;
    }

    public Vision toEntity(VisionDTO dto) {
        Vision entity = new Vision();
        entity.setIdVision(dto.getIdVision());
        entity.setContenido(dto.getContenido());
        entity.setFecha(dto.getFecha());
        return entity;
    }
}

