package com.api.login.Documentos.EvaluacionHabilidadesPersonal.Mapper;

import com.api.login.Documentos.EvaluacionHabilidadesPersonal.DTO.DatosEvaluacionHaPersonalDTO;
import com.api.login.Documentos.EvaluacionHabilidadesPersonal.Pojo.DatosEvaluacionHaPersonal;
import com.api.login.Documentos.EvaluacionHabilidadesPersonal.Pojo.EvaluacionHabiPersonal;
import org.springframework.stereotype.Component;

@Component
public class DatosEvaluacionHaPersonalMapper {

    public DatosEvaluacionHaPersonalDTO toDTODaEvaPer(DatosEvaluacionHaPersonal entity){
        DatosEvaluacionHaPersonalDTO dto = new DatosEvaluacionHaPersonalDTO();
        dto.setIdDatosEvaluacionHaPersonal(entity.getIdDatosEvaluacionHaPersonal());
        dto.setNombre(entity.getNombre());
        dto.setPuesto(entity.getPuesto());
        dto.setFechaEvaluacion(entity.getFechaEvaluacion());
        dto.setEvaluador(entity.getEvaluador());
        dto.setPromedio(entity.getPromedio());
        dto.setIdEvaluacionHabiPersonal(entity.getEvaluacionHabiPersonal().getIdEvaluacionHabiPersonal());
        return dto;

    }

    public DatosEvaluacionHaPersonal toEntityDaEvaPer(DatosEvaluacionHaPersonalDTO dto, EvaluacionHabiPersonal evaluacionHabiPersonal){
        DatosEvaluacionHaPersonal entity = new DatosEvaluacionHaPersonal();
        entity.setIdDatosEvaluacionHaPersonal(dto.getIdDatosEvaluacionHaPersonal());
        entity.setNombre(dto.getNombre());
        entity.setPuesto(dto.getPuesto());
        entity.setFechaEvaluacion(dto.getFechaEvaluacion());
        entity.setEvaluador(dto.getEvaluador());
        entity.setPromedio(dto.getPromedio());
        entity.setEvaluacionHabiPersonal(evaluacionHabiPersonal);

        return entity;

    }
}
