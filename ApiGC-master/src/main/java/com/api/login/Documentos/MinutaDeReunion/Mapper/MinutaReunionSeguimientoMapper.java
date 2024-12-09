package com.api.login.Documentos.MinutaDeReunion.Mapper;

import com.api.login.Documentos.MinutaDeReunion.DTO.MinutaReunionSeguimientoDTO;
import com.api.login.Documentos.MinutaDeReunion.Pojo.MinutaReunion;
import com.api.login.Documentos.MinutaDeReunion.Pojo.MinutaReunionSeguimiento;
import org.springframework.stereotype.Component;

@Component
public class MinutaReunionSeguimientoMapper {

    public MinutaReunionSeguimientoDTO toDTO(MinutaReunionSeguimiento entity) {
        MinutaReunionSeguimientoDTO dto = new MinutaReunionSeguimientoDTO();
        dto.setIdMinutaReunionSeguimiento(entity.getIdMinutaReunionSeguimiento());
        dto.setContenido(entity.getContenido());
        dto.setIdMinutaReunion(entity.getMinutaReunion().getIdMinutaReunion());
        return dto;
    }

    public MinutaReunionSeguimiento toEntity(MinutaReunionSeguimientoDTO dto, MinutaReunion minutaReunion) {
        MinutaReunionSeguimiento entity = new MinutaReunionSeguimiento();
        entity.setIdMinutaReunionSeguimiento(dto.getIdMinutaReunionSeguimiento());
        entity.setContenido(dto.getContenido());
        entity.setMinutaReunion(minutaReunion);
        return entity;
    }
}
