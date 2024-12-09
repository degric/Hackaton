package com.api.login.Documentos.ProgramaAuditoriasInternas.Dao;

import com.api.login.Documentos.ProgramaAuditoriasInternas.Pojo.ProgramaAuditoriasInternas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramaAuditoriasInternasDao extends JpaRepository<ProgramaAuditoriasInternas, Integer> {

}
