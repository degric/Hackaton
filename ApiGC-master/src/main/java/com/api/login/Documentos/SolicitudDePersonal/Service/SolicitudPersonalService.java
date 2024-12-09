package com.api.login.Documentos.SolicitudDePersonal.Service;

import com.api.login.Documentos.SolicitudDePersonal.DTO.SolicitudPersonalDTO;
import com.lowagie.text.DocumentException;

import java.util.List;

public interface SolicitudPersonalService {

    List<SolicitudPersonalDTO> findAll();

    SolicitudPersonalDTO findById(Long id);

    SolicitudPersonalDTO save(SolicitudPersonalDTO solicitudPersonalDTO);

    SolicitudPersonalDTO update(Long id, SolicitudPersonalDTO solicitudPersonalDTO);

    void deleteById(Long id);

    byte[] generarPdf(Long id) throws DocumentException;
}

