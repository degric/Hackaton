package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Mapper;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.IRDNoConformidadesAcCorrectivasDTO;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.IRDNoConformidadesAcCorrectivas;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.InformeRevisionDireccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IRDNoConformidadesAcCorrectivasMapper {

    @Autowired
    private InformeRevisionDireccionMapper informeRevisionDireccionMapper;

    public IRDNoConformidadesAcCorrectivasDTO toDTO(IRDNoConformidadesAcCorrectivas entity) {
        IRDNoConformidadesAcCorrectivasDTO dto = new IRDNoConformidadesAcCorrectivasDTO();
        dto.setIdIRDNoConformidadesAcCorrectivas(entity.getIdIRDNoConformidadesAcCorrectivas());
        dto.setTipo(entity.getTipo());
        dto.setReportadas(entity.getReportadas());
        dto.setEnSeguimiento(entity.getEnSeguimiento());
        dto.setImplementadas(entity.getImplementadas());
        dto.setCerradas(entity.getCerradas());
        dto.setIdInformeRevisionDireccion(entity.getInformeRevisionDireccion().getIdInformeRevisionDireccion());
        return dto;
    }

    public IRDNoConformidadesAcCorrectivas toEntity(IRDNoConformidadesAcCorrectivasDTO dto, InformeRevisionDireccion informeRevisionDireccion) {
        IRDNoConformidadesAcCorrectivas entity = new IRDNoConformidadesAcCorrectivas();
        entity.setIdIRDNoConformidadesAcCorrectivas(dto.getIdIRDNoConformidadesAcCorrectivas());
        entity.setTipo(dto.getTipo());
        entity.setReportadas(dto.getReportadas());
        entity.setEnSeguimiento(dto.getEnSeguimiento());
        entity.setImplementadas(dto.getImplementadas());
        entity.setCerradas(dto.getCerradas());
        entity.setInformeRevisionDireccion(informeRevisionDireccion);
        return entity;
    }
}

