package com.api.login.Documentos.MatrizFodaEstrategica.Mapper;

import com.api.login.Documentos.MatrizFodaEstrategica.DTO.EstrategiasDOMatrizFodaEstrategicaDTO;
import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.EstrategiasDOMatrizFodaEstrategica;
import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.MatrizFodaEstrategica;
import org.springframework.stereotype.Component;

@Component
public class EstrategiasDOMatrizFodaEstrategicaMapper {

    public EstrategiasDOMatrizFodaEstrategicaDTO toDTO(EstrategiasDOMatrizFodaEstrategica entity) {
        EstrategiasDOMatrizFodaEstrategicaDTO dto = new EstrategiasDOMatrizFodaEstrategicaDTO();
        dto.setIdEstrategiasDOMatrizFodaEstrategica(entity.getIdEstrategiasDOMatrizFodaEstrategica());
        dto.setContenido(entity.getContenido());
        dto.setIdMatrizFodaEstrategica(entity.getMatrizFodaEstrategica().getIdMatrizFodaEstrategica());
        return dto;
    }

    public EstrategiasDOMatrizFodaEstrategica toEntity(EstrategiasDOMatrizFodaEstrategicaDTO dto, MatrizFodaEstrategica matrizFodaEstrategica) {
        EstrategiasDOMatrizFodaEstrategica entity = new EstrategiasDOMatrizFodaEstrategica();
        entity.setIdEstrategiasDOMatrizFodaEstrategica(dto.getIdEstrategiasDOMatrizFodaEstrategica());
        entity.setContenido(dto.getContenido());
        entity.setMatrizFodaEstrategica(matrizFodaEstrategica);
        return entity;
    }
}

