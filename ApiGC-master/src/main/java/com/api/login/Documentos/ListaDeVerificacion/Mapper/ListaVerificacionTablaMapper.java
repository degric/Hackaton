package com.api.login.Documentos.ListaDeVerificacion.Mapper;

import com.api.login.Documentos.ListaDeVerificacion.DTO.ListaVerificacionTablaDTO;
import com.api.login.Documentos.ListaDeVerificacion.Pojo.ListaVerificacion;
import com.api.login.Documentos.ListaDeVerificacion.Pojo.ListaVerificacionTabla;
import org.springframework.stereotype.Component;

@Component
public class ListaVerificacionTablaMapper {

    public ListaVerificacionTablaDTO toDTO(ListaVerificacionTabla entity) {
        ListaVerificacionTablaDTO dto = new ListaVerificacionTablaDTO();
        dto.setIdListaVerificacionTabla(entity.getIdListaVerificacionTabla());
        dto.setNumero(entity.getNumero());
        dto.setContextoOrganizacion(entity.getContextoOrganizacion());
        dto.setMarcador(entity.getMarcador());
        dto.setEvidenciasAllasgos(entity.getEvidenciasAllasgos());
        dto.setIdListaVerificacion(entity.getListaVerificacion().getIdListaVerificacion());
        return dto;
    }

    public ListaVerificacionTabla toEntity(ListaVerificacionTablaDTO dto, ListaVerificacion listaVerificacion) {
        ListaVerificacionTabla entity = new ListaVerificacionTabla();
        entity.setIdListaVerificacionTabla(dto.getIdListaVerificacionTabla());
        entity.setNumero(dto.getNumero());
        entity.setContextoOrganizacion(dto.getContextoOrganizacion());
        entity.setMarcador(dto.getMarcador());
        entity.setEvidenciasAllasgos(dto.getEvidenciasAllasgos());
        entity.setListaVerificacion(listaVerificacion);
        return entity;
    }
}

