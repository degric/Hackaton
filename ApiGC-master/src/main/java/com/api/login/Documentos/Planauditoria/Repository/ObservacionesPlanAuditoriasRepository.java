package com.api.login.Documentos.Planauditoria.Repository;

import com.api.login.Documentos.Planauditoria.Pojo.ObservacionesPlanAuditorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObservacionesPlanAuditoriasRepository extends JpaRepository<ObservacionesPlanAuditorias, Long> {
    List<ObservacionesPlanAuditorias> findByPlanAuditoria_IdPlanAuditoria(Long idPlanAuditoria);
}

