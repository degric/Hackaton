package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Mapper;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.IRDObjetivosCalidadDTO;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.IRDObjetivosCalidad;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.InformeRevisionDireccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IRDObjetivosCalidadMapper {

    @Autowired
    private InformeRevisionDireccionMapper informeRevisionDireccionMapper;

    public IRDObjetivosCalidadDTO toDTO(IRDObjetivosCalidad entity) {
        IRDObjetivosCalidadDTO dto = new IRDObjetivosCalidadDTO();
        dto.setIdIRDObjetivosCalidad(entity.getIdIRDObjetivosCalidad());
        dto.setContenido(entity.getContenido());
        dto.setIdInformeRevisionDireccion(entity.getInformeRevisionDireccion().getIdInformeRevisionDireccion());
        return dto;
    }

    public IRDObjetivosCalidad toEntity(IRDObjetivosCalidadDTO dto, InformeRevisionDireccion informeRevisionDireccion) {
        IRDObjetivosCalidad entity = new IRDObjetivosCalidad();
        entity.setIdIRDObjetivosCalidad(dto.getIdIRDObjetivosCalidad());
        entity.setContenido(dto.getContenido());
        entity.setInformeRevisionDireccion(informeRevisionDireccion);
        return entity;
    }
}
