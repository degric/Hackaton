package com.api.login.Procesos.Mapper;

import com.api.login.Procesos.DTO.DoReferenciaProcesoDTO;
import com.api.login.Procesos.Pojo.DoReferenciaProceso;
import com.api.login.Procesos.Pojo.EnProceso;
import org.springframework.stereotype.Component;

@Component
public class DoReferenciaProcesoMapper {

    public DoReferenciaProcesoDTO toDTODoReferencia(DoReferenciaProceso entity){
        DoReferenciaProcesoDTO dto = new DoReferenciaProcesoDTO();
        dto.setIdDoReferenciaProceso(entity.getIdDoReferenciaProceso());
        dto.setCoDocumento(entity.getCoDocumento());
        dto.setNombreDocumento(entity.getNombreDocumento());
        dto.setIdEnProceso(entity.getEnProceso().getIdEnProceso());

        return dto;
    }

    public DoReferenciaProceso toEntityDoReferencia(DoReferenciaProcesoDTO dto, EnProceso enProceso){
        DoReferenciaProceso entity = new DoReferenciaProceso();
        entity.setIdDoReferenciaProceso(dto.getIdDoReferenciaProceso());
        entity.setCoDocumento(dto.getCoDocumento());
        entity.setNombreDocumento(dto.getNombreDocumento());
        entity.setEnProceso(enProceso);

        return entity;
    }
}
