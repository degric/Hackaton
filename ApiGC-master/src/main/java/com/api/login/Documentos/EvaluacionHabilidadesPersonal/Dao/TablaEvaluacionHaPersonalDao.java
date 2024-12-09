package com.api.login.Documentos.EvaluacionHabilidadesPersonal.Dao;

import com.api.login.Documentos.EvaluacionHabilidadesPersonal.Pojo.TablaEvaluacionHaPersonal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TablaEvaluacionHaPersonalDao extends JpaRepository<TablaEvaluacionHaPersonal, Long> {
    List<TablaEvaluacionHaPersonal> findByEvaluacionHabiPersonalIdEvaluacionHabiPersonal(Long id);
}

