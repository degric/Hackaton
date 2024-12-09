package com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Dao;


import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Pojo.Preguntas2DNC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Preguntas2DNCRepository extends JpaRepository<Preguntas2DNC, Long> {
    List<Preguntas2DNC> findByDetecionNeCaDNC_IdDetecionNeCaDNC(Long idDetecionNeCaDNC);
}
