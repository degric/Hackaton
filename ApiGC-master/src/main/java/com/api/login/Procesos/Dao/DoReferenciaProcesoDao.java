package com.api.login.Procesos.Dao;

import com.api.login.Procesos.Pojo.DoReferenciaProceso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DoReferenciaProcesoDao extends JpaRepository<DoReferenciaProceso, Long> {

    List<DoReferenciaProceso> findByEnProcesoIdEnProceso(Long id);
}

