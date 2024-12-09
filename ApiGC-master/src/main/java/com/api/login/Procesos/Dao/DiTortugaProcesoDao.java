package com.api.login.Procesos.Dao;

import com.api.login.Procesos.Pojo.DiTortugaProceso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiTortugaProcesoDao extends JpaRepository<DiTortugaProceso, Long> {

    List<DiTortugaProceso> findByEnProcesoIdEnProceso(Long id);
}

