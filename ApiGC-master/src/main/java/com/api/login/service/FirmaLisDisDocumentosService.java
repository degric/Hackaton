package com.api.login.service;

import com.api.login.DTO.FirmaLisDisDocumentosDTO;
import com.api.login.pojo.FirmaLisDisDocumentos;

import java.util.List;

public interface FirmaLisDisDocumentosService {

    List<FirmaLisDisDocumentosDTO> getAll();

    FirmaLisDisDocumentos create(FirmaLisDisDocumentosDTO dto);

    FirmaLisDisDocumentosDTO update(Integer id, FirmaLisDisDocumentosDTO dto);

    void delete(Integer id);

    List<FirmaLisDisDocumentosDTO> getFirmaLisDisById(Integer id);
}
