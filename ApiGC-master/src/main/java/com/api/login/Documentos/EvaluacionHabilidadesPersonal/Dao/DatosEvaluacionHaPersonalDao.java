package com.api.login.Documentos.EvaluacionHabilidadesPersonal.Dao;

import com.api.login.Documentos.EvaluacionHabilidadesPersonal.Pojo.DatosEvaluacionHaPersonal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DatosEvaluacionHaPersonalDao extends JpaRepository<DatosEvaluacionHaPersonal, Long> {

    Optional<DatosEvaluacionHaPersonal> findByEvaluacionHabiPersonalIdEvaluacionHabiPersonal(Long id);
}
