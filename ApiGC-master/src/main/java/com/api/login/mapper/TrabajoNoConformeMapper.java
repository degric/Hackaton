package com.api.login.mapper;

import com.api.login.DTO.TrabajoNoConformeDTO;
import com.api.login.pojo.TrabajoNoConforme;
import org.springframework.stereotype.Component;

@Component
public class TrabajoNoConformeMapper {

    public TrabajoNoConformeDTO toDTO(TrabajoNoConforme trabajoNoConforme){
        TrabajoNoConformeDTO dto = new TrabajoNoConformeDTO();

        dto.setIdTrabajoNoConforme(trabajoNoConforme.getIdTrabajoNoConforme());
        dto.setFechaEmision(trabajoNoConforme.getFechaEmision());
        dto.setFechaRevision(trabajoNoConforme.getFechaRevision());
        dto.setNombreEmpresa(trabajoNoConforme.getNombreEmpresa());
        dto.setFechaDeNoConformidad(trabajoNoConforme.getFechaDeNoConformidad());
        dto.setFechaCierre(trabajoNoConforme.getFechaCierre());
        dto.setNoRevision(trabajoNoConforme.getNoRevision());
        dto.setCodigoDocumento(trabajoNoConforme.getCodigoDocumento());
        dto.setNombre(trabajoNoConforme.getNombre());
        dto.setImportancia(trabajoNoConforme.getImportancia());
        dto.setDescripcion(trabajoNoConforme.getDescripcion());
        dto.setAccionesCorrectivas(trabajoNoConforme.getAccionesCorrectivas());
        dto.setInvolucrados(trabajoNoConforme.getInvolucrados());
        dto.setSeguimiento(trabajoNoConforme.getSeguimiento());
        dto.setConformidadUsuario(trabajoNoConforme.getConformidadUsuario());
        dto.setProveedor(trabajoNoConforme.getProveedor());

        return dto;
    }

    public TrabajoNoConforme toEntity(TrabajoNoConformeDTO dto){
        TrabajoNoConforme trabajoNoConforme = new TrabajoNoConforme();

        trabajoNoConforme.setIdTrabajoNoConforme(dto.getIdTrabajoNoConforme());
        trabajoNoConforme.setFechaEmision(dto.getFechaEmision());
        trabajoNoConforme.setFechaRevision(dto.getFechaRevision());
        trabajoNoConforme.setNombreEmpresa(dto.getNombreEmpresa());
        trabajoNoConforme.setFechaDeNoConformidad(dto.getFechaDeNoConformidad());
        trabajoNoConforme.setFechaCierre(dto.getFechaCierre());
        trabajoNoConforme.setNoRevision(dto.getNoRevision());
        trabajoNoConforme.setCodigoDocumento(dto.getCodigoDocumento());
        trabajoNoConforme.setNombre(dto.getNombre());
        trabajoNoConforme.setImportancia(dto.getImportancia());
        trabajoNoConforme.setDescripcion(dto.getDescripcion());
        trabajoNoConforme.setAccionesCorrectivas(dto.getAccionesCorrectivas());
        trabajoNoConforme.setInvolucrados(dto.getInvolucrados());
        trabajoNoConforme.setSeguimiento(dto.getSeguimiento());
        trabajoNoConforme.setConformidadUsuario(dto.getConformidadUsuario());
        trabajoNoConforme.setProveedor(dto.getProveedor());

        return trabajoNoConforme;
    }
}
