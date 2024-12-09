package com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Dao;

import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Pojo.TablaReAsisCurCapa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TablaReAsisCurCapaDao extends JpaRepository<TablaReAsisCurCapa, Long> {

    List<TablaReAsisCurCapa> findByReAsisCurCapaIdReAsisCurCapa(Long id);

}
