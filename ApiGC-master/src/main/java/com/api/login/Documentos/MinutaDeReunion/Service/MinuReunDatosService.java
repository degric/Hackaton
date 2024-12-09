package com.api.login.Documentos.MinutaDeReunion.Service;

import com.api.login.Documentos.MinutaDeReunion.DTO.MinuReunDatosDTO;

import java.util.List;

public interface MinuReunDatosService {

    List<MinuReunDatosDTO> findAll();

    MinuReunDatosDTO findById(Long id);

    List<MinuReunDatosDTO> findByMinutaReunion(Long idMinutaReunion);

    MinuReunDatosDTO save(MinuReunDatosDTO minuReunDatosDTO);

    MinuReunDatosDTO update(Long id, MinuReunDatosDTO minuReunDatosDTO);

    void deleteById(Long id);
}
