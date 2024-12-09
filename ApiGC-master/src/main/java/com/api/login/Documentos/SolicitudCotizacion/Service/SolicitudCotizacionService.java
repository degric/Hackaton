package com.api.login.Documentos.SolicitudCotizacion.Service;

import com.api.login.Documentos.SolicitudCotizacion.DTO.SolicitudCotizacionDTO;

import java.util.List;
import java.util.Optional;

public interface SolicitudCotizacionService {


    List<SolicitudCotizacionDTO> getAllSoCoo();

    Optional<SolicitudCotizacionDTO> getSoCo(Integer id);

    SolicitudCotizacionDTO createSoCo(SolicitudCotizacionDTO DTO);

    SolicitudCotizacionDTO updateSoCo(Integer id, SolicitudCotizacionDTO DTO);

    void deleteSoCo(Integer id);
}
