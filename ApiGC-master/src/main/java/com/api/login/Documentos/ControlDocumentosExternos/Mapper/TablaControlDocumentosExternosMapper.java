package com.api.login.Documentos.ControlDocumentosExternos.Mapper;

import com.api.login.Documentos.ControlDocumentosExternos.DTO.TablaControlDocumentosExternosDTO;
import com.api.login.Documentos.ControlDocumentosExternos.Pojo.ControlDocumentosExternos;
import com.api.login.Documentos.ControlDocumentosExternos.Pojo.TablaControlDocumentosExternos;
import org.springframework.stereotype.Component;

@Component
public class TablaControlDocumentosExternosMapper {

    public TablaControlDocumentosExternosDTO toDTO(TablaControlDocumentosExternos entity) {
        TablaControlDocumentosExternosDTO dto = new TablaControlDocumentosExternosDTO();
        dto.setIdTablaControlDocumentosExternos(entity.getIdTablaControlDocumentosExternos());
        dto.setNumero(entity.getNumero());
        dto.setExterno(entity.getExterno());
        dto.setCodigo(entity.getCodigo());
        dto.setNombreDocumento(entity.getNombreDocumento());
        dto.setRevision(entity.getRevision());
        dto.setFechaEmocion(entity.getFechaEmocion());
        dto.setFechaRevision(entity.getFechaRevision());
        dto.setFechaUltimoCambio(entity.getFechaUltimoCambio());
        dto.setIdControlDocumentosExternos(entity.getControlDocumentosExternos().getIdControlDocumentosExternos());
        return dto;
    }

    public TablaControlDocumentosExternos toEntity(TablaControlDocumentosExternosDTO dto, ControlDocumentosExternos controlDocumentosExternos) {
        TablaControlDocumentosExternos entity = new TablaControlDocumentosExternos();
        entity.setIdTablaControlDocumentosExternos(dto.getIdTablaControlDocumentosExternos());
        entity.setNumero(dto.getNumero());
        entity.setExterno(dto.getExterno());
        entity.setCodigo(dto.getCodigo());
        entity.setNombreDocumento(dto.getNombreDocumento());
        entity.setRevision(dto.getRevision());
        entity.setFechaEmocion(dto.getFechaEmocion());
        entity.setFechaRevision(dto.getFechaRevision());
        entity.setFechaUltimoCambio(dto.getFechaUltimoCambio());
        entity.setControlDocumentosExternos(controlDocumentosExternos);
        return entity;
    }
}
