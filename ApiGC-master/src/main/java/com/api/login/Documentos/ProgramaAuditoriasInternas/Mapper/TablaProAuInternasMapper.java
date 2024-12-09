package com.api.login.Documentos.ProgramaAuditoriasInternas.Mapper;

import com.api.login.Documentos.ProgramaAuditoriasInternas.DTO.TablaProAuInternasDTO;
import com.api.login.Documentos.ProgramaAuditoriasInternas.Pojo.ProgramaAuditoriasInternas;
import com.api.login.Documentos.ProgramaAuditoriasInternas.Pojo.TablaProAuInternas;
import org.springframework.stereotype.Component;

@Component
public class TablaProAuInternasMapper {
    public TablaProAuInternasDTO toDTOTaProAuIn(TablaProAuInternas entity){
        TablaProAuInternasDTO dto = new TablaProAuInternasDTO();

        dto.setIdTablaProAuInternas(entity.getIdTablaProAuInternas());
        dto.setAreaAuditada(entity.getAreaAuditada());
        dto.setMes1AuIn(entity.getMes1AuIn());
        dto.setMes2AuIn(entity.getMes2AuIn());
        dto.setMesAuEx(entity.getMesAuEx());
        dto.setIdProgramaAuditoriasInternas(entity.getProgramaAuditoriasInternas().getIdProgramaAuditoriasInternas());
        return dto;

    }

    public TablaProAuInternas toEntityTaProAuIn(TablaProAuInternasDTO dto, ProgramaAuditoriasInternas programaAuditoriasInternas){

        TablaProAuInternas entity = new TablaProAuInternas();
        entity.setIdTablaProAuInternas(dto.getIdTablaProAuInternas());
        entity.setAreaAuditada(dto.getAreaAuditada());
        entity.setMes1AuIn(dto.getMes1AuIn());
        entity.setMes2AuIn(dto.getMes2AuIn());
        entity.setMesAuEx(dto.getMesAuEx());
        entity.setProgramaAuditoriasInternas(programaAuditoriasInternas);
        return entity;
    }

}
