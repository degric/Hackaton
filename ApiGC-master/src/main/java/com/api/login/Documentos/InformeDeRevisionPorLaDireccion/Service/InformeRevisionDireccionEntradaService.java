package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.InformeRevisionDireccionEntradaDTO;

import java.util.List;

public interface InformeRevisionDireccionEntradaService {

    List<InformeRevisionDireccionEntradaDTO> findAll();

    InformeRevisionDireccionEntradaDTO findById(Long id);

    List<InformeRevisionDireccionEntradaDTO> findByInformeRevisionDireccion(Long idInformeRevisionDireccion);

    InformeRevisionDireccionEntradaDTO save(InformeRevisionDireccionEntradaDTO informeRevisionDireccionEntradaDTO);

    InformeRevisionDireccionEntradaDTO update(Long id, InformeRevisionDireccionEntradaDTO informeRevisionDireccionEntradaDTO);

    void deleteById(Long id);
}
