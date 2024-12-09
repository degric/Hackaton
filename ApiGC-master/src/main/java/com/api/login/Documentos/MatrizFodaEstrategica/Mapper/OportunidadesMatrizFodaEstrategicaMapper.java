package com.api.login.Documentos.MatrizFodaEstrategica.Mapper;

import com.api.login.Documentos.MatrizFodaEstrategica.DTO.OportunidadesMatrizFodaEstrategicaDTO;
import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.MatrizFodaEstrategica;
import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.OportunidadesMatrizFodaEstrategica;
import org.springframework.stereotype.Component;

@Component
public class OportunidadesMatrizFodaEstrategicaMapper {

    public OportunidadesMatrizFodaEstrategicaDTO toDTO(OportunidadesMatrizFodaEstrategica entity) {
        OportunidadesMatrizFodaEstrategicaDTO dto = new OportunidadesMatrizFodaEstrategicaDTO();
        dto.setIdOportunidadesMatrizFodaEstrategica(entity.getIdOportunidadesMatrizFodaEstrategica());
        dto.setContenido(entity.getContenido());
        dto.setIdMatrizFodaEstrategica(entity.getMatrizFodaEstrategica().getIdMatrizFodaEstrategica());
        return dto;
    }

    public OportunidadesMatrizFodaEstrategica toEntity(OportunidadesMatrizFodaEstrategicaDTO dto, MatrizFodaEstrategica matrizFodaEstrategica) {
        OportunidadesMatrizFodaEstrategica entity = new OportunidadesMatrizFodaEstrategica();
        entity.setIdOportunidadesMatrizFodaEstrategica(dto.getIdOportunidadesMatrizFodaEstrategica());
        entity.setContenido(dto.getContenido());
        entity.setMatrizFodaEstrategica(matrizFodaEstrategica);
        return entity;
    }
}
