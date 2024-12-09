package com.api.login.Documentos.ReporteDeAuditoria.Mapper;

import com.api.login.Documentos.ReporteDeAuditoria.DTO.CierreReporteAuditoria2DTO;
import com.api.login.Documentos.ReporteDeAuditoria.Pojo.CierreReporteAuditoria2;
import com.api.login.Documentos.ReporteDeAuditoria.Pojo.ReporteAuditoria;
import org.springframework.stereotype.Component;

@Component
public class CierreReporteAuditoria2Mapper {

    public CierreReporteAuditoria2DTO toDTO(CierreReporteAuditoria2 entity) {
        CierreReporteAuditoria2DTO dto = new CierreReporteAuditoria2DTO();
        dto.setIdCierreReporteAuditoria2(entity.getIdCierreReporteAuditoria2());
        dto.setNombreAuditor(entity.getNombreAuditor());
        dto.setFirma(entity.getFirma());
        dto.setIdReporteAuditoria(entity.getReporteAuditoria().getIdReporteAuditoria());
        return dto;
    }

    public CierreReporteAuditoria2 toEntity(CierreReporteAuditoria2DTO dto, ReporteAuditoria reporteAuditoria) {
        CierreReporteAuditoria2 entity = new CierreReporteAuditoria2();
        entity.setIdCierreReporteAuditoria2(dto.getIdCierreReporteAuditoria2());
        entity.setNombreAuditor(dto.getNombreAuditor());
        entity.setFirma(dto.getFirma());
        entity.setReporteAuditoria(reporteAuditoria);
        return entity;
    }
}

