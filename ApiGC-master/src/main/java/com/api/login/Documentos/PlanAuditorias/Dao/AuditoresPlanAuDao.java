package com.api.login.Documentos.PlanAuditorias.Dao;

import com.api.login.Documentos.PlanAuditorias.Pojo.AuditoresPlanAu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuditoresPlanAuDao extends JpaRepository<AuditoresPlanAu, Long> {

    List<AuditoresPlanAu> findByPlanAuditoriasIdPlanAuditorias(Long id);

}

