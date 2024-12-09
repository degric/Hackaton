package com.api.login.Documentos.MinutaDeReunion.Service;

import com.api.login.Documentos.MinutaDeReunion.DTO.MinutaReunionDTO;
import com.lowagie.text.DocumentException;

import java.util.List;

public interface MinutaReunionService {

    List<MinutaReunionDTO> findAll();

    MinutaReunionDTO findById(Long id);

    MinutaReunionDTO save(MinutaReunionDTO minutaReunionDTO);

    MinutaReunionDTO update(Long id, MinutaReunionDTO minutaReunionDTO);

    void deleteById(Long id);

    byte[] generarMinutaPdf(Long id) throws DocumentException;
}

