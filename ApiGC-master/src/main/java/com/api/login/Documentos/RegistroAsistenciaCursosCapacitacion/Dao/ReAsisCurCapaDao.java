package com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Dao;

import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Pojo.ReAsisCurCapa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReAsisCurCapaDao extends JpaRepository<ReAsisCurCapa, Long> {
}
