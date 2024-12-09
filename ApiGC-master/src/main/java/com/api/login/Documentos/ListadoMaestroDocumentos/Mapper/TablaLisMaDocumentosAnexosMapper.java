package com.api.login.Documentos.ListadoMaestroDocumentos.Mapper;

import com.api.login.Documentos.ListadoMaestroDocumentos.DTO.TablaLisMaDocumentosAnexosDTO;
import com.api.login.Documentos.ListadoMaestroDocumentos.Pojo.ListadoMaestroDocumentos;
import com.api.login.Documentos.ListadoMaestroDocumentos.Pojo.TablaLisMaDocumentosAnexos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TablaLisMaDocumentosAnexosMapper {

    @Autowired
    private ListadoMaestroDocumentosMapper listadoMaestroDocumentosMapper;

    public TablaLisMaDocumentosAnexosDTO toDTO(TablaLisMaDocumentosAnexos entity) {
        TablaLisMaDocumentosAnexosDTO dto = new TablaLisMaDocumentosAnexosDTO();
        dto.setIdTablaLisMaDocumentosFormatosAnexos(entity.getIdTablaLisMaDocumentosFormatosAnexos());
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

    public TablaLisMaDocumentosAnexos toEntity(TablaLisMaDocumentosAnexosDTO dto, ListadoMaestroDocumentos listadoMaestroDocumentos) {
        TablaLisMaDocumentosAnexos entity = new TablaLisMaDocumentosAnexos();
        entity.setIdTablaLisMaDocumentosFormatosAnexos(dto.getIdTablaLisMaDocumentosFormatosAnexos());
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

