package com.api.login.rest;

import com.api.login.DTO.LisDisDocumentosDTO;
import com.api.login.DTO.ReclamoCompraDTO;
import com.api.login.service.ReclamoCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reclamocompra")
public class ReclamoCompraController {

    @Autowired
    private ReclamoCompraService service;

    @GetMapping
    public ResponseEntity<List<ReclamoCompraDTO>> listar(){
        List<ReclamoCompraDTO> constancia = service.GetAll();
        return new ResponseEntity<>(constancia, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ReclamoCompraDTO> guardar(@RequestBody ReclamoCompraDTO dto){
        ReclamoCompraDTO create = service.Crear(dto);
        return new ResponseEntity<>( create, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReclamoCompraDTO>actualizar(@PathVariable Integer id,@RequestBody ReclamoCompraDTO dto){
        ReclamoCompraDTO update = service.Actualizar(id, dto);
        if (update != null){
            return new ResponseEntity<>(update, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id){
        service.Eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
