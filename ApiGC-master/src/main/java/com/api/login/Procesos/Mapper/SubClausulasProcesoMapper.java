package com.api.login.Procesos.Mapper;

import com.api.login.Procesos.DTO.SubClausulasProcesoDTO;
import com.api.login.Procesos.Pojo.DesarrolloProceso;
import com.api.login.Procesos.Pojo.SubClausulasProceso;
import com.api.login.Procesos.Pojo.SubSubClausulasProceso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SubClausulasProcesoMapper {

    @Autowired
    private SubSubClausulasProcesoMapper subClausulasProcesoMapper;


    public SubClausulasProcesoDTO toDTO(SubClausulasProceso entity) {
        SubClausulasProcesoDTO dto = new SubClausulasProcesoDTO();
        dto.setIdSubClausulasProceso(entity.getIdSubClausulasProceso());
        dto.setTitulo(entity.getTitulo());
        dto.setContenido(entity.getContenido());
        dto.setIdDesarrolloProceso(entity.getDesarrolloProceso().getIdDesarrolloProceso());

        dto.setSubSubClausulas(
                entity.getSubSubClausulasProceso() != null
                ? entity.getSubSubClausulasProceso().stream().map(subClausulasProcesoMapper::toDTO).collect(Collectors.toList())
                        : Collections.emptyList()
        );
        return dto;
    }

    public SubClausulasProceso toEntity(SubClausulasProcesoDTO dto, DesarrolloProceso desarrolloProceso) {
        SubClausulasProceso entity = new SubClausulasProceso();
        entity.setIdSubClausulasProceso(dto.getIdSubClausulasProceso());
        entity.setTitulo(dto.getTitulo());
        entity.setContenido(dto.getContenido());
        entity.setDesarrolloProceso(desarrolloProceso);

        if(dto.getSubSubClausulas() != null){
            List<SubSubClausulasProceso> subSubClausulasProcesos = dto.getSubSubClausulas().stream()
                    .map(subSubClausulasProcesoDTO -> {
                        SubSubClausulasProceso subSubClausulasProceso = subClausulasProcesoMapper.toEntity(subSubClausulasProcesoDTO, entity);
                        subSubClausulasProceso.setSubClausulasProceso(entity);

                        return subSubClausulasProceso;
                    }).collect(Collectors.toList());
            entity.setSubSubClausulasProceso(subSubClausulasProcesos);
        }
        else {
            entity.setSubSubClausulasProceso(Collections.emptyList());
        }

        return entity;
    }
}

