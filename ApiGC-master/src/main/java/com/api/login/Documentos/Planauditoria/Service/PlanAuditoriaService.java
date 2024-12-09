package com.api.login.Documentos.Planauditoria.Service;

import com.api.login.Documentos.Planauditoria.DTO.PlanAuditoriaDTO;
import com.lowagie.text.DocumentException;

import java.util.List;

public interface PlanAuditoriaService {

    List<PlanAuditoriaDTO> findAll();

    PlanAuditoriaDTO findById(Long id);

    PlanAuditoriaDTO save(PlanAuditoriaDTO planAuditoriaDTO);

    PlanAuditoriaDTO update(Long id, PlanAuditoriaDTO planAuditoriaDTO);

    void deleteById(Long id);

    public byte[] generarBSCPdf(Long id) throws DocumentException;
}

