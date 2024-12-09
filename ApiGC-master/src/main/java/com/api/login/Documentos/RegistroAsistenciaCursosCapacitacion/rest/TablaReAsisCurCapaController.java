package com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.rest;

import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.DTO.TablaReAsisCurCapaDTO;
import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Service.TablaReAsisCurCapaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/tabrareasiscurcapa")
public class TablaReAsisCurCapaController {

    @Autowired
    private TablaReAsisCurCapaService service;

    @GetMapping
    public ResponseEntity<List<TablaReAsisCurCapaDTO>> listar(){
        List<TablaReAsisCurCapaDTO> dtos = service.getAll();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TablaReAsisCurCapaDTO> guardar(@RequestBody TablaReAsisCurCapaDTO dto){
        TablaReAsisCurCapaDTO createDTO = service.create(dto);
        if (createDTO != null) {
            return new ResponseEntity<>(createDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TablaReAsisCurCapaDTO> actualizar(@PathVariable Long id, @RequestBody TablaReAsisCurCapaDTO dto){
        TablaReAsisCurCapaDTO update = service.update(id, dto);
        if (update != null){
            return new ResponseEntity<>(update, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/encabezado/{id}")
    public List<TablaReAsisCurCapaDTO> listarPorId(@PathVariable Long id){
        return service.getById(id);
    }
}
