package com.api.login.mapper;

import com.api.login.DTO.ImagenReclamoCompraDTO;
import com.api.login.pojo.ImagenReclamoCompra;
import com.api.login.pojo.ReclamoCompra;
import org.springframework.stereotype.Component;

@Component
public class ImagenReclamoCompramMapper {

    public ImagenReclamoCompraDTO toDTO(ImagenReclamoCompra imagenReclamoCompra){
        ImagenReclamoCompraDTO dto = new ImagenReclamoCompraDTO();

        dto.setIdImagenReclamoCompra(imagenReclamoCompra.getIdImagenReclamoCompra());
        dto.setNombreImagen(imagenReclamoCompra.getNombreImagen());
        dto.setDescripcion(imagenReclamoCompra.getDescripcion());
        dto.setIdReclamoCompra(imagenReclamoCompra.getReclamoCompra().getIdReclamoCompra());

        return dto;
    }

    public ImagenReclamoCompra toEntity(ImagenReclamoCompraDTO dto, ReclamoCompra reclamoCompra){
        ImagenReclamoCompra entity = new ImagenReclamoCompra();

        entity.setIdImagenReclamoCompra(dto.getIdImagenReclamoCompra());
        entity.setNombreImagen(dto.getNombreImagen());
        entity.setDescripcion(dto.getDescripcion());
        entity.setReclamoCompra(reclamoCompra);

        return entity;
    }
}
