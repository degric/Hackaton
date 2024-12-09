package com.api.login.Procesos.Rest;

import com.api.login.Procesos.DTO.DistribucionProcesoDTO;
import com.api.login.Procesos.Mapper.DistribucionProcesoMapper;
import com.api.login.Procesos.Service.DistribucionProcesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/distribucionproceso")
public class DistribucionProcesoController {

    @Autowired
    private DistribucionProcesoService service;

    @Autowired
    private DistribucionProcesoMapper mapper;

    @GetMapping
    private ResponseEntity<List<DistribucionProcesoDTO>> listarTodo(){
        List<DistribucionProcesoDTO> firmas = service.getAllDistribucion();
        return new ResponseEntity<>(firmas, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<DistribucionProcesoDTO> Guardar(@RequestBody DistribucionProcesoDTO dto){
        DistribucionProcesoDTO newData = service.createDistribucion(dto);

        if (newData == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        //ObjetivoProcesoDTO newDTO = mapper.toDTOObProceso(newDocumentos);
        return new ResponseEntity<>(newData,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DistribucionProcesoDTO> Actualizar(@PathVariable Long id, @RequestBody DistribucionProcesoDTO dto){
        DistribucionProcesoDTO dtoUpdate = service.updateDistribucion(id, dto);
        if (dtoUpdate != null){
            return ResponseEntity.ok(dtoUpdate);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Eliminar(@PathVariable Long id){
        service.deleteDistribucion(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/encabezado/{id}")
    public Optional<DistribucionProcesoDTO> listarPorConstanciaId(@PathVariable Long id){
        return service.findByIdEnProceso(id);
    }
}

