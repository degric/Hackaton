package com.api.login.Documentos.NuevoIngreso.Dao;

import com.api.login.Documentos.NuevoIngreso.Pojo.NuevoIngreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NuevoIngresoDao extends JpaRepository<NuevoIngreso, Integer> {
}
