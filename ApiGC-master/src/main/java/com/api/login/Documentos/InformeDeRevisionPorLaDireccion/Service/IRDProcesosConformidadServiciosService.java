package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.IRDProcesosConformidadServiciosDTO;

import java.util.List;

public interface IRDProcesosConformidadServiciosService {

    List<IRDProcesosConformidadServiciosDTO> findAll();

    IRDProcesosConformidadServiciosDTO findById(Long id);

    List<IRDProcesosConformidadServiciosDTO> findByInformeRevisionDireccion(Long idInformeRevisionDireccion);

    IRDProcesosConformidadServiciosDTO save(IRDProcesosConformidadServiciosDTO irdProcesosConformidadServiciosDTO);

    IRDProcesosConformidadServiciosDTO update(Long id, IRDProcesosConformidadServiciosDTO irdProcesosConformidadServiciosDTO);

    void deleteById(Long id);
}
