package com.api.login.ManualDeCalidad.Dao;

import com.api.login.ManualDeCalidad.pojo.PlanificacionManual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PlanificacionManualDao extends JpaRepository<PlanificacionManual, Long> {
    List<PlanificacionManual> findByManualCalidadIdManualCalidad(Long idManualCalidad);
}

