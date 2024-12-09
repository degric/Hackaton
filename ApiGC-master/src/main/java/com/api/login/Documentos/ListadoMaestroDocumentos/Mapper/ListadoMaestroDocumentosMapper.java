package com.api.login.Documentos.ListadoMaestroDocumentos.Mapper;

import com.api.login.Documentos.ListadoMaestroDocumentos.DTO.ListadoMaestroDocumentosDTO;
import com.api.login.Documentos.ListadoMaestroDocumentos.Pojo.ListadoMaestroDocumentos;
import com.api.login.Documentos.ListadoMaestroDocumentos.Pojo.TablaLisMaDocumentosAnexos;
import com.api.login.Documentos.ListadoMaestroDocumentos.Pojo.TablaLisMaDocumentosFormatos;
import com.api.login.Documentos.ListadoMaestroDocumentos.Pojo.TablaLisMaDocumentosProcesos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ListadoMaestroDocumentosMapper {

    @Autowired
    private TablaLisMaDocumentosProcesosMapper tablaLisMaDocumentosProcesosMapper;

    @Autowired
    private TablaLisMaDocumentosFormatosMapper tablaLisMaDocumentosFormatosMapper;

    @Autowired
    private TablaLisMaDocumentosAnexosMapper tablaLisMaDocumentosAnexosMapper;

    public ListadoMaestroDocumentosDTO toDTO(ListadoMaestroDocumentos entity) {
        ListadoMaestroDocumentosDTO dto = new ListadoMaestroDocumentosDTO();
        dto.setIdListadoMaestroDocumentos(entity.getIdListadoMaestroDocumentos());
        dto.setCoDocumento(entity.getCoDocumento());
        dto.setNoRevision(entity.getNoRevision());
        dto.setFechaEmicion(entity.getFechaEmicion());
        dto.setFechaRevision(entity.getFechaRevision());


        // Mapear la lista de procesos relacionados
        if (entity.getProcesos() != null) {
            dto.setProcesos(entity.getProcesos().stream()
                    .map(tablaLisMaDocumentosProcesosMapper::toDTO)
                    .collect(Collectors.toList()));
        } else {
            dto.setProcesos(Collections.emptyList());
        }

        if (entity.getFormatos() != null) {
            dto.setFormatos(entity.getFormatos().stream()
                    .map(tablaLisMaDocumentosFormatosMapper::toDTO)
                    .collect(Collectors.toList()));
        } else {
            dto.setFormatos(Collections.emptyList());
        }

        // Mapear la lista de anexos relacionados
        if (entity.getAnexos() != null) {
            dto.setAnexos(entity.getAnexos().stream()
                    .map(tablaLisMaDocumentosAnexosMapper::toDTO)
                    .collect(Collectors.toList()));
        } else {
            dto.setAnexos(Collections.emptyList());
        }


        return dto;

    }

    public ListadoMaestroDocumentos toEntity(ListadoMaestroDocumentosDTO dto) {
        ListadoMaestroDocumentos entity = new ListadoMaestroDocumentos();
        entity.setIdListadoMaestroDocumentos(dto.getIdListadoMaestroDocumentos());
        entity.setCoDocumento(dto.getCoDocumento());
        entity.setNoRevision(dto.getNoRevision());
        entity.setFechaEmicion(dto.getFechaEmicion());
        entity.setFechaRevision(dto.getFechaRevision());

        // Mapear la lista de procesos relacionados
        if (dto.getProcesos() != null) {
            List<TablaLisMaDocumentosProcesos> procesos = dto.getProcesos().stream()
                    .map(tablaDTO -> tablaLisMaDocumentosProcesosMapper.toEntity(tablaDTO, entity))
                    .collect(Collectors.toList());
            entity.setProcesos(procesos);
        }


        // Mapear la lista de formatos relacionados
        if (dto.getFormatos() != null) {
            List<TablaLisMaDocumentosFormatos> formatos = dto.getFormatos().stream()
                    .map(tablaDTO->tablaLisMaDocumentosFormatosMapper.toEntity(tablaDTO, entity))
                    .collect(Collectors.toList());
            entity.setFormatos(formatos);
        }

        // Mapear la lista de anexos relacionados
        if (dto.getAnexos() != null) {
            List<TablaLisMaDocumentosAnexos> anexos = dto.getAnexos().stream()
                    .map(tablaDTO->tablaLisMaDocumentosAnexosMapper.toEntity(tablaDTO, entity))
                    .collect(Collectors.toList());
            entity.setAnexos(anexos);
        }

        return entity;
    }
}


