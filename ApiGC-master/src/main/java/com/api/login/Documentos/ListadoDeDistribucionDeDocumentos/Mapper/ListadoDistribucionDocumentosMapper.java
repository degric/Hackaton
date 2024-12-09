package com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Mapper;

import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.DTO.ListadoDistribucionDocumentosDTO;
import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Pojo.LDDDescricionDocumento;
import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Pojo.LDDocTabla;
import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Pojo.ListadoDistribucionDocumentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ListadoDistribucionDocumentosMapper {

    @Autowired
    private LDDDescricionDocumentoMapper lddDescricionDocumentoMapper;

    @Autowired
    private LDDocTablaMapper lddDocTablaMapper;


    public ListadoDistribucionDocumentosDTO toDTO(ListadoDistribucionDocumentos entity) {
        ListadoDistribucionDocumentosDTO dto = new ListadoDistribucionDocumentosDTO();
        dto.setIdListadoDistribucionDocumentos(entity.getIdListadoDistribucionDocumentos());
        dto.setCoDocumento(entity.getCoDocumento());
        dto.setNoRevision(entity.getNoRevision());
        dto.setFechaEmicion(entity.getFechaEmicion());
        dto.setFechaRevision(entity.getFechaRevision());

        // Mapear la lista de descripciones de documentos relacionadas
        if (entity.getLddDescricionDocumentos() != null) {
            dto.setLddDescricionDocumentos(entity.getLddDescricionDocumentos().stream()
                    .map(lddDescricionDocumentoMapper::toDTO)
                    .collect(Collectors.toList()));
        }

        // Mapear la lista de tablas de distribución de documentos relacionadas
        if (entity.getLddDocTablas() != null) {
            dto.setLddDocTablas(entity.getLddDocTablas().stream()
                    .map(lddDocTablaMapper::toDTO)
                    .collect(Collectors.toList()));
        }


        return dto;
    }

    public ListadoDistribucionDocumentos toEntity(ListadoDistribucionDocumentosDTO dto) {
        ListadoDistribucionDocumentos entity = new ListadoDistribucionDocumentos();
        entity.setIdListadoDistribucionDocumentos(dto.getIdListadoDistribucionDocumentos());
        entity.setCoDocumento(dto.getCoDocumento());
        entity.setNoRevision(dto.getNoRevision());
        entity.setFechaEmicion(dto.getFechaEmicion());
        entity.setFechaRevision(dto.getFechaRevision());

        // Mapear la lista de descripciones de documentos relacionadas
        if (dto.getLddDescricionDocumentos() != null) {
            List<LDDDescricionDocumento> descripciones = dto.getLddDescricionDocumentos().stream()
                    .map(descripcionDTO -> {
                        LDDDescricionDocumento descripcion = lddDescricionDocumentoMapper.toEntity(descripcionDTO, entity);
                        descripcion.setListadoDistribucionDocumentos(entity);  // Asignar la relación
                        return descripcion;
                    })
                    .collect(Collectors.toList());
            entity.setLddDescricionDocumentos(descripciones);
        }
        // Mapear la lista de tablas de distribución de documentos relacionadas
        if (dto.getLddDocTablas() != null) {
            List<LDDocTabla> docTablas = dto.getLddDocTablas().stream()
                    .map(docTablaDTO -> {
                        LDDocTabla docTabla = lddDocTablaMapper.toEntity(docTablaDTO, entity);
                        docTabla.setListadoDistribucionDocumentos(entity);  // Asignar la relación
                        return docTabla;
                    })
                    .collect(Collectors.toList());
            entity.setLddDocTablas(docTablas);
        }

        return entity;
    }
}

