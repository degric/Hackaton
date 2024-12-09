package com.api.login.ManualDeCalidad.Dao;

import com.api.login.ManualDeCalidad.pojo.OperacionManual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OperacionManualDao extends JpaRepository<OperacionManual, Long> {
    List<OperacionManual> findByManualCalidadIdManualCalidad(Long idManualCalidad);
}

