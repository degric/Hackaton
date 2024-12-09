package com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Mapper;

import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.DTO.LDDDescricionDocumentoDTO;
import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Pojo.LDDDescricionDocumento;
import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Pojo.ListadoDistribucionDocumentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LDDDescricionDocumentoMapper {

    @Autowired
    private ListadoDistribucionDocumentosMapper listadoDistribucionDocumentosMapper;

    public LDDDescricionDocumentoDTO toDTO(LDDDescricionDocumento entity) {
        LDDDescricionDocumentoDTO dto = new LDDDescricionDocumentoDTO();
        dto.setIdLDDDescricionDocumento(entity.getIdLDDDescricionDocumento());
        dto.setDescripcion(entity.getDescripcion());
        dto.setDocumento(entity.getDocumento());
        dto.setArea(entity.getArea());
        dto.setCodigoDocumento(entity.getCodigoDocumento());
        dto.setRevision(entity.getRevision());
        dto.setFechaImplantacion(entity.getFechaImplantacion());
        dto.setIdListadoDistribucionDocumentos(entity.getListadoDistribucionDocumentos().getIdListadoDistribucionDocumentos());
        return dto;
    }

    public LDDDescricionDocumento toEntity(LDDDescricionDocumentoDTO dto, ListadoDistribucionDocumentos listadoDistribucionDocumentos) {
        LDDDescricionDocumento entity = new LDDDescricionDocumento();
        entity.setIdLDDDescricionDocumento(dto.getIdLDDDescricionDocumento());
        entity.setDescripcion(dto.getDescripcion());
        entity.setDocumento(dto.getDocumento());
        entity.setArea(dto.getArea());
        entity.setCodigoDocumento(dto.getCodigoDocumento());
        entity.setRevision(dto.getRevision());
        entity.setFechaImplantacion(dto.getFechaImplantacion());
        entity.setListadoDistribucionDocumentos(listadoDistribucionDocumentos);
        return entity;
    }
}

