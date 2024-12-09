package com.api.login.Procesos.Service;

import com.api.login.Procesos.DTO.DistribucionProcesoDTO;

import java.util.List;
import java.util.Optional;

public interface DistribucionProcesoService {

    List<DistribucionProcesoDTO> getAllDistribucion();

    DistribucionProcesoDTO createDistribucion(DistribucionProcesoDTO dto);

    DistribucionProcesoDTO updateDistribucion(Long id, DistribucionProcesoDTO dto);

    void deleteDistribucion(Long id);

    Optional<DistribucionProcesoDTO> findByIdEnProceso(Long id);
}

