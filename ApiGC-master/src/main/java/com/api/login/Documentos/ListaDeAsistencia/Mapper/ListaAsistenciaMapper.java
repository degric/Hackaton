package com.api.login.Documentos.ListaDeAsistencia.Mapper;

import com.api.login.Documentos.ListaDeAsistencia.DTO.ListaAsistenciaDTO;
import com.api.login.Documentos.ListaDeAsistencia.Pojo.DatosListaAsistencia;
import com.api.login.Documentos.ListaDeAsistencia.Pojo.ListaAsistencia;
import com.api.login.Documentos.ListaDeAsistencia.Pojo.TablaListaAsistencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ListaAsistenciaMapper {

    @Autowired
    private DatosListaAsistenciaMapper datosMapper;

    @Autowired
    private TablaListaAsistenciaMapper tablaMapper;

    public ListaAsistenciaDTO toDTO(ListaAsistencia entity) {
        ListaAsistenciaDTO dto = new ListaAsistenciaDTO();
        dto.setIdListaAsistencia(entity.getIdListaAsistencia());
        dto.setCoDocumento(entity.getCoDocumento());
        dto.setNoRevision(entity.getNoRevision());
        dto.setFechaEmicion(entity.getFechaEmicion());
        dto.setFechaRevision(entity.getFechaRevision());

        if (entity.getDatosListaAsistencia() != null) {
            dto.setDatosListaAsistencia(datosMapper.toDTO(entity.getDatosListaAsistencia()));
        }

        if (entity.getTablaListaAsistenciaList() != null) {
            dto.setTablaListaAsistenciaList(entity.getTablaListaAsistenciaList().stream()
                    .map(tablaMapper::toDTO)
                    .collect(Collectors.toList()));
        }

        return dto;
    }

    public ListaAsistencia toEntity(ListaAsistenciaDTO dto) {
        ListaAsistencia entity = new ListaAsistencia();
        entity.setIdListaAsistencia(dto.getIdListaAsistencia());
        entity.setCoDocumento(dto.getCoDocumento());
        entity.setNoRevision(dto.getNoRevision());
        entity.setFechaEmicion(dto.getFechaEmicion());
        entity.setFechaRevision(dto.getFechaRevision());

        if (dto.getDatosListaAsistencia() != null) {
            DatosListaAsistencia datos = datosMapper.toEntity(dto.getDatosListaAsistencia(), entity);
            entity.setDatosListaAsistencia(datos);
        }

        if (dto.getTablaListaAsistenciaList() != null) {
            List<TablaListaAsistencia> tablas = dto.getTablaListaAsistenciaList().stream()
                    .map(tablaDTO -> tablaMapper.toEntity(tablaDTO, entity))
                    .collect(Collectors.toList());
            entity.setTablaListaAsistenciaList(tablas);
        }


        return entity;
    }
}
