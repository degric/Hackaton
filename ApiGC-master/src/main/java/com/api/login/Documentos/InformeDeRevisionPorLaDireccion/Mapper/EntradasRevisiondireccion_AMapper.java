package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Mapper;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.EntradasRevisiondireccion_ADTO;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.EntradasRevisiondireccion_A;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.InformeRevisionDireccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntradasRevisiondireccion_AMapper {

    @Autowired
    private InformeRevisionDireccionMapper informeRevisionDireccionMapper;

    public EntradasRevisiondireccion_ADTO toDTO(EntradasRevisiondireccion_A entity) {
        EntradasRevisiondireccion_ADTO dto = new EntradasRevisiondireccion_ADTO();
        dto.setIdEntradasRevisiondireccion_A(entity.getIdEntradasRevisiondireccion_A());
        dto.setSituacionActual(entity.getSituacionActual());
        dto.setIdInformeRevisionDireccion(entity.getInformeRevisionDireccion().getIdInformeRevisionDireccion());
        return dto;
    }

    public EntradasRevisiondireccion_A toEntity(EntradasRevisiondireccion_ADTO dto, InformeRevisionDireccion informeRevisionDireccion) {
        EntradasRevisiondireccion_A entity = new EntradasRevisiondireccion_A();
        entity.setIdEntradasRevisiondireccion_A(dto.getIdEntradasRevisiondireccion_A());
        entity.setSituacionActual(dto.getSituacionActual());
        entity.setInformeRevisionDireccion(informeRevisionDireccion);
        return entity;
    }
}

