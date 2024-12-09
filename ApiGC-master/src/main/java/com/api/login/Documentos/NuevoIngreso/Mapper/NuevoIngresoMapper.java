package com.api.login.Documentos.NuevoIngreso.Mapper;

import com.api.login.Documentos.NuevoIngreso.DTO.NuevoIngresoDTO;
import com.api.login.Documentos.NuevoIngreso.Pojo.NuevoIngreso;
import org.springframework.stereotype.Component;

@Component
public class NuevoIngresoMapper {

    public NuevoIngresoDTO toDTONuIn(NuevoIngreso entity){
        NuevoIngresoDTO dto = new NuevoIngresoDTO();

        dto.setIdNuevoIngreso(entity.getIdNuevoIngreso());
        dto.setCoDocumento(entity.getCoDocumento());
        dto.setNoRevision(entity.getNoRevision());
        dto.setFechaEmicion(entity.getFechaEmicion());
        dto.setFechaRevision(entity.getFechaRevision());

        return dto;
    }

    public NuevoIngreso toEntityNuIn(NuevoIngresoDTO dto){
        NuevoIngreso entity = new NuevoIngreso();

        entity.setIdNuevoIngreso(dto.getIdNuevoIngreso());
        entity.setCoDocumento(dto.getCoDocumento());
        entity.setNoRevision(dto.getNoRevision());
        entity.setFechaEmicion(dto.getFechaEmicion());
        entity.setFechaRevision(dto.getFechaRevision());

        return entity;
    }
}
