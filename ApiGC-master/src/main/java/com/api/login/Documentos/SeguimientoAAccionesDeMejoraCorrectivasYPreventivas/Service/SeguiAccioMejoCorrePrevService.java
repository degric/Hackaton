package com.api.login.Documentos.SeguimientoAAccionesDeMejoraCorrectivasYPreventivas.Service;

import com.api.login.Documentos.SeguimientoAAccionesDeMejoraCorrectivasYPreventivas.DTO.SeguiAccioMejoCorrePrevDTO;
import com.lowagie.text.DocumentException;

import java.util.List;

public interface SeguiAccioMejoCorrePrevService {

    List<SeguiAccioMejoCorrePrevDTO> findAll();

    SeguiAccioMejoCorrePrevDTO findById(Long id);

    SeguiAccioMejoCorrePrevDTO save(SeguiAccioMejoCorrePrevDTO seguiAccioMejoCorrePrevDTO);

    SeguiAccioMejoCorrePrevDTO update(Long id, SeguiAccioMejoCorrePrevDTO seguiAccioMejoCorrePrevDTO);

    void deleteById(Long id);

    public byte[] generarReportePdf(Long id) throws DocumentException;
}

