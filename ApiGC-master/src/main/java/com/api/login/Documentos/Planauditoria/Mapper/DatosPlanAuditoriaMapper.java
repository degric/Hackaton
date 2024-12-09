package com.api.login.Documentos.Planauditoria.Mapper;

import com.api.login.Documentos.Planauditoria.DTO.DatosPlanAuditoriaDTO;
import com.api.login.Documentos.Planauditoria.Pojo.DatosPlanAuditoria;
import com.api.login.Documentos.Planauditoria.Pojo.PlanAuditoria;
import org.springframework.stereotype.Component;

@Component
public class DatosPlanAuditoriaMapper {

    public DatosPlanAuditoriaDTO toDTO(DatosPlanAuditoria entity) {
        DatosPlanAuditoriaDTO dto = new DatosPlanAuditoriaDTO();
        dto.setIdDatosPlanAuditoria(entity.getIdDatosPlanAuditoria());
        dto.setObjetivoAuditoria(entity.getObjetivoAuditoria());
        dto.setAlcanceAuditoria(entity.getAlcanceAuditoria());
        dto.setCriteriosAuditorias(entity.getCriteriosAuditorias());
        dto.setFechaElaboracion(entity.getFechaElaboracion());
        dto.setNoAuditoria(entity.getNoAuditoria());
        dto.setFechaInicio(entity.getFechaInicio());
        dto.setFechaTermino(entity.getFechaTermino());
        dto.setIdPlanAuditoria(entity.getPlanAuditoria().getIdPlanAuditoria());
        return dto;
    }

    public DatosPlanAuditoria toEntity(DatosPlanAuditoriaDTO dto, PlanAuditoria planAuditoria) {
        DatosPlanAuditoria entity = new DatosPlanAuditoria();
        entity.setIdDatosPlanAuditoria(dto.getIdDatosPlanAuditoria());
        entity.setObjetivoAuditoria(dto.getObjetivoAuditoria());
        entity.setAlcanceAuditoria(dto.getAlcanceAuditoria());
        entity.setCriteriosAuditorias(dto.getCriteriosAuditorias());
        entity.setFechaElaboracion(dto.getFechaElaboracion());
        entity.setNoAuditoria(dto.getNoAuditoria());
        entity.setFechaInicio(dto.getFechaInicio());
        entity.setFechaTermino(dto.getFechaTermino());
        entity.setPlanAuditoria(planAuditoria);
        return entity;
    }
}

