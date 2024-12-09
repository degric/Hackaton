package com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Service;

import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.DTO.LDDocTablaDTO;

import java.util.List;

public interface LDDocTablaService {

    List<LDDocTablaDTO> findAll();

    LDDocTablaDTO findById(Long id);

    List<LDDocTablaDTO> findByListadoDistribucionDocumentos(Long idListadoDistribucionDocumentos);

    LDDocTablaDTO save(LDDocTablaDTO lddDocTablaDTO);

    LDDocTablaDTO update(Long id, LDDocTablaDTO lddDocTablaDTO);

    void deleteById(Long id);
}

