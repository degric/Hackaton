package com.api.login.Documentos.MejoraContinua.Mapper;

import com.api.login.Documentos.MejoraContinua.DTO.MejoraContinuaDTO;
import com.api.login.Documentos.MejoraContinua.Pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MejoraContinuaMapper {

    @Autowired
    private DatosMejoraContinuaMapper datosMapper;

    @Autowired
    private TablaMejoraContinuaMapper tablaMapper;

    @Autowired
    private EvaluacionEficienciaMejoraContinuaMapper evaluacionMapper;

    @Autowired
    private IntegrantesMejoraContinuaMapper integrantesMapper;

    public MejoraContinuaDTO toDTO(MejoraContinua entity) {
        MejoraContinuaDTO dto = new MejoraContinuaDTO();
        dto.setIdMejoraContinua(entity.getIdMejoraContinua());
        dto.setCoDocumento(entity.getCoDocumento());
        dto.setNoRevision(entity.getNoRevision());
        dto.setFechaEmicion(entity.getFechaEmicion());
        dto.setFechaRevision(entity.getFechaRevision());

        if (entity.getDatosMejoraContinua() != null) {
            dto.setDatosMejoraContinua(datosMapper.toDTO(entity.getDatosMejoraContinua()));
        }

        if (entity.getTablaMejoraContinuaList() != null) {
            dto.setTablaMejoraContinuaList(entity.getTablaMejoraContinuaList().stream()
                    .map(tablaMapper::toDTO)
                    .collect(Collectors.toList()));
        }

        if (entity.getEvaluacionEficienciaMejoraContinua() != null) {
            dto.setEvaluacionEficienciaMejoraContinua(evaluacionMapper.toDTO(entity.getEvaluacionEficienciaMejoraContinua()));
        }

        if (entity.getIntegrantesMejoraContinuaList() != null) {
            dto.setIntegrantesMejoraContinuaList(entity.getIntegrantesMejoraContinuaList().stream()
                    .map(integrantesMapper::toDTO)
                    .collect(Collectors.toList()));
        }

        return dto;
    }

    public MejoraContinua toEntity(MejoraContinuaDTO dto) {
        MejoraContinua entity = new MejoraContinua();
        entity.setIdMejoraContinua(dto.getIdMejoraContinua());
        entity.setCoDocumento(dto.getCoDocumento());
        entity.setNoRevision(dto.getNoRevision());
        entity.setFechaEmicion(dto.getFechaEmicion());
        entity.setFechaRevision(dto.getFechaRevision());

        if (dto.getDatosMejoraContinua() != null) {
            DatosMejoraContinua datos = datosMapper.toEntity(dto.getDatosMejoraContinua(), entity);
            entity.setDatosMejoraContinua(datos);
        }

        if (dto.getTablaMejoraContinuaList() != null) {
            List<TablaMejoraContinua> tablas = dto.getTablaMejoraContinuaList().stream()
                    .map(tablaDTO -> tablaMapper.toEntity(tablaDTO, entity))
                    .collect(Collectors.toList());
            entity.setTablaMejoraContinuaList(tablas);
        }

        if (dto.getEvaluacionEficienciaMejoraContinua() != null) {
            EvaluacionEficienciaMejoraContinua evaluacion = evaluacionMapper.toEntity(dto.getEvaluacionEficienciaMejoraContinua(), entity);
            entity.setEvaluacionEficienciaMejoraContinua(evaluacion);
        }

        if (dto.getIntegrantesMejoraContinuaList() != null) {
            List<IntegrantesMejoraContinua> integrantes = dto.getIntegrantesMejoraContinuaList().stream()
                    .map(integranteDTO -> integrantesMapper.toEntity(integranteDTO, entity))
                    .collect(Collectors.toList());
            entity.setIntegrantesMejoraContinuaList(integrantes);
        }


        return entity;
    }
}

