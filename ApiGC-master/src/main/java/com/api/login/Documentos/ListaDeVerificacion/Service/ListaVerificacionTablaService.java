package com.api.login.Documentos.ListaDeVerificacion.Service;

import com.api.login.Documentos.ListaDeVerificacion.DTO.ListaVerificacionTablaDTO;

import java.util.List;

public interface ListaVerificacionTablaService {

    List<ListaVerificacionTablaDTO> findAll();

    ListaVerificacionTablaDTO findById(Long id);

    List<ListaVerificacionTablaDTO> findByListaVerificacion(Long idListaVerificacion);

    ListaVerificacionTablaDTO save(ListaVerificacionTablaDTO listaVerificacionTablaDTO);

    ListaVerificacionTablaDTO update(Long id, ListaVerificacionTablaDTO listaVerificacionTablaDTO);

    void deleteById(Long id);
}

