package com.api.login.Procesos.Service;

import com.api.login.Procesos.DTO.DoReferenciaProcesoDTO;

import java.util.List;
import java.util.Optional;

public interface DoReferenciaProcesoService {

    List<DoReferenciaProcesoDTO> getAllDoReferencia();

    DoReferenciaProcesoDTO createDoReferencia(DoReferenciaProcesoDTO dto);

    DoReferenciaProcesoDTO updateDoReferencia(Long id, DoReferenciaProcesoDTO dto);

    void deleteDoReferencia(Long id);

    List<DoReferenciaProcesoDTO> finByIdEnProceso(Long id);
}

