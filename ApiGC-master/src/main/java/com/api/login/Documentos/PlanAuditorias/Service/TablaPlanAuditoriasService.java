package com.api.login.Documentos.PlanAuditorias.Service;

import com.api.login.Documentos.PlanAuditorias.DTO.TablaPlanAuditoriasDTO;

import java.util.List;

public interface TablaPlanAuditoriasService {

    List<TablaPlanAuditoriasDTO> getAllConPlanAu();

    TablaPlanAuditoriasDTO createConPlanAu(TablaPlanAuditoriasDTO dto);

    TablaPlanAuditoriasDTO updateConPlanAu(Long id, TablaPlanAuditoriasDTO dto);

    void deleteConPlanAu(Long id);

    List<TablaPlanAuditoriasDTO> getByIdEncabezado(Long id);
}

