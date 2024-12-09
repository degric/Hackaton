package com.api.login.Documentos.MatrizFodaEstrategica.Pojo;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "EstrategiasFOMatrizFodaEstrategica")
public class EstrategiasFOMatrizFodaEstrategica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstrategiasFOMatrizFodaEstrategica;

    private String contenido;

    @ManyToOne
    @JoinColumn(name = "idMatrizFodaEstrategica", nullable = false)
    private MatrizFodaEstrategica matrizFodaEstrategica;
}
