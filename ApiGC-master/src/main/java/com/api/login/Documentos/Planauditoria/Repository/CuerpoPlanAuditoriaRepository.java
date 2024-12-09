package com.api.login.Documentos.Planauditoria.Repository;

import com.api.login.Documentos.Planauditoria.Pojo.CuerpoPlanAuditoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuerpoPlanAuditoriaRepository extends JpaRepository<CuerpoPlanAuditoria, Long> {
    List<CuerpoPlanAuditoria> findByPlanAuditoria_IdPlanAuditoria(Long idPlanAuditoria);
}

