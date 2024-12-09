package com.api.login.Documentos.ConstanciaInduccion.Mapper;

import com.api.login.Documentos.ConstanciaInduccion.DTO.InformacionConsInduDTO;
import com.api.login.Documentos.ConstanciaInduccion.Pojo.ConstanciaInduccion;
import com.api.login.Documentos.ConstanciaInduccion.Pojo.InformacionConsIndu;
import org.springframework.stereotype.Component;

@Component
public class InformacionConsInduMapper {

    public InformacionConsInduDTO toDTO(InformacionConsIndu entity) {
        InformacionConsInduDTO dto = new InformacionConsInduDTO();
        dto.setIdInformacionConsIndu(entity.getIdInformacionConsIndu());
        dto.setInfo(entity.getInfo());
        dto.setRespuesta(entity.getRespuesta());
        dto.setIdConstanciaInduccion(entity.getConstanciaInduccion().getIdConstanciaInduccion());
        return dto;
    }

    public InformacionConsIndu toEntity(InformacionConsInduDTO dto, ConstanciaInduccion constanciaInduccion) {
        InformacionConsIndu entity = new InformacionConsIndu();
        entity.setIdInformacionConsIndu(dto.getIdInformacionConsIndu());
        entity.setInfo(dto.getInfo());
        entity.setRespuesta(dto.getRespuesta());
        entity.setConstanciaInduccion(constanciaInduccion);
        return entity;
    }
}
