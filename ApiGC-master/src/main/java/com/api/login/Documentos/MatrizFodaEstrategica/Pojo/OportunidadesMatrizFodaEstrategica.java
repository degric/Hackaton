package com.api.login.Documentos.MatrizFodaEstrategica.Pojo;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "OportunidadesMatrizFodaEstrategica")
public class OportunidadesMatrizFodaEstrategica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOportunidadesMatrizFodaEstrategica;

    private String contenido;

    @ManyToOne
    @JoinColumn(name = "idMatrizFodaEstrategica", nullable = false)
    private MatrizFodaEstrategica matrizFodaEstrategica;
}

