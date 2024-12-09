package com.api.login.Procesos.Mapper;

import com.api.login.Procesos.DTO.ObjetivoProcesoDTO;
import com.api.login.Procesos.Pojo.EnProceso;
import com.api.login.Procesos.Pojo.ObjetivoProceso;
import org.springframework.stereotype.Component;

@Component
public class ObjetivoProcesoMapper {

    public ObjetivoProcesoDTO toDTOObProceso(ObjetivoProceso entity){
        ObjetivoProcesoDTO dto = new ObjetivoProcesoDTO();
        dto.setIdObjetivoProceso(entity.getIdObjetivoProceso());
        dto.setContenido(entity.getContenido());
        dto.setIdEnProceso(entity.getEnProceso().getIdEnProceso());

        return dto;
    }

    public ObjetivoProceso toEntityObProceso(ObjetivoProcesoDTO dto, EnProceso enProceso){
        ObjetivoProceso entity = new ObjetivoProceso();

        entity.setIdObjetivoProceso(dto.getIdObjetivoProceso());
        entity.setContenido(dto.getContenido());
        entity.setEnProceso(enProceso);

        return entity;
    }

}
