package com.api.login.Documentos.ProgramaAuditoriasInternas.Mapper;

import com.api.login.Documentos.ProgramaAuditoriasInternas.DTO.ProgramaAuditoriasInternasDTO;
import com.api.login.Documentos.ProgramaAuditoriasInternas.Pojo.ProgramaAuditoriasInternas;
import org.springframework.stereotype.Component;

@Component
public class ProgramaAuditoriasInternasMapper {

    public ProgramaAuditoriasInternasDTO toDTOProAuIn(ProgramaAuditoriasInternas entity){
        ProgramaAuditoriasInternasDTO dto = new ProgramaAuditoriasInternasDTO();

        dto.setIdProgramaAuditoriasInternas(entity.getIdProgramaAuditoriasInternas());
        dto.setCoDocumento(entity.getCoDocumento());
        dto.setNoRevision(entity.getNoRevision());
        dto.setFechaEmicion(entity.getFechaEmicion());
        dto.setFechaRevision(entity.getFechaRevision());
        dto.setAnio(entity.getAnio());
        return dto;
    }

    public ProgramaAuditoriasInternas toEntityProAuIn(ProgramaAuditoriasInternasDTO dto){
        ProgramaAuditoriasInternas entity = new ProgramaAuditoriasInternas();
        entity.setIdProgramaAuditoriasInternas(dto.getIdProgramaAuditoriasInternas());
        entity.setCoDocumento(dto.getCoDocumento());
        entity.setNoRevision(dto.getNoRevision());
        entity.setFechaEmicion(dto.getFechaEmicion());
        entity.setFechaRevision(dto.getFechaRevision());
        entity.setAnio(dto.getAnio());

        return entity;
    }

}
