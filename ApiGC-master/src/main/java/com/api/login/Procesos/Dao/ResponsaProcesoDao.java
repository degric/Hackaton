package com.api.login.Procesos.Dao;

import com.api.login.Procesos.Pojo.ResponsaProceso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResponsaProcesoDao extends JpaRepository<ResponsaProceso, Long> {

    List<ResponsaProceso> findByEnProcesoIdEnProceso(Long id);
}
