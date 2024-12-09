package com.api.login.Procesos.Mapper;

import com.api.login.Procesos.DTO.DiTortugaProcesoDTO;
import com.api.login.Procesos.Pojo.DiTortugaProceso;
import com.api.login.Procesos.Pojo.EnProceso;
import org.springframework.stereotype.Component;

@Component
public class DiTortugaProcesoMapper {

    public DiTortugaProcesoDTO toDTODiTortugaProceso(DiTortugaProceso entity){
        DiTortugaProcesoDTO dto = new DiTortugaProcesoDTO();
        dto.setIdDiTortuga(entity.getIdDiTortuga());
        dto.setNombreProceso(entity.getNombreProceso());
        dto.setDescripcion(entity.getDescripcion());
        dto.setIdEnProceso(entity.getEnProceso().getIdEnProceso());

        return dto;
    }

    public DiTortugaProceso toEntityDiTortugaProceso(DiTortugaProcesoDTO dto, EnProceso enProceso){
        DiTortugaProceso entity = new DiTortugaProceso();
        entity.setIdDiTortuga(dto.getIdDiTortuga());
        entity.setNombreProceso(dto.getNombreProceso());
        entity.setDescripcion(dto.getDescripcion());
        entity.setEnProceso(enProceso);

        return entity;
    }
}

