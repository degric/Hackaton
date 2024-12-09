package com.api.login.Procesos.Pojo;

import com.api.login.ManualDeCalidad.pojo.MachoteDocumentos;
import com.api.login.ManualDeCalidad.pojo.ManualCalidad;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DocumentosReProcesos")
public class DocumentosReProcesos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDocumentosReProcesos;

    private String nombrePunto;

    private Long nivelPunto;

    private Long idSubpunto;

    @ManyToOne
    @JoinColumn(name = "idEnProceso", nullable = false)
    private EnProceso enProceso;

    @ManyToOne
    @JoinColumn(name = "idMachoteDocumentos", nullable = false)
    private MachoteDocumentos machoteDocumentos;

}
