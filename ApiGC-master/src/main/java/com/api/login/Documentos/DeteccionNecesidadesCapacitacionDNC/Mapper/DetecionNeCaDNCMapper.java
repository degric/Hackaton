package com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Mapper;

import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.DTO.DetecionNeCaDNCDTO;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DetecionNeCaDNCMapper {

    @Autowired
    private DatosGeneralesDNCMapper datosMapper;

    @Autowired
    private DatosJefeInmediatoDNCMapper datosJefeMapper;

    @Autowired
    private Pregunta1DNCMapper preguntaMapper;

    @Autowired
    private Preguntas2DNCMapper pregunta2Mapper;

    public DetecionNeCaDNCDTO toDTO(DetecionNeCaDNC entity) {
        DetecionNeCaDNCDTO dto = new DetecionNeCaDNCDTO();
        dto.setIdDetecionNeCaDNC(entity.getIdDetecionNeCaDNC());
        dto.setCoDocumento(entity.getCoDocumento());
        dto.setNoRevision(entity.getNoRevision());
        dto.setFechaEmicion(entity.getFechaEmicion());
        dto.setFechaRevision(entity.getFechaRevision());

        if (entity.getDatosGeneralesDNC() != null) {
            dto.setDatosGeneralesDNC(datosMapper.toDTO(entity.getDatosGeneralesDNC()));
        }

        if (entity.getDatosJefeInmediatoDNC() != null) {
            dto.setDatosJefeInmediatoDNC(datosJefeMapper.toDTO(entity.getDatosJefeInmediatoDNC()));
        }

        if (entity.getPreguntas1DNC() != null) {
            dto.setPreguntas1DNC(entity.getPreguntas1DNC().stream()
                    .map(preguntaMapper::toDTO)
                    .collect(Collectors.toList()));
        }

        if (entity.getPreguntas2DNC() != null) {
            dto.setPreguntas2DNC(entity.getPreguntas2DNC().stream()
                    .map(pregunta2Mapper::toDTO)
                    .collect(Collectors.toList()));
        }
        return dto;
    }

    public DetecionNeCaDNC toEntity(DetecionNeCaDNCDTO dto) {
        DetecionNeCaDNC entity = new DetecionNeCaDNC();
        entity.setIdDetecionNeCaDNC(dto.getIdDetecionNeCaDNC());
        entity.setCoDocumento(dto.getCoDocumento());
        entity.setNoRevision(dto.getNoRevision());
        entity.setFechaEmicion(dto.getFechaEmicion());
        entity.setFechaRevision(dto.getFechaRevision());

        if (dto.getDatosGeneralesDNC() != null) {
            DatosGeneralesDNC datos = datosMapper.toEntity(dto.getDatosGeneralesDNC(), entity);
            entity.setDatosGeneralesDNC(datos);
        }

        if (dto.getDatosJefeInmediatoDNC() != null) {
            DatosJefeInmediatoDNC datosJefe = datosJefeMapper.toEntity(dto.getDatosJefeInmediatoDNC(), entity);
            entity.setDatosJefeInmediatoDNC(datosJefe);
        }

        if (dto.getPreguntas1DNC() != null) {
            List<Pregunta1DNC> preguntas = dto.getPreguntas1DNC().stream()
                    .map(preguntaDTO -> preguntaMapper.toEntity(preguntaDTO, entity))
                    .collect(Collectors.toList());
            entity.setPreguntas1DNC(preguntas);
        }

        if (dto.getPreguntas2DNC() != null) {
            List<Preguntas2DNC> preguntas2 = dto.getPreguntas2DNC().stream()
                    .map(pregunta2DTO -> pregunta2Mapper.toEntity(pregunta2DTO, entity))
                    .collect(Collectors.toList());
            entity.setPreguntas2DNC(preguntas2);
        }

        return entity;
    }
}
