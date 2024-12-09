package com.api.login.Documentos.Planauditoria.Mapper;

import com.api.login.Documentos.Planauditoria.DTO.CuerpoPlanAuditoriaDTO;
import com.api.login.Documentos.Planauditoria.Pojo.CuerpoPlanAuditoria;
import com.api.login.Documentos.Planauditoria.Pojo.PlanAuditoria;
import org.springframework.stereotype.Component;

@Component
public class CuerpoPlanAuditoriaMapper {

    public CuerpoPlanAuditoriaDTO toDTO(CuerpoPlanAuditoria entity) {
        CuerpoPlanAuditoriaDTO dto = new CuerpoPlanAuditoriaDTO();
        dto.setIdCuerpoPlanAuditoria(entity.getIdCuerpoPlanAuditoria());
        dto.setInicio(entity.getInicio());
        dto.setTermino(entity.getTermino());
        dto.setProcesoAuditar(entity.getProcesoAuditar());
        dto.setRequisitosNorma(entity.getRequisitosNorma());
        dto.setContraparteAuditada(entity.getContraparteAuditada());
        dto.setAuditor(entity.getAuditor());
        dto.setIdPlanAuditoria(entity.getPlanAuditoria().getIdPlanAuditoria());
        return dto;
    }

    public CuerpoPlanAuditoria toEntity(CuerpoPlanAuditoriaDTO dto, PlanAuditoria planAuditoria) {
        CuerpoPlanAuditoria entity = new CuerpoPlanAuditoria();
        entity.setIdCuerpoPlanAuditoria(dto.getIdCuerpoPlanAuditoria());
        entity.setInicio(dto.getInicio());
        entity.setTermino(dto.getTermino());
        entity.setProcesoAuditar(dto.getProcesoAuditar());
        entity.setRequisitosNorma(dto.getRequisitosNorma());
        entity.setContraparteAuditada(dto.getContraparteAuditada());
        entity.setAuditor(dto.getAuditor());
        entity.setPlanAuditoria(planAuditoria);
        return entity;
    }
}

