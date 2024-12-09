package com.api.login.Documentos.PlanAuditorias.Service;

import com.api.login.Documentos.PlanAuditorias.DTO.ContenidoPlanAuditoriasDTO;

import java.util.List;
import java.util.Optional;

public interface ContenidoPlanAuditoriasService {

    List<ContenidoPlanAuditoriasDTO> getAllConPlanAu();

    ContenidoPlanAuditoriasDTO createConPlanAu(ContenidoPlanAuditoriasDTO dto);

    ContenidoPlanAuditoriasDTO updateConPlanAu(Long id, ContenidoPlanAuditoriasDTO dto);

    void deleteConPlanAu(Long id);

    Optional<ContenidoPlanAuditoriasDTO> getByIdEncabezado(Long id);
}
