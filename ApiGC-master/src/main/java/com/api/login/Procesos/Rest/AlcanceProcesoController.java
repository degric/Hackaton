package com.api.login.Procesos.Rest;

import com.api.login.Procesos.DTO.AlcanceProcesoDTO;
import com.api.login.Procesos.DTO.ObjetivoProcesoDTO;
import com.api.login.Procesos.Mapper.AlcanceProcesoMapper;
import com.api.login.Procesos.Service.AlcanceProcesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alproceso")
public class AlcanceProcesoController {

    @Autowired
    private AlcanceProcesoService service;

    @Autowired
    private AlcanceProcesoMapper mapper;

    @GetMapping
    private ResponseEntity<List<AlcanceProcesoDTO>> listarTodo(){
        List<AlcanceProcesoDTO> firmas = service.getAllAlProceso();
        return new ResponseEntity<>(firmas, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<AlcanceProcesoDTO> Guardar(@RequestBody AlcanceProcesoDTO dto){
        AlcanceProcesoDTO newData = service.createAlProceso(dto);

        if (newData == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        //ObjetivoProcesoDTO newDTO = mapper.toDTOObProceso(newDocumentos);
        return new ResponseEntity<>(newData,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlcanceProcesoDTO> Actualizar(@PathVariable Long id, @RequestBody AlcanceProcesoDTO dto){
        AlcanceProcesoDTO dtoUpdate = service.updateAlProceso(id, dto);
        if (dtoUpdate != null){
            return ResponseEntity.ok(dtoUpdate);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Eliminar(@PathVariable Long id){
        service.deleteAlProceso(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/encabezado/{id}")
    public Optional<AlcanceProcesoDTO> listarPorConstanciaId(@PathVariable Long id){
        return service.finByIdEnProceso(id);
    }
}
