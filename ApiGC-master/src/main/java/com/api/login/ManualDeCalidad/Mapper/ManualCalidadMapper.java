package com.api.login.ManualDeCalidad.Mapper;

import com.api.login.ManualDeCalidad.DTO.ManualCalidadDTO;
import com.api.login.ManualDeCalidad.pojo.ManualCalidad;
import org.springframework.stereotype.Component;

@Component
public class ManualCalidadMapper {

    public ManualCalidadDTO toDTOManualC(ManualCalidad entity){
        ManualCalidadDTO dto = new ManualCalidadDTO();
        dto.setIdManualCalidad(entity.getIdManualCalidad());
        dto.setFechaEmision(entity.getFechaEmision());
        dto.setFechaRevision(entity.getFechaRevision());
        dto.setNoRevision(entity.getNoRevision());
        dto.setCoDocumento(entity.getCoDocumento());
        dto.setCoPie(entity.getCoPie());

        return dto;
    }

    public ManualCalidad toEntityManualC(ManualCalidadDTO dto){
        ManualCalidad entity = new ManualCalidad();
        entity.setIdManualCalidad(dto.getIdManualCalidad());
        entity.setFechaEmision(dto.getFechaEmision());
        entity.setFechaRevision(dto.getFechaRevision());
        entity.setNoRevision(dto.getNoRevision());
        entity.setCoDocumento(dto.getCoDocumento());
        entity.setCoPie(dto.getCoPie());

        return entity;
    }
}
