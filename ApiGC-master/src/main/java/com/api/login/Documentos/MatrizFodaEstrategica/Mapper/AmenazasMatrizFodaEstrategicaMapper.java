package com.api.login.Documentos.MatrizFodaEstrategica.Mapper;

import com.api.login.Documentos.MatrizFodaEstrategica.DTO.AmenazasMatrizFodaEstrategicaDTO;
import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.AmenazasMatrizFodaEstrategica;
import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.MatrizFodaEstrategica;
import org.springframework.stereotype.Component;

@Component
public class AmenazasMatrizFodaEstrategicaMapper {

    public AmenazasMatrizFodaEstrategicaDTO toDTO(AmenazasMatrizFodaEstrategica entity) {
        AmenazasMatrizFodaEstrategicaDTO dto = new AmenazasMatrizFodaEstrategicaDTO();
        dto.setIdAmenazasMatrizFodaEstrategica(entity.getIdAmenazasMatrizFodaEstrategica());
        dto.setContenido(entity.getContenido());
        dto.setIdMatrizFodaEstrategica(entity.getMatrizFodaEstrategica().getIdMatrizFodaEstrategica());
        return dto;
    }

    public AmenazasMatrizFodaEstrategica toEntity(AmenazasMatrizFodaEstrategicaDTO dto, MatrizFodaEstrategica matrizFodaEstrategica) {
        AmenazasMatrizFodaEstrategica entity = new AmenazasMatrizFodaEstrategica();
        entity.setIdAmenazasMatrizFodaEstrategica(dto.getIdAmenazasMatrizFodaEstrategica());
        entity.setContenido(dto.getContenido());
        entity.setMatrizFodaEstrategica(matrizFodaEstrategica);
        return entity;
    }
}
