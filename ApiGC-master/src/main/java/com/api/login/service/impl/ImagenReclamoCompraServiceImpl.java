package com.api.login.service.impl;

import com.api.login.DTO.ImagenReclamoCompraDTO;
import com.api.login.DTO.ReclamoCompraDTO;
import com.api.login.dao.ImagenReclamoCompraDao;
import com.api.login.mapper.ImagenReclamoCompramMapper;
import com.api.login.mapper.ReclamoCompraMapper;
import com.api.login.pojo.ImagenReclamoCompra;
import com.api.login.pojo.ReclamoCompra;
import com.api.login.service.ImagenReclamoCompraService;
import com.api.login.service.ReclamoCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectAclRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ImagenReclamoCompraServiceImpl implements ImagenReclamoCompraService {

    @Autowired
    private ImagenReclamoCompraDao dao;

    @Autowired
    private ImagenReclamoCompramMapper mapper;

    @Autowired
    private ReclamoCompraService reclamoCompraService;

    @Autowired
    private ReclamoCompraMapper reclamoCompraMapper;

    //Configuracion de S3
    private final S3Client s3Client;

    public ImagenReclamoCompraServiceImpl(S3Client s3Client) {
        this.s3Client = s3Client;
    }

    //Metodos de la clase
    @Override
    public List<ImagenReclamoCompraDTO> getAll() {
        List<ImagenReclamoCompra> imagen = dao.findAll();
        return imagen.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ImagenReclamoCompra Create(Integer id,String descripcion, MultipartFile file)throws IOException {
        //Carga de imagen
        String fileName = file.getOriginalFilename();
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket("lean-archivos")
                .key(fileName)
                .build();

        s3Client.putObject(putObjectRequest, RequestBody.fromBytes(file.getBytes()));

        //Guardado de Informacion
        ReclamoCompraDTO reclamoCompraDTO = reclamoCompraService.GetById(id).orElse(null);

        if (reclamoCompraDTO == null){
            return null;
        }
        ReclamoCompra reclamoCompra = reclamoCompraMapper.ToEntity(reclamoCompraDTO);
        //ImagenReclamoCompra imagenReclamoCompra = mapper.toEntity(dto,reclamoCompra);
        ImagenReclamoCompra imagenReclamoCompra = new ImagenReclamoCompra();
        imagenReclamoCompra.setNombreImagen(fileName);
        imagenReclamoCompra.setDescripcion(descripcion);
        imagenReclamoCompra.setReclamoCompra(reclamoCompra);
        return dao.save(imagenReclamoCompra);


    }

    @Override
    public ImagenReclamoCompraDTO Update(Integer id, ImagenReclamoCompraDTO dto) {
        Optional<ImagenReclamoCompra> optional = dao.findById(id);
        if (optional.isPresent()){
            ImagenReclamoCompra imagenReclamoCompra = optional.get();

            imagenReclamoCompra.setNombreImagen(dto.getNombreImagen());
            imagenReclamoCompra.setDescripcion(dto.getDescripcion());
            ReclamoCompraDTO reclamoCompraDTO = reclamoCompraService.GetById(dto.getIdReclamoCompra()).orElse(null);
            imagenReclamoCompra.setReclamoCompra(reclamoCompraMapper.ToEntity(reclamoCompraDTO));

            return mapper.toDTO(dao.save(imagenReclamoCompra));
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        Optional<ImagenReclamoCompra> optional = dao.findById(id);
        if (optional.isPresent()){
            dao.deleteById(id);
        }

    }

    @Override
    public List<ImagenReclamoCompraDTO> getByReclamoCompraId(Integer id) {
        List<ImagenReclamoCompra> imagenReclamoCompras = dao.findByReclamoCompraIdReclamoCompra(id);
        return imagenReclamoCompras.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
}
