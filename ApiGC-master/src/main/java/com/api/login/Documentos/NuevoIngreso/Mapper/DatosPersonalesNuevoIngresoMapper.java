package com.api.login.Documentos.NuevoIngreso.Mapper;

import com.api.login.Documentos.NuevoIngreso.DTO.DatosPersonalesNuevoIngresoDTO;
import com.api.login.Documentos.NuevoIngreso.Pojo.DatosPersonalesNuevoIngreso;
import com.api.login.Documentos.NuevoIngreso.Pojo.NuevoIngreso;
import org.springframework.stereotype.Component;

@Component
public class DatosPersonalesNuevoIngresoMapper {

    public DatosPersonalesNuevoIngresoDTO toDtoDaPer(DatosPersonalesNuevoIngreso entity){
        DatosPersonalesNuevoIngresoDTO dto =new DatosPersonalesNuevoIngresoDTO();
        dto.setIdDatosPersonalesNuevoIngreso(entity.getIdDatosPersonalesNuevoIngreso());
        dto.setNombreEmpleado(entity.getNombreEmpleado());
        dto.setFechaNacimiento(entity.getFechaNacimiento());
        dto.setLugarNacimiento(entity.getLugarNacimiento());
        dto.setEdad(entity.getEdad());
        dto.setEstadoSivil(entity.getEstadoSivil());
        dto.setFechaIngreso(entity.getFechaIngreso());
        dto.setNombreMama(entity.getNombreMama());
        dto.setNombrePapa(entity.getNombrePapa());
        dto.setNuHermanos(entity.getNuHermanos());
        dto.setIdNuevoIngreso(entity.getNuevoIngreso().getIdNuevoIngreso());

        return dto;
    }

    public DatosPersonalesNuevoIngreso  toEntityDaPer(DatosPersonalesNuevoIngresoDTO dto, NuevoIngreso nuevoIngreso){
        DatosPersonalesNuevoIngreso entity = new DatosPersonalesNuevoIngreso();

        entity.setIdDatosPersonalesNuevoIngreso(dto.getIdDatosPersonalesNuevoIngreso());
        entity.setNombreEmpleado(dto.getNombreEmpleado());
        entity.setFechaNacimiento(dto.getFechaNacimiento());
        entity.setLugarNacimiento(dto.getLugarNacimiento());
        entity.setEdad(dto.getEdad());
        entity.setEstadoSivil(dto.getEstadoSivil());
        entity.setFechaIngreso(dto.getFechaIngreso());
        entity.setNombreMama(dto.getNombreMama());
        entity.setNombrePapa(dto.getNombrePapa());
        entity.setNuHermanos(dto.getNuHermanos());
        entity.setNuevoIngreso(nuevoIngreso);

        return entity;
    }

}
