package com.api.login.Documentos.ProgramaAnualCapacitacion.Mapper;

import com.api.login.Documentos.ProgramaAnualCapacitacion.DTO.ProAnualCapacitacionDTO;
import com.api.login.Documentos.ProgramaAnualCapacitacion.Pojo.ProAnualCapacitacion;
import com.api.login.Documentos.ProgramaAnualCapacitacion.Pojo.TablaProAnualCapacitacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProAnualCapacitacionMapper {

    @Autowired
    private TablaProAnualCapacitacionMapper tablaMapper;

    public ProAnualCapacitacionDTO toDTO(ProAnualCapacitacion entity) {
        ProAnualCapacitacionDTO dto = new ProAnualCapacitacionDTO();
        dto.setIdProAnualCapacitacion(entity.getIdProAnualCapacitacion());
        dto.setCoDocumento(entity.getCoDocumento());
        dto.setNoRevision(entity.getNoRevision());
        dto.setFechaEmicion(entity.getFechaEmicion());
        dto.setFechaRevision(entity.getFechaRevision());

        if (entity.getTablasProAnualCapacitacion() != null) {
            dto.setTablasProAnualCapacitacion(entity.getTablasProAnualCapacitacion().stream()
                    .map(tablaMapper::toDTO)
                    .collect(Collectors.toList()));
        }

        return dto;
    }

    public ProAnualCapacitacion toEntity(ProAnualCapacitacionDTO dto) {
        ProAnualCapacitacion entity = new ProAnualCapacitacion();
        entity.setIdProAnualCapacitacion(dto.getIdProAnualCapacitacion());
        entity.setCoDocumento(dto.getCoDocumento());
        entity.setNoRevision(dto.getNoRevision());
        entity.setFechaEmicion(dto.getFechaEmicion());
        entity.setFechaRevision(dto.getFechaRevision());

        if (dto.getTablasProAnualCapacitacion() != null) {
            List<TablaProAnualCapacitacion> tablas = dto.getTablasProAnualCapacitacion().stream()
                    .map(tablaDTO -> tablaMapper.toEntity(tablaDTO, entity))
                    .collect(Collectors.toList());
            entity.setTablasProAnualCapacitacion(tablas);
        }
        return entity;
    }
}
