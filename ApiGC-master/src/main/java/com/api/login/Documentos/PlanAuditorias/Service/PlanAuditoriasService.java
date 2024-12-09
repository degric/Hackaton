package com.api.login.Documentos.PlanAuditorias.Service;

import com.api.login.Documentos.PlanAuditorias.DTO.PlanAuditoriasDTO;

import java.util.List;
import java.util.Optional;

public interface PlanAuditoriasService {

    List<PlanAuditoriasDTO> getAllPlanAun();

    Optional<PlanAuditoriasDTO> getPlanAuById(Long id);

    PlanAuditoriasDTO createPlanAu(PlanAuditoriasDTO dto);

    PlanAuditoriasDTO updatePlanAu(Long id, PlanAuditoriasDTO dto);

    void deletePlanAu(Long id);
}
