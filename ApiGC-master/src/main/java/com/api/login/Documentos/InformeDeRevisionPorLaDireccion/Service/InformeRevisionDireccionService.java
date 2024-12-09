package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.InformeRevisionDireccionDTO;

import java.util.List;

public interface InformeRevisionDireccionService {

    List<InformeRevisionDireccionDTO> findAll();

    InformeRevisionDireccionDTO findById(Long id);

    InformeRevisionDireccionDTO save(InformeRevisionDireccionDTO informeRevisionDireccionDTO);

    InformeRevisionDireccionDTO update(Long id, InformeRevisionDireccionDTO informeRevisionDireccionDTO);

    void deleteById(Long id);
}

