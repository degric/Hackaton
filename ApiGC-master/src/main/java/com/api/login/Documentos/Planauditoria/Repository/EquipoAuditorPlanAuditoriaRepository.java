package com.api.login.Documentos.Planauditoria.Repository;

import com.api.login.Documentos.Planauditoria.Pojo.EquipoAuditorPlanAuditoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipoAuditorPlanAuditoriaRepository extends JpaRepository<EquipoAuditorPlanAuditoria, Long> {
    List<EquipoAuditorPlanAuditoria> findByPlanAuditoria_IdPlanAuditoria(Long idPlanAuditoria);
}

