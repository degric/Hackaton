package com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Service;

import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.DTO.InformacionReAsisCurCapaDTO;

import java.util.List;
import java.util.Optional;

public interface InformacionReAsisCurCapaService {

    List<InformacionReAsisCurCapaDTO> getAllInReAs();

    InformacionReAsisCurCapaDTO createInReAs(InformacionReAsisCurCapaDTO dto);

    InformacionReAsisCurCapaDTO updateInReAs(Long id, InformacionReAsisCurCapaDTO dto);

    void deleteInReAs(Long id);

    Optional<InformacionReAsisCurCapaDTO> findByIdEncabezado(Long id);

}
