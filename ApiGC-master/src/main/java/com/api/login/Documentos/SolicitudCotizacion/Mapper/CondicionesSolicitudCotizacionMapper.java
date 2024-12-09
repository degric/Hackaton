package com.api.login.Documentos.SolicitudCotizacion.Mapper;

import com.api.login.Documentos.SolicitudCotizacion.DTO.CondicionesSolicitudCotizacionDTO;
import com.api.login.Documentos.SolicitudCotizacion.pojo.CondicionesSolicitudCotizacion;
import com.api.login.Documentos.SolicitudCotizacion.pojo.SolicitudCotizacion;
import org.springframework.stereotype.Component;

@Component
public class CondicionesSolicitudCotizacionMapper {

    public CondicionesSolicitudCotizacionDTO toDtoCoSoCo(CondicionesSolicitudCotizacion entity){
        CondicionesSolicitudCotizacionDTO dto = new CondicionesSolicitudCotizacionDTO();

        dto.setIdCondicionesSolicitudCotizacion(entity.getIdCondicionesSolicitudCotizacion());
        dto.setReAlceTecnico(entity.getReAlceTecnico());
        dto.setAlDocumental(entity.getAlDocumental());
        dto.setReAlDocumental(entity.getReAlDocumental());
        dto.setTiempoEntrega(entity.getTiempoEntrega());
        dto.setEnCertificados(entity.getEnCertificados());
        dto.setIva(entity.getIva());
        dto.setCondiPago(entity.getCondiPago());
        dto.setIdSolicitudCotizacion(entity.getSolicitudCotizacion().getIdSolicitudCotizacion());

        return dto;
    }

    public CondicionesSolicitudCotizacion toEntityCoSoCo(CondicionesSolicitudCotizacionDTO dto, SolicitudCotizacion solicitudCotizacion){
        CondicionesSolicitudCotizacion entity = new CondicionesSolicitudCotizacion();

        entity.setIdCondicionesSolicitudCotizacion(dto.getIdCondicionesSolicitudCotizacion());
        entity.setReAlceTecnico(dto.getReAlceTecnico());
        entity.setAlDocumental(dto.getAlDocumental());
        entity.setReAlDocumental(dto.getReAlDocumental());
        entity.setTiempoEntrega(dto.getTiempoEntrega());
        entity.setEnCertificados(dto.getEnCertificados());
        entity.setIva(dto.getIva());
        entity.setCondiPago(dto.getCondiPago());
        entity.setSolicitudCotizacion(solicitudCotizacion);

        return entity;
    }
}
