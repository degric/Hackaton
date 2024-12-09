package com.api.login.ManualDeCalidad.Dao;

import com.api.login.ManualDeCalidad.pojo.ManualCalidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManualCalidadDao extends JpaRepository<ManualCalidad, Long> {
}
