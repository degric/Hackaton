package com.api.login.Documentos.Planauditoria.Repository;

import com.api.login.Documentos.Planauditoria.Pojo.PlanAuditoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanAuditoriaRepository extends JpaRepository<PlanAuditoria, Long> {
}
