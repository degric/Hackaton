package com.api.login.rest;

import com.api.login.DTO.LisDisDocumentosDTO;
import com.api.login.service.LisDisDocumentosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lisdis")
public class LisDisDocumentosController {

    @Autowired
    private LisDisDocumentosService service;

    @GetMapping
    public ResponseEntity<List<LisDisDocumentosDTO>> listar(){
        List<LisDisDocumentosDTO> constancia = service.getAll();
        return new ResponseEntity<>(constancia, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LisDisDocumentosDTO> guardar(@RequestBody LisDisDocumentosDTO dto){
        LisDisDocumentosDTO create = service.create(dto);
        return new ResponseEntity<>( create, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LisDisDocumentosDTO>actualizar(@PathVariable Integer id,@RequestBody LisDisDocumentosDTO dto){
        LisDisDocumentosDTO update = service.update(id, dto);
        if (update != null){
            return new ResponseEntity<>(update, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id){
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
