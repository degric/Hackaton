package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Mapper;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.IRDResultadosAuditoriaDTO;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.IRDResultadosAuditoria;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.InformeRevisionDireccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IRDResultadosAuditoriaMapper {

    @Autowired
    private InformeRevisionDireccionMapper informeRevisionDireccionMapper;

    public IRDResultadosAuditoriaDTO toDTO(IRDResultadosAuditoria entity) {
        IRDResultadosAuditoriaDTO dto = new IRDResultadosAuditoriaDTO();
        dto.setIdIRDResultadosAuditoria(entity.getIdIRDResultadosAuditoria());
        dto.setContenido(entity.getContenido());
        dto.setIdInformeRevisionDireccion(entity.getInformeRevisionDireccion().getIdInformeRevisionDireccion());
        return dto;
    }

    public IRDResultadosAuditoria toEntity(IRDResultadosAuditoriaDTO dto, InformeRevisionDireccion informeRevisionDireccion) {
        IRDResultadosAuditoria entity = new IRDResultadosAuditoria();
        entity.setIdIRDResultadosAuditoria(dto.getIdIRDResultadosAuditoria());
        entity.setContenido(dto.getContenido());
        entity.setInformeRevisionDireccion(informeRevisionDireccion);
        return entity;
    }
}

