package com.api.login.Documentos.ListaDeAsistencia.Mapper;

import com.api.login.Documentos.ListaDeAsistencia.DTO.TablaListaAsistenciaDTO;
import com.api.login.Documentos.ListaDeAsistencia.Pojo.ListaAsistencia;
import com.api.login.Documentos.ListaDeAsistencia.Pojo.TablaListaAsistencia;
import org.springframework.stereotype.Component;

@Component
public class TablaListaAsistenciaMapper {

    public TablaListaAsistenciaDTO toDTO(TablaListaAsistencia entity) {
        TablaListaAsistenciaDTO dto = new TablaListaAsistenciaDTO();
        dto.setIdTablaListaAsistencia(entity.getIdTablaListaAsistencia());
        dto.setNombreParticipante(entity.getNombreParticipante());
        dto.setPuesto(entity.getPuesto());
        dto.setFirma(entity.getFirma());
        dto.setIdListaAsistencia(entity.getListaAsistencia().getIdListaAsistencia());
        return dto;
    }

    public TablaListaAsistencia toEntity(TablaListaAsistenciaDTO dto, ListaAsistencia listaAsistencia) {
        TablaListaAsistencia entity = new TablaListaAsistencia();
        entity.setIdTablaListaAsistencia(dto.getIdTablaListaAsistencia());
        entity.setNombreParticipante(dto.getNombreParticipante());
        entity.setPuesto(dto.getPuesto());
        entity.setFirma(dto.getFirma());
        entity.setListaAsistencia(listaAsistencia);
        return entity;
    }
}

