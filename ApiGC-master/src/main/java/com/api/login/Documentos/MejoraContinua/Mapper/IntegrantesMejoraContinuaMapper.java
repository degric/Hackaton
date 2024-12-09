package com.api.login.Documentos.MejoraContinua.Mapper;

import com.api.login.Documentos.MejoraContinua.DTO.IntegrantesMejoraContinuaDTO;
import com.api.login.Documentos.MejoraContinua.Pojo.IntegrantesMejoraContinua;
import com.api.login.Documentos.MejoraContinua.Pojo.MejoraContinua;
import org.springframework.stereotype.Component;

@Component
public class IntegrantesMejoraContinuaMapper {

    public IntegrantesMejoraContinuaDTO toDTO(IntegrantesMejoraContinua entity) {
        IntegrantesMejoraContinuaDTO dto = new IntegrantesMejoraContinuaDTO();
        dto.setIdIntegrantesMejoraContinua(entity.getIdIntegrantesMejoraContinua());
        dto.setIntegrante(entity.getIntegrante());
        dto.setPuesto(entity.getPuesto());
        dto.setFirma(entity.getFirma());
        dto.setIdMejoraContinua(entity.getMejoraContinua().getIdMejoraContinua());
        return dto;
    }

    public IntegrantesMejoraContinua toEntity(IntegrantesMejoraContinuaDTO dto, MejoraContinua mejoraContinua) {
        IntegrantesMejoraContinua entity = new IntegrantesMejoraContinua();
        entity.setIdIntegrantesMejoraContinua(dto.getIdIntegrantesMejoraContinua());
        entity.setIntegrante(dto.getIntegrante());
        entity.setPuesto(dto.getPuesto());
        entity.setFirma(dto.getFirma());
        entity.setMejoraContinua(mejoraContinua);
        return entity;
    }
}
