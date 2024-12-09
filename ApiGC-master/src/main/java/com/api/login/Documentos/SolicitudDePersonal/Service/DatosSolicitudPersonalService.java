package com.api.login.Documentos.SolicitudDePersonal.Service;

import com.api.login.Documentos.SolicitudDePersonal.DTO.DatosSolicitudPersonalDTO;

import java.util.List;

public interface DatosSolicitudPersonalService {

    List<DatosSolicitudPersonalDTO> findAll();

    DatosSolicitudPersonalDTO findById(Long id);

    DatosSolicitudPersonalDTO findBySolicitudPersonal(Long idSolicitudPersonal);

    DatosSolicitudPersonalDTO save(DatosSolicitudPersonalDTO datosSolicitudPersonalDTO);

    DatosSolicitudPersonalDTO update(Long id, DatosSolicitudPersonalDTO datosSolicitudPersonalDTO);

    void deleteById(Long id);
}

