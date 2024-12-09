package com.api.login.Documentos.MatrizFodaEstrategica.Pojo;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "EstrategiasFAMatrizFodaEstrategica")
public class EstrategiasFAMatrizFodaEstrategica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstrategiasFAMatrizFodaEstrategica;

    private String contenido;

    @ManyToOne
    @JoinColumn(name = "idMatrizFodaEstrategica", nullable = false)
    private MatrizFodaEstrategica matrizFodaEstrategica;
}
