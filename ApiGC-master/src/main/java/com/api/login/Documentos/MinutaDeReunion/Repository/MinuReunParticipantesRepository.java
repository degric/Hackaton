package com.api.login.Documentos.MinutaDeReunion.Repository;

import com.api.login.Documentos.MinutaDeReunion.Pojo.MinuReunParticipantes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MinuReunParticipantesRepository extends JpaRepository<MinuReunParticipantes, Long> {
    List<MinuReunParticipantes> findByMinutaReunion_IdMinutaReunion(Long idMinutaReunion);
}

