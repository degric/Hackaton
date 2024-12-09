package com.api.login.Procesos.Dao;

import com.api.login.Procesos.Pojo.DesarrolloProceso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DesarrolloProcesoDao extends JpaRepository<DesarrolloProceso, Long> {

    List<DesarrolloProceso> findByEnProcesoIdEnProceso(Long id);
}

