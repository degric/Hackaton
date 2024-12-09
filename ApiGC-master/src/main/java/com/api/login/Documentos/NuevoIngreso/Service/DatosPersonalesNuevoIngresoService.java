package com.api.login.Documentos.NuevoIngreso.Service;

import com.api.login.Documentos.NuevoIngreso.DTO.DatosPersonalesNuevoIngresoDTO;
import com.api.login.Documentos.NuevoIngreso.Pojo.DatosPersonalesNuevoIngreso;
import software.amazon.awssdk.services.s3.endpoints.internal.Value;

import java.util.List;

public interface DatosPersonalesNuevoIngresoService {

    List<DatosPersonalesNuevoIngresoDTO> GetAllDaPer();

    DatosPersonalesNuevoIngreso createDaPer(DatosPersonalesNuevoIngresoDTO dto);

    DatosPersonalesNuevoIngresoDTO updateDaPer(Integer id, DatosPersonalesNuevoIngresoDTO dto);

    void deleteDaPer(Integer id);

    List<DatosPersonalesNuevoIngresoDTO> getDaPerByNuevoIngreso(Integer id);
}
