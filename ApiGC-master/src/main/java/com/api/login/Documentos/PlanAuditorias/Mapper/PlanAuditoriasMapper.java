package com.api.login.Documentos.PlanAuditorias.Mapper;

import com.api.login.Documentos.PlanAuditorias.DTO.PlanAuditoriasDTO;
import com.api.login.Documentos.PlanAuditorias.Pojo.PlanAuditorias;
import org.springframework.stereotype.Component;

@Component
public class PlanAuditoriasMapper {

    public PlanAuditoriasDTO toDTOPlanAu(PlanAuditorias entity){

        PlanAuditoriasDTO dto = new PlanAuditoriasDTO();
        dto.setIdPlanAuditorias(entity.getIdPlanAuditorias());
        dto.setCoDocumento(entity.getCoDocumento());
        dto.setNoRevision(entity.getNoRevision());
        dto.setFechaEmicion(entity.getFechaEmicion());
        dto.setFechaRevision(entity.getFechaRevision());

        return dto;
    }

    public PlanAuditorias toEntityPlanAu(PlanAuditoriasDTO dto){
        PlanAuditorias entity = new PlanAuditorias();
        entity.setIdPlanAuditorias(dto.getIdPlanAuditorias());
        entity.setCoDocumento(dto.getCoDocumento());
        entity.setNoRevision(dto.getNoRevision());
        entity.setFechaEmicion(dto.getFechaEmicion());
        entity.setFechaRevision(dto.getFechaRevision());

        return entity;
    }

}
