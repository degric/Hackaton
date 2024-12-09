package com.api.login.Documentos.ListaDeAsistencia.Mapper;

import com.api.login.Documentos.ListaDeAsistencia.DTO.DatosListaAsistenciaDTO;
import com.api.login.Documentos.ListaDeAsistencia.Pojo.DatosListaAsistencia;
import com.api.login.Documentos.ListaDeAsistencia.Pojo.ListaAsistencia;
import org.springframework.stereotype.Component;

@Component
public class DatosListaAsistenciaMapper {

    public DatosListaAsistenciaDTO toDTO(DatosListaAsistencia entity) {
        DatosListaAsistenciaDTO dto = new DatosListaAsistenciaDTO();
        dto.setIdDatosListaAsistencia(entity.getIdDatosListaAsistencia());
        dto.setDepartamentoCoordinador(entity.getDepartamentoCoordinador());
        dto.setResponable(entity.getResponable());
        dto.setTitulo(entity.getTitulo());
        dto.setFecha(entity.getFecha());
        dto.setIdListaAsistencia(entity.getListaAsistencia().getIdListaAsistencia());
        return dto;
    }

    public DatosListaAsistencia toEntity(DatosListaAsistenciaDTO dto, ListaAsistencia listaAsistencia) {
        DatosListaAsistencia entity = new DatosListaAsistencia();
        entity.setIdDatosListaAsistencia(dto.getIdDatosListaAsistencia());
        entity.setDepartamentoCoordinador(dto.getDepartamentoCoordinador());
        entity.setResponable(dto.getResponable());
        entity.setTitulo(dto.getTitulo());
        entity.setFecha(dto.getFecha());
        entity.setListaAsistencia(listaAsistencia);
        return entity;
    }
}

