package com.api.login.ManualDeCalidad.pojo;

import com.api.login.Procesos.Pojo.DocumentosReProcesos;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MachoteDocumentos")
public class MachoteDocumentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMachoteDocumentos;

    private String nombreDocumento;

    private Long idDocumento;

    private Integer nivelDocumento;

    private String codigoDocumento;

    @OneToMany(mappedBy = "machoteDocumentos")
    private List<DocumentosReManualCalidad> documentosReManualCalidad;

    @OneToMany(mappedBy = "machoteDocumentos")
    private List<DocumentosReProcesos> documentosReProcesos;
}
