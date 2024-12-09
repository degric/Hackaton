package com.api.login.rest;

import com.api.login.DTO.TrabajoNoConformeDTO;
import com.api.login.service.TrabajoNoConformeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trabajo")
public class TrabajoNoConformeController {

    @Autowired
    private TrabajoNoConformeService service;

    @GetMapping
    public ResponseEntity<List<TrabajoNoConformeDTO>> listar(){
        List<TrabajoNoConformeDTO> dto = service.getAll();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TrabajoNoConformeDTO> guardar(@RequestBody TrabajoNoConformeDTO dto){
        TrabajoNoConformeDTO create = service.create(dto);
        return new ResponseEntity<>(create, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrabajoNoConformeDTO> actualizar(@PathVariable Integer id,@RequestBody TrabajoNoConformeDTO dto){
        TrabajoNoConformeDTO update = service.update(id, dto);
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
