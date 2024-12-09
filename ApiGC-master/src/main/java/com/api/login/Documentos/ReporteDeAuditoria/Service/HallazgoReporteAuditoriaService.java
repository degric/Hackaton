package com.api.login.Documentos.ReporteDeAuditoria.Service;

import com.api.login.Documentos.ReporteDeAuditoria.DTO.HallazgoReporteAuditoriaDTO;

import java.util.List;

public interface HallazgoReporteAuditoriaService {

    List<HallazgoReporteAuditoriaDTO> findAll();

    HallazgoReporteAuditoriaDTO findById(Long id);

    List<HallazgoReporteAuditoriaDTO> findByReporteAuditoria(Long idReporteAuditoria);

    HallazgoReporteAuditoriaDTO save(HallazgoReporteAuditoriaDTO hallazgoDTO);

    HallazgoReporteAuditoriaDTO update(Long id, HallazgoReporteAuditoriaDTO hallazgoDTO);

    void deleteById(Long id);
}

