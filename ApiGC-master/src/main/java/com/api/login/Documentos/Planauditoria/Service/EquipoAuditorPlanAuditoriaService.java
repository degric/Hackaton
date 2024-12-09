package com.api.login.Documentos.Planauditoria.Service;

import com.api.login.Documentos.Planauditoria.DTO.EquipoAuditorPlanAuditoriaDTO;

import java.util.List;

public interface EquipoAuditorPlanAuditoriaService {

    List<EquipoAuditorPlanAuditoriaDTO> findAll();

    EquipoAuditorPlanAuditoriaDTO findById(Long id);

    List<EquipoAuditorPlanAuditoriaDTO> findByPlanAuditoria(Long idPlanAuditoria);

    EquipoAuditorPlanAuditoriaDTO save(EquipoAuditorPlanAuditoriaDTO equipoAuditorDTO);

    EquipoAuditorPlanAuditoriaDTO update(Long id, EquipoAuditorPlanAuditoriaDTO equipoAuditorDTO);

    void deleteById(Long id);
}

