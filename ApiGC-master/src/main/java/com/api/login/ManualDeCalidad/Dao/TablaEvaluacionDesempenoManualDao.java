package com.api.login.ManualDeCalidad.Dao;

import com.api.login.ManualDeCalidad.pojo.TablaEvaluacionDesempenoManual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TablaEvaluacionDesempenoManualDao extends JpaRepository<TablaEvaluacionDesempenoManual, Long> {
    List<TablaEvaluacionDesempenoManual> findByManualCalidadIdManualCalidad(Long idManualCalidad);
}

