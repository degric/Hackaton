package com.api.login.Procesos.Service;

import com.api.login.Procesos.DTO.AbreProdesoDTO;

import java.util.List;

public interface AbreProdesoService {
    List<AbreProdesoDTO> getAllAbreProceso();

    AbreProdesoDTO createAbreProceso(AbreProdesoDTO dto);

    AbreProdesoDTO updateAbreProceso(Long id, AbreProdesoDTO dto);

    void deleteAbreProceso(Long id);

    List<AbreProdesoDTO> findByIdEnProceso(Long id);
}
