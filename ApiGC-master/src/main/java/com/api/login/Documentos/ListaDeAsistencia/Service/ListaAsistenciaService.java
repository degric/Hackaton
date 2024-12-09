package com.api.login.Documentos.ListaDeAsistencia.Service;

import com.api.login.Documentos.ListaDeAsistencia.DTO.ListaAsistenciaDTO;
import com.lowagie.text.DocumentException;

import java.util.List;

public interface ListaAsistenciaService {

    List<ListaAsistenciaDTO> findAll();

    ListaAsistenciaDTO findById(Long id);

    ListaAsistenciaDTO save(ListaAsistenciaDTO listaAsistenciaDTO);

    ListaAsistenciaDTO update(Long id, ListaAsistenciaDTO listaAsistenciaDTO);

    void deleteById(Long id);

    byte[] generarPdf(Long id) throws DocumentException;
}
