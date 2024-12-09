package com.api.login.mapper;

import com.api.login.DTO.ReclamoCompraDTO;
import com.api.login.pojo.ReclamoCompra;
import org.springframework.stereotype.Component;

@Component
public class ReclamoCompraMapper {

    public ReclamoCompraDTO ToDTO(ReclamoCompra reclamoCompra){
        ReclamoCompraDTO dto = new ReclamoCompraDTO();

        dto.setIdReclamoCompra(reclamoCompra.getIdReclamoCompra());
        dto.setCoDocumento(reclamoCompra.getCoDocumento());
        dto.setNumeroRevision(reclamoCompra.getNumeroRevision());
        dto.setFechaEmision(reclamoCompra.getFechaEmision());
        dto.setFechaRevision(reclamoCompra.getFechaRevision());
        dto.setFecha(reclamoCompra.getFecha());
        dto.setProveedor(reclamoCompra.getProveedor());
        dto.setNomAtiReclamo(reclamoCompra.getNomAtiReclamo());
        dto.setCasua(reclamoCompra.getCasua());
        dto.setAccionTomada(reclamoCompra.getAccionTomada());
        dto.setFechaCierre(reclamoCompra.getFechaCierre());
        dto.setElaboro(reclamoCompra.getElaboro());
        dto.setAutorizo(reclamoCompra.getAutorizo());

        return dto;
    }

    public ReclamoCompra ToEntity(ReclamoCompraDTO dto){

        ReclamoCompra entity = new ReclamoCompra();

        entity.setIdReclamoCompra(dto.getIdReclamoCompra());
        entity.setCoDocumento(dto.getCoDocumento());
        entity.setNumeroRevision(dto.getNumeroRevision());
        entity.setFechaEmision(dto.getFechaEmision());
        entity.setFechaRevision(dto.getFechaRevision());
        entity.setFecha(dto.getFecha());
        entity.setProveedor(dto.getProveedor());
        entity.setNomAtiReclamo(dto.getNomAtiReclamo());
        entity.setCasua(dto.getCasua());
        entity.setAccionTomada(dto.getAccionTomada());
        entity.setFechaCierre(dto.getFechaCierre());
        entity.setElaboro(dto.getElaboro());
        entity.setAutorizo(dto.getAutorizo());

        return entity;
    }


}
