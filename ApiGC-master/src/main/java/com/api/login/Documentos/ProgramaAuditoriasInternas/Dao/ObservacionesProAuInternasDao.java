package com.api.login.Documentos.ProgramaAuditoriasInternas.Dao;

import com.api.login.Documentos.ProgramaAuditoriasInternas.Pojo.ObservacionesProAuInternas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ObservacionesProAuInternasDao extends JpaRepository<ObservacionesProAuInternas, Integer> {
    Optional<ObservacionesProAuInternas> findByProgramaAuditoriasInternasIdProgramaAuditoriasInternas(Integer id);
}
