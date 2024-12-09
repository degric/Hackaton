package com.api.login.ManualDeCalidad.Dao;

import com.api.login.ManualDeCalidad.pojo.NormasReferenciaManual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NormasReferenciaManualDao extends JpaRepository<NormasReferenciaManual, Long> {
    List<NormasReferenciaManual> findByManualCalidadIdManualCalidad(Long idManualCalidad);
}

