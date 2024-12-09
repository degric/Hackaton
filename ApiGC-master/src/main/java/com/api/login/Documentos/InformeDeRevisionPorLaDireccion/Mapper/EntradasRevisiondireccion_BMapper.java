package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Mapper;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.EntradasRevisiondireccion_BDTO;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.EntradasRevisiondireccion_B;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.InformeRevisionDireccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntradasRevisiondireccion_BMapper {

    @Autowired
    private InformeRevisionDireccionMapper informeRevisionDireccionMapper;

    public EntradasRevisiondireccion_BDTO toDTO(EntradasRevisiondireccion_B entity) {
        EntradasRevisiondireccion_BDTO dto = new EntradasRevisiondireccion_BDTO();
        dto.setIdEntradasRevisiondireccion_B(entity.getIdEntradasRevisiondireccion_B());
        dto.setSituacionActual(entity.getSituacionActual());
        dto.setIdInformeRevisionDireccion(entity.getInformeRevisionDireccion().getIdInformeRevisionDireccion());
        return dto;
    }

    public EntradasRevisiondireccion_B toEntity(EntradasRevisiondireccion_BDTO dto, InformeRevisionDireccion informeRevisionDireccion) {
        EntradasRevisiondireccion_B entity = new EntradasRevisiondireccion_B();
        entity.setIdEntradasRevisiondireccion_B(dto.getIdEntradasRevisiondireccion_B());
        entity.setSituacionActual(dto.getSituacionActual());
        entity.setInformeRevisionDireccion(informeRevisionDireccion);
        return entity;
    }
}
