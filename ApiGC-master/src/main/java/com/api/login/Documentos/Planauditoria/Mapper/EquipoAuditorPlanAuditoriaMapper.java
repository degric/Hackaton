package com.api.login.Documentos.Planauditoria.Mapper;

import com.api.login.Documentos.Planauditoria.DTO.EquipoAuditorPlanAuditoriaDTO;
import com.api.login.Documentos.Planauditoria.Pojo.EquipoAuditorPlanAuditoria;
import com.api.login.Documentos.Planauditoria.Pojo.PlanAuditoria;
import org.springframework.stereotype.Component;

@Component
public class EquipoAuditorPlanAuditoriaMapper {

    public EquipoAuditorPlanAuditoriaDTO toDTO(EquipoAuditorPlanAuditoria entity) {
        EquipoAuditorPlanAuditoriaDTO dto = new EquipoAuditorPlanAuditoriaDTO();
        dto.setIdEquipoAuditorPlanAuditoria(entity.getIdEquipoAuditorPlanAuditoria());
        dto.setAuditorLider(entity.getAuditorLider());
        dto.setAuditores(entity.getAuditores());
        dto.setAuditoresEntrenamiento(entity.getAuditoresEntrenamiento());
        dto.setIdPlanAuditoria(entity.getPlanAuditoria().getIdPlanAuditoria());
        return dto;
    }

    public EquipoAuditorPlanAuditoria toEntity(EquipoAuditorPlanAuditoriaDTO dto, PlanAuditoria planAuditoria) {
        EquipoAuditorPlanAuditoria entity = new EquipoAuditorPlanAuditoria();
        entity.setIdEquipoAuditorPlanAuditoria(dto.getIdEquipoAuditorPlanAuditoria());
        entity.setAuditorLider(dto.getAuditorLider());
        entity.setAuditores(dto.getAuditores());
        entity.setAuditoresEntrenamiento(dto.getAuditoresEntrenamiento());
        entity.setPlanAuditoria(planAuditoria);
        return entity;
    }
}

