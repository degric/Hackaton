package com.api.login.Documentos.PlanAuditorias.Dao;

import com.api.login.Documentos.PlanAuditorias.Pojo.ContenidoPlanAuditorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContenidoPlanAuditoriasDao extends JpaRepository<ContenidoPlanAuditorias, Long> {

    Optional<ContenidoPlanAuditorias> findByPlanAuditoriasIdPlanAuditorias(Long id);

}
