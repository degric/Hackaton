package com.api.login.Documentos.SolicitudCotizacion.Mapper;

import com.api.login.Documentos.SolicitudCotizacion.DTO.SolicitudCotizacionDTO;
import com.api.login.Documentos.SolicitudCotizacion.pojo.SolicitudCotizacion;
import org.springframework.stereotype.Component;

@Component
public class SolicitudCotizacionMapper {

    public SolicitudCotizacionDTO toDTOSoCo(SolicitudCotizacion entity){
        SolicitudCotizacionDTO dto = new SolicitudCotizacionDTO();

        dto.setIdSolicitudCotizacion(entity.getIdSolicitudCotizacion());
        dto.setCoDocumento(entity.getCoDocumento());
        dto.setNoRevision(entity.getNoRevision());
        dto.setFechaEmicion(entity.getFechaEmicion());
        dto.setFechaRevision(entity.getFechaRevision());
        dto.setNomSolicita(entity.getNomSolicita());

        return dto;
    }

    public SolicitudCotizacion toEntitySoCo(SolicitudCotizacionDTO dto){
        SolicitudCotizacion entity = new SolicitudCotizacion();

        entity.setIdSolicitudCotizacion(dto.getIdSolicitudCotizacion());
        entity.setCoDocumento(dto.getCoDocumento());
        entity.setNoRevision(dto.getNoRevision());
        entity.setFechaEmicion(dto.getFechaEmicion());
        entity.setFechaRevision(dto.getFechaRevision());
        entity.setNomSolicita(dto.getNomSolicita());

        return entity;
    }
}
