package com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Pojo;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Preguntas2DNC")
public class Preguntas2DNC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPreguntas2DNC;

    private String contenido1;
    private String contenido2;
    private String contenido3;

    // Relación muchos a uno con DetecionNeCaDNC
    @ManyToOne
    @JoinColumn(name = "idDetecionNeCaDNC", nullable = false)
    private DetecionNeCaDNC detecionNeCaDNC;
}

