package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "IRDDesemProveExternos")
public class IRDDesemProveExternos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIRDDesemProveExternos;

    private String proveedor;
    private String tiempoEntrega;
    private String precio;
    private String calidad;
    private String calificacion;

    // Relación muchos a uno con InformeRevisionDireccion
    @ManyToOne
    @JoinColumn(name = "idInformeRevisionDireccion")
    private InformeRevisionDireccion informeRevisionDireccion;
}
