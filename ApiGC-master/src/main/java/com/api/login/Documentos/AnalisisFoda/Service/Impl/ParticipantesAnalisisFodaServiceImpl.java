package com.api.login.Documentos.AnalisisFoda.Service.Impl;

import com.api.login.Documentos.AnalisisFoda.Pojo.ParticipantesAnalisisFoda;
import com.api.login.Documentos.AnalisisFoda.Repository.ParticipantesAnalisisFodaRepository;
import com.api.login.Documentos.AnalisisFoda.Service.ParticipantesAnalisisFodaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ParticipantesAnalisisFodaServiceImpl implements ParticipantesAnalisisFodaService {

    @Autowired
    private ParticipantesAnalisisFodaRepository participantesAnalisisFodaRepository;

    @Override
    public List<ParticipantesAnalisisFoda> findAll() {
        return participantesAnalisisFodaRepository.findAll();
    }

    @Override
    public List<ParticipantesAnalisisFoda> findByAnalisisFodaId(Long idAnalisisFoda) {
        return participantesAnalisisFodaRepository.findByAnalisisFoda_IdAnalisisFoda(idAnalisisFoda);
    }

    @Override
    public ParticipantesAnalisisFoda findById(Long id) {
        Optional<ParticipantesAnalisisFoda> optional = participantesAnalisisFodaRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public ParticipantesAnalisisFoda save(ParticipantesAnalisisFoda participantesAnalisisFoda) {
        return participantesAnalisisFodaRepository.save(participantesAnalisisFoda);
    }

    @Override
    public ParticipantesAnalisisFoda update(Long id, ParticipantesAnalisisFoda participantesAnalisisFoda) {
        Optional<ParticipantesAnalisisFoda> optional = participantesAnalisisFodaRepository.findById(id);
        if (optional.isPresent()) {
            participantesAnalisisFoda.setIdParticipantesAnalisisFoda(id);
            return participantesAnalisisFodaRepository.save(participantesAnalisisFoda);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        participantesAnalisisFodaRepository.deleteById(id);
    }
}

