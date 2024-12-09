package com.api.login.ManualDeCalidad.Mapper;

import com.api.login.ManualDeCalidad.DTO.RevisionManualDTO;
import com.api.login.ManualDeCalidad.pojo.ManualCalidad;
import com.api.login.ManualDeCalidad.pojo.RevisionManual;
import org.springframework.stereotype.Component;

@Component
public class RevisionManualMapper {

    public RevisionManualDTO toDTO(RevisionManual entity) {
        RevisionManualDTO dto = new RevisionManualDTO();
        dto.setIdRevisionManual(entity.getIdRevisionManual());
        dto.setNoRevision(entity.getNoRevision());
        dto.setFechaEmision(entity.getFechaEmision());
        dto.setSeccionAfectada(entity.getSeccionAfectada());
        dto.setEfectuadaPor(entity.getEfectuadaPor());
        dto.setFechaEjecucion(entity.getFechaEjecucion());
        dto.setIdManualCalidad(entity.getManualCalidad().getIdManualCalidad());
        return dto;
    }

    public RevisionManual toEntity(RevisionManualDTO dto, ManualCalidad manualCalidad) {
        RevisionManual entity = new RevisionManual();
        entity.setIdRevisionManual(dto.getIdRevisionManual());
        entity.setNoRevision(dto.getNoRevision());
        entity.setFechaEmision(dto.getFechaEmision());
        entity.setSeccionAfectada(dto.getSeccionAfectada());
        entity.setEfectuadaPor(dto.getEfectuadaPor());
        entity.setFechaEjecucion(dto.getFechaEjecucion());
        entity.setManualCalidad(manualCalidad);
        return entity;
    }
}

