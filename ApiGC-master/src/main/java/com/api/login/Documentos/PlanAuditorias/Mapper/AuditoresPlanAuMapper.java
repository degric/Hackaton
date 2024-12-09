package com.api.login.Documentos.PlanAuditorias.Mapper;

import com.api.login.Documentos.PlanAuditorias.DTO.AuditoresPlanAuDTO;
import com.api.login.Documentos.PlanAuditorias.Pojo.AuditoresPlanAu;
import com.api.login.Documentos.PlanAuditorias.Pojo.PlanAuditorias;
import org.springframework.stereotype.Component;

@Component
public class AuditoresPlanAuMapper {

    public AuditoresPlanAuDTO toDTOConPlanAu(AuditoresPlanAu entity) {
        AuditoresPlanAuDTO dto = new AuditoresPlanAuDTO();
        dto.setIdAuditoresPlanAu(entity.getIdAuditoresPlanAu());
        dto.setAuditor(entity.getAuditor());
        dto.setIdPlanAuditorias(entity.getPlanAuditorias().getIdPlanAuditorias());
        return dto;
    }

    public AuditoresPlanAu toEntityConPlanAu(AuditoresPlanAuDTO dto, PlanAuditorias planAuditorias) {
        AuditoresPlanAu entity = new AuditoresPlanAu();
        entity.setIdAuditoresPlanAu(dto.getIdAuditoresPlanAu());
        entity.setAuditor(dto.getAuditor());
        entity.setPlanAuditorias(planAuditorias);
        return entity;
    }
}

