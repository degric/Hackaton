package com.api.login.Documentos.MinutaDeReunion.Mapper;

import com.api.login.Documentos.MinutaDeReunion.DTO.MinutaReunionDTO;
import com.api.login.Documentos.MinutaDeReunion.Pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MinutaReunionMapper {

    @Autowired
    private MinuReunDatosMapper minuReunDatosMapper;

    @Autowired
    private MinuReunParticipantesMapper minuReunParticipantesMapper;

    @Autowired
    private MinuReunPuntosTratarMapper minuReunPuntosTratarMapper;

    @Autowired
    private MinuReunResultadosAcuerdosMapper minuReunResultadosAcuerdosMapper;

    @Autowired
    private MinutaReunionSeguimientoMapper minutaReunionSeguimientoMapper;


    public MinutaReunionDTO toDTO(MinutaReunion entity) {
        MinutaReunionDTO dto = new MinutaReunionDTO();
        dto.setIdMinutaReunion(entity.getIdMinutaReunion());
        dto.setCoDocumento(entity.getCoDocumento());
        dto.setNoRevision(entity.getNoRevision());
        dto.setFechaEmicion(entity.getFechaEmicion());
        dto.setFechaRevision(entity.getFechaRevision());

        // Mapear la lista de datos de la reunión relacionados
        if (entity.getMinuReunDatos() != null) {
            dto.setMinuReunDatos(entity.getMinuReunDatos().stream()
                    .map(minuReunDatosMapper::toDTO)
                    .collect(Collectors.toList()));
        }

        // Mapear la lista de participantes de la reunión relacionados
        if (entity.getMinuReunParticipantes() != null) {
            dto.setMinuReunParticipantes(entity.getMinuReunParticipantes().stream()
                    .map(minuReunParticipantesMapper::toDTO)
                    .collect(Collectors.toList()));
        }

        // Mapear la lista de puntos a tratar de la reunión relacionados
        if (entity.getMinuReunPuntosTratar() != null) {
            dto.setMinuReunPuntosTratar(entity.getMinuReunPuntosTratar().stream()
                    .map(minuReunPuntosTratarMapper::toDTO)
                    .collect(Collectors.toList()));
        }
        // Mapear la lista de resultados de acuerdos de la reunión relacionados
        if (entity.getMinuReunResultadosAcuerdos() != null) {
            dto.setMinuReunResultadosAcuerdos(entity.getMinuReunResultadosAcuerdos().stream()
                    .map(minuReunResultadosAcuerdosMapper::toDTO)
                    .collect(Collectors.toList()));
        }

        // Mapear la lista de seguimientos de la reunión relacionados
        if (entity.getMinutaReunionSeguimientos() != null) {
            dto.setMinutaReunionSeguimientos(entity.getMinutaReunionSeguimientos().stream()
                    .map(minutaReunionSeguimientoMapper::toDTO)
                    .collect(Collectors.toList()));
        }


        return dto;
    }

    public MinutaReunion toEntity(MinutaReunionDTO dto) {
        MinutaReunion entity = new MinutaReunion();
        entity.setIdMinutaReunion(dto.getIdMinutaReunion());
        entity.setCoDocumento(dto.getCoDocumento());
        entity.setNoRevision(dto.getNoRevision());
        entity.setFechaEmicion(dto.getFechaEmicion());
        entity.setFechaRevision(dto.getFechaRevision());

        // Mapear la lista de datos de la reunión relacionados
        if (dto.getMinuReunDatos() != null) {
            List<MinuReunDatos> datosReunion = dto.getMinuReunDatos().stream()
                    .map(minuReunDatosDTO -> {
                        MinuReunDatos datos = minuReunDatosMapper.toEntity(minuReunDatosDTO, entity);
                        datos.setMinutaReunion(entity);  // Asignar la relación
                        return datos;
                    })
                    .collect(Collectors.toList());
            entity.setMinuReunDatos(datosReunion);
        }

        // Mapear la lista de participantes de la reunión relacionados
        if (dto.getMinuReunParticipantes() != null) {
            List<MinuReunParticipantes> participantesReunion = dto.getMinuReunParticipantes().stream()
                    .map(participanteDTO -> {
                        MinuReunParticipantes participante = minuReunParticipantesMapper.toEntity(participanteDTO, entity);
                        participante.setMinutaReunion(entity);  // Asignar la relación
                        return participante;
                    })
                    .collect(Collectors.toList());
            entity.setMinuReunParticipantes(participantesReunion);
        }

        // Mapear la lista de puntos a tratar de la reunión relacionados
        if (dto.getMinuReunPuntosTratar() != null) {
            List<MinuReunPuntosTratar> puntosReunion = dto.getMinuReunPuntosTratar().stream()
                    .map(puntoDTO -> {
                        MinuReunPuntosTratar punto = minuReunPuntosTratarMapper.toEntity(puntoDTO, entity);
                        punto.setMinutaReunion(entity);  // Asignar la relación
                        return punto;
                    })
                    .collect(Collectors.toList());
            entity.setMinuReunPuntosTratar(puntosReunion);
        }

        // Mapear la lista de resultados de acuerdos de la reunión relacionados
        if (dto.getMinuReunResultadosAcuerdos() != null) {
            List<MinuReunResultadosAcuerdos> acuerdosReunion = dto.getMinuReunResultadosAcuerdos().stream()
                    .map(acuerdosDTO -> {
                        MinuReunResultadosAcuerdos acuerdo = minuReunResultadosAcuerdosMapper.toEntity(acuerdosDTO, entity);
                        acuerdo.setMinutaReunion(entity);  // Asignar la relación
                        return acuerdo;
                    })
                    .collect(Collectors.toList());
            entity.setMinuReunResultadosAcuerdos(acuerdosReunion);
        }

        // Mapear la lista de seguimientos de la reunión relacionados
        if (dto.getMinutaReunionSeguimientos() != null) {
            List<MinutaReunionSeguimiento> seguimientosReunion = dto.getMinutaReunionSeguimientos().stream()
                    .map(seguimientoDTO -> {
                        MinutaReunionSeguimiento seguimiento = minutaReunionSeguimientoMapper.toEntity(seguimientoDTO, entity);
                        seguimiento.setMinutaReunion(entity);  // Asignar la relación
                        return seguimiento;
                    })
                    .collect(Collectors.toList());
            entity.setMinutaReunionSeguimientos(seguimientosReunion);
        }

        return entity;
    }
}

