package com.api.login.ManualDeCalidad.Dao;

import com.api.login.ManualDeCalidad.pojo.ContextoOrganizacionManual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ContextoOrganizacionManualDao extends JpaRepository<ContextoOrganizacionManual, Long> {

    List<ContextoOrganizacionManual> findByManualCalidadIdManualCalidad(Long idManualCalidad);

}

