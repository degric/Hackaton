package com.api.login.Documentos.ReporteDeAuditoria.Repository;

import com.api.login.Documentos.ReporteDeAuditoria.Pojo.ReporteAuditoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReporteAuditoriaRepository extends JpaRepository<ReporteAuditoria, Long> {
}

