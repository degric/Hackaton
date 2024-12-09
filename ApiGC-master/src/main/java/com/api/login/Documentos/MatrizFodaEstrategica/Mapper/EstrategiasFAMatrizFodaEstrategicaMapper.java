package com.api.login.Documentos.MatrizFodaEstrategica.Mapper;

import com.api.login.Documentos.MatrizFodaEstrategica.DTO.EstrategiasFAMatrizFodaEstrategicaDTO;
import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.EstrategiasFAMatrizFodaEstrategica;
import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.MatrizFodaEstrategica;
import org.springframework.stereotype.Component;

@Component
public class EstrategiasFAMatrizFodaEstrategicaMapper {

    public EstrategiasFAMatrizFodaEstrategicaDTO toDTO(EstrategiasFAMatrizFodaEstrategica entity) {
        EstrategiasFAMatrizFodaEstrategicaDTO dto = new EstrategiasFAMatrizFodaEstrategicaDTO();
        dto.setIdEstrategiasFAMatrizFodaEstrategica(entity.getIdEstrategiasFAMatrizFodaEstrategica());
        dto.setContenido(entity.getContenido());
        dto.setIdMatrizFodaEstrategica(entity.getMatrizFodaEstrategica().getIdMatrizFodaEstrategica());
        return dto;
    }

    public EstrategiasFAMatrizFodaEstrategica toEntity(EstrategiasFAMatrizFodaEstrategicaDTO dto, MatrizFodaEstrategica matrizFodaEstrategica) {
        EstrategiasFAMatrizFodaEstrategica entity = new EstrategiasFAMatrizFodaEstrategica();
        entity.setIdEstrategiasFAMatrizFodaEstrategica(dto.getIdEstrategiasFAMatrizFodaEstrategica());
        entity.setContenido(dto.getContenido());
        entity.setMatrizFodaEstrategica(matrizFodaEstrategica);
        return entity;
    }
}
