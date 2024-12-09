package com.api.login.Documentos.NuevoIngreso.Service;

import com.api.login.Documentos.NuevoIngreso.DTO.TraAnNuevoIngresoDTO;
import com.api.login.Documentos.NuevoIngreso.Pojo.TraAnNuevoIngreso;
import software.amazon.awssdk.services.s3.endpoints.internal.Value;

import java.util.List;

public interface TraAnNuevoIngresoService {

    List<TraAnNuevoIngresoDTO> getAllTraNuIn();

    TraAnNuevoIngreso createTraNuIn(TraAnNuevoIngresoDTO dto);

    TraAnNuevoIngresoDTO updateTraNuIn(Integer id, TraAnNuevoIngresoDTO dto);

    void deleteTraNuIn(Integer id);

    List<TraAnNuevoIngresoDTO> getTraByNuIn(Integer id);

}
