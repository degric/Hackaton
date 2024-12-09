package com.api.login.rest;

import com.api.login.DTO.FirmaLisDisDocumentosDTO;
import com.api.login.DTO.ImagenReclamoCompraDTO;
import com.api.login.mapper.ImagenReclamoCompramMapper;
import com.api.login.pojo.FirmaLisDisDocumentos;
import com.api.login.pojo.ImagenReclamoCompra;
import com.api.login.service.ImagenReclamoCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/imagenreclamo")
public class ImagenReclamoCompraController {

    @Autowired
    private ImagenReclamoCompraService service;

    @Autowired
    private ImagenReclamoCompramMapper mapper;

    @GetMapping
    private ResponseEntity<List<ImagenReclamoCompraDTO>> listarTodo(){
        List<ImagenReclamoCompraDTO> imagen = service.getAll();
        return new ResponseEntity<>(imagen, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<ImagenReclamoCompraDTO> Guardar(@PathVariable Integer id,@RequestParam("des") String descripcion,
                                                          @RequestParam("file")MultipartFile file) throws IOException {
        ImagenReclamoCompra newDocumentos = service.Create(id,descripcion,file);

        if (newDocumentos == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ImagenReclamoCompraDTO DTO = mapper.toDTO(newDocumentos);
        return new ResponseEntity<>(DTO,HttpStatus.CREATED);
    }

    /*
    @PutMapping("/{id}")
    public ResponseEntity<FirmaLisDisDocumentosDTO> Actualizar(@PathVariable Integer id, @RequestBody FirmaLisDisDocumentosDTO dto){
        FirmaLisDisDocumentosDTO dtoUpdate = firmaLisDisDocumentosService.update(id, dto);
        if (dtoUpdate != null){
            return ResponseEntity.ok(dtoUpdate);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Eliminar(@PathVariable Integer id){
        firmaLisDisDocumentosService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/encabezado/{id}")
    public List<FirmaLisDisDocumentosDTO> listarPorConstanciaId(@PathVariable Integer id){
        return firmaLisDisDocumentosService.getFirmaLisDisById(id);
    }

     */
}
