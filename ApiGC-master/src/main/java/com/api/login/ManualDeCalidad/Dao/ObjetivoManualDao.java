package com.api.login.ManualDeCalidad.Dao;

import com.api.login.ManualDeCalidad.pojo.ObjetivoManual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ObjetivoManualDao extends JpaRepository<ObjetivoManual, Long> {
    List<ObjetivoManual> findByManualCalidadIdManualCalidad(Long idManualCalidad);
}
