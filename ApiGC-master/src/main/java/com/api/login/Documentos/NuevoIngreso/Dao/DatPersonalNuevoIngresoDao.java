package com.api.login.Documentos.NuevoIngreso.Dao;

import com.api.login.Documentos.NuevoIngreso.Pojo.DatPersonalNuevoIngreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DatPersonalNuevoIngresoDao extends JpaRepository<DatPersonalNuevoIngreso, Integer> {

    Optional<DatPersonalNuevoIngreso> findByNuevoIngresoIdNuevoIngreso(Integer integer);

}
