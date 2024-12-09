package com.api.login.Procesos.Mapper;

import com.api.login.Procesos.DTO.AlcanceProcesoDTO;
import com.api.login.Procesos.Pojo.AlcanceProceso;
import com.api.login.Procesos.Pojo.EnProceso;
import org.springframework.stereotype.Component;

@Component
public class AlcanceProcesoMapper {

    public AlcanceProcesoDTO toDTOAlProceso(AlcanceProceso entity){
        AlcanceProcesoDTO dto = new AlcanceProcesoDTO();
        dto.setIdAlcanceProceso(entity.getIdAlcanceProceso());
        dto.setContenido(entity.getContenido());
        dto.setIdEnProceso(entity.getEnProceso().getIdEnProceso());

        return dto;
    }

    public AlcanceProceso toEntityAlProceso(AlcanceProcesoDTO dto, EnProceso enProceso){
        AlcanceProceso entity = new AlcanceProceso();
        entity.setIdAlcanceProceso(dto.getIdAlcanceProceso());
        entity.setContenido(dto.getContenido());
        entity.setEnProceso(enProceso);

        return entity;
    }
}
