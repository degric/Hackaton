package com.api.login.Documentos.ListadoMaestroDocumentos.Mapper;

import com.api.login.Documentos.ListadoMaestroDocumentos.DTO.TablaLisMaDocumentosProcesosDTO;
import com.api.login.Documentos.ListadoMaestroDocumentos.Pojo.ListadoMaestroDocumentos;
import com.api.login.Documentos.ListadoMaestroDocumentos.Pojo.TablaLisMaDocumentosProcesos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TablaLisMaDocumentosProcesosMapper {

    @Autowired
    private ListadoMaestroDocumentosMapper listadoMaestroDocumentosMapper;

    public TablaLisMaDocumentosProcesosDTO toDTO(TablaLisMaDocumentosProcesos entity) {
        TablaLisMaDocumentosProcesosDTO dto = new TablaLisMaDocumentosProcesosDTO();
        dto.setIdTablaLisMaDocumentosProcesos(entity.getIdTablaLisMaDocumentosProcesos());
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

    public TablaLisMaDocumentosProcesos toEntity(TablaLisMaDocumentosProcesosDTO dto, ListadoMaestroDocumentos listadoMaestroDocumentos) {
        TablaLisMaDocumentosProcesos entity = new TablaLisMaDocumentosProcesos();
        entity.setIdTablaLisMaDocumentosProcesos(dto.getIdTablaLisMaDocumentosProcesos());
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


