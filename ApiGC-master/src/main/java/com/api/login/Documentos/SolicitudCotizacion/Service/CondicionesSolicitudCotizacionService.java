package com.api.login.Documentos.SolicitudCotizacion.Service;

import com.api.login.Documentos.SolicitudCotizacion.DTO.CondicionesSolicitudCotizacionDTO;
import com.api.login.Documentos.SolicitudCotizacion.pojo.CondicionesSolicitudCotizacion;

import java.util.List;

public interface CondicionesSolicitudCotizacionService {
    List<CondicionesSolicitudCotizacionDTO> GetAllCoSoCo();

    CondicionesSolicitudCotizacion createCoSoCo(CondicionesSolicitudCotizacionDTO dto);

    CondicionesSolicitudCotizacionDTO updateCoSoCo(Integer id, CondicionesSolicitudCotizacionDTO dto);

    void deleteCoSoCo(Integer id);

    List<CondicionesSolicitudCotizacionDTO> getCondiSoliCoti(Integer id);
}
