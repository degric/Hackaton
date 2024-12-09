package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.IRDNoConformidadesAcCorrectivasDTO;

import java.util.List;

public interface IRDNoConformidadesAcCorrectivasService {

    List<IRDNoConformidadesAcCorrectivasDTO> findAll();

    IRDNoConformidadesAcCorrectivasDTO findById(Long id);

    List<IRDNoConformidadesAcCorrectivasDTO> findByInformeRevisionDireccion(Long idInformeRevisionDireccion);

    IRDNoConformidadesAcCorrectivasDTO save(IRDNoConformidadesAcCorrectivasDTO irdNoConformidadesAcCorrectivasDTO);

    IRDNoConformidadesAcCorrectivasDTO update(Long id, IRDNoConformidadesAcCorrectivasDTO irdNoConformidadesAcCorrectivasDTO);

    void deleteById(Long id);
}
