package com.api.login.dao;

import com.api.login.pojo.PolCalidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface PolCalidadDao extends JpaRepository<PolCalidad, Integer> {
    List<PolCalidad> getAllPolCalidad();

    Optional<PolCalidad> findByFecha(Date fecha);


}
