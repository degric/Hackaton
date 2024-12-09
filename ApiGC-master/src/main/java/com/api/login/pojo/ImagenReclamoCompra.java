package com.api.login.pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ImagenReclamoCompra")
public class ImagenReclamoCompra {

    @Id
    @Column(name = "idImagenReclamoCompra")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idImagenReclamoCompra;

    private String nombreImagen;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "reclamo_compra_id", referencedColumnName = "idReclamoCompra")
    private ReclamoCompra reclamoCompra;
}
