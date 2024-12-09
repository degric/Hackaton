package com.api.login.Documentos.NuevoIngreso.Mapper;

import com.api.login.Documentos.NuevoIngreso.DTO.DatPersonalNuevoIngresoDTO;
import com.api.login.Documentos.NuevoIngreso.Pojo.DatPersonalNuevoIngreso;
import com.api.login.Documentos.NuevoIngreso.Pojo.NuevoIngreso;
import org.springframework.stereotype.Component;

@Component
public class DatPersonalNuevoIngresoMapper {

    public DatPersonalNuevoIngresoDTO toDTODatPerNu(DatPersonalNuevoIngreso entity){
        DatPersonalNuevoIngresoDTO dto = new DatPersonalNuevoIngresoDTO();

        dto.setIdDatPersonalNuevoIngreso(entity.getIdDatPersonalNuevoIngreso());
        dto.setRfc(entity.getRfc());
        dto.setTipoSangre(entity.getTipoSangre());
        dto.setNoTelefono(entity.getNoTelefono());
        dto.setNoPerTelefono(entity.getNoPerTelefono());
        dto.setNoSeguroSocial(entity.getNoSeguroSocial());
        dto.setLiConducir(entity.getLiConducir());
        dto.setNoLicencia(entity.getNoLicencia());
        dto.setEmail(entity.getEmail());
        dto.setNivelEstudios(entity.getNivelEstudios());
        dto.setPasatiempos(entity.getPasatiempos());
        dto.setIdNuevoIngreso(entity.getNuevoIngreso().getIdNuevoIngreso());

        return dto;
    }

    public DatPersonalNuevoIngreso toEntityDatPerNu(DatPersonalNuevoIngresoDTO dto, NuevoIngreso nuevoIngreso){
        DatPersonalNuevoIngreso entity = new DatPersonalNuevoIngreso();

        entity.setIdDatPersonalNuevoIngreso(dto.getIdDatPersonalNuevoIngreso());
        entity.setRfc(dto.getRfc());
        entity.setTipoSangre(dto.getTipoSangre());
        entity.setNoTelefono(dto.getNoTelefono());
        entity.setNoPerTelefono(dto.getNoPerTelefono());
        entity.setNoSeguroSocial(dto.getNoSeguroSocial());
        entity.setLiConducir(dto.getLiConducir());
        entity.setNoLicencia(dto.getNoLicencia());
        entity.setEmail(dto.getEmail());
        entity.setNivelEstudios(dto.getNivelEstudios());
        entity.setPasatiempos(dto.getPasatiempos());
        entity.setNuevoIngreso(nuevoIngreso);

        return entity;
    }

}
