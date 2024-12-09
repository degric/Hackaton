package com.api.login.Procesos.Dao;

import com.api.login.Procesos.Pojo.AlcanceProceso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlcanceProcesoDao extends JpaRepository<AlcanceProceso, Long> {

    Optional<AlcanceProceso> findByEnProcesoIdEnProceso(Long id);
}
