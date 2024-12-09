package com.api.login.Documentos.ProgramaAuditoriasInternas.Mapper;

import com.api.login.Documentos.ProgramaAuditoriasInternas.DTO.ObservacionesProAuInternasDTO;
import com.api.login.Documentos.ProgramaAuditoriasInternas.Pojo.ObservacionesProAuInternas;
import com.api.login.Documentos.ProgramaAuditoriasInternas.Pojo.ProgramaAuditoriasInternas;
import org.springframework.stereotype.Component;

@Component
public class ObservacionesProAuInternasMapper {

    public ObservacionesProAuInternasDTO toDTOObProAuIn(ObservacionesProAuInternas entity){
        ObservacionesProAuInternasDTO dto = new ObservacionesProAuInternasDTO();
        dto.setIdObservacionesProAuInternas(entity.getIdObservacionesProAuInternas());
        dto.setObservaciones(entity.getObservaciones());
        dto.setElaboro(entity.getElaboro());
        dto.setAutorizo(entity.getAutorizo());
        dto.setIdProgramaAuditoriasInternas(entity.getProgramaAuditoriasInternas().getIdProgramaAuditoriasInternas());
        return dto;

    }


    public ObservacionesProAuInternas toEntityObProAuIn(ObservacionesProAuInternasDTO dto, ProgramaAuditoriasInternas programaAuditoriasInternas){
        ObservacionesProAuInternas entity = new ObservacionesProAuInternas();

        entity.setIdObservacionesProAuInternas(dto.getIdObservacionesProAuInternas());
        entity.setObservaciones(dto.getObservaciones());
        entity.setElaboro(dto.getElaboro());
        entity.setAutorizo(dto.getAutorizo());
        entity.setProgramaAuditoriasInternas(programaAuditoriasInternas);
        return entity;
    }
}
