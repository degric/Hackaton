package com.api.login.Documentos.MatrizFodaEstrategica.Mapper;

import com.api.login.Documentos.MatrizFodaEstrategica.DTO.EstrategiasDAMatrizFodaEstrategicaDTO;
import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.EstrategiasDAMatrizFodaEstrategica;
import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.MatrizFodaEstrategica;
import org.springframework.stereotype.Component;

@Component
public class EstrategiasDAMatrizFodaEstrategicaMapper {

    public EstrategiasDAMatrizFodaEstrategicaDTO toDTO(EstrategiasDAMatrizFodaEstrategica entity) {
        EstrategiasDAMatrizFodaEstrategicaDTO dto = new EstrategiasDAMatrizFodaEstrategicaDTO();
        dto.setIdEstrategiasDAMatrizFodaEstrategica(entity.getIdEstrategiasDAMatrizFodaEstrategica());
        dto.setContenido(entity.getContenido());
        dto.setIdMatrizFodaEstrategica(entity.getMatrizFodaEstrategica().getIdMatrizFodaEstrategica());
        return dto;
    }

    public EstrategiasDAMatrizFodaEstrategica toEntity(EstrategiasDAMatrizFodaEstrategicaDTO dto, MatrizFodaEstrategica matrizFodaEstrategica) {
        EstrategiasDAMatrizFodaEstrategica entity = new EstrategiasDAMatrizFodaEstrategica();
        entity.setIdEstrategiasDAMatrizFodaEstrategica(dto.getIdEstrategiasDAMatrizFodaEstrategica());
        entity.setContenido(dto.getContenido());
        entity.setMatrizFodaEstrategica(matrizFodaEstrategica);
        return entity;
    }
}
