package com.api.login.Documentos.ReporteDeAuditoria.Mapper;

import com.api.login.Documentos.ReporteDeAuditoria.DTO.HallazgoReporteAuditoriaDTO;
import com.api.login.Documentos.ReporteDeAuditoria.Pojo.HallazgoReporteAuditoria;
import com.api.login.Documentos.ReporteDeAuditoria.Pojo.ReporteAuditoria;
import org.springframework.stereotype.Component;

@Component
public class HallazgoReporteAuditoriaMapper {

    public HallazgoReporteAuditoriaDTO toDTO(HallazgoReporteAuditoria entity) {
        HallazgoReporteAuditoriaDTO dto = new HallazgoReporteAuditoriaDTO();
        dto.setIdHallazgoReporteAuditoria(entity.getIdHallazgoReporteAuditoria());
        dto.setClausulaNorma(entity.getClausulaNorma());
        dto.setTipoHallazgo(entity.getTipoHallazgo());
        dto.setComentario(entity.getComentario());
        dto.setIdReporteAuditoria(entity.getReporteAuditoria().getIdReporteAuditoria());
        return dto;
    }

    public HallazgoReporteAuditoria toEntity(HallazgoReporteAuditoriaDTO dto, ReporteAuditoria reporteAuditoria) {
        HallazgoReporteAuditoria entity = new HallazgoReporteAuditoria();
        entity.setIdHallazgoReporteAuditoria(dto.getIdHallazgoReporteAuditoria());
        entity.setClausulaNorma(dto.getClausulaNorma());
        entity.setTipoHallazgo(dto.getTipoHallazgo());
        entity.setComentario(dto.getComentario());
        entity.setReporteAuditoria(reporteAuditoria);
        return entity;
    }
}
