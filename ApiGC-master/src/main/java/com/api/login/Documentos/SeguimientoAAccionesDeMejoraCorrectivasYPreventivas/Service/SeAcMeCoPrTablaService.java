package com.api.login.Documentos.SeguimientoAAccionesDeMejoraCorrectivasYPreventivas.Service;

import com.api.login.Documentos.SeguimientoAAccionesDeMejoraCorrectivasYPreventivas.DTO.SeAcMeCoPrTablaDTO;

import java.util.List;

public interface SeAcMeCoPrTablaService {

    List<SeAcMeCoPrTablaDTO> findAll();

    SeAcMeCoPrTablaDTO findById(Long id);

    List<SeAcMeCoPrTablaDTO> findBySeguiAccioMejoCorrePrev(Long idSeguiAccioMejoCorrePrev);

    SeAcMeCoPrTablaDTO save(SeAcMeCoPrTablaDTO seAcMeCoPrTablaDTO);

    SeAcMeCoPrTablaDTO update(Long id, SeAcMeCoPrTablaDTO seAcMeCoPrTablaDTO);

    void deleteById(Long id);
}

