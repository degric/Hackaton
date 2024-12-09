package com.api.login.Procesos.Dao;

import com.api.login.ManualDeCalidad.pojo.LiderazgoManual;
import com.api.login.Procesos.Pojo.SubClausulasProceso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubClausulasProcesoDao extends JpaRepository<SubClausulasProceso, Long> {

    List<SubClausulasProceso> findByDesarrolloProcesoIdDesarrolloProceso(Long id);
}
