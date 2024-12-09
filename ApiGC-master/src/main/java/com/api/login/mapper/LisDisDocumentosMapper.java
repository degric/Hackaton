package com.api.login.mapper;

import com.api.login.DTO.LisDisDocumentosDTO;
import com.api.login.pojo.LisDisDocumentos;
import org.springframework.stereotype.Component;

@Component
public class LisDisDocumentosMapper {

    public LisDisDocumentosDTO toDTO(LisDisDocumentos lisDisDocumentos){
        LisDisDocumentosDTO dto = new LisDisDocumentosDTO();

        dto.setIdLisDisDocumentos(lisDisDocumentos.getIdLisDisDocumentos());
        dto.setFechaEmosion(lisDisDocumentos.getFechaEmosion());
        dto.setFechaRevision(lisDisDocumentos.getFechaRevision());
        dto.setCoDocumentos(lisDisDocumentos.getCoDocumentos());
        dto.setNoRevision(lisDisDocumentos.getNoRevision());
        dto.setStatus(lisDisDocumentos.getStatus());
        dto.setDescripcion(lisDisDocumentos.getDescripcion());

        return dto;
    }

    public LisDisDocumentos toEntity(LisDisDocumentosDTO dto){
        LisDisDocumentos entity = new LisDisDocumentos();

        entity.setIdLisDisDocumentos(dto.getIdLisDisDocumentos());
        entity.setFechaEmosion(dto.getFechaEmosion());
        entity.setFechaRevision(dto.getFechaRevision());
        entity.setCoDocumentos(dto.getCoDocumentos());
        entity.setNoRevision(dto.getNoRevision());
        entity.setStatus(dto.getStatus());
        entity.setDescripcion(dto.getDescripcion());

        return entity;
    }
}
