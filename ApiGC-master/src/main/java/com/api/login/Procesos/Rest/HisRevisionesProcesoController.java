package com.api.login.Procesos.Rest;

import com.api.login.Procesos.DTO.HisRevisionesProcesoDTO;
import com.api.login.Procesos.Mapper.HisRevisionesProcesoMapper;
import com.api.login.Procesos.Service.HisRevisionesProcesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/revisionesproceso")
public class HisRevisionesProcesoController {

    @Autowired
    private HisRevisionesProcesoService service;

    @Autowired
    private HisRevisionesProcesoMapper mapper;

    @GetMapping
    public ResponseEntity<List<HisRevisionesProcesoDTO>> listarTodo(){
        List<HisRevisionesProcesoDTO> revisiones = service.getAllHisRevisionesProceso();
        return new ResponseEntity<>(revisiones, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HisRevisionesProcesoDTO> guardar(@RequestBody HisRevisionesProcesoDTO dto){
        HisRevisionesProcesoDTO newData = service.createHisRevisionesProceso(dto);

        if (newData == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(newData, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HisRevisionesProcesoDTO> actualizar(@PathVariable Long id, @RequestBody HisRevisionesProcesoDTO dto){
        HisRevisionesProcesoDTO dtoUpdate = service.updateHisRevisionesProceso(id, dto);
        if (dtoUpdate != null){
            return ResponseEntity.ok(dtoUpdate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        service.deleteHisRevisionesProceso(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/encabezado/{id}")
    public List<HisRevisionesProcesoDTO> listarPorEnProcesoId(@PathVariable Long id){
        return service.findByIdEnProceso(id);
    }
}

