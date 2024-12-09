package com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Dao;

import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Pojo.Pregunta1DNC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Pregunta1DNCRepository extends JpaRepository<Pregunta1DNC, Long> {
    List<Pregunta1DNC> findByDetecionNeCaDNC_IdDetecionNeCaDNC(Long idDetecionNeCaDNC);
}
