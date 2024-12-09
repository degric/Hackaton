package com.api.login.Documentos.MinutaDeReunion.Service;

import com.api.login.Documentos.MinutaDeReunion.DTO.MinuReunParticipantesDTO;

import java.util.List;

public interface MinuReunParticipantesService {

    List<MinuReunParticipantesDTO> findAll();

    MinuReunParticipantesDTO findById(Long id);

    List<MinuReunParticipantesDTO> findByMinutaReunion(Long idMinutaReunion);

    MinuReunParticipantesDTO save(MinuReunParticipantesDTO minuReunParticipantesDTO);

    MinuReunParticipantesDTO update(Long id, MinuReunParticipantesDTO minuReunParticipantesDTO);

    void deleteById(Long id);
}

