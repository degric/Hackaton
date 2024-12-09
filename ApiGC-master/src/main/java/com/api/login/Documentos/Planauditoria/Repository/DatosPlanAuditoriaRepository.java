package com.api.login.Documentos.Planauditoria.Repository;

import com.api.login.Documentos.Planauditoria.Pojo.DatosPlanAuditoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DatosPlanAuditoriaRepository extends JpaRepository<DatosPlanAuditoria, Long> {
    List<DatosPlanAuditoria> findByPlanAuditoria_IdPlanAuditoria(Long idPlanAuditoria);
}
