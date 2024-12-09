package com.api.login.mapper;

import com.api.login.DTO.DocumentosLisDisDoDTO;
import com.api.login.pojo.DocumentosLisDisDo;
import com.api.login.pojo.LisDisDocumentos;
import org.springframework.stereotype.Component;

@Component
public class DocumentosLisDisDoMapper {
    public DocumentosLisDisDoDTO toDTO(DocumentosLisDisDo documentos){
        DocumentosLisDisDoDTO dto = new DocumentosLisDisDoDTO();

        dto.setIdDocumentosLisDisDo(documentos.getIdDocumentosLisDisDo());
        dto.setArea(documentos.getArea());
        dto.setCoDocumento(documentos.getCoDocumento());
        dto.setRevision(documentos.getRevision());
        dto.setFechaImplantacion(documentos.getFechaImplantacion());
        dto.setIdLisDisDocumentos(documentos.getLisDisDocumentos().getIdLisDisDocumentos());

        return dto;
    }
    public DocumentosLisDisDo toEntity(DocumentosLisDisDoDTO dto, LisDisDocumentos lisDisDocumentos){
        DocumentosLisDisDo documentos = new DocumentosLisDisDo();
        documentos.setIdDocumentosLisDisDo(dto.getIdDocumentosLisDisDo());
        documentos.setArea(dto.getArea());
        documentos.setCoDocumento(dto.getCoDocumento());
        documentos.setRevision(dto.getRevision());
        documentos.setFechaImplantacion( dto.getFechaImplantacion());
        documentos.setLisDisDocumentos(lisDisDocumentos);

        return documentos;

    }
}
