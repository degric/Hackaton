package com.api.login.Documentos.MejoraContinua.Mapper;

import com.api.login.Documentos.MejoraContinua.DTO.DatosMejoraContinuaDTO;
import com.api.login.Documentos.MejoraContinua.Pojo.DatosMejoraContinua;
import com.api.login.Documentos.MejoraContinua.Pojo.MejoraContinua;
import org.springframework.stereotype.Component;

@Component
public class DatosMejoraContinuaMapper {

    public DatosMejoraContinuaDTO toDTO(DatosMejoraContinua entity) {
        DatosMejoraContinuaDTO dto = new DatosMejoraContinuaDTO();
        dto.setIdDatosMejoraContinua(entity.getIdDatosMejoraContinua());
        dto.setAlcance(entity.getAlcance());
        dto.setNumeroControl(entity.getNumeroControl());
        dto.setObjetivo(entity.getObjetivo());
        dto.setOrigenMejora(entity.getOrigenMejora());
        dto.setDescripcionAccion(entity.getDescripcionAccion());
        dto.setDescriocion(entity.getDescriocion());
        dto.setCuantificacion(entity.getCuantificacion());
        dto.setPeriodo(entity.getPeriodo());
        dto.setTiempoInicial(entity.getTiempoInicial());
        dto.setTiempoFinal(entity.getTiempoFinal());
        dto.setResultado(entity.getResultado());
        dto.setIdMejoraContinua(entity.getMejoraContinua().getIdMejoraContinua());
        return dto;
    }

    public DatosMejoraContinua toEntity(DatosMejoraContinuaDTO dto, MejoraContinua mejoraContinua) {
        DatosMejoraContinua entity = new DatosMejoraContinua();
        entity.setIdDatosMejoraContinua(dto.getIdDatosMejoraContinua());
        entity.setAlcance(dto.getAlcance());
        entity.setNumeroControl(dto.getNumeroControl());
        entity.setObjetivo(dto.getObjetivo());
        entity.setOrigenMejora(dto.getOrigenMejora());
        entity.setDescripcionAccion(dto.getDescripcionAccion());
        entity.setDescriocion(dto.getDescriocion());
        entity.setCuantificacion(dto.getCuantificacion());
        entity.setPeriodo(dto.getPeriodo());
        entity.setTiempoInicial(dto.getTiempoInicial());
        entity.setTiempoFinal(dto.getTiempoFinal());
        entity.setResultado(dto.getResultado());
        entity.setMejoraContinua(mejoraContinua);
        return entity;
    }
}

