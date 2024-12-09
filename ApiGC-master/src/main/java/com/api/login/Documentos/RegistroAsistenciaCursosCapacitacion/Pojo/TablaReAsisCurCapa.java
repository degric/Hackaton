package com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TablaReAsisCurCapa")
public class TablaReAsisCurCapa {
    @Id
    @Column(name = "idTablaReAsisCurCapa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTablaReAsisCurCapa;

    private String nombre;

    private String puesto;

    private String area;

    private String firma;

    @ManyToOne
    @JoinColumn(name = "id_encabezado", referencedColumnName = "idReAsisCurCapa")
    private ReAsisCurCapa reAsisCurCapa;
}
