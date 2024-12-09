package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Mapper;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.InformeRevisionDireccionEntradaDTO;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.InformeRevisionDireccion;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.InformeRevisionDireccionEntrada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InformeRevisionDireccionEntradaMapper {

    @Autowired
    private InformeRevisionDireccionMapper informeRevisionDireccionMapper;

    public InformeRevisionDireccionEntradaDTO toDTO(InformeRevisionDireccionEntrada entity) {
        InformeRevisionDireccionEntradaDTO dto = new InformeRevisionDireccionEntradaDTO();
        dto.setIdInformeRevisionDireccionEntrada(entity.getIdInformeRevisionDireccionEntrada());
        dto.setEntradas(entity.getEntradas());
        dto.setDirectrices(entity.getDirectrices());
        dto.setIdInformeRevisionDireccion(entity.getInformeRevisionDireccion().getIdInformeRevisionDireccion());
        return dto;
    }

    public InformeRevisionDireccionEntrada toEntity(InformeRevisionDireccionEntradaDTO dto, InformeRevisionDireccion informeRevisionDireccion) {
        InformeRevisionDireccionEntrada entity = new InformeRevisionDireccionEntrada();
        entity.setIdInformeRevisionDireccionEntrada(dto.getIdInformeRevisionDireccionEntrada());
        entity.setEntradas(dto.getEntradas());
        entity.setDirectrices(dto.getDirectrices());
        entity.setInformeRevisionDireccion(informeRevisionDireccion);
        return entity;
    }
}

