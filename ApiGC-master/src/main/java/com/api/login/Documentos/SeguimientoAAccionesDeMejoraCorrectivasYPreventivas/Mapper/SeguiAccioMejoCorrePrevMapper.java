package com.api.login.Documentos.SeguimientoAAccionesDeMejoraCorrectivasYPreventivas.Mapper;

import com.api.login.Documentos.SeguimientoAAccionesDeMejoraCorrectivasYPreventivas.DTO.SeguiAccioMejoCorrePrevDTO;
import com.api.login.Documentos.SeguimientoAAccionesDeMejoraCorrectivasYPreventivas.Pojo.SeAcMeCoPrTabla;
import com.api.login.Documentos.SeguimientoAAccionesDeMejoraCorrectivasYPreventivas.Pojo.SeguiAccioMejoCorrePrev;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SeguiAccioMejoCorrePrevMapper {

    @Autowired
    private SeAcMeCoPrTablaMapper seAcMeCoPrTablaMapper;

    public SeguiAccioMejoCorrePrevDTO toDTO(SeguiAccioMejoCorrePrev entity) {
        SeguiAccioMejoCorrePrevDTO dto = new SeguiAccioMejoCorrePrevDTO();
        dto.setIdSeguiAccioMejoCorrePrev(entity.getIdSeguiAccioMejoCorrePrev());
        dto.setCoDocumento(entity.getCoDocumento());
        dto.setNoRevision(entity.getNoRevision());
        dto.setFechaEmicion(entity.getFechaEmicion());
        dto.setFechaRevision(entity.getFechaRevision());

        // Mapear la lista de tablas relacionadas
        if (entity.getSeAcMeCoPrTablas() != null) {
            dto.setSeAcMeCoPrTablas(entity.getSeAcMeCoPrTablas().stream()
                    .map(seAcMeCoPrTablaMapper::toDTO)
                    .collect(Collectors.toList()));
        }

        return dto;
    }

    public SeguiAccioMejoCorrePrev toEntity(SeguiAccioMejoCorrePrevDTO dto) {
        SeguiAccioMejoCorrePrev entity = new SeguiAccioMejoCorrePrev();
        entity.setIdSeguiAccioMejoCorrePrev(dto.getIdSeguiAccioMejoCorrePrev());
        entity.setCoDocumento(dto.getCoDocumento());
        entity.setNoRevision(dto.getNoRevision());
        entity.setFechaEmicion(dto.getFechaEmicion());
        entity.setFechaRevision(dto.getFechaRevision());

        // Mapear la lista de tablas relacionadas
        if (dto.getSeAcMeCoPrTablas() != null) {
            List<SeAcMeCoPrTabla> tablas = dto.getSeAcMeCoPrTablas().stream()
                    .map(tablaDTO -> {
                        SeAcMeCoPrTabla tabla = seAcMeCoPrTablaMapper.toEntity(tablaDTO, entity);
                        tabla.setSeguiAccioMejoCorrePrev(entity);  // Asignar la relación
                        return tabla;
                    })
                    .collect(Collectors.toList());
            entity.setSeAcMeCoPrTablas(tablas);
        }

        return entity;
    }
}

