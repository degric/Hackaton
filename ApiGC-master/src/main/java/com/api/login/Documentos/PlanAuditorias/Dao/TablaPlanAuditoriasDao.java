package com.api.login.Documentos.PlanAuditorias.Dao;

import com.api.login.Documentos.PlanAuditorias.Pojo.TablaPlanAuditorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TablaPlanAuditoriasDao extends JpaRepository<TablaPlanAuditorias, Long> {

    List<TablaPlanAuditorias> findByPlanAuditoriasIdPlanAuditorias(Long id);

}
