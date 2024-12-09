package com.api.login.Documentos.ReporteDeAuditoria.Repository;

import com.api.login.Documentos.ReporteDeAuditoria.Pojo.CierreReporteAuditoria2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CierreReporteAuditoria2Repository extends JpaRepository<CierreReporteAuditoria2, Long> {
    List<CierreReporteAuditoria2> findByReporteAuditoria_IdReporteAuditoria(Long idReporteAuditoria);
}

