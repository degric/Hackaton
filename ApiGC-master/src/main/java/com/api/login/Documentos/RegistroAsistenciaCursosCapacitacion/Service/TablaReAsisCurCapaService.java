package com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Service;

import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.DTO.TablaReAsisCurCapaDTO;

import java.util.List;

public interface TablaReAsisCurCapaService {

    List<TablaReAsisCurCapaDTO> getAll();

    TablaReAsisCurCapaDTO create(TablaReAsisCurCapaDTO dto);

    TablaReAsisCurCapaDTO update(Long id, TablaReAsisCurCapaDTO dto);

    void delete(Long id);

    List<TablaReAsisCurCapaDTO> getById(Long id);
}

