package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.IRDObjetivosCalidadDTO;

import java.util.List;

public interface IRDObjetivosCalidadService {

    List<IRDObjetivosCalidadDTO> findAll();

    IRDObjetivosCalidadDTO findById(Long id);

    List<IRDObjetivosCalidadDTO> findByInformeRevisionDireccion(Long idInformeRevisionDireccion);

    IRDObjetivosCalidadDTO save(IRDObjetivosCalidadDTO irdObjetivosCalidadDTO);

    IRDObjetivosCalidadDTO update(Long id, IRDObjetivosCalidadDTO irdObjetivosCalidadDTO);

    void deleteById(Long id);
}
