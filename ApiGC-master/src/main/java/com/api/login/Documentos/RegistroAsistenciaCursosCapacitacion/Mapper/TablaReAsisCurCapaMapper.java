package com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Mapper;

import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.DTO.TablaReAsisCurCapaDTO;
import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Pojo.ReAsisCurCapa;
import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Pojo.TablaReAsisCurCapa;
import org.springframework.stereotype.Component;

@Component
public class TablaReAsisCurCapaMapper {

    public TablaReAsisCurCapaDTO toDTO(TablaReAsisCurCapa entity){
        TablaReAsisCurCapaDTO dto = new TablaReAsisCurCapaDTO();

        dto.setIdTablaReAsisCurCapa(entity.getIdTablaReAsisCurCapa());
        dto.setNombre(entity.getNombre());
        dto.setPuesto(entity.getPuesto());
        dto.setArea(entity.getArea());
        dto.setFirma(entity.getFirma());
        dto.setIdReAsisCurCapa(entity.getReAsisCurCapa().getIdReAsisCurCapa());

        return dto;
    }

    public TablaReAsisCurCapa toEntity(TablaReAsisCurCapaDTO dto, ReAsisCurCapa reAsisCurCapa){
        TablaReAsisCurCapa entity = new TablaReAsisCurCapa();

        entity.setIdTablaReAsisCurCapa(dto.getIdTablaReAsisCurCapa());
        entity.setNombre(dto.getNombre());
        entity.setPuesto(dto.getPuesto());
        entity.setArea(dto.getArea());
        entity.setFirma(dto.getFirma());
        entity.setReAsisCurCapa(reAsisCurCapa);

        return entity;
    }
}

