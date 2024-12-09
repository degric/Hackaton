package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Mapper;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.IRDProcesosConformidadServiciosDTO;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.IRDProcesosConformidadServicios;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.InformeRevisionDireccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IRDProcesosConformidadServiciosMapper {

    @Autowired
    private InformeRevisionDireccionMapper informeRevisionDireccionMapper;

    public IRDProcesosConformidadServiciosDTO toDTO(IRDProcesosConformidadServicios entity) {
        IRDProcesosConformidadServiciosDTO dto = new IRDProcesosConformidadServiciosDTO();
        dto.setIdIRDProcesosConformidadServicios(entity.getIdIRDProcesosConformidadServicios());
        dto.setProceso(entity.getProceso());
        dto.setIndicador(entity.getIndicador());
        dto.setMeta(entity.getMeta());
        dto.setTendencia(entity.getTendencia());
        dto.setStatus(entity.getStatus());
        dto.setIdInformeRevisionDireccion(entity.getInformeRevisionDireccion().getIdInformeRevisionDireccion());
        return dto;
    }

    public IRDProcesosConformidadServicios toEntity(IRDProcesosConformidadServiciosDTO dto, InformeRevisionDireccion informeRevisionDireccion) {
        IRDProcesosConformidadServicios entity = new IRDProcesosConformidadServicios();
        entity.setIdIRDProcesosConformidadServicios(dto.getIdIRDProcesosConformidadServicios());
        entity.setProceso(dto.getProceso());
        entity.setIndicador(dto.getIndicador());
        entity.setMeta(dto.getMeta());
        entity.setTendencia(dto.getTendencia());
        entity.setStatus(dto.getStatus());
        entity.setInformeRevisionDireccion(informeRevisionDireccion);
        return entity;
    }
}
