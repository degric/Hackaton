package com.api.login.Procesos.Service;

import com.api.login.Procesos.DTO.DiTortugaProcesoDTO;

import java.util.List;

public interface DiTortugaProcesoService {

    List<DiTortugaProcesoDTO> getAllDiTortugaProceso();

    DiTortugaProcesoDTO createDiTortugaProceso(DiTortugaProcesoDTO dto);

    DiTortugaProcesoDTO updateDiTortugaProceso(Long id, DiTortugaProcesoDTO dto);

    void deleteDiTortugaProceso(Long id);

    List<DiTortugaProcesoDTO> findByIdEnProceso(Long id);
}
