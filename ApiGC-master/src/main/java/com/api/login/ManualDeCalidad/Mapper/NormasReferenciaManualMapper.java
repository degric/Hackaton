package com.api.login.ManualDeCalidad.Mapper;

import com.api.login.ManualDeCalidad.DTO.NormasReferenciaManualDTO;
import com.api.login.ManualDeCalidad.pojo.ManualCalidad;
import com.api.login.ManualDeCalidad.pojo.NormasReferenciaManual;
import org.springframework.stereotype.Component;

@Component
public class NormasReferenciaManualMapper {

    public NormasReferenciaManualDTO toDTO(NormasReferenciaManual entity) {
        NormasReferenciaManualDTO dto = new NormasReferenciaManualDTO();
        dto.setIdNormasReferenciaManual(entity.getIdNormasReferenciaManual());
        dto.setNorma(entity.getNorma());
        dto.setDescripcion(entity.getDescripcion());
        dto.setIdManualCalidad(entity.getManualCalidad().getIdManualCalidad());
        return dto;
    }

    public NormasReferenciaManual toEntity(NormasReferenciaManualDTO dto, ManualCalidad manualCalidad) {
        NormasReferenciaManual entity = new NormasReferenciaManual();
        entity.setIdNormasReferenciaManual(dto.getIdNormasReferenciaManual());
        entity.setNorma(dto.getNorma());
        entity.setDescripcion(dto.getDescripcion());
        entity.setManualCalidad(manualCalidad);
        return entity;
    }
}
