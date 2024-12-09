package com.api.login.Documentos.ListadoMaestroDocumentos.Mapper;

import com.api.login.Documentos.ListadoMaestroDocumentos.DTO.TablaLisMaDocumentosFormatosDTO;
import com.api.login.Documentos.ListadoMaestroDocumentos.Pojo.ListadoMaestroDocumentos;
import com.api.login.Documentos.ListadoMaestroDocumentos.Pojo.TablaLisMaDocumentosFormatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TablaLisMaDocumentosFormatosMapper {

    @Autowired
    private ListadoMaestroDocumentosMapper listadoMaestroDocumentosMapper;

    public TablaLisMaDocumentosFormatosDTO toDTO(TablaLisMaDocumentosFormatos entity) {
        TablaLisMaDocumentosFormatosDTO dto = new TablaLisMaDocumentosFormatosDTO();
        dto.setIdTablaLisMaDocumentosFormatos(entity.getIdTablaLisMaDocumentosFormatos());
        dto.setCodigo(entity.getCodigo());
        dto.setNombredocumento(entity.getNombredocumento());
        dto.setDepartamento(entity.getDepartamento());
        dto.setResponsable(entity.getResponsable());
        dto.setNoRevision(entity.getNoRevision());
        dto.setElaborado(entity.getElaborado());
        dto.setRevisado(entity.getRevisado());
        dto.setModificado(entity.getModificado());
        dto.setIdListadoMaestroDocumentos(entity.getListadoMaestroDocumentos().getIdListadoMaestroDocumentos());
        return dto;
    }

    public TablaLisMaDocumentosFormatos toEntity(TablaLisMaDocumentosFormatosDTO dto, ListadoMaestroDocumentos listadoMaestroDocumentos) {
        TablaLisMaDocumentosFormatos entity = new TablaLisMaDocumentosFormatos();
        entity.setIdTablaLisMaDocumentosFormatos(dto.getIdTablaLisMaDocumentosFormatos());
        entity.setCodigo(dto.getCodigo());
        entity.setNombredocumento(dto.getNombredocumento());
        entity.setDepartamento(dto.getDepartamento());
        entity.setResponsable(dto.getResponsable());
        entity.setNoRevision(dto.getNoRevision());
        entity.setElaborado(dto.getElaborado());
        entity.setRevisado(dto.getRevisado());
        entity.setModificado(dto.getModificado());
        entity.setListadoMaestroDocumentos(listadoMaestroDocumentos);
        return entity;
    }
}

