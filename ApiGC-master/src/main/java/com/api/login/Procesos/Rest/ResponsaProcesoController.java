package com.api.login.Procesos.Rest;

import com.api.login.Procesos.DTO.ResponsaProcesoDTO;
import com.api.login.Procesos.Mapper.ResponsaProcesoMapper;
import com.api.login.Procesos.Service.ResponsaProcesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/responsaproceso")
public class ResponsaProcesoController {

    @Autowired
    private ResponsaProcesoService service;

    @Autowired
    private ResponsaProcesoMapper mapper;

    @GetMapping
    private ResponseEntity<List<ResponsaProcesoDTO>> listarTodo(){
        List<ResponsaProcesoDTO> firmas = service.getAll();
        return new ResponseEntity<>(firmas, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<ResponsaProcesoDTO> guardar(@RequestBody ResponsaProcesoDTO dto){
        ResponsaProcesoDTO newData = service.create(dto);

        if (newData == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(newData, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponsaProcesoDTO> actualizar(@PathVariable Long id, @RequestBody ResponsaProcesoDTO dto){
        ResponsaProcesoDTO dtoUpdate = service.update(id, dto);
        if (dtoUpdate != null){
            return ResponseEntity.ok(dtoUpdate);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/encabezado/{id}")
    public List<ResponsaProcesoDTO> listarPorConstanciaId(@PathVariable Long id){
        return service.findByIdEnProceso(id);
    }
}

