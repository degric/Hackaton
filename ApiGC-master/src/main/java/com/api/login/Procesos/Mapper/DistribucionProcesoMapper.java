package com.api.login.Procesos.Mapper;

import com.api.login.Procesos.DTO.DistribucionProcesoDTO;
import com.api.login.Procesos.Pojo.DistribucionProceso;
import com.api.login.Procesos.Pojo.EnProceso;
import org.springframework.stereotype.Component;

@Component
public class DistribucionProcesoMapper {

    public DistribucionProcesoDTO toDTODistribucion(DistribucionProceso entity){
        DistribucionProcesoDTO dto = new DistribucionProcesoDTO();
        dto.setIdDisProceso(entity.getIdDisProceso());
        dto.setContenido(entity.getContenido());
        dto.setIdEnProceso(entity.getEnProceso().getIdEnProceso());

        return dto;
    }

    public DistribucionProceso toEntityDistribucion(DistribucionProcesoDTO dto, EnProceso enProceso){
        DistribucionProceso entity = new DistribucionProceso();
        entity.setIdDisProceso(dto.getIdDisProceso());
        entity.setContenido(dto.getContenido());
        entity.setEnProceso(enProceso);

        return entity;
    }
}

