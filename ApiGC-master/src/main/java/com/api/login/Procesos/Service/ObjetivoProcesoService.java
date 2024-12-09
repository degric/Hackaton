package com.api.login.Procesos.Service;

import com.api.login.Procesos.DTO.ObjetivoProcesoDTO;

import java.util.List;
import java.util.Optional;

public interface ObjetivoProcesoService {

    List<ObjetivoProcesoDTO> getAllObProceso();

    ObjetivoProcesoDTO createObProceso(ObjetivoProcesoDTO dto);

    ObjetivoProcesoDTO updateObProceso(Long id,ObjetivoProcesoDTO dto);

    void deleteObProceso(Long id);

    Optional<ObjetivoProcesoDTO> findByIdEnProceso(Long id);

}
