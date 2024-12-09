package com.api.login.Documentos.SolicitudCotizacion.Mapper;

import com.api.login.Documentos.SolicitudCotizacion.DTO.DatosSolicitudCotizacionDTO;
import com.api.login.Documentos.SolicitudCotizacion.pojo.DatosSolicitudCotizacion;
import com.api.login.Documentos.SolicitudCotizacion.pojo.SolicitudCotizacion;
import org.springframework.stereotype.Component;

@Component
public class DatosSolicitudCotizacionMapper {

    public DatosSolicitudCotizacionDTO toDTODatosSoCo(DatosSolicitudCotizacion entity){
        DatosSolicitudCotizacionDTO dto = new DatosSolicitudCotizacionDTO();

        dto.setIdDatosSolicitudCotizacion(entity.getIdDatosSolicitudCotizacion());
        dto.setMunicipio(entity.getMunicipio());
        dto.setEstado(entity.getEstado());
        dto.setFecha(entity.getFecha());
        dto.setSolicitud(entity.getSolicitud());
        dto.setNombre(entity.getNombre());
        dto.setDireccion(entity.getDireccion());
        dto.setTelefono(entity.getTelefono());
        dto.setCelular(entity.getCelular());
        dto.setNombreAtencion(entity.getNombreAtencion());
        dto.setPuesto(entity.getPuesto());
        dto.setCorreo(entity.getCorreo());
        dto.setDescripcionSolicitado(entity.getDescripcionSolicitado());
        dto.setIdSolicitudCotizacion(entity.getSolicitudCotizacion().getIdSolicitudCotizacion());

        return dto;
    }

    public DatosSolicitudCotizacion toEntitySoCo(DatosSolicitudCotizacionDTO dto, SolicitudCotizacion solicitudCotizacion){
        DatosSolicitudCotizacion entity = new DatosSolicitudCotizacion();

        entity.setIdDatosSolicitudCotizacion(dto.getIdDatosSolicitudCotizacion());
        entity.setMunicipio(dto.getMunicipio());
        entity.setEstado(dto.getEstado());
        entity.setFecha(dto.getFecha());
        entity.setSolicitud(dto.getSolicitud());
        entity.setNombre(dto.getNombre());
        entity.setDireccion(dto.getDireccion());
        entity.setTelefono(dto.getTelefono());
        entity.setCelular(dto.getCelular());
        entity.setNombreAtencion(dto.getNombreAtencion());
        entity.setPuesto(dto.getPuesto());
        entity.setCorreo(dto.getCorreo());
        entity.setDescripcionSolicitado(dto.getDescripcionSolicitado());
        entity.setSolicitudCotizacion(solicitudCotizacion);

        return entity;
    }
}
