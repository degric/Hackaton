package com.api.login.Documentos.AnalisisFoda.Service;

import com.api.login.Documentos.AnalisisFoda.Pojo.ParticipantesAnalisisFoda;

import java.util.List;

public interface ParticipantesAnalisisFodaService {

    List<ParticipantesAnalisisFoda> findAll();

    List<ParticipantesAnalisisFoda> findByAnalisisFodaId(Long idAnalisisFoda);

    ParticipantesAnalisisFoda findById(Long id);

    ParticipantesAnalisisFoda save(ParticipantesAnalisisFoda participantesAnalisisFoda);

    ParticipantesAnalisisFoda update(Long id, ParticipantesAnalisisFoda participantesAnalisisFoda);

    void deleteById(Long id);
}

