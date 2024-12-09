package com.api.login.Documentos.NuevoIngreso.Dao;

import com.api.login.Documentos.NuevoIngreso.Pojo.TraAnNuevoIngreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TraAnNuevoIngresoDao extends JpaRepository<TraAnNuevoIngreso, Integer> {
    List<TraAnNuevoIngreso> findByNuevoIngresoIdNuevoIngreso(Integer integer);
}
