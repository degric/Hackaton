package com.api.login.Documentos.ListaDeAsistencia.Service;

import com.api.login.Documentos.ListaDeAsistencia.DTO.TablaListaAsistenciaDTO;

import java.util.List;

public interface TablaListaAsistenciaService {

    List<TablaListaAsistenciaDTO> findAll();

    TablaListaAsistenciaDTO findById(Long id);

    List<TablaListaAsistenciaDTO> findByListaAsistencia(Long idListaAsistencia);

    TablaListaAsistenciaDTO save(TablaListaAsistenciaDTO tablaDTO);

    TablaListaAsistenciaDTO update(Long id, TablaListaAsistenciaDTO tablaDTO);

    void deleteById(Long id);
}

