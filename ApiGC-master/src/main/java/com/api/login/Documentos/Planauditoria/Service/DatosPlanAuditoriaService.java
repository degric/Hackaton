package com.api.login.Documentos.Planauditoria.Service;

import com.api.login.Documentos.Planauditoria.DTO.DatosPlanAuditoriaDTO;

import java.util.List;

public interface DatosPlanAuditoriaService {

    List<DatosPlanAuditoriaDTO> findAll();

    DatosPlanAuditoriaDTO findById(Long id);

    List<DatosPlanAuditoriaDTO> findByPlanAuditoria(Long idPlanAuditoria);

    DatosPlanAuditoriaDTO save(DatosPlanAuditoriaDTO datosPlanAuditoriaDTO);

    DatosPlanAuditoriaDTO update(Long id, DatosPlanAuditoriaDTO datosPlanAuditoriaDTO);

    void deleteById(Long id);
}

