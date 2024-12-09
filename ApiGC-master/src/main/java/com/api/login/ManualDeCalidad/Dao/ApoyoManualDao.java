package com.api.login.ManualDeCalidad.Dao;

import com.api.login.ManualDeCalidad.pojo.ApoyoManual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ApoyoManualDao extends JpaRepository<ApoyoManual, Long> {
    List<ApoyoManual> findByManualCalidadIdManualCalidad(Long idManualCalidad);
    
}

