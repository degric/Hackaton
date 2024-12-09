package com.api.login.Documentos.ReporteDeAuditoria.Pojo;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "HallazgoReporteAuditoria")
public class HallazgoReporteAuditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHallazgoReporteAuditoria;

    private String clausulaNorma;
    private String tipoHallazgo;
    private String comentario;

    // Relación muchos a uno con ReporteAuditoria
    @ManyToOne
    @JoinColumn(name = "idReporteAuditoria")
    private ReporteAuditoria reporteAuditoria;
}
