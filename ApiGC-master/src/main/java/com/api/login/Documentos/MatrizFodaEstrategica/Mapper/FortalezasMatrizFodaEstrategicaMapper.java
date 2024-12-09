package com.api.login.Documentos.MatrizFodaEstrategica.Mapper;

import com.api.login.Documentos.MatrizFodaEstrategica.DTO.FortalezasMatrizFodaEstrategicaDTO;
import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.FortalezasMatrizFodaEstrategica;
import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.MatrizFodaEstrategica;
import org.springframework.stereotype.Component;

@Component
public class FortalezasMatrizFodaEstrategicaMapper {

    public FortalezasMatrizFodaEstrategicaDTO toDTO(FortalezasMatrizFodaEstrategica entity) {
        FortalezasMatrizFodaEstrategicaDTO dto = new FortalezasMatrizFodaEstrategicaDTO();
        dto.setIdFortalezasMatrizFodaEstrategica(entity.getIdFortalezasMatrizFodaEstrategica());
        dto.setContenido(entity.getContenido());
        dto.setIdMatrizFodaEstrategica(entity.getMatrizFodaEstrategica().getIdMatrizFodaEstrategica());
        return dto;
    }

    public FortalezasMatrizFodaEstrategica toEntity(FortalezasMatrizFodaEstrategicaDTO dto, MatrizFodaEstrategica matrizFodaEstrategica) {
        FortalezasMatrizFodaEstrategica entity = new FortalezasMatrizFodaEstrategica();
        entity.setIdFortalezasMatrizFodaEstrategica(dto.getIdFortalezasMatrizFodaEstrategica());
        entity.setContenido(dto.getContenido());
        entity.setMatrizFodaEstrategica(matrizFodaEstrategica);
        return entity;
    }
}

