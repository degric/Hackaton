package com.api.login.Documentos.SeguimientoAAccionesDeMejoraCorrectivasYPreventivas.Mapper;

import com.api.login.Documentos.SeguimientoAAccionesDeMejoraCorrectivasYPreventivas.DTO.SeAcMeCoPrTablaDTO;
import com.api.login.Documentos.SeguimientoAAccionesDeMejoraCorrectivasYPreventivas.Pojo.SeAcMeCoPrTabla;
import com.api.login.Documentos.SeguimientoAAccionesDeMejoraCorrectivasYPreventivas.Pojo.SeguiAccioMejoCorrePrev;
import org.springframework.stereotype.Component;

@Component
public class SeAcMeCoPrTablaMapper {

    public SeAcMeCoPrTablaDTO toDTO(SeAcMeCoPrTabla entity) {
        SeAcMeCoPrTablaDTO dto = new SeAcMeCoPrTablaDTO();
        dto.setIdSeAcMeCoPrTabla(entity.getIdSeAcMeCoPrTabla());
        dto.setHallazgo(entity.getHallazgo());
        dto.setEvidenciasObservadas(entity.getEvidenciasObservadas());
        dto.setResponsableAreaImplantacion(entity.getResponsableAreaImplantacion());
        dto.setFechaInicio(entity.getFechaInicio());
        dto.setFechaTermino(entity.getFechaTermino());
        dto.setAvance(entity.getAvance());
        dto.setRevisionValoracion(entity.getRevisionValoracion());
        dto.setIdSeguiAccioMejoCorrePrev(entity.getSeguiAccioMejoCorrePrev().getIdSeguiAccioMejoCorrePrev());
        return dto;
    }

    public SeAcMeCoPrTabla toEntity(SeAcMeCoPrTablaDTO dto, SeguiAccioMejoCorrePrev seguiAccioMejoCorrePrev) {
        SeAcMeCoPrTabla entity = new SeAcMeCoPrTabla();
        entity.setIdSeAcMeCoPrTabla(dto.getIdSeAcMeCoPrTabla());
        entity.setHallazgo(dto.getHallazgo());
        entity.setEvidenciasObservadas(dto.getEvidenciasObservadas());
        entity.setResponsableAreaImplantacion(dto.getResponsableAreaImplantacion());
        entity.setFechaInicio(dto.getFechaInicio());
        entity.setFechaTermino(dto.getFechaTermino());
        entity.setAvance(dto.getAvance());
        entity.setRevisionValoracion(dto.getRevisionValoracion());
        entity.setSeguiAccioMejoCorrePrev(seguiAccioMejoCorrePrev);
        return entity;
    }
}

