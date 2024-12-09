package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.IRDResultadosSeguimientoMedicionDTO;

import java.util.List;

public interface IRDResultadosSeguimientoMedicionService {

    List<IRDResultadosSeguimientoMedicionDTO> findAll();

    IRDResultadosSeguimientoMedicionDTO findById(Long id);

    List<IRDResultadosSeguimientoMedicionDTO> findByInformeRevisionDireccion(Long idInformeRevisionDireccion);

    IRDResultadosSeguimientoMedicionDTO save(IRDResultadosSeguimientoMedicionDTO irdResultadosSeguimientoMedicionDTO);

    IRDResultadosSeguimientoMedicionDTO update(Long id, IRDResultadosSeguimientoMedicionDTO irdResultadosSeguimientoMedicionDTO);

    void deleteById(Long id);
}

