package com.api.login.Procesos.Service;

import com.api.login.Procesos.DTO.ResponsaProcesoDTO;

import java.util.List;

public interface ResponsaProcesoService {

    List<ResponsaProcesoDTO> getAll();

    ResponsaProcesoDTO create(ResponsaProcesoDTO dto);

    ResponsaProcesoDTO update(Long id, ResponsaProcesoDTO dto);

    void delete(Long id);

    List<ResponsaProcesoDTO> findByIdEnProceso(Long id);
}

