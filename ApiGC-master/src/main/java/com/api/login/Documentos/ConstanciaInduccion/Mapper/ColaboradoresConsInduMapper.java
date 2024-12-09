package com.api.login.Documentos.ConstanciaInduccion.Mapper;

import com.api.login.Documentos.ConstanciaInduccion.DTO.ColaboradoresConsInduDTO;
import com.api.login.Documentos.ConstanciaInduccion.Pojo.ColaboradoresConsIndu;
import com.api.login.Documentos.ConstanciaInduccion.Pojo.ConstanciaInduccion;
import org.springframework.stereotype.Component;

@Component
public class ColaboradoresConsInduMapper {

    public ColaboradoresConsInduDTO toDTO(ColaboradoresConsIndu entity) {
        ColaboradoresConsInduDTO dto = new ColaboradoresConsInduDTO();
        dto.setIdColaboradoresConsIndu(entity.getIdColaboradoresConsIndu());
        dto.setNombre(entity.getNombre());
        dto.setPuesto(entity.getPuesto());
        dto.setFirma(entity.getFirma());
        dto.setIdConstanciaInduccion(entity.getConstanciaInduccion().getIdConstanciaInduccion());
        return dto;
    }

    public ColaboradoresConsIndu toEntity(ColaboradoresConsInduDTO dto, ConstanciaInduccion constanciaInduccion) {
        ColaboradoresConsIndu entity = new ColaboradoresConsIndu();
        entity.setIdColaboradoresConsIndu(dto.getIdColaboradoresConsIndu());
        entity.setNombre(dto.getNombre());
        entity.setPuesto(dto.getPuesto());
        entity.setFirma(dto.getFirma());
        entity.setConstanciaInduccion(constanciaInduccion);
        return entity;
    }
}
