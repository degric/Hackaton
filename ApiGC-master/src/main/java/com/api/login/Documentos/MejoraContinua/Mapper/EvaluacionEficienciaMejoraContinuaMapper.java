package com.api.login.Documentos.MejoraContinua.Mapper;

import com.api.login.Documentos.MejoraContinua.DTO.EvaluacionEficienciaMejoraContinuaDTO;
import com.api.login.Documentos.MejoraContinua.Pojo.EvaluacionEficienciaMejoraContinua;
import com.api.login.Documentos.MejoraContinua.Pojo.MejoraContinua;
import org.springframework.stereotype.Component;

@Component
public class EvaluacionEficienciaMejoraContinuaMapper {

    public EvaluacionEficienciaMejoraContinuaDTO toDTO(EvaluacionEficienciaMejoraContinua entity) {
        EvaluacionEficienciaMejoraContinuaDTO dto = new EvaluacionEficienciaMejoraContinuaDTO();
        dto.setIdEvaluacionEficienciaMejoraContinua(entity.getIdEvaluacionEficienciaMejoraContinua());
        dto.setPreguntaSeCumAccPro(entity.getPreguntaSeCumAccPro());
        dto.setObservacion1(entity.getObservacion1());
        dto.setPreguntaAunHayAccPen(entity.getPreguntaAunHayAccPen());
        dto.setObservacion2(entity.getObservacion2());
        dto.setPreguntaSeReAc(entity.getPreguntaSeReAc());
        dto.setIdMejoraContinua(entity.getMejoraContinua().getIdMejoraContinua());
        return dto;
    }

    public EvaluacionEficienciaMejoraContinua toEntity(EvaluacionEficienciaMejoraContinuaDTO dto, MejoraContinua mejoraContinua) {
        EvaluacionEficienciaMejoraContinua entity = new EvaluacionEficienciaMejoraContinua();
        entity.setIdEvaluacionEficienciaMejoraContinua(dto.getIdEvaluacionEficienciaMejoraContinua());
        entity.setPreguntaSeCumAccPro(dto.getPreguntaSeCumAccPro());
        entity.setObservacion1(dto.getObservacion1());
        entity.setPreguntaAunHayAccPen(dto.getPreguntaAunHayAccPen());
        entity.setObservacion2(dto.getObservacion2());
        entity.setPreguntaSeReAc(dto.getPreguntaSeReAc());
        entity.setMejoraContinua(mejoraContinua);
        return entity;
    }
}

