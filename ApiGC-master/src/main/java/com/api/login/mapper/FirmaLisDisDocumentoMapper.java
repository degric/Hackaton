package com.api.login.mapper;

import com.api.login.DTO.FirmaLisDisDocumentosDTO;
import com.api.login.pojo.FirmaLisDisDocumentos;
import com.api.login.pojo.LisDisDocumentos;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
public class FirmaLisDisDocumentoMapper {

    public FirmaLisDisDocumentosDTO ToDTO(FirmaLisDisDocumentos entity){

        FirmaLisDisDocumentosDTO dto = new FirmaLisDisDocumentosDTO();
        dto.setIdFirmaLisDisDocumentos(entity.getIdFirmaLisDisDocumentos());
        dto.setArea(entity.getArea());
        dto.setNombre(entity.getNombre());
        dto.setFirma(entity.getFirma());
        dto.setIdLisDisDocumentos(entity.getLisDisDocumentos().getIdLisDisDocumentos());

        return dto;
    }

    public FirmaLisDisDocumentos ToEntity(FirmaLisDisDocumentosDTO dto, LisDisDocumentos lisDisDocumentos){

        FirmaLisDisDocumentos entity = new FirmaLisDisDocumentos();
        entity.setIdFirmaLisDisDocumentos(dto.getIdFirmaLisDisDocumentos());
        entity.setArea(dto.getArea());
        entity.setNombre(dto.getNombre());
        entity.setFirma(dto.getFirma());
        entity.setLisDisDocumentos(lisDisDocumentos);

        return entity;
    }

}
