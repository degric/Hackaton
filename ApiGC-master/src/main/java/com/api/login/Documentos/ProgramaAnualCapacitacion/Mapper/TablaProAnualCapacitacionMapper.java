package com.api.login.Documentos.ProgramaAnualCapacitacion.Mapper;

import com.api.login.Documentos.ProgramaAnualCapacitacion.DTO.TablaProAnualCapacitacionDTO;
import com.api.login.Documentos.ProgramaAnualCapacitacion.Pojo.ProAnualCapacitacion;
import com.api.login.Documentos.ProgramaAnualCapacitacion.Pojo.TablaProAnualCapacitacion;
import org.springframework.stereotype.Component;

@Component
public class TablaProAnualCapacitacionMapper {

    public TablaProAnualCapacitacionDTO toDTO(TablaProAnualCapacitacion entity) {
        TablaProAnualCapacitacionDTO dto = new TablaProAnualCapacitacionDTO();
        dto.setIdTablaProAnualCapacitacion(entity.getIdTablaProAnualCapacitacion());
        dto.setTitulo(entity.getTitulo());
        dto.setPerDepartamento(entity.getPerDepartamento());
        dto.setTipo(entity.getTipo());
        dto.setCapacitador(entity.getCapacitador());
        dto.setDuracion(entity.getDuracion());
        dto.setEstatus(entity.getEstatus());
        dto.setFecha(entity.getFecha());
        dto.setIdProAnualCapacitacion(entity.getProAnualCapacitacion().getIdProAnualCapacitacion());
        return dto;
    }

    public TablaProAnualCapacitacion toEntity(TablaProAnualCapacitacionDTO dto, ProAnualCapacitacion proAnualCapacitacion) {
        TablaProAnualCapacitacion entity = new TablaProAnualCapacitacion();
        entity.setIdTablaProAnualCapacitacion(dto.getIdTablaProAnualCapacitacion());
        entity.setTitulo(dto.getTitulo());
        entity.setPerDepartamento(dto.getPerDepartamento());
        entity.setTipo(dto.getTipo());
        entity.setCapacitador(dto.getCapacitador());
        entity.setDuracion(dto.getDuracion());
        entity.setEstatus(dto.getEstatus());
        entity.setFecha(dto.getFecha());
        entity.setProAnualCapacitacion(proAnualCapacitacion);
        return entity;
    }
}
