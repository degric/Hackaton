package com.api.login.Documentos.NuevoIngreso.Mapper;

import com.api.login.Documentos.NuevoIngreso.DTO.DomicilioNuevoIngresoDTO;
import com.api.login.Documentos.NuevoIngreso.Pojo.DomicilioNuevoIngreso;
import com.api.login.Documentos.NuevoIngreso.Pojo.NuevoIngreso;
import org.springframework.stereotype.Component;

@Component
public class DomicilioNuevoIngresoMapper {

    public DomicilioNuevoIngresoDTO toDTODoNuIn(DomicilioNuevoIngreso entity){
        DomicilioNuevoIngresoDTO dto = new DomicilioNuevoIngresoDTO();
        dto.setIdDomicilioNuevoIngreso(entity.getIdDomicilioNuevoIngreso());
        dto.setCalleNumero(entity.getCalleNumero());
        dto.setColonia(entity.getColonia());
        dto.setLocalidad(entity.getLocalidad());
        dto.setMuinicipio(entity.getMuinicipio());
        dto.setEstado(entity.getEstado());
        dto.setCp(entity.getCp());
        dto.setIdNuevoIngreso(entity.getNuevoIngreso().getIdNuevoIngreso());

        return dto;
    }

    public DomicilioNuevoIngreso toEntityDoNuIn(DomicilioNuevoIngresoDTO dto, NuevoIngreso nuevoIngreso){
        DomicilioNuevoIngreso entity = new DomicilioNuevoIngreso();

        entity.setIdDomicilioNuevoIngreso(dto.getIdDomicilioNuevoIngreso());
        entity.setCalleNumero(dto.getCalleNumero());
        entity.setColonia(dto.getColonia());
        entity.setLocalidad(dto.getLocalidad());
        entity.setMuinicipio(dto.getMuinicipio());
        entity.setEstado(dto.getEstado());
        entity.setCp(dto.getCp());
        entity.setNuevoIngreso(nuevoIngreso);

        return entity;
    }
}
