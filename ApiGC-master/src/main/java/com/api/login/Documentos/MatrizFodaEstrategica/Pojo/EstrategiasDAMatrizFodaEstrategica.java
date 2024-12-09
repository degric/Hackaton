package com.api.login.Documentos.MatrizFodaEstrategica.Pojo;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "EstrategiasDAMatrizFodaEstrategica")
public class EstrategiasDAMatrizFodaEstrategica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstrategiasDAMatrizFodaEstrategica;

    private String contenido;

    @ManyToOne
    @JoinColumn(name = "idMatrizFodaEstrategica", nullable = false)
    private MatrizFodaEstrategica matrizFodaEstrategica;
}

