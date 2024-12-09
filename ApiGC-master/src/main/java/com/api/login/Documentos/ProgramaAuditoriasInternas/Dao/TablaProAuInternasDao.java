package com.api.login.Documentos.ProgramaAuditoriasInternas.Dao;

import com.api.login.Documentos.ProgramaAuditoriasInternas.Pojo.TablaProAuInternas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TablaProAuInternasDao extends JpaRepository<TablaProAuInternas, Integer> {

    List<TablaProAuInternas> findByProgramaAuditoriasInternasIdProgramaAuditoriasInternas(Integer id);

}
