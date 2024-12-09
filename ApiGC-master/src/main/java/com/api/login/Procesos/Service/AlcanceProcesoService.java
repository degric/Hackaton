package com.api.login.Procesos.Service;

import com.api.login.Procesos.DTO.AlcanceProcesoDTO;

import java.util.List;
import java.util.Optional;

public interface AlcanceProcesoService {

    List<AlcanceProcesoDTO> getAllAlProceso();

    AlcanceProcesoDTO createAlProceso(AlcanceProcesoDTO dto);

    AlcanceProcesoDTO updateAlProceso(Long id, AlcanceProcesoDTO dto);

    void deleteAlProceso(Long id);

    Optional<AlcanceProcesoDTO> finByIdEnProceso(Long id);
}
