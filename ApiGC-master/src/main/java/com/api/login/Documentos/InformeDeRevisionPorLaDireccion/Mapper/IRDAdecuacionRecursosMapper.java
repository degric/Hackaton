package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Mapper;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.IRDAdecuacionRecursosDTO;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.IRDAdecuacionRecursos;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.InformeRevisionDireccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IRDAdecuacionRecursosMapper {

    @Autowired
    private InformeRevisionDireccionMapper informeRevisionDireccionMapper;

    public IRDAdecuacionRecursosDTO toDTO(IRDAdecuacionRecursos entity) {
        IRDAdecuacionRecursosDTO dto = new IRDAdecuacionRecursosDTO();
        dto.setIdIRDAdecuacionRecursos(entity.getIdIRDAdecuacionRecursos());
        dto.setSituacionActual(entity.getSituacionActual());
        dto.setIdInformeRevisionDireccion(entity.getInformeRevisionDireccion().getIdInformeRevisionDireccion());
        return dto;
    }

    public IRDAdecuacionRecursos toEntity(IRDAdecuacionRecursosDTO dto, InformeRevisionDireccion informeRevisionDireccion) {
        IRDAdecuacionRecursos entity = new IRDAdecuacionRecursos();
        entity.setIdIRDAdecuacionRecursos(dto.getIdIRDAdecuacionRecursos());
        entity.setSituacionActual(dto.getSituacionActual());
        entity.setInformeRevisionDireccion(informeRevisionDireccion);
        return entity;
    }
}

