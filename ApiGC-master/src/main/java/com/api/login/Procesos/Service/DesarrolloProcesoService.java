package com.api.login.Procesos.Service;

import com.api.login.Procesos.DTO.DesarrolloProcesoDTO;
import com.api.login.Procesos.Pojo.DesarrolloProceso;

import java.util.List;
import java.util.Optional;

public interface DesarrolloProcesoService {

    List<DesarrolloProcesoDTO> getAllDesarrolloProceso();

    DesarrolloProceso findById(Long id);

    DesarrolloProcesoDTO createDesarrolloProceso(DesarrolloProcesoDTO dto);

    DesarrolloProceso updateDesarrolloProceso(Long id, DesarrolloProceso dto);

    void deleteDesarrolloProceso(Long id);

    List<DesarrolloProcesoDTO> findByIdEnProceso(Long id);
}
