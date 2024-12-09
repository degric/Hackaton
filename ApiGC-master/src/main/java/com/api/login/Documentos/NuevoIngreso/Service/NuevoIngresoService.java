package com.api.login.Documentos.NuevoIngreso.Service;

import com.api.login.Documentos.NuevoIngreso.DTO.NuevoIngresoDTO;

import java.util.List;
import java.util.Optional;

public interface NuevoIngresoService {

    List<NuevoIngresoDTO> getAllNuIn();

    Optional<NuevoIngresoDTO> getByIdNuIn(Integer id);

    NuevoIngresoDTO createNuIn(NuevoIngresoDTO dto);

    NuevoIngresoDTO updateNuIn(Integer id, NuevoIngresoDTO dto);

    void deleteNuIn(Integer id);
}
