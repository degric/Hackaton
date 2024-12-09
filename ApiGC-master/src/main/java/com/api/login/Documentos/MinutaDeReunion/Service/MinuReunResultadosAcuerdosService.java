package com.api.login.Documentos.MinutaDeReunion.Service;

import com.api.login.Documentos.MinutaDeReunion.DTO.MinuReunResultadosAcuerdosDTO;

import java.util.List;

public interface MinuReunResultadosAcuerdosService {

    List<MinuReunResultadosAcuerdosDTO> findAll();

    MinuReunResultadosAcuerdosDTO findById(Long id);

    List<MinuReunResultadosAcuerdosDTO> findByMinutaReunion(Long idMinutaReunion);

    MinuReunResultadosAcuerdosDTO save(MinuReunResultadosAcuerdosDTO minuReunResultadosAcuerdosDTO);

    MinuReunResultadosAcuerdosDTO update(Long id, MinuReunResultadosAcuerdosDTO minuReunResultadosAcuerdosDTO);

    void deleteById(Long id);
}

