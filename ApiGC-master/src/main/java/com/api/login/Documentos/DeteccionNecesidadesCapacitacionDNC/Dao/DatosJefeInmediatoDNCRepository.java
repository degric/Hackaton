package com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Dao;

import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Pojo.DatosJefeInmediatoDNC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DatosJefeInmediatoDNCRepository extends JpaRepository<DatosJefeInmediatoDNC, Long> {
    Optional<DatosJefeInmediatoDNC> findByDetecionNeCaDNC_IdDetecionNeCaDNC(Long idDetecionNeCaDNC);
}