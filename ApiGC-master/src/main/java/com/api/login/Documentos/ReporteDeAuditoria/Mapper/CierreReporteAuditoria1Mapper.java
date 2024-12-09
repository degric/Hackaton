package com.api.login.Documentos.ReporteDeAuditoria.Mapper;

import com.api.login.Documentos.ReporteDeAuditoria.DTO.CierreReporteAuditoria1DTO;
import com.api.login.Documentos.ReporteDeAuditoria.Pojo.CierreReporteAuditoria1;
import com.api.login.Documentos.ReporteDeAuditoria.Pojo.ReporteAuditoria;
import org.springframework.stereotype.Component;

@Component
public class CierreReporteAuditoria1Mapper {

    public CierreReporteAuditoria1DTO toDTO(CierreReporteAuditoria1 entity) {
        CierreReporteAuditoria1DTO dto = new CierreReporteAuditoria1DTO();
        dto.setIdCierreReporteAuditoria1(entity.getIdCierreReporteAuditoria1());
        dto.setNombreAuditor(entity.getNombreAuditor());
        dto.setFirma(entity.getFirma());
        dto.setIdReporteAuditoria(entity.getReporteAuditoria().getIdReporteAuditoria());
        return dto;
    }

    public CierreReporteAuditoria1 toEntity(CierreReporteAuditoria1DTO dto, ReporteAuditoria reporteAuditoria) {
        CierreReporteAuditoria1 entity = new CierreReporteAuditoria1();
        entity.setIdCierreReporteAuditoria1(dto.getIdCierreReporteAuditoria1());
        entity.setNombreAuditor(dto.getNombreAuditor());
        entity.setFirma(dto.getFirma());
        entity.setReporteAuditoria(reporteAuditoria);
        return entity;
    }
}

