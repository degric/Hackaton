package com.api.login.ManualDeCalidad.Dao;

import com.api.login.ManualDeCalidad.pojo.EvaluacionDesemManual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EvaluacionDesemManualDao extends JpaRepository<EvaluacionDesemManual, Long> {
    List<EvaluacionDesemManual> findByManualCalidadIdManualCalidad(Long idManualCalidad);
}

