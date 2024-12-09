package com.api.login.Documentos.ReporteDeAuditoria.Service;

import com.api.login.Documentos.ReporteDeAuditoria.DTO.CierreReporteAuditoria2DTO;

import java.util.List;

public interface CierreReporteAuditoria2Service {

    List<CierreReporteAuditoria2DTO> findAll();

    CierreReporteAuditoria2DTO findById(Long id);

    List<CierreReporteAuditoria2DTO> findByReporteAuditoria(Long idReporteAuditoria);

    CierreReporteAuditoria2DTO save(CierreReporteAuditoria2DTO cierreDTO);

    CierreReporteAuditoria2DTO update(Long id, CierreReporteAuditoria2DTO cierreDTO);

    void deleteById(Long id);
}

