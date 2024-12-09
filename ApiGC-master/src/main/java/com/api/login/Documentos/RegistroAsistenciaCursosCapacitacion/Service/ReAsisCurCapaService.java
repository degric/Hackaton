package com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Service;

import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.DTO.ReAsisCurCapaDTO;

import java.util.List;
import java.util.Optional;

public interface ReAsisCurCapaService {

    List<ReAsisCurCapaDTO> getAllReAsCur();

    Optional<ReAsisCurCapaDTO> getById(Long id);

    ReAsisCurCapaDTO createReAsCur(ReAsisCurCapaDTO dto);

    ReAsisCurCapaDTO updateReAsCur(Long id, ReAsisCurCapaDTO dto);

    void deleteReAsCur(Long id);

}
