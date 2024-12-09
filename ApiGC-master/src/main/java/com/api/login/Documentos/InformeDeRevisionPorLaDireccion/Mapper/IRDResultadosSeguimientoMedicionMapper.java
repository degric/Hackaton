package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Mapper;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.IRDResultadosSeguimientoMedicionDTO;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.IRDResultadosSeguimientoMedicion;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.InformeRevisionDireccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IRDResultadosSeguimientoMedicionMapper {

    @Autowired
    private InformeRevisionDireccionMapper informeRevisionDireccionMapper;

    public IRDResultadosSeguimientoMedicionDTO toDTO(IRDResultadosSeguimientoMedicion entity) {
        IRDResultadosSeguimientoMedicionDTO dto = new IRDResultadosSeguimientoMedicionDTO();
        dto.setIdIRDResultadosSeguimientoMedicion(entity.getIdIRDResultadosSeguimientoMedicion());
        dto.setContenido(entity.getContenido());
        dto.setIdInformeRevisionDireccion(entity.getInformeRevisionDireccion().getIdInformeRevisionDireccion());
        return dto;
    }

    public IRDResultadosSeguimientoMedicion toEntity(IRDResultadosSeguimientoMedicionDTO dto, InformeRevisionDireccion informeRevisionDireccion) {
        IRDResultadosSeguimientoMedicion entity = new IRDResultadosSeguimientoMedicion();
        entity.setIdIRDResultadosSeguimientoMedicion(dto.getIdIRDResultadosSeguimientoMedicion());
        entity.setContenido(dto.getContenido());
        entity.setInformeRevisionDireccion(informeRevisionDireccion);
        return entity;
    }
}

