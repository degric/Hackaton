package com.api.login.Documentos.NuevoIngreso.Dao;

import com.api.login.Documentos.NuevoIngreso.Pojo.DomicilioNuevoIngreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DomicilioNuevoIngresoDao extends JpaRepository<DomicilioNuevoIngreso, Integer> {
    Optional<DomicilioNuevoIngreso> findByNuevoIngresoIdNuevoIngreso(Integer integer);
}
