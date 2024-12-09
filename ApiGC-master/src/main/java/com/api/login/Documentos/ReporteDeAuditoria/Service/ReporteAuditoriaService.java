package com.api.login.Documentos.ReporteDeAuditoria.Service;

import com.api.login.Documentos.ReporteDeAuditoria.DTO.ReporteAuditoriaDTO;
import com.lowagie.text.DocumentException;

import java.util.List;

public interface ReporteAuditoriaService {

    List<ReporteAuditoriaDTO> findAll();

    ReporteAuditoriaDTO findById(Long id);

    ReporteAuditoriaDTO save(ReporteAuditoriaDTO reporteAuditoriaDTO);

    ReporteAuditoriaDTO update(Long id, ReporteAuditoriaDTO reporteAuditoriaDTO);

    void deleteById(Long id);

    byte[] generarPdf(Long id) throws DocumentException;
}
