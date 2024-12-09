package com.api.login.Documentos.PlanAuditorias.Mapper;

import com.api.login.Documentos.PlanAuditorias.DTO.ContenidoPlanAuditoriasDTO;
import com.api.login.Documentos.PlanAuditorias.Pojo.ContenidoPlanAuditorias;
import com.api.login.Documentos.PlanAuditorias.Pojo.PlanAuditorias;
import org.springframework.stereotype.Component;

@Component
public class ContenidoPlanAuditoriasMapper {

    public ContenidoPlanAuditoriasDTO toDTOConPlanAu(ContenidoPlanAuditorias entity){
        ContenidoPlanAuditoriasDTO dto = new ContenidoPlanAuditoriasDTO();

        dto.setIdContenidoPlanAuditorias(entity.getIdContenidoPlanAuditorias());
        dto.setNoAuditoria(entity.getNoAuditoria());
        dto.setFecha(entity.getFecha());
        dto.setAreas(entity.getAreas());
        dto.setObjetivos(entity.getObjetivos());
        dto.setAlcance(entity.getAlcance());
        dto.setCriterios(entity.getCriterios());
        dto.setIdPlanAuditorias(entity.getPlanAuditorias().getIdPlanAuditorias());

        return dto;
    }

    public ContenidoPlanAuditorias toEntityConPlanAu(ContenidoPlanAuditoriasDTO dto, PlanAuditorias planAuditorias){
            ContenidoPlanAuditorias entity = new ContenidoPlanAuditorias();

            entity.setIdContenidoPlanAuditorias(dto.getIdContenidoPlanAuditorias());
            entity.setNoAuditoria(dto.getNoAuditoria());
            entity.setFecha(dto.getFecha());
            entity.setAreas(dto.getAreas());
            entity.setObjetivos(dto.getObjetivos());
            entity.setAlcance(dto.getAlcance());
            entity.setCriterios(dto.getCriterios());
            entity.setPlanAuditorias(planAuditorias);

            return entity;
    }
}
