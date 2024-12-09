package com.api.login.Documentos.PlanAuditorias.Dao;

import com.api.login.Documentos.PlanAuditorias.Pojo.PlanAuditorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanAuditoriasDao extends JpaRepository<PlanAuditorias, Long> {

}
