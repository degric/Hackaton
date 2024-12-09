package com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "InformacionReAsisCurCapa")
public class InformacionReAsisCurCapa {

    @Id
    @Column(name = "idInformacionReAsisCurCapa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInformacionReAsisCurCapa;

    private Date fecha;

    private String nomCurso;

    private String instructor;

    private String duracion;

    private String responsable;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_encabezado", referencedColumnName = "idReAsisCurCapa")
    private ReAsisCurCapa reAsisCurCapa;
}
