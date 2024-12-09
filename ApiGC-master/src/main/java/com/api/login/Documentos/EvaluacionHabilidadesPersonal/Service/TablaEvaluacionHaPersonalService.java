package com.api.login.Documentos.EvaluacionHabilidadesPersonal.Service;

import com.api.login.Documentos.EvaluacionHabilidadesPersonal.DTO.TablaEvaluacionHaPersonalDTO;

import java.util.List;

public interface TablaEvaluacionHaPersonalService {
    List<TablaEvaluacionHaPersonalDTO> getAllDaEvaPer();
    TablaEvaluacionHaPersonalDTO createDaEvaPer(TablaEvaluacionHaPersonalDTO dto);
    TablaEvaluacionHaPersonalDTO updateDaEvaPer(Long id, TablaEvaluacionHaPersonalDTO dto);
    void deleteDaEvaPer(Long id);
    List<TablaEvaluacionHaPersonalDTO> findByEncabezado(Long id);

    Integer promedio (Long id);
}

