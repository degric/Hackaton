package com.api.login.Documentos.MinutaDeReunion.Service;

import com.api.login.Documentos.MinutaDeReunion.DTO.MinuReunPuntosTratarDTO;

import java.util.List;

public interface MinuReunPuntosTratarService {

    List<MinuReunPuntosTratarDTO> findAll();

    MinuReunPuntosTratarDTO findById(Long id);

    List<MinuReunPuntosTratarDTO> findByMinutaReunion(Long idMinutaReunion);

    MinuReunPuntosTratarDTO save(MinuReunPuntosTratarDTO minuReunPuntosTratarDTO);

    MinuReunPuntosTratarDTO update(Long id, MinuReunPuntosTratarDTO minuReunPuntosTratarDTO);

    void deleteById(Long id);
}

