package com.api.login.Documentos.EvaluacionHabilidadesPersonal.Service;

import com.api.login.Documentos.EvaluacionHabilidadesPersonal.DTO.EvaluacionHabiPersonalDTO;
import com.api.login.Documentos.EvaluacionHabilidadesPersonal.Pojo.EvaluacionHabiPersonal;

import java.util.List;
import java.util.Optional;

public interface EvaluacionHabiPersonalService {

    List<EvaluacionHabiPersonalDTO> getAllEHaPe();

    Optional<EvaluacionHabiPersonalDTO> getByIdEHaPe(Long id);

    EvaluacionHabiPersonalDTO createEHaPe(EvaluacionHabiPersonalDTO dto);

    EvaluacionHabiPersonalDTO updateEHaPe(Long id, EvaluacionHabiPersonalDTO dto);

    void deleteEHaPe(Long id);

}
