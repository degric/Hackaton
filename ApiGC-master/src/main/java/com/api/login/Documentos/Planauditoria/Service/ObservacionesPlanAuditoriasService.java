package com.api.login.Documentos.Planauditoria.Service;

import com.api.login.Documentos.Planauditoria.DTO.ObservacionesPlanAuditoriasDTO;

import java.util.List;

public interface ObservacionesPlanAuditoriasService {

    List<ObservacionesPlanAuditoriasDTO> findAll();

    ObservacionesPlanAuditoriasDTO findById(Long id);

    List<ObservacionesPlanAuditoriasDTO> findByPlanAuditoria(Long idPlanAuditoria);

    ObservacionesPlanAuditoriasDTO save(ObservacionesPlanAuditoriasDTO observacionesDTO);

    ObservacionesPlanAuditoriasDTO update(Long id, ObservacionesPlanAuditoriasDTO observacionesDTO);

    void deleteById(Long id);
}

