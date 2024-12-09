package com.api.login.Procesos.Dao;

import com.api.login.Procesos.Pojo.SubSubClausulasProceso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubSubClausulasProcesoDao extends JpaRepository<SubSubClausulasProceso, Long> {
    List<SubSubClausulasProceso> findBySubClausulasProcesoIdSubClausulasProceso(Long id);
}