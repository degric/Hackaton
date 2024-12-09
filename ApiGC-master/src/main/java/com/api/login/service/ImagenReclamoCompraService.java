package com.api.login.service;

import com.api.login.DTO.ImagenReclamoCompraDTO;
import com.api.login.pojo.ImagenReclamoCompra;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImagenReclamoCompraService {

    List<ImagenReclamoCompraDTO> getAll();

    ImagenReclamoCompra Create(Integer id,String descripcion, MultipartFile file)throws IOException;

    ImagenReclamoCompraDTO Update(Integer id, ImagenReclamoCompraDTO dto);

    void delete(Integer id);

    List<ImagenReclamoCompraDTO> getByReclamoCompraId(Integer id);
}
