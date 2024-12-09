package com.api.login.Documentos.MinutaDeReunion.Repository;

import com.api.login.Documentos.MinutaDeReunion.Pojo.MinutaReunionSeguimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MinutaReunionSeguimientoRepository extends JpaRepository<MinutaReunionSeguimiento, Long> {
    List<MinutaReunionSeguimiento> findByMinutaReunion_IdMinutaReunion(Long idMinutaReunion);
}

