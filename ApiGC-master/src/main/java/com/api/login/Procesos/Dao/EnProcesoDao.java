package com.api.login.Procesos.Dao;

import com.api.login.Procesos.DTO.EnProcesoDTOSinListas;
import com.api.login.Procesos.Pojo.EnProceso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnProcesoDao extends JpaRepository<EnProceso, Long> {

    List<EnProceso> findAllByNombreProcesoIgnoreCase(String nombre);


}
