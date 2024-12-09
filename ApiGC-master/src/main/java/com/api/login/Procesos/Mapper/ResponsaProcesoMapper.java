package com.api.login.Procesos.Mapper;

import com.api.login.Procesos.DTO.ResponsaProcesoDTO;
import com.api.login.Procesos.Pojo.EnProceso;
import com.api.login.Procesos.Pojo.ResponsaProceso;
import org.springframework.stereotype.Component;

@Component
public class ResponsaProcesoMapper {

    public ResponsaProcesoDTO toDTO(ResponsaProceso entity){
        ResponsaProcesoDTO dto = new ResponsaProcesoDTO();
        dto.setIdResponsaProceso(entity.getIdResponsaProceso());
        dto.setResponsable(entity.getResponsable());
        dto.setResponsabilidades(entity.getResponsabilidades());
        dto.setIdEnProceso(entity.getEnProceso().getIdEnProceso());

        return dto;
    }

    public ResponsaProceso toEntity(ResponsaProcesoDTO dto, EnProceso enProceso){
        ResponsaProceso entity = new ResponsaProceso();
        entity.setIdResponsaProceso(dto.getIdResponsaProceso());
        entity.setResponsable(dto.getResponsable());
        entity.setResponsabilidades(dto.getResponsabilidades());
        entity.setEnProceso(enProceso);

        return entity;
    }
}

