package com.api.login.Documentos.MatrizFodaEstrategica.Pojo;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "EstrategiasDOMatrizFodaEstrategica")
public class EstrategiasDOMatrizFodaEstrategica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstrategiasDOMatrizFodaEstrategica;

    private String contenido;

    @ManyToOne
    @JoinColumn(name = "idMatrizFodaEstrategica", nullable = false)
    private MatrizFodaEstrategica matrizFodaEstrategica;
}
