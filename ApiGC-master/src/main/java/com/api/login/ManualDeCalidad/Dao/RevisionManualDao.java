package com.api.login.ManualDeCalidad.Dao;

import com.api.login.ManualDeCalidad.pojo.RevisionManual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RevisionManualDao extends JpaRepository<RevisionManual, Long> {
    List<RevisionManual> findByManualCalidadIdManualCalidad(Long idManualCalidad);
}

