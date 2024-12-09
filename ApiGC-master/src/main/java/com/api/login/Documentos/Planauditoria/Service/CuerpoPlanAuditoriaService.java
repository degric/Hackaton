package com.api.login.Documentos.Planauditoria.Service;

import com.api.login.Documentos.Planauditoria.DTO.CuerpoPlanAuditoriaDTO;

import java.util.List;

public interface CuerpoPlanAuditoriaService {

    List<CuerpoPlanAuditoriaDTO> findAll();

    CuerpoPlanAuditoriaDTO findById(Long id);

    List<CuerpoPlanAuditoriaDTO> findByPlanAuditoria(Long idPlanAuditoria);

    CuerpoPlanAuditoriaDTO save(CuerpoPlanAuditoriaDTO cuerpoDTO);

    CuerpoPlanAuditoriaDTO update(Long id, CuerpoPlanAuditoriaDTO cuerpoDTO);

    void deleteById(Long id);
}

