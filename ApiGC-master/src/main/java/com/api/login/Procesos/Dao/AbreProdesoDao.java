package com.api.login.Procesos.Dao;

import com.api.login.Procesos.Pojo.AbreProdeso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbreProdesoDao extends JpaRepository<AbreProdeso,Long> {
    List<AbreProdeso> findByEnProcesoIdEnProceso(Long id);

}
