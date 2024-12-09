package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.IRDDesemProveExternosDTO;

import java.util.List;

public interface IRDDesemProveExternosService {

    List<IRDDesemProveExternosDTO> findAll();

    IRDDesemProveExternosDTO findById(Long id);

    List<IRDDesemProveExternosDTO> findByInformeRevisionDireccion(Long idInformeRevisionDireccion);

    IRDDesemProveExternosDTO save(IRDDesemProveExternosDTO irdDesemProveExternosDTO);

    IRDDesemProveExternosDTO update(Long id, IRDDesemProveExternosDTO irdDesemProveExternosDTO);

    void deleteById(Long id);
}

