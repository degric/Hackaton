package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.IRDAdecuacionRecursosDTO;

import java.util.List;

public interface IRDAdecuacionRecursosService {

    List<IRDAdecuacionRecursosDTO> findAll();

    IRDAdecuacionRecursosDTO findById(Long id);

    List<IRDAdecuacionRecursosDTO> findByInformeRevisionDireccion(Long idInformeRevisionDireccion);

    IRDAdecuacionRecursosDTO save(IRDAdecuacionRecursosDTO irdAdecuacionRecursosDTO);

    IRDAdecuacionRecursosDTO update(Long id, IRDAdecuacionRecursosDTO irdAdecuacionRecursosDTO);

    void deleteById(Long id);
}
