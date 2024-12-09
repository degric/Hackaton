package com.api.login.Documentos.EvaluacionHabilidadesPersonal.Service;

import com.api.login.Documentos.EvaluacionHabilidadesPersonal.DTO.DatosEvaluacionHaPersonalDTO;
import org.aspectj.apache.bcel.classfile.Module;

import java.util.List;
import java.util.Optional;

public interface DatosEvaluacionHaPersonalService {

    List<DatosEvaluacionHaPersonalDTO> getAllDaEvaPer();

    DatosEvaluacionHaPersonalDTO createDaEvaPer(DatosEvaluacionHaPersonalDTO dto);

    DatosEvaluacionHaPersonalDTO updateDaEvaPer(Long id, DatosEvaluacionHaPersonalDTO dto);

    void deleteDaEvaPer(Long id);

    Optional<DatosEvaluacionHaPersonalDTO> findByEncabezado(Long id);
}
