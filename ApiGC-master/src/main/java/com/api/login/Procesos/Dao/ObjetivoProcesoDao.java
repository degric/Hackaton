package com.api.login.Procesos.Dao;

import com.api.login.Procesos.Pojo.ObjetivoProceso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ObjetivoProcesoDao extends JpaRepository<ObjetivoProceso, Long> {

    Optional<ObjetivoProceso> findByEnProcesoIdEnProceso(Long id);
}
