package com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Pojo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Pregunta1DNC")
public class Pregunta1DNC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPreguntas1DNC;

    private String contenido1;
    private String contenido2;
    private String contenido3;

    // Relación muchos a uno con DetecionNeCaDNC
    @ManyToOne
    @JoinColumn(name = "idDetecionNeCaDNC", nullable = false)
    private DetecionNeCaDNC detecionNeCaDNC;
}
