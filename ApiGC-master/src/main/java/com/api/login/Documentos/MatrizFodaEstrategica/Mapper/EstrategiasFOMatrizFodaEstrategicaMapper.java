package com.api.login.Documentos.MatrizFodaEstrategica.Mapper;

import com.api.login.Documentos.MatrizFodaEstrategica.DTO.EstrategiasFOMatrizFodaEstrategicaDTO;
import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.EstrategiasFOMatrizFodaEstrategica;
import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.MatrizFodaEstrategica;
import org.springframework.stereotype.Component;

@Component
public class EstrategiasFOMatrizFodaEstrategicaMapper {

    public EstrategiasFOMatrizFodaEstrategicaDTO toDTO(EstrategiasFOMatrizFodaEstrategica entity) {
        EstrategiasFOMatrizFodaEstrategicaDTO dto = new EstrategiasFOMatrizFodaEstrategicaDTO();
        dto.setIdEstrategiasFOMatrizFodaEstrategica(entity.getIdEstrategiasFOMatrizFodaEstrategica());
        dto.setContenido(entity.getContenido());
        dto.setIdMatrizFodaEstrategica(entity.getMatrizFodaEstrategica().getIdMatrizFodaEstrategica());
        return dto;
    }

    public EstrategiasFOMatrizFodaEstrategica toEntity(EstrategiasFOMatrizFodaEstrategicaDTO dto, MatrizFodaEstrategica matrizFodaEstrategica) {
        EstrategiasFOMatrizFodaEstrategica entity = new EstrategiasFOMatrizFodaEstrategica();
        entity.setIdEstrategiasFOMatrizFodaEstrategica(dto.getIdEstrategiasFOMatrizFodaEstrategica());
        entity.setContenido(dto.getContenido());
        entity.setMatrizFodaEstrategica(matrizFodaEstrategica);
        return entity;
    }
}
