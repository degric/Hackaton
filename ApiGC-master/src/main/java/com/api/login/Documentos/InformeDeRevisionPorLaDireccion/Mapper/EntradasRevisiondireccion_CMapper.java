package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Mapper;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.EntradasRevisiondireccion_CDTO;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.EntradasRevisiondireccion_C;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.InformeRevisionDireccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntradasRevisiondireccion_CMapper {

    @Autowired
    private InformeRevisionDireccionMapper informeRevisionDireccionMapper;

    public EntradasRevisiondireccion_CDTO toDTO(EntradasRevisiondireccion_C entity) {
        EntradasRevisiondireccion_CDTO dto = new EntradasRevisiondireccion_CDTO();
        dto.setIdEntradasRevisiondireccion_C(entity.getIdEntradasRevisiondireccion_C());
        dto.setSituacionActual(entity.getSituacionActual());
        dto.setRetroalimentacion(entity.getRetroalimentacion());
        dto.setIdInformeRevisionDireccion(entity.getInformeRevisionDireccion().getIdInformeRevisionDireccion());
        return dto;
    }

    public EntradasRevisiondireccion_C toEntity(EntradasRevisiondireccion_CDTO dto, InformeRevisionDireccion informeRevisionDireccion) {
        EntradasRevisiondireccion_C entity = new EntradasRevisiondireccion_C();
        entity.setIdEntradasRevisiondireccion_C(dto.getIdEntradasRevisiondireccion_C());
        entity.setSituacionActual(dto.getSituacionActual());
        entity.setRetroalimentacion(dto.getRetroalimentacion());
        entity.setInformeRevisionDireccion(informeRevisionDireccion);
        return entity;
    }
}

