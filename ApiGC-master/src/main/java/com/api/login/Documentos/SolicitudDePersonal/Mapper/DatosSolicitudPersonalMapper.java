package com.api.login.Documentos.SolicitudDePersonal.Mapper;

import com.api.login.Documentos.SolicitudDePersonal.DTO.DatosSolicitudPersonalDTO;
import com.api.login.Documentos.SolicitudDePersonal.Pojo.DatosSolicitudPersonal;
import com.api.login.Documentos.SolicitudDePersonal.Pojo.SolicitudPersonal;
import org.springframework.stereotype.Component;

@Component
public class DatosSolicitudPersonalMapper {

    public DatosSolicitudPersonalDTO toDTO(DatosSolicitudPersonal entity) {
        DatosSolicitudPersonalDTO dto = new DatosSolicitudPersonalDTO();
        dto.setIdDatosSolicitudPersonal(entity.getIdDatosSolicitudPersonal());
        dto.setNombre(entity.getNombre());
        dto.setCargo(entity.getCargo());
        dto.setAreaActual(entity.getAreaActual());
        dto.setFechaSolicitud(entity.getFechaSolicitud());
        dto.setPuestoSolicitado(entity.getPuestoSolicitado());
        dto.setAreaNueva(entity.getAreaNueva());
        dto.setNumeroVacantes(entity.getNumeroVacantes());
        dto.setFechaPrevista(entity.getFechaPrevista());
        dto.setMotivotipoContrato(entity.getMotivotipoContrato());
        dto.setEstatus(entity.getEstatus());
        dto.setEspecifique(entity.getEspecifique());
        dto.setIdSolicitudPersonal(entity.getSolicitudPersonal().getIdSolicitudPersonal());
        return dto;
    }

    public DatosSolicitudPersonal toEntity(DatosSolicitudPersonalDTO dto, SolicitudPersonal solicitudPersonal) {
        DatosSolicitudPersonal entity = new DatosSolicitudPersonal();
        entity.setIdDatosSolicitudPersonal(dto.getIdDatosSolicitudPersonal());
        entity.setNombre(dto.getNombre());
        entity.setCargo(dto.getCargo());
        entity.setAreaActual(dto.getAreaActual());
        entity.setFechaSolicitud(dto.getFechaSolicitud());
        entity.setPuestoSolicitado(dto.getPuestoSolicitado());
        entity.setAreaNueva(dto.getAreaNueva());
        entity.setNumeroVacantes(dto.getNumeroVacantes());
        entity.setFechaPrevista(dto.getFechaPrevista());
        entity.setMotivotipoContrato(dto.getMotivotipoContrato());
        entity.setEstatus(dto.getEstatus());
        entity.setEspecifique(dto.getEspecifique());
        entity.setSolicitudPersonal(solicitudPersonal);
        return entity;
    }
}

