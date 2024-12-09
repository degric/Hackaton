package com.api.login.Documentos.ControlDocumentosExternos.Mapper;

import com.api.login.Documentos.ControlDocumentosExternos.DTO.ModificacionesControlDocExDTO;
import com.api.login.Documentos.ControlDocumentosExternos.Pojo.ControlDocumentosExternos;
import com.api.login.Documentos.ControlDocumentosExternos.Pojo.ModificacionesControlDocEx;
import org.springframework.stereotype.Component;

@Component
public class ModificacionesControlDocExMapper {

    public ModificacionesControlDocExDTO toDTO(ModificacionesControlDocEx entity) {
        ModificacionesControlDocExDTO dto = new ModificacionesControlDocExDTO();
        dto.setIdModificacionesControlDocEx(entity.getIdModificacionesControlDocEx());
        dto.setFechaCambio(entity.getFechaCambio());
        dto.setEdRev(entity.getEdRev());
        dto.setCambiosRealizadosVerAn(entity.getCambiosRealizadosVerAn());
        dto.setIdControlDocumentosExternos(entity.getControlDocumentosExternos().getIdControlDocumentosExternos());
        return dto;
    }

    public ModificacionesControlDocEx toEntity(ModificacionesControlDocExDTO dto, ControlDocumentosExternos controlDocumentosExternos) {
        ModificacionesControlDocEx entity = new ModificacionesControlDocEx();
        entity.setIdModificacionesControlDocEx(dto.getIdModificacionesControlDocEx());
        entity.setFechaCambio(dto.getFechaCambio());
        entity.setEdRev(dto.getEdRev());
        entity.setCambiosRealizadosVerAn(dto.getCambiosRealizadosVerAn());
        entity.setControlDocumentosExternos(controlDocumentosExternos);
        return entity;
    }
}

