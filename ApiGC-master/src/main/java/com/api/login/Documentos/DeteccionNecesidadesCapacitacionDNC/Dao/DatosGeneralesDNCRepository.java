package com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Dao;

import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Pojo.DatosGeneralesDNC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DatosGeneralesDNCRepository extends JpaRepository<DatosGeneralesDNC, Long> {
    Optional<DatosGeneralesDNC> findByDetecionNeCaDNC_IdDetecionNeCaDNC(Long idDetecionNeCaDNC);
}

