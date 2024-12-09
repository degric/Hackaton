package com.api.login.Documentos.MatrizFodaEstrategica.Mapper;

import com.api.login.Documentos.MatrizFodaEstrategica.DTO.PlanAccionEstrategiasFodaDTO;
import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.MatrizFodaEstrategica;
import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.PlanAccionEstrategiasFoda;
import org.springframework.stereotype.Component;

@Component
public class PlanAccionEstrategiasFodaMapper {

    public PlanAccionEstrategiasFodaDTO toDTO(PlanAccionEstrategiasFoda entity) {
        PlanAccionEstrategiasFodaDTO dto = new PlanAccionEstrategiasFodaDTO();
        dto.setIdPlanAccionEstrategiasFoda(entity.getIdPlanAccionEstrategiasFoda());
        dto.setTipo(entity.getTipo());
        dto.setEstrategias(entity.getEstrategias());
        dto.setObjetivo(entity.getObjetivo());
        dto.setFolio(entity.getFolio());
        dto.setResponsable(entity.getResponsable());
        dto.setFechaMeta(entity.getFechaMeta());
        dto.setIdMatrizFodaEstrategica(entity.getMatrizFodaEstrategica().getIdMatrizFodaEstrategica());
        return dto;
    }

    public PlanAccionEstrategiasFoda toEntity(PlanAccionEstrategiasFodaDTO dto, MatrizFodaEstrategica matrizFodaEstrategica) {
        PlanAccionEstrategiasFoda entity = new PlanAccionEstrategiasFoda();
        entity.setIdPlanAccionEstrategiasFoda(dto.getIdPlanAccionEstrategiasFoda());
        entity.setTipo(dto.getTipo());
        entity.setEstrategias(dto.getEstrategias());
        entity.setObjetivo(dto.getObjetivo());
        entity.setFolio(dto.getFolio());
        entity.setResponsable(dto.getResponsable());
        entity.setFechaMeta(dto.getFechaMeta());
        entity.setMatrizFodaEstrategica(matrizFodaEstrategica);
        return entity;
    }
}
