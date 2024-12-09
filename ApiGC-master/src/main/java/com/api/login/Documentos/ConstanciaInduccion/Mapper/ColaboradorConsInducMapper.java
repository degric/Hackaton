package com.api.login.Documentos.ConstanciaInduccion.Mapper;

import com.api.login.Documentos.ConstanciaInduccion.DTO.ColaboradorConsInducDTO;
import com.api.login.Documentos.ConstanciaInduccion.Pojo.ColaboradorConsInduc;
import com.api.login.Documentos.ConstanciaInduccion.Pojo.ConstanciaInduccion;
import org.springframework.stereotype.Component;

@Component
public class ColaboradorConsInducMapper {

    public ColaboradorConsInducDTO toDTO(ColaboradorConsInduc entity) {
        ColaboradorConsInducDTO dto = new ColaboradorConsInducDTO();
        dto.setIdColaboradorConsInduc(entity.getIdColaboradorConsInduc());
        dto.setNombre(entity.getNombre());
        dto.setFirma(entity.getFirma());
        dto.setIdConstanciaInduccion(entity.getConstanciaInduccion().getIdConstanciaInduccion());
        return dto;
    }

    public ColaboradorConsInduc toEntity(ColaboradorConsInducDTO dto, ConstanciaInduccion constanciaInduccion) {
        ColaboradorConsInduc entity = new ColaboradorConsInduc();
        entity.setIdColaboradorConsInduc(dto.getIdColaboradorConsInduc());
        entity.setNombre(dto.getNombre());
        entity.setFirma(dto.getFirma());
        entity.setConstanciaInduccion(constanciaInduccion);
        return entity;
    }
}
