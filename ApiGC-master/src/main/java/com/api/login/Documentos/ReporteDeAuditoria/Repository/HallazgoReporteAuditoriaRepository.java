package com.api.login.Documentos.ReporteDeAuditoria.Repository;

import com.api.login.Documentos.ReporteDeAuditoria.Pojo.HallazgoReporteAuditoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HallazgoReporteAuditoriaRepository extends JpaRepository<HallazgoReporteAuditoria, Long> {
    List<HallazgoReporteAuditoria> findByReporteAuditoria_IdReporteAuditoria(Long idReporteAuditoria);
}

