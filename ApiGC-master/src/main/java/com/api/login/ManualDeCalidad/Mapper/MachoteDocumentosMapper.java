package com.api.login.ManualDeCalidad.Mapper;

import com.api.login.ManualDeCalidad.DTO.MachoteDocumentosDTO;
import com.api.login.ManualDeCalidad.pojo.MachoteDocumentos;
import org.springframework.stereotype.Component;

@Component
public class MachoteDocumentosMapper {

    public MachoteDocumentosDTO toDTO(MachoteDocumentos entity) {
        MachoteDocumentosDTO dto = new MachoteDocumentosDTO();
        dto.setIdMachoteDocumentos(entity.getIdMachoteDocumentos());
        dto.setNombreDocumento(entity.getNombreDocumento());
        dto.setIdDocumento(entity.getIdDocumento());
        dto.setNivelDocumento(entity.getNivelDocumento());
        dto.setCodigoDocumento(entity.getCodigoDocumento());
        return dto;
    }

    public MachoteDocumentos toEntity(MachoteDocumentosDTO dto) {
        MachoteDocumentos entity = new MachoteDocumentos();
        entity.setIdMachoteDocumentos(dto.getIdMachoteDocumentos());
        entity.setNombreDocumento(dto.getNombreDocumento());
        entity.setIdDocumento(dto.getIdDocumento());
        entity.setNivelDocumento(dto.getNivelDocumento());
        entity.setCodigoDocumento(dto.getCodigoDocumento());
        return entity;
    }
}

