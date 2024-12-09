package com.api.login.Documentos.MatrizFodaEstrategica.Mapper;

import com.api.login.Documentos.MatrizFodaEstrategica.DTO.DebilidadesMatrizFodaEstrategicaDTO;
import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.DebilidadesMatrizFodaEstrategica;
import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.MatrizFodaEstrategica;
import org.springframework.stereotype.Component;

@Component
public class DebilidadesMatrizFodaEstrategicaMapper {

    public DebilidadesMatrizFodaEstrategicaDTO toDTO(DebilidadesMatrizFodaEstrategica entity) {
        DebilidadesMatrizFodaEstrategicaDTO dto = new DebilidadesMatrizFodaEstrategicaDTO();
        dto.setIdDebilidadesMatrizFodaEstrategica(entity.getIdDebilidadesMatrizFodaEstrategica());
        dto.setContenido(entity.getContenido());
        dto.setIdMatrizFodaEstrategica(entity.getMatrizFodaEstrategica().getIdMatrizFodaEstrategica());
        return dto;
    }

    public DebilidadesMatrizFodaEstrategica toEntity(DebilidadesMatrizFodaEstrategicaDTO dto, MatrizFodaEstrategica matrizFodaEstrategica) {
        DebilidadesMatrizFodaEstrategica entity = new DebilidadesMatrizFodaEstrategica();
        entity.setIdDebilidadesMatrizFodaEstrategica(dto.getIdDebilidadesMatrizFodaEstrategica());
        entity.setContenido(dto.getContenido());
        entity.setMatrizFodaEstrategica(matrizFodaEstrategica);
        return entity;
    }
}
