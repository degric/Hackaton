package com.api.login.ManualDeCalidad.Dao;

import com.api.login.ManualDeCalidad.pojo.MejoraManual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MejoraManualDao extends JpaRepository<MejoraManual, Long> {
    List<MejoraManual> findByManualCalidadIdManualCalidad(Long idManualCalidad);
}
