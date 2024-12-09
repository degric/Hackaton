package com.api.login.Procesos.Dao;

import com.api.login.ManualDeCalidad.pojo.DocumentosReManualCalidad;
import com.api.login.Procesos.Pojo.DocumentosReProcesos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentosReProcesosDao extends JpaRepository<DocumentosReProcesos, Long> {

    List<DocumentosReProcesos> findByEnProcesoIdEnProceso(Long id);

    List<DocumentosReProcesos> findByNivelPunto(Long id);

    List<DocumentosReProcesos> findByIdSubpunto(Long id);
}

