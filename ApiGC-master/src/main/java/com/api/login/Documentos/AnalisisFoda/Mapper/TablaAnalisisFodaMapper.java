package com.api.login.Documentos.AnalisisFoda.Mapper;

import com.api.login.Documentos.AnalisisFoda.DTO.TablaAnalisisFodaDTO;
import com.api.login.Documentos.AnalisisFoda.Pojo.AnalisisFoda;
import com.api.login.Documentos.AnalisisFoda.Pojo.TablaAnalisisFoda;
import org.springframework.stereotype.Component;

@Component
public class TablaAnalisisFodaMapper {

    public TablaAnalisisFodaDTO toDTO(TablaAnalisisFoda entity) {
        TablaAnalisisFodaDTO dto = new TablaAnalisisFodaDTO();
        dto.setIdTablaAnalisisFoda(entity.getIdTablaAnalisisFoda());
        dto.setDepartamento(entity.getDepartamento());
        dto.setFortalezas(entity.getFortalezas());
        dto.setOportunidades(entity.getOportunidades());
        dto.setDebilidades(entity.getDebilidades());
        dto.setAmanezas(entity.getAmanezas());
        dto.setIdAnalisisFoda(entity.getAnalisisFoda().getIdAnalisisFoda());
        return dto;
    }

    public TablaAnalisisFoda toEntity(TablaAnalisisFodaDTO dto, AnalisisFoda analisisFoda) {
        TablaAnalisisFoda entity = new TablaAnalisisFoda();
        entity.setIdTablaAnalisisFoda(dto.getIdTablaAnalisisFoda());
        entity.setDepartamento(dto.getDepartamento());
        entity.setFortalezas(dto.getFortalezas());
        entity.setOportunidades(dto.getOportunidades());
        entity.setDebilidades(dto.getDebilidades());
        entity.setAmanezas(dto.getAmanezas());
        entity.setAnalisisFoda(analisisFoda);
        return entity;
    }
}

