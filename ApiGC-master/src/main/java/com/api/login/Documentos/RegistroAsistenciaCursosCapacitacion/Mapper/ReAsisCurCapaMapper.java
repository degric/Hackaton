package com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Mapper;

import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.DTO.ReAsisCurCapaDTO;
import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Pojo.ReAsisCurCapa;
import org.springframework.stereotype.Component;

@Component
public class ReAsisCurCapaMapper {

    public ReAsisCurCapaDTO toDTOReAs(ReAsisCurCapa entity){
        ReAsisCurCapaDTO dto = new ReAsisCurCapaDTO();

        dto.setIdReAsisCurCapa(entity.getIdReAsisCurCapa());
        dto.setCoDocumento(entity.getCoDocumento());
        dto.setNoRevision(entity.getNoRevision());
        dto.setFechaEmicion(entity.getFechaEmicion());
        dto.setFechaRevision(entity.getFechaRevision());

        return dto;
    }

    public ReAsisCurCapa toEntityReAs(ReAsisCurCapaDTO dto){
        ReAsisCurCapa entity = new ReAsisCurCapa();

        entity.setIdReAsisCurCapa(dto.getIdReAsisCurCapa());
        entity.setCoDocumento(dto.getCoDocumento());
        entity.setNoRevision(dto.getNoRevision());
        entity.setFechaEmicion(dto.getFechaEmicion());
        entity.setFechaRevision(dto.getFechaRevision());

        return entity;
    }

}
