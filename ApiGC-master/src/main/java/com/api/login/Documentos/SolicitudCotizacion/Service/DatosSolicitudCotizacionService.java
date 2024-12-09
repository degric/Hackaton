package com.api.login.Documentos.SolicitudCotizacion.Service;

import com.api.login.Documentos.SolicitudCotizacion.DTO.CondicionesSolicitudCotizacionDTO;
import com.api.login.Documentos.SolicitudCotizacion.DTO.DatosSolicitudCotizacionDTO;
import com.api.login.Documentos.SolicitudCotizacion.pojo.CondicionesSolicitudCotizacion;
import com.api.login.Documentos.SolicitudCotizacion.pojo.DatosSolicitudCotizacion;

import java.util.List;

public interface DatosSolicitudCotizacionService {
    List<DatosSolicitudCotizacionDTO> GetAllDaSoCo();

    DatosSolicitudCotizacion createDaSoCo(DatosSolicitudCotizacionDTO dto);

    DatosSolicitudCotizacionDTO updateDaSoCo(Integer id, DatosSolicitudCotizacionDTO dto);

    void deleteDaSoCo(Integer id);

    List<DatosSolicitudCotizacionDTO> getDandiSoliCoti(Integer id);
}
