package com.api.login.Procesos.Mapper;

import com.api.login.Procesos.DTO.SubSubClausulasProcesoDTO;
import com.api.login.Procesos.Pojo.SubClausulasProceso;
import com.api.login.Procesos.Pojo.SubSubClausulasProceso;
import org.springframework.stereotype.Component;

@Component
public class SubSubClausulasProcesoMapper {

    public SubSubClausulasProcesoDTO toDTO(SubSubClausulasProceso entity) {
        SubSubClausulasProcesoDTO dto = new SubSubClausulasProcesoDTO();
        dto.setIdSubSubClausulasProceso(entity.getIdSubSubClausulasProceso());
        dto.setTitulo(entity.getTitulo());
        dto.setContenido(entity.getContenido());
        dto.setIdSubClausulasProceso(entity.getSubClausulasProceso().getIdSubClausulasProceso());
        return dto;
    }

    public SubSubClausulasProceso toEntity(SubSubClausulasProcesoDTO dto, SubClausulasProceso subClausulasProceso) {
        SubSubClausulasProceso entity = new SubSubClausulasProceso();
        entity.setIdSubSubClausulasProceso(dto.getIdSubSubClausulasProceso());
        entity.setTitulo(dto.getTitulo());
        entity.setContenido(dto.getContenido());
        entity.setSubClausulasProceso(subClausulasProceso);
        return entity;
    }
}

