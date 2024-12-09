package com.api.login.Procesos.Service;

import com.api.login.Procesos.DTO.EnProcesoDTO;
import com.api.login.Procesos.DTO.EnProcesoDTOSinListas;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EnProcesoService {

    Page<EnProcesoDTOSinListas> getAllEnProceso(Pageable pageable);

    List<EnProcesoDTO> getAllEnProcesoEntity();
    Optional<EnProcesoDTO> getByIdEnProceso(Long id);

    EnProcesoDTO createEnProceso(EnProcesoDTO dto);

    EnProcesoDTO updateEnProceso(Long id,EnProcesoDTO dto);

    void deleteEnProceso(Long id);

    List<EnProcesoDTO> findbynombre (String nombre);

    Page<EnProcesoDTO> listaPagina(Pageable pageable);
}
