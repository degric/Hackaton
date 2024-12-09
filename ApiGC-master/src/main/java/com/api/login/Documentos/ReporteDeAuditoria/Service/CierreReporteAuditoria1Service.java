package com.api.login.Documentos.ReporteDeAuditoria.Service;

import com.api.login.Documentos.ReporteDeAuditoria.DTO.CierreReporteAuditoria1DTO;

import java.util.List;

public interface CierreReporteAuditoria1Service {

    List<CierreReporteAuditoria1DTO> findAll();

    CierreReporteAuditoria1DTO findById(Long id);

    List<CierreReporteAuditoria1DTO> findByReporteAuditoria(Long idReporteAuditoria);

    CierreReporteAuditoria1DTO save(CierreReporteAuditoria1DTO cierreDTO);

    CierreReporteAuditoria1DTO update(Long id, CierreReporteAuditoria1DTO cierreDTO);

    void deleteById(Long id);
}

