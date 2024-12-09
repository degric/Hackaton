package com.api.login.Documentos.ListaDeVerificacion.Mapper;

import com.api.login.Documentos.ListaDeVerificacion.DTO.ListaVerificacionDTO;
import com.api.login.Documentos.ListaDeVerificacion.Pojo.ListaVerificacion;
import com.api.login.Documentos.ListaDeVerificacion.Pojo.ListaVerificacionTabla;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ListaVerificacionMapper {

    @Autowired
    private ListaVerificacionTablaMapper listaVerificacionTablaMapper;


    public ListaVerificacionDTO toDTO(ListaVerificacion entity) {
        ListaVerificacionDTO dto = new ListaVerificacionDTO();
        dto.setIdListaVerificacion(entity.getIdListaVerificacion());
        dto.setCoDocumento(entity.getCoDocumento());
        dto.setNoRevision(entity.getNoRevision());
        dto.setFechaEmicion(entity.getFechaEmicion());
        dto.setFechaRevision(entity.getFechaRevision());

        // Mapear la lista de tablas de la lista de verificación relacionadas
        if (entity.getListaVerificacionTablas() != null) {
            dto.setListaVerificacionTablas(entity.getListaVerificacionTablas().stream()
                    .map(listaVerificacionTablaMapper::toDTO)
                    .collect(Collectors.toList()));
        }

        return dto;
    }

    public ListaVerificacion toEntity(ListaVerificacionDTO dto) {
        ListaVerificacion entity = new ListaVerificacion();
        entity.setIdListaVerificacion(dto.getIdListaVerificacion());
        entity.setCoDocumento(dto.getCoDocumento());
        entity.setNoRevision(dto.getNoRevision());
        entity.setFechaEmicion(dto.getFechaEmicion());
        entity.setFechaRevision(dto.getFechaRevision());


        // Mapear la lista de tablas de la lista de verificación relacionadas
        if (dto.getListaVerificacionTablas() != null) {
            List<ListaVerificacionTabla> tablas = dto.getListaVerificacionTablas().stream()
                    .map(tablaDTO -> {
                        ListaVerificacionTabla tabla = listaVerificacionTablaMapper.toEntity(tablaDTO, entity);
                        tabla.setListaVerificacion(entity);  // Asignar la relación
                        return tabla;
                    })
                    .collect(Collectors.toList());
            entity.setListaVerificacionTablas(tablas);
        }

        return entity;
    }
}

