package com.api.login.DTO;

import lombok.Data;

@Data
public class ImagenReclamoCompraDTO {
    private Integer idImagenReclamoCompra;

    private String nombreImagen;

    private String descripcion;

    private Integer idReclamoCompra;
}
