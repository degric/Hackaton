package com.api.login.Procesos.Dao;

import com.api.login.Procesos.Pojo.HisRevisionesProceso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HisRevisionesProcesoDao extends JpaRepository<HisRevisionesProceso, Long> {

    List<HisRevisionesProceso> findByEnProcesoIdEnProceso(Long id);
}


