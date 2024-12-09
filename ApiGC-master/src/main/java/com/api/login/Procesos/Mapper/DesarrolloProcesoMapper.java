package com.api.login.Procesos.Mapper;

import com.api.login.Procesos.DTO.DesarrolloProcesoDTO;
import com.api.login.Procesos.Pojo.DesarrolloProceso;
import com.api.login.Procesos.Pojo.EnProceso;
import com.api.login.Procesos.Pojo.SubClausulasProceso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DesarrolloProcesoMapper {

    @Autowired
    private SubClausulasProcesoMapper subClausulasProcesoMapper;

    public DesarrolloProcesoDTO toDTODesarrolloProceso(DesarrolloProceso entity){
        DesarrolloProcesoDTO dto = new DesarrolloProcesoDTO();
        dto.setIdDesarrolloProceso(entity.getIdDesarrolloProceso());
        dto.setTitulo(entity.getTitulo());
        dto.setContenido(entity.getContenido());
        dto.setIdEnProceso(entity.getEnProceso().getIdEnProceso());

        dto.setSubClausulas(
                entity.getSubClausulas() != null
                ? entity.getSubClausulas().stream().map(subClausulasProcesoMapper::toDTO).collect(Collectors.toList())
                        : Collections.emptyList()
        );

        return dto;
    }

    public DesarrolloProceso toEntityDesarrolloProceso(DesarrolloProcesoDTO dto, EnProceso enProceso){
        DesarrolloProceso entity = new DesarrolloProceso();
        entity.setIdDesarrolloProceso(dto.getIdDesarrolloProceso());
        entity.setTitulo(dto.getTitulo());
        entity.setContenido(dto.getContenido());
        entity.setEnProceso(enProceso);

        if (dto.getSubClausulas() != null){
            List<SubClausulasProceso> subClausulasProcesos = dto.getSubClausulas().stream()
                    .map(subClausulasProcesoDTO -> {
                        SubClausulasProceso subClausulasProceso = subClausulasProcesoMapper.toEntity(subClausulasProcesoDTO, entity);
                        subClausulasProceso.setDesarrolloProceso(entity);

                        return subClausulasProceso;
                    }).collect(Collectors.toList());
            entity.setSubClausulas(subClausulasProcesos);
        }else {
            entity.setSubClausulas(Collections.emptyList());
        }

        return entity;
    }
}
