package com.api.login.Documentos.ReporteDeAuditoria.Mapper;

import com.api.login.Documentos.ReporteDeAuditoria.DTO.InfoReporteAuditoriaDTO;
import com.api.login.Documentos.ReporteDeAuditoria.Pojo.InfoReporteAuditoria;
import com.api.login.Documentos.ReporteDeAuditoria.Pojo.ReporteAuditoria;
import org.springframework.stereotype.Component;

@Component
public class InfoReporteAuditoriaMapper {

    public InfoReporteAuditoriaDTO toDTO(InfoReporteAuditoria entity) {
        InfoReporteAuditoriaDTO dto = new InfoReporteAuditoriaDTO();
        dto.setIdInfoReporteAuditoria(entity.getIdInfoReporteAuditoria());
        dto.setProcesoAuditado(entity.getProcesoAuditado());
        dto.setResponSGC(entity.getResponSGC());
        dto.setFecha(entity.getFecha());
        dto.setNoAuditoria(entity.getNoAuditoria());
        dto.setCalificacion(entity.getCalificacion());
        dto.setIdReporteAuditoria(entity.getReporteAuditoria().getIdReporteAuditoria());
        return dto;
    }

    public InfoReporteAuditoria toEntity(InfoReporteAuditoriaDTO dto, ReporteAuditoria reporteAuditoria) {
        InfoReporteAuditoria entity = new InfoReporteAuditoria();
        entity.setIdInfoReporteAuditoria(dto.getIdInfoReporteAuditoria());
        entity.setProcesoAuditado(dto.getProcesoAuditado());
        entity.setResponSGC(dto.getResponSGC());
        entity.setFecha(dto.getFecha());
        entity.setNoAuditoria(dto.getNoAuditoria());
        entity.setCalificacion(dto.getCalificacion());
        entity.setReporteAuditoria(reporteAuditoria);
        return entity;
    }
}

