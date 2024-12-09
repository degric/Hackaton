package com.api.login.Procesos.Rest;

import com.api.login.Procesos.DTO.AbreProdesoDTO;
import com.api.login.Procesos.Mapper.AbreProdesoMapper;
import com.api.login.Procesos.Service.AbreProdesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/abreproceso")
public class AbreProdesoController {
    @Autowired
    private AbreProdesoService service;

    @Autowired
    private AbreProdesoMapper mapper;

    @GetMapping
    private ResponseEntity<List<AbreProdesoDTO>> listarTodo() {
        List<AbreProdesoDTO> firmas = service.getAllAbreProceso();
        return new ResponseEntity<>(firmas, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<AbreProdesoDTO> Guardar(@RequestBody AbreProdesoDTO dto) {
        AbreProdesoDTO newData = service.createAbreProceso(dto);

        if (newData == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(newData, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AbreProdesoDTO> Actualizar(@PathVariable Long id, @RequestBody AbreProdesoDTO dto) {
        AbreProdesoDTO dtoUpdate = service.updateAbreProceso(id, dto);
        if (dtoUpdate != null) {
            return ResponseEntity.ok(dtoUpdate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Eliminar(@PathVariable Long id) {
        service.deleteAbreProceso(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/encabezado/{id}")
    public List<AbreProdesoDTO> listarPorConstanciaId(@PathVariable Long id) {
        return service.findByIdEnProceso(id);
    }
}
