package com.api.login.Procesos.Dao;

import com.api.login.Procesos.Pojo.DistribucionProceso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DistribucionProcesoDao extends JpaRepository<DistribucionProceso, Long> {

    Optional<DistribucionProceso> findByEnProcesoIdEnProceso(Long id);
}

