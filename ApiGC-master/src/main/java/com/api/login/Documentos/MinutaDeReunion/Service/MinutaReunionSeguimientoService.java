package com.api.login.Documentos.MinutaDeReunion.Service;

import com.api.login.Documentos.MinutaDeReunion.DTO.MinutaReunionSeguimientoDTO;

import java.util.List;

public interface MinutaReunionSeguimientoService {

    List<MinutaReunionSeguimientoDTO> findAll();

    MinutaReunionSeguimientoDTO findById(Long id);

    List<MinutaReunionSeguimientoDTO> findByMinutaReunion(Long idMinutaReunion);

    MinutaReunionSeguimientoDTO save(MinutaReunionSeguimientoDTO minutaReunionSeguimientoDTO);

    MinutaReunionSeguimientoDTO update(Long id, MinutaReunionSeguimientoDTO minutaReunionSeguimientoDTO);

    void deleteById(Long id);
}
