package com.api.login.Documentos.NuevoIngreso.Service;

import com.api.login.Documentos.NuevoIngreso.DTO.DomicilioNuevoIngresoDTO;
import com.api.login.Documentos.NuevoIngreso.Pojo.DomicilioNuevoIngreso;

import java.util.List;
import java.util.Optional;

public interface DomicilioNuevoIngresoService {

    List<DomicilioNuevoIngresoDTO> getAllDoNuIn();

    DomicilioNuevoIngreso createDoNuIn(DomicilioNuevoIngresoDTO dto);

    DomicilioNuevoIngresoDTO updateDoNuIn(Integer id, DomicilioNuevoIngresoDTO dto);

    void eliminarDoNuIn(Integer id);

    List<DomicilioNuevoIngresoDTO> getByIdNuevoIngreso(Integer id);
}
