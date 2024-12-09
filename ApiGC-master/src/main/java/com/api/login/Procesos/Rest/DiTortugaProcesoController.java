package com.api.login.Procesos.Rest;

import com.api.login.Procesos.DTO.DiTortugaProcesoDTO;
import com.api.login.Procesos.Mapper.DiTortugaProcesoMapper;
import com.api.login.Procesos.Service.DiTortugaProcesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ditortuga")
public class DiTortugaProcesoController {

    @Autowired
    private DiTortugaProcesoService service;

    @Autowired
    private DiTortugaProcesoMapper mapper;

    @GetMapping
    private ResponseEntity<List<DiTortugaProcesoDTO>> listarTodo(){
        List<DiTortugaProcesoDTO> firmas = service.getAllDiTortugaProceso();
        return new ResponseEntity<>(firmas, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<DiTortugaProcesoDTO> guardar(@RequestBody DiTortugaProcesoDTO dto){
        DiTortugaProcesoDTO newData = service.createDiTortugaProceso(dto);

        if (newData == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(newData,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiTortugaProcesoDTO> actualizar(@PathVariable Long id, @RequestBody DiTortugaProcesoDTO dto){
        DiTortugaProcesoDTO dtoUpdate = service.updateDiTortugaProceso(id, dto);
        if (dtoUpdate != null){
            return ResponseEntity.ok(dtoUpdate);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        service.deleteDiTortugaProceso(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/encabezado/{id}")
    public List<DiTortugaProcesoDTO> listarPorConstanciaId(@PathVariable Long id){
        return service.findByIdEnProceso(id);
    }
}

