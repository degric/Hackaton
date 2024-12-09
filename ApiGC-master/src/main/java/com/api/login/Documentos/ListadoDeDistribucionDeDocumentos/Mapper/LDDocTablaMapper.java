package com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Mapper;

import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.DTO.LDDocTablaDTO;
import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Pojo.LDDocTabla;
import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Pojo.ListadoDistribucionDocumentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LDDocTablaMapper {

    @Autowired
    private ListadoDistribucionDocumentosMapper listadoDistribucionDocumentosMapper;

    public LDDocTablaDTO toDTO(LDDocTabla entity) {
        LDDocTablaDTO dto = new LDDocTablaDTO();
        dto.setIdLDDocTabla(entity.getIdLDDocTabla());
        dto.setNombreReceptor(entity.getNombreReceptor());
        dto.setPuesto(entity.getPuesto());
        dto.setFirma(entity.getFirma());
        dto.setIdListadoDistribucionDocumentos(entity.getListadoDistribucionDocumentos().getIdListadoDistribucionDocumentos());
        return dto;
    }

    public LDDocTabla toEntity(LDDocTablaDTO dto, ListadoDistribucionDocumentos listadoDistribucionDocumentos) {
        LDDocTabla entity = new LDDocTabla();
        entity.setIdLDDocTabla(dto.getIdLDDocTabla());
        entity.setNombreReceptor(dto.getNombreReceptor());
        entity.setPuesto(dto.getPuesto());
        entity.setFirma(dto.getFirma());
        entity.setListadoDistribucionDocumentos(listadoDistribucionDocumentos);
        return entity;
    }
}

