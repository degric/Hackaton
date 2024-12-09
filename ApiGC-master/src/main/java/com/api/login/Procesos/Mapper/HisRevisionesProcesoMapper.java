package com.api.login.Procesos.Mapper;

import com.api.login.Procesos.DTO.HisRevisionesProcesoDTO;
import com.api.login.Procesos.Pojo.EnProceso;
import com.api.login.Procesos.Pojo.HisRevisionesProceso;
import org.springframework.stereotype.Component;

@Component
public class HisRevisionesProcesoMapper {

    public HisRevisionesProcesoDTO toDTOHisRevisionesProceso(HisRevisionesProceso entity){
        HisRevisionesProcesoDTO dto = new HisRevisionesProcesoDTO();
        dto.setIdHisRevisionProceso(entity.getIdHisRevisionProceso());
        dto.setNumeroRevision(entity.getNumeroRevision());
        dto.setFecha(entity.getFecha());
        dto.setSeccionAfectada(entity.getSeccionAfectada());
        dto.setEfectuadoPor(entity.getEfectuadoPor());
        dto.setFechaEjecucion(entity.getFechaEjecucion());
        dto.setIdEnProceso(entity.getEnProceso().getIdEnProceso());

        return dto;
    }

    public HisRevisionesProceso toEntityHisRevisionesProceso(HisRevisionesProcesoDTO dto, EnProceso enProceso){
        HisRevisionesProceso entity = new HisRevisionesProceso();
        entity.setIdHisRevisionProceso(dto.getIdHisRevisionProceso());
        entity.setNumeroRevision(dto.getNumeroRevision());
        entity.setFecha(dto.getFecha());
        entity.setSeccionAfectada(dto.getSeccionAfectada());
        entity.setEfectuadoPor(dto.getEfectuadoPor());
        entity.setFechaEjecucion(dto.getFechaEjecucion());
        entity.setEnProceso(enProceso);

        return entity;
    }
}


