package com.api.login.service;

import com.api.login.DTO.DocumentosLisDisDoDTO;
import com.api.login.pojo.DocumentosLisDisDo;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface DocumentosLisDisDoService {

    List<DocumentosLisDisDoDTO> getAll();

    DocumentosLisDisDo create(DocumentosLisDisDoDTO dto, Integer idLisDis);

    DocumentosLisDisDoDTO update(Integer id, DocumentosLisDisDoDTO dto);

    void delete(Integer id);

    List<DocumentosLisDisDoDTO> getDocimentosByIdEncabezado(Integer id);
}
