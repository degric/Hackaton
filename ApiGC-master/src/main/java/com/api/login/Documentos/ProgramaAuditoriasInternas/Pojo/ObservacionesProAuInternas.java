package com.api.login.Documentos.ProgramaAuditoriasInternas.Pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ObservacionesProAuInternas")
public class ObservacionesProAuInternas {
    @Id
    @Column(name = "idObservacionesProAuInternas")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idObservacionesProAuInternas;

    private String observaciones;

    private String elaboro;

    private String autorizo;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "programa_au_internas_id", referencedColumnName = "idProgramaAuditoriasInternas")
    private ProgramaAuditoriasInternas programaAuditoriasInternas;
}
