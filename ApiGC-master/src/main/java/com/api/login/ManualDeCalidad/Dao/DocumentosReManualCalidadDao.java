package com.api.login.ManualDeCalidad.Dao;

import com.api.login.ManualDeCalidad.pojo.DocumentosReManualCalidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentosReManualCalidadDao extends JpaRepository<DocumentosReManualCalidad, Long> {

    List<DocumentosReManualCalidad> findByManualCalidadIdManualCalidad(Long id);
}

