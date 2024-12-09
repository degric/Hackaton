package com.api.login.Documentos.PlanAuditorias.Mapper;

import com.api.login.Documentos.PlanAuditorias.DTO.TablaPlanAuditoriasDTO;
import com.api.login.Documentos.PlanAuditorias.Pojo.PlanAuditorias;
import com.api.login.Documentos.PlanAuditorias.Pojo.TablaPlanAuditorias;
import org.springframework.stereotype.Component;

@Component
public class TablaPlanAuditoriasMapper {

    public TablaPlanAuditoriasDTO toDTOConPlanAu(TablaPlanAuditorias entity){
        TablaPlanAuditoriasDTO dto = new TablaPlanAuditoriasDTO();

        dto.setIdTablaPlanAuditorias(entity.getIdTablaPlanAuditorias());
        dto.setHorario(entity.getHorario());
        dto.setHoraFin(entity.getHoraFin());
        dto.setRequisito(entity.getRequisito());
        dto.setAuditor(entity.getAuditor());
        dto.setRequisito1(entity.getRequisito1());
        dto.setAuditor1(entity.getAuditor1());
        dto.setRequisito2(entity.getRequisito2());
        dto.setAuditor2(entity.getAuditor2());
        dto.setIdPlanAuditorias(entity.getPlanAuditorias().getIdPlanAuditorias());

        return dto;
    }

    public TablaPlanAuditorias toEntityConPlanAu(TablaPlanAuditoriasDTO dto, PlanAuditorias planAuditorias){
        TablaPlanAuditorias entity = new TablaPlanAuditorias();

        entity.setIdTablaPlanAuditorias(dto.getIdTablaPlanAuditorias());
        entity.setHorario(dto.getHorario());
        entity.setHoraFin(dto.getHoraFin());
        entity.setRequisito(dto.getRequisito());
        entity.setAuditor(dto.getAuditor());
        entity.setRequisito1(dto.getRequisito1());
        entity.setAuditor1(dto.getAuditor1());
        entity.setRequisito2(dto.getRequisito2());
        entity.setAuditor2(dto.getAuditor2());
        entity.setPlanAuditorias(planAuditorias);

        return entity;
    }
}

