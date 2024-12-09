package com.api.login.Documentos.ReporteDeAuditoria.Service;

import com.api.login.Documentos.ReporteDeAuditoria.DTO.InfoReporteAuditoriaDTO;

import java.util.List;

public interface InfoReporteAuditoriaService {

    List<InfoReporteAuditoriaDTO> findAll();

    InfoReporteAuditoriaDTO findById(Long id);

    InfoReporteAuditoriaDTO findByReporteAuditoria(Long idReporteAuditoria);

    InfoReporteAuditoriaDTO save(InfoReporteAuditoriaDTO infoReporteAuditoriaDTO);

    InfoReporteAuditoriaDTO update(Long id, InfoReporteAuditoriaDTO infoReporteAuditoriaDTO);

    void deleteById(Long id);
}
