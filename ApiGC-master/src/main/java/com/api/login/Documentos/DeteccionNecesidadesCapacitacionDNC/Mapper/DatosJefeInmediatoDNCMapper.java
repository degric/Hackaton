package com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Mapper;

import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.DTO.DatosJefeInmediatoDNCDTO;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Pojo.DatosJefeInmediatoDNC;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Pojo.DetecionNeCaDNC;
import org.springframework.stereotype.Component;

@Component
public class DatosJefeInmediatoDNCMapper {

    public DatosJefeInmediatoDNCDTO toDTO(DatosJefeInmediatoDNC entity) {
        DatosJefeInmediatoDNCDTO dto = new DatosJefeInmediatoDNCDTO();
        dto.setIdDatosJefeInmediatoDNC(entity.getIdDatosJefeInmediatoDNC());
        dto.setNombre(entity.getNombre());
        dto.setPuesto(entity.getPuesto());
        dto.setArea(entity.getArea());
        dto.setFecha(entity.getFecha());
        dto.setIdDetecionNeCaDNC(entity.getDetecionNeCaDNC().getIdDetecionNeCaDNC());
        return dto;
    }

    public DatosJefeInmediatoDNC toEntity(DatosJefeInmediatoDNCDTO dto, DetecionNeCaDNC detecionNeCaDNC) {
        DatosJefeInmediatoDNC entity = new DatosJefeInmediatoDNC();
        entity.setIdDatosJefeInmediatoDNC(dto.getIdDatosJefeInmediatoDNC());
        entity.setNombre(dto.getNombre());
        entity.setPuesto(dto.getPuesto());
        entity.setArea(dto.getArea());
        entity.setFecha(dto.getFecha());
        entity.setDetecionNeCaDNC(detecionNeCaDNC);
        return entity;
    }
}
