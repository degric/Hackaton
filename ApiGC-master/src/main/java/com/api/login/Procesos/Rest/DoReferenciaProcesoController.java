package com.api.login.Procesos.Rest;

import com.api.login.Procesos.DTO.DoReferenciaProcesoDTO;
import com.api.login.Procesos.Mapper.DoReferenciaProcesoMapper;
import com.api.login.Procesos.Service.DoReferenciaProcesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reproceso")
public class DoReferenciaProcesoController {

    @Autowired
    private DoReferenciaProcesoService service;

    @Autowired
    private DoReferenciaProcesoMapper mapper;

    @GetMapping
    private ResponseEntity<List<DoReferenciaProcesoDTO>> listarTodo(){
        List<DoReferenciaProcesoDTO> firmas = service.getAllDoReferencia();
        return new ResponseEntity<>(firmas, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<DoReferenciaProcesoDTO> Guardar(@RequestBody DoReferenciaProcesoDTO dto){
        DoReferenciaProcesoDTO newData = service.createDoReferencia(dto);

        if (newData == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(newData, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoReferenciaProcesoDTO> Actualizar(@PathVariable Long id, @RequestBody DoReferenciaProcesoDTO dto){
        DoReferenciaProcesoDTO dtoUpdate = service.updateDoReferencia(id, dto);
        if (dtoUpdate != null){
            return ResponseEntity.ok(dtoUpdate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Eliminar(@PathVariable Long id){
        service.deleteDoReferencia(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/encabezado/{id}")
    public List<DoReferenciaProcesoDTO> listarPorConstanciaId(@PathVariable Long id){
        return service.finByIdEnProceso(id);
    }
}

