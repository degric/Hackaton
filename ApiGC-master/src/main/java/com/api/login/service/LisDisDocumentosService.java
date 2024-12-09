package com.api.login.service;

import com.api.login.DTO.LisDisDocumentosDTO;
import com.api.login.pojo.LisDisDocumentos;

import java.util.List;
import java.util.Optional;

public interface LisDisDocumentosService {

    List<LisDisDocumentosDTO> getAll();

    Optional<LisDisDocumentosDTO> getById(Integer id);

    LisDisDocumentosDTO create(LisDisDocumentosDTO dto);

    LisDisDocumentosDTO update(Integer id, LisDisDocumentosDTO dto);

    void eliminar(Integer id);


}
