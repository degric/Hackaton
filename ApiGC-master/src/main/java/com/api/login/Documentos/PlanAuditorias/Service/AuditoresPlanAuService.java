package com.api.login.Documentos.PlanAuditorias.Service;

import com.api.login.Documentos.PlanAuditorias.DTO.AuditoresPlanAuDTO;

import java.util.List;

public interface AuditoresPlanAuService {
    List<AuditoresPlanAuDTO> getAllConPlanAu();
    AuditoresPlanAuDTO createConPlanAu(AuditoresPlanAuDTO dto);
    AuditoresPlanAuDTO updateConPlanAu(Long id, AuditoresPlanAuDTO dto);
    void deleteConPlanAu(Long id);
    List<AuditoresPlanAuDTO> getByIdEncabezado(Long id);
}
