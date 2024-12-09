package com.api.login.Procesos.Mapper;

import com.api.login.Procesos.DTO.AbreProdesoDTO;
import com.api.login.Procesos.Pojo.AbreProdeso;
import com.api.login.Procesos.Pojo.EnProceso;
import org.springframework.stereotype.Component;

@Component
public class AbreProdesoMapper {
    public AbreProdesoDTO toDTOAbreProceso(AbreProdeso entity){
        AbreProdesoDTO dto = new AbreProdesoDTO();
        dto.setIdAbreProceso(entity.getIdAbreProceso());
        dto.setAbreviaciones(entity.getAbreviaciones());
        dto.setDefinicion(entity.getDefinicion());
        dto.setIdEnProceso(entity.getEnProceso().getIdEnProceso());

        return dto;
    }

    public AbreProdeso toEntityAbreProceso(AbreProdesoDTO dto, EnProceso enProceso){
        AbreProdeso entity = new AbreProdeso();
        entity.setIdAbreProceso(dto.getIdAbreProceso());
        entity.setAbreviaciones(dto.getAbreviaciones());
        entity.setDefinicion(dto.getDefinicion());
        entity.setEnProceso(enProceso);

        return entity;
    }
}
