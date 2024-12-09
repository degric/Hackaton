package com.api.login.Documentos.ReporteDeAuditoria.Repository;

import com.api.login.Documentos.ReporteDeAuditoria.Pojo.InfoReporteAuditoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InfoReporteAuditoriaRepository extends JpaRepository<InfoReporteAuditoria, Long> {
    Optional<InfoReporteAuditoria> findByReporteAuditoria_IdReporteAuditoria(Long idReporteAuditoria);
}

