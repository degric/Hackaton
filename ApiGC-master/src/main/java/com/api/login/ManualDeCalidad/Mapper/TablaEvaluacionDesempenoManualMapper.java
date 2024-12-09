package com.api.login.ManualDeCalidad.Mapper;

import com.api.login.ManualDeCalidad.DTO.TablaEvaluacionDesempenoManualDTO;
import com.api.login.ManualDeCalidad.pojo.ManualCalidad;
import com.api.login.ManualDeCalidad.pojo.TablaEvaluacionDesempenoManual;
import org.springframework.stereotype.Component;

@Component
public class TablaEvaluacionDesempenoManualMapper {

    public TablaEvaluacionDesempenoManualDTO toDTO(TablaEvaluacionDesempenoManual entity) {
        TablaEvaluacionDesempenoManualDTO dto = new TablaEvaluacionDesempenoManualDTO();
        dto.setIdTablaEvaluacionDesempenoManual(entity.getIdTablaEvaluacionDesempenoManual());
        dto.setQueEvaluar(entity.getQueEvaluar());
        dto.setMetodoSeguimientoMedicion(entity.getMetodoSeguimientoMedicion());
        dto.setCuandoDarSeguimientoMedicion(entity.getCuandoDarSeguimientoMedicion());
        dto.setCuandoAnalizarEvaluarResultados(entity.getCuandoAnalizarEvaluarResultados());
        dto.setIdManualCalidad(entity.getManualCalidad().getIdManualCalidad());
        return dto;
    }

    public TablaEvaluacionDesempenoManual toEntity(TablaEvaluacionDesempenoManualDTO dto, ManualCalidad manualCalidad) {
        TablaEvaluacionDesempenoManual entity = new TablaEvaluacionDesempenoManual();
        entity.setIdTablaEvaluacionDesempenoManual(dto.getIdTablaEvaluacionDesempenoManual());
        entity.setQueEvaluar(dto.getQueEvaluar());
        entity.setMetodoSeguimientoMedicion(dto.getMetodoSeguimientoMedicion());
        entity.setCuandoDarSeguimientoMedicion(dto.getCuandoDarSeguimientoMedicion());
        entity.setCuandoAnalizarEvaluarResultados(dto.getCuandoAnalizarEvaluarResultados());
        entity.setManualCalidad(manualCalidad);
        return entity;
    }
}

