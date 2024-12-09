package com.api.login.Procesos.Service;

import com.api.login.Procesos.DTO.HisRevisionesProcesoDTO;

import java.util.List;
import java.util.Optional;

public interface HisRevisionesProcesoService {

    List<HisRevisionesProcesoDTO> getAllHisRevisionesProceso();

    HisRevisionesProcesoDTO createHisRevisionesProceso(HisRevisionesProcesoDTO dto);

    HisRevisionesProcesoDTO updateHisRevisionesProceso(Long id, HisRevisionesProcesoDTO dto);

    void deleteHisRevisionesProceso(Long id);

    List<HisRevisionesProcesoDTO> findByIdEnProceso(Long id);
}

