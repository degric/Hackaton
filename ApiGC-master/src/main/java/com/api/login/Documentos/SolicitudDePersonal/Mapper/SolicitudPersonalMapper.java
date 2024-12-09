package com.api.login.Documentos.SolicitudDePersonal.Mapper;

import com.api.login.Documentos.SolicitudDePersonal.DTO.SolicitudPersonalDTO;
import com.api.login.Documentos.SolicitudDePersonal.Pojo.DatosSolicitudPersonal;
import com.api.login.Documentos.SolicitudDePersonal.Pojo.SolicitudPersonal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SolicitudPersonalMapper {

    @Autowired
    private DatosSolicitudPersonalMapper datosMapper;

    public SolicitudPersonalDTO toDTO(SolicitudPersonal entity) {
        SolicitudPersonalDTO dto = new SolicitudPersonalDTO();
        dto.setIdSolicitudPersonal(entity.getIdSolicitudPersonal());
        dto.setCoDocumento(entity.getCoDocumento());
        dto.setNoRevision(entity.getNoRevision());
        dto.setFechaEmicion(entity.getFechaEmicion());
        dto.setFechaRevision(entity.getFechaRevision());

        if (entity.getDatosSolicitudPersonal() != null) {
            dto.setDatosSolicitudPersonal(datosMapper.toDTO(entity.getDatosSolicitudPersonal()));
        }
        return dto;
    }

    public SolicitudPersonal toEntity(SolicitudPersonalDTO dto) {
        SolicitudPersonal entity = new SolicitudPersonal();
        entity.setIdSolicitudPersonal(dto.getIdSolicitudPersonal());
        entity.setCoDocumento(dto.getCoDocumento());
        entity.setNoRevision(dto.getNoRevision());
        entity.setFechaEmicion(dto.getFechaEmicion());
        entity.setFechaRevision(dto.getFechaRevision());

        if (dto.getDatosSolicitudPersonal() != null) {
            DatosSolicitudPersonal datos = datosMapper.toEntity(dto.getDatosSolicitudPersonal(), entity);
            entity.setDatosSolicitudPersonal(datos);
        }

        return entity;
    }
}
