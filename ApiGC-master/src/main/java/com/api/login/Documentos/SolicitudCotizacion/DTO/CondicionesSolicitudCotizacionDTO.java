package com.api.login.Documentos.SolicitudCotizacion.DTO;

import lombok.Data;

@Data
public class CondicionesSolicitudCotizacionDTO {
    private Integer idCondicionesSolicitudCotizacion;

    private String reAlceTecnico;

    private String alDocumental;

    private String reAlDocumental;

    private String tiempoEntrega;

    private String enCertificados;

    private String iva;

    private String condiPago;

    private Integer idSolicitudCotizacion;
}
