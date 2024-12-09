package com.api.login.Documentos.EvaluacionHabilidadesPersonal.Dao;

import com.api.login.Documentos.EvaluacionHabilidadesPersonal.Pojo.EvaluacionHabiPersonal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluacionHabiPersonalDao extends JpaRepository<EvaluacionHabiPersonal, Long> {

}
