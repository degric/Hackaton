package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.IRDResultadosAuditoriaDTO;

import java.util.List;

public interface IRDResultadosAuditoriaService {

    List<IRDResultadosAuditoriaDTO> findAll();

    IRDResultadosAuditoriaDTO findById(Long id);

    List<IRDResultadosAuditoriaDTO> findByInformeRevisionDireccion(Long idInformeRevisionDireccion);

    IRDResultadosAuditoriaDTO save(IRDResultadosAuditoriaDTO irdResultadosAuditoriaDTO);

    IRDResultadosAuditoriaDTO update(Long id, IRDResultadosAuditoriaDTO irdResultadosAuditoriaDTO);

    void deleteById(Long id);
}

