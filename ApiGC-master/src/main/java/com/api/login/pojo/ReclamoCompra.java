package com.api.login.pojo;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.sql.Date;
import java.util.Collection;

@Data
@Entity
@Table(name = "reclamoCompra")
public class ReclamoCompra {
    @Id
    @Column(name = "idReclamoCompra")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReclamoCompra;

    //encabezado
    private String coDocumento;

    private String numeroRevision;

    private Date fechaEmision;

    private Date fechaRevision;

    //contenido
    private Date fecha;

    private String proveedor;

    //nombre de quien atiende la reclamacion
    private String nomAtiReclamo;

    private String casua;

    private String accionTomada;

    private Date fechaCierre;

    private String elaboro;

    private String autorizo;

    @OneToMany(mappedBy = "reclamoCompra", fetch = FetchType.LAZY)
    Collection<ImagenReclamoCompra> imagenReclamoCompras;
}
