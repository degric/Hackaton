package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Mapper;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.IRDDesemProveExternosDTO;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.IRDDesemProveExternos;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.InformeRevisionDireccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IRDDesemProveExternosMapper {

    @Autowired
    private InformeRevisionDireccionMapper informeRevisionDireccionMapper;

    public IRDDesemProveExternosDTO toDTO(IRDDesemProveExternos entity) {
        IRDDesemProveExternosDTO dto = new IRDDesemProveExternosDTO();
        dto.setIdIRDDesemProveExternos(entity.getIdIRDDesemProveExternos());
        dto.setProveedor(entity.getProveedor());
        dto.setTiempoEntrega(entity.getTiempoEntrega());
        dto.setPrecio(entity.getPrecio());
        dto.setCalidad(entity.getCalidad());
        dto.setCalificacion(entity.getCalificacion());
        dto.setIdInformeRevisionDireccion(entity.getInformeRevisionDireccion().getIdInformeRevisionDireccion());
        return dto;
    }

    public IRDDesemProveExternos toEntity(IRDDesemProveExternosDTO dto, InformeRevisionDireccion informeRevisionDireccion) {
        IRDDesemProveExternos entity = new IRDDesemProveExternos();
        entity.setIdIRDDesemProveExternos(dto.getIdIRDDesemProveExternos());
        entity.setProveedor(dto.getProveedor());
        entity.setTiempoEntrega(dto.getTiempoEntrega());
        entity.setPrecio(dto.getPrecio());
        entity.setCalidad(dto.getCalidad());
        entity.setCalificacion(dto.getCalificacion());
        entity.setInformeRevisionDireccion(informeRevisionDireccion);
        return entity;
    }
}

