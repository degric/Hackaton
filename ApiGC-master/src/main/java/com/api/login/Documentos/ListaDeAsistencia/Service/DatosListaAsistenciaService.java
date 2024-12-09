package com.api.login.Documentos.ListaDeAsistencia.Service;

import com.api.login.Documentos.ListaDeAsistencia.DTO.DatosListaAsistenciaDTO;

import java.util.List;

public interface DatosListaAsistenciaService {

    List<DatosListaAsistenciaDTO> findAll();

    DatosListaAsistenciaDTO findById(Long id);

    DatosListaAsistenciaDTO findByListaAsistencia(Long idListaAsistencia);

    DatosListaAsistenciaDTO save(DatosListaAsistenciaDTO datosDTO);

    DatosListaAsistenciaDTO update(Long id, DatosListaAsistenciaDTO datosDTO);

    void deleteById(Long id);
}

