package com.api.login.Documentos.MejoraContinua.Repository;

import com.api.login.Documentos.MejoraContinua.Pojo.EvaluacionEficienciaMejoraContinua;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EvaluacionEficienciaMejoraContinuaRepository extends JpaRepository<EvaluacionEficienciaMejoraContinua, Long> {
    Optional<EvaluacionEficienciaMejoraContinua> findByMejoraContinua_IdMejoraContinua(Long idMejoraContinua);
}
