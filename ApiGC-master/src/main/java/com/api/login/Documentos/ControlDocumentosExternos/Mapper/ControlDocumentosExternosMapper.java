package com.api.login.Documentos.ControlDocumentosExternos.Mapper;

import com.api.login.Documentos.ControlDocumentosExternos.DTO.ControlDocumentosExternosDTO;
import com.api.login.Documentos.ControlDocumentosExternos.DTO.ControlDocumentosExternosDTOSinListas;
import com.api.login.Documentos.ControlDocumentosExternos.Pojo.ControlDocumentosExternos;
import com.api.login.Documentos.ControlDocumentosExternos.Pojo.ModificacionesControlDocEx;
import com.api.login.Documentos.ControlDocumentosExternos.Pojo.TablaControlDocumentosExternos;
import org.springframework.stereotype.Component;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Collections;

@Component
public class ControlDocumentosExternosMapper {

    @Autowired
    private TablaControlDocumentosExternosMapper tablaControlDocumentosExternosMapper;

    @Autowired
    private ModificacionesControlDocExMapper modificacionesControlDocExMapper;

    public ControlDocumentosExternosDTO toDTO(ControlDocumentosExternos entity) {
        ControlDocumentosExternosDTO dto = new ControlDocumentosExternosDTO();
        dto.setIdControlDocumentosExternos(entity.getIdControlDocumentosExternos());
        dto.setCoDocumento(entity.getCoDocumento());
        dto.setNoRevision(entity.getNoRevision());
        dto.setFechaEmicion(entity.getFechaEmicion());
        dto.setFechaRevision(entity.getFechaRevision());
        dto.setArea(entity.getArea());
        dto.setSeccion(entity.getSeccion());
        dto.setFecha(entity.getFecha());

        if (entity.getTablasControlDocumentosExternos() != null) {
            dto.setTablasControlDocumentosExternos(entity.getTablasControlDocumentosExternos().stream()
                    .map(tablaControlDocumentosExternosMapper::toDTO)
                    .collect(Collectors.toList()));
        } else {
            dto.setTablasControlDocumentosExternos(Collections.emptyList());
        }

        if (entity.getModificacionesControlDocExes() != null) {
            dto.setModificacionesControlDocEx(entity.getModificacionesControlDocExes().stream()
                    .map(modificacionesControlDocExMapper::toDTO)
                    .collect(Collectors.toList()));
        } else {
            dto.setModificacionesControlDocEx(Collections.emptyList());
        }

        return dto;
    }
    public ControlDocumentosExternosDTOSinListas toDTOSinListas(ControlDocumentosExternos entity) {
        ControlDocumentosExternosDTOSinListas dto = new ControlDocumentosExternosDTOSinListas();
        dto.setIdControlDocumentosExternos(entity.getIdControlDocumentosExternos());
        dto.setCoDocumento(entity.getCoDocumento());
        dto.setNoRevision(entity.getNoRevision());
        dto.setFechaEmicion(entity.getFechaEmicion());
        dto.setFechaRevision(entity.getFechaRevision());
        dto.setArea(entity.getArea());
        dto.setSeccion(entity.getSeccion());
        dto.setFecha(entity.getFecha());

        return dto;
    }


    public ControlDocumentosExternos toEntity(ControlDocumentosExternosDTO dto) {
        ControlDocumentosExternos entity = new ControlDocumentosExternos();
        entity.setIdControlDocumentosExternos(dto.getIdControlDocumentosExternos());
        entity.setCoDocumento(dto.getCoDocumento());
        entity.setNoRevision(dto.getNoRevision());
        entity.setFechaEmicion(dto.getFechaEmicion());
        entity.setFechaRevision(dto.getFechaRevision());
        entity.setArea(dto.getArea());
        entity.setSeccion(dto.getSeccion());
        entity.setFecha(dto.getFecha());

        if (dto.getTablasControlDocumentosExternos() != null) {
            List<TablaControlDocumentosExternos> tablas = dto.getTablasControlDocumentosExternos().stream()
                    .map(tablaDTO -> {
                        TablaControlDocumentosExternos tabla = tablaControlDocumentosExternosMapper.toEntity(tablaDTO, entity);
                        tabla.setControlDocumentosExternos(entity);
                        return tabla;
                    })
                    .collect(Collectors.toList());
            entity.setTablasControlDocumentosExternos(tablas);
        }
        if (dto.getModificacionesControlDocEx() != null) {
            List<ModificacionesControlDocEx> modificaciones = dto.getModificacionesControlDocEx().stream()
                    .map(modificacionesDTO -> modificacionesControlDocExMapper.toEntity(modificacionesDTO, entity))
                    .collect(Collectors.toList());
            entity.setModificacionesControlDocExes(modificaciones);
        }

        return entity;
    }
}


