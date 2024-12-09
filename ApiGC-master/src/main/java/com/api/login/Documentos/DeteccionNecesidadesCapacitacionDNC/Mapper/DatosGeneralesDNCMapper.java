package com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Mapper;

import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.DTO.DatosGeneralesDNCDTO;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Pojo.DatosGeneralesDNC;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Pojo.DetecionNeCaDNC;
import org.springframework.stereotype.Component;

@Component
public class DatosGeneralesDNCMapper {

    public DatosGeneralesDNCDTO toDTO(DatosGeneralesDNC entity) {
        DatosGeneralesDNCDTO dto = new DatosGeneralesDNCDTO();
        dto.setIdDatosGeneralesDNC(entity.getIdDatosGeneralesDNC());
        dto.setNombre(entity.getNombre());
        dto.setPuesto(entity.getPuesto());
        dto.setAntiguedadEmpresa(entity.getAntiguedadEmpresa());
        dto.setAntiguedadPuesto(entity.getAntiguedadPuesto());
        dto.setEscolaridad(entity.getEscolaridad());
        dto.setIdDetecionNeCaDNC(entity.getDetecionNeCaDNC().getIdDetecionNeCaDNC());
        return dto;
    }

    public DatosGeneralesDNC toEntity(DatosGeneralesDNCDTO dto, DetecionNeCaDNC detecionNeCaDNC) {
        DatosGeneralesDNC entity = new DatosGeneralesDNC();
        entity.setIdDatosGeneralesDNC(dto.getIdDatosGeneralesDNC());
        entity.setNombre(dto.getNombre());
        entity.setPuesto(dto.getPuesto());
        entity.setAntiguedadEmpresa(dto.getAntiguedadEmpresa());
        entity.setAntiguedadPuesto(dto.getAntiguedadPuesto());
        entity.setEscolaridad(dto.getEscolaridad());
        entity.setDetecionNeCaDNC(detecionNeCaDNC);
        return entity;
    }
}
