package com.api.login.Documentos.NuevoIngreso.Mapper;

import com.api.login.Documentos.NuevoIngreso.DTO.TraAnNuevoIngresoDTO;
import com.api.login.Documentos.NuevoIngreso.Pojo.NuevoIngreso;
import com.api.login.Documentos.NuevoIngreso.Pojo.TraAnNuevoIngreso;
import org.springframework.stereotype.Component;

@Component
public class TraAnNuevoIngresoMapper {

    public TraAnNuevoIngresoDTO toDTOTraNuIn(TraAnNuevoIngreso entity){
        TraAnNuevoIngresoDTO dto = new TraAnNuevoIngresoDTO();

        dto.setIdTraAnNuevoIngreso(entity.getIdTraAnNuevoIngreso());
        dto.setFecha(entity.getFecha());
        dto.setLugar(entity.getLugar());
        dto.setFunDesempenadas(entity.getFunDesempenadas());
        dto.setIdNuevoIngreso(entity.getNuevoIngreso().getIdNuevoIngreso());

        return dto;
    }

    public TraAnNuevoIngreso toEntityTraNuIn(TraAnNuevoIngresoDTO dto, NuevoIngreso nuevoIngreso){
        TraAnNuevoIngreso entity = new TraAnNuevoIngreso();

        entity.setIdTraAnNuevoIngreso(dto.getIdTraAnNuevoIngreso());
        entity.setFecha(dto.getFecha());
        entity.setLugar(dto.getLugar());
        entity.setFunDesempenadas(dto.getFunDesempenadas());
        entity.setNuevoIngreso(nuevoIngreso);

        return entity;
    }
}
