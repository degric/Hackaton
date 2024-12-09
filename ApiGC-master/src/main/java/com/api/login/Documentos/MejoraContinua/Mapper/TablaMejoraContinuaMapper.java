package com.api.login.Documentos.MejoraContinua.Mapper;

import com.api.login.Documentos.MejoraContinua.DTO.TablaMejoraContinuaDTO;
import com.api.login.Documentos.MejoraContinua.Pojo.MejoraContinua;
import com.api.login.Documentos.MejoraContinua.Pojo.TablaMejoraContinua;
import org.springframework.stereotype.Component;

@Component
public class TablaMejoraContinuaMapper {

    public TablaMejoraContinuaDTO toDTO(TablaMejoraContinua entity) {
        TablaMejoraContinuaDTO dto = new TablaMejoraContinuaDTO();
        dto.setIdTablaMejoraContinua(entity.getIdTablaMejoraContinua());
        dto.setQueSeVaHacer(entity.getQueSeVaHacer());
        dto.setMetaEsperada(entity.getMetaEsperada());
        dto.setIdMejoraContinua(entity.getMejoraContinua().getIdMejoraContinua());
        return dto;
    }

    public TablaMejoraContinua toEntity(TablaMejoraContinuaDTO dto, MejoraContinua mejoraContinua) {
        TablaMejoraContinua entity = new TablaMejoraContinua();
        entity.setIdTablaMejoraContinua(dto.getIdTablaMejoraContinua());
        entity.setQueSeVaHacer(dto.getQueSeVaHacer());
        entity.setMetaEsperada(dto.getMetaEsperada());
        entity.setMejoraContinua(mejoraContinua);
        return entity;
    }
}
