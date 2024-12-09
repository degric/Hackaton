package com.api.login.Documentos.AnalisisFoda.Repository;

import com.api.login.Documentos.AnalisisFoda.Pojo.ParticipantesAnalisisFoda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ParticipantesAnalisisFodaRepository extends JpaRepository<ParticipantesAnalisisFoda, Long> {
    List<ParticipantesAnalisisFoda> findByAnalisisFoda_IdAnalisisFoda(Long idAnalisisFoda);  // Método para buscar por idAnalisisFoda
}

