package com.api.login.Documentos.SolicitudCotizacion.pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CondicionesSolicitudCotizacion")
public class CondicionesSolicitudCotizacion {

    @Id
    @Column(name = "idCondicionesSolicitudCotizacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCondicionesSolicitudCotizacion;

    private String reAlceTecnico;

    private String alDocumental;

    private String reAlDocumental;

    private String tiempoEntrega;

    private String enCertificados;

    private String iva;

    private String condiPago;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "solicitud_id", referencedColumnName = "idSolicitudCotizacion")
    private SolicitudCotizacion solicitudCotizacion;

}
