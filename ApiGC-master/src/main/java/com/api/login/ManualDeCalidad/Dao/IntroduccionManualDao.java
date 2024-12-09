package com.api.login.ManualDeCalidad.Dao;

import com.api.login.ManualDeCalidad.pojo.IntroduccionManual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IntroduccionManualDao extends JpaRepository<IntroduccionManual, Long> {

    List<IntroduccionManual> findByManualCalidadIdManualCalidad(Long idManualCalidad);
}
