package com.api.login.Documentos.Planauditoria.Mapper;

import com.api.login.Documentos.Planauditoria.DTO.ObservacionesPlanAuditoriasDTO;
import com.api.login.Documentos.Planauditoria.Pojo.ObservacionesPlanAuditorias;
import com.api.login.Documentos.Planauditoria.Pojo.PlanAuditoria;
import org.springframework.stereotype.Component;

@Component
public class ObservacionesPlanAuditoriasMapper {

    public ObservacionesPlanAuditoriasDTO toDTO(ObservacionesPlanAuditorias entity) {
        ObservacionesPlanAuditoriasDTO dto = new ObservacionesPlanAuditoriasDTO();
        dto.setIdObservacionesPlanAuditorias(entity.getIdObservacionesPlanAuditorias());
        dto.setObservacion(entity.getObservacion());
        dto.setIdPlanAuditoria(entity.getPlanAuditoria().getIdPlanAuditoria());
        return dto;
    }

    public ObservacionesPlanAuditorias toEntity(ObservacionesPlanAuditoriasDTO dto, PlanAuditoria planAuditoria) {
        ObservacionesPlanAuditorias entity = new ObservacionesPlanAuditorias();
        entity.setIdObservacionesPlanAuditorias(dto.getIdObservacionesPlanAuditorias());
        entity.setObservacion(dto.getObservacion());
        entity.setPlanAuditoria(planAuditoria);
        return entity;
    }
}

