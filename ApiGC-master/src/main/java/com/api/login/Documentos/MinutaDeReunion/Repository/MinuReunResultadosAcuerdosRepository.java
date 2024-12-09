package com.api.login.Documentos.MinutaDeReunion.Repository;

import com.api.login.Documentos.MinutaDeReunion.Pojo.MinuReunResultadosAcuerdos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MinuReunResultadosAcuerdosRepository extends JpaRepository<MinuReunResultadosAcuerdos, Long> {
    List<MinuReunResultadosAcuerdos> findByMinutaReunion_IdMinutaReunion(Long idMinutaReunion);
}

