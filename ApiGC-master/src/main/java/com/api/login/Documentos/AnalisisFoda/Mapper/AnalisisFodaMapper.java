package com.api.login.Documentos.AnalisisFoda.Mapper;

import com.api.login.Documentos.AnalisisFoda.DTO.AnalisisFodaDTO;
import com.api.login.Documentos.AnalisisFoda.DTO.AnalisisFodaDTOSinListas;
import com.api.login.Documentos.AnalisisFoda.Pojo.AnalisisFoda;
import com.api.login.Documentos.AnalisisFoda.Pojo.ParticipantesAnalisisFoda;
import com.api.login.Documentos.AnalisisFoda.Pojo.TablaAnalisisFoda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AnalisisFodaMapper {

    @Autowired
    private TablaAnalisisFodaMapper tablaAnalisisFodaMapper;

    @Autowired
    private ParticipantesAnalisisFodaMapper participantesAnalisisFodaMapper;

    public AnalisisFodaDTO toDTO(AnalisisFoda entity) {
        AnalisisFodaDTO dto = new AnalisisFodaDTO();
        dto.setIdAnalisisFoda(entity.getIdAnalisisFoda());
        dto.setCoDocumento(entity.getCoDocumento());
        dto.setNoRevision(entity.getNoRevision());
        dto.setFechaEmicion(entity.getFechaEmicion());
        dto.setFechaRevision(entity.getFechaRevision());
        dto.setFechaRegistro(entity.getFechaRegistro());


        if (entity.getTablaAnalisisFoda() != null) {
            dto.setTablaAnalisisFoda(entity.getTablaAnalisisFoda().stream()
                    .map(tablaAnalisisFodaMapper::toDTO)
                    .collect(Collectors.toList()));
        } else {
            dto.setTablaAnalisisFoda(Collections.emptyList());
        }

        if (entity.getParticipantesAnalisisFoda() != null) {
            dto.setParticipantesAnalisisFoda(entity.getParticipantesAnalisisFoda().stream()
                    .map(participantesAnalisisFodaMapper::toDTO)
                    .collect(Collectors.toList()));
        } else {
            dto.setParticipantesAnalisisFoda(Collections.emptyList());
        }
        return dto;
    }

    public AnalisisFodaDTOSinListas toDTOSinListas(AnalisisFoda entity) {
        AnalisisFodaDTOSinListas dto = new AnalisisFodaDTOSinListas();
        dto.setIdAnalisisFoda(entity.getIdAnalisisFoda());
        dto.setCoDocumento(entity.getCoDocumento());
        dto.setNoRevision(entity.getNoRevision());
        dto.setFechaEmicion(entity.getFechaEmicion());
        dto.setFechaRevision(entity.getFechaRevision());
        dto.setFechaRegistro(entity.getFechaRegistro());

        return dto;
    }


    public AnalisisFoda toEntity(AnalisisFodaDTO dto) {
        AnalisisFoda entity = new AnalisisFoda();
        entity.setIdAnalisisFoda(dto.getIdAnalisisFoda());
        entity.setCoDocumento(dto.getCoDocumento());
        entity.setNoRevision(dto.getNoRevision());
        entity.setFechaEmicion(dto.getFechaEmicion());
        entity.setFechaRevision(dto.getFechaRevision());
        entity.setFechaRegistro(dto.getFechaRegistro());

        if (dto.getTablaAnalisisFoda() != null) {
            List<TablaAnalisisFoda> tablas = dto.getTablaAnalisisFoda().stream()
                    .map(tablaDTO -> tablaAnalisisFodaMapper.toEntity(tablaDTO, entity))
                    .collect(Collectors.toList());
            entity.setTablaAnalisisFoda(tablas);
        }

        if (dto.getParticipantesAnalisisFoda() != null) {
            List<ParticipantesAnalisisFoda> participantes = dto.getParticipantesAnalisisFoda().stream()
                    .map(participantesDTO -> participantesAnalisisFodaMapper.toEntity(participantesDTO, entity))
                    .collect(Collectors.toList());
            entity.setParticipantesAnalisisFoda(participantes);
        }
        return entity;
    }
}

