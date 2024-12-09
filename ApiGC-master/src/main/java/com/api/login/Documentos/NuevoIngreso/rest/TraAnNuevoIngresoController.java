package com.api.login.Documentos.NuevoIngreso.rest;

import com.api.login.Documentos.NuevoIngreso.DTO.DomicilioNuevoIngresoDTO;
import com.api.login.Documentos.NuevoIngreso.DTO.TraAnNuevoIngresoDTO;
import com.api.login.Documentos.NuevoIngreso.Mapper.TraAnNuevoIngresoMapper;
import com.api.login.Documentos.NuevoIngreso.Pojo.DomicilioNuevoIngreso;
import com.api.login.Documentos.NuevoIngreso.Pojo.TraAnNuevoIngreso;
import com.api.login.Documentos.NuevoIngreso.Service.TraAnNuevoIngresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/traanuevoingreso")
public class TraAnNuevoIngresoController {

    @Autowired
    private TraAnNuevoIngresoService service;

    @Autowired
    private TraAnNuevoIngresoMapper mapper;

    @GetMapping
    private ResponseEntity<List<TraAnNuevoIngresoDTO>> listarTodo(){
        List<TraAnNuevoIngresoDTO> firmas = service.getAllTraNuIn();
        return new ResponseEntity<>(firmas, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<TraAnNuevoIngresoDTO> Guardar(@RequestBody TraAnNuevoIngresoDTO dto){
        TraAnNuevoIngreso newDocumentos = service.createTraNuIn(dto);

        if (newDocumentos == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        TraAnNuevoIngresoDTO newDTO = mapper.toDTOTraNuIn(newDocumentos);
        return new ResponseEntity<>(newDTO,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TraAnNuevoIngresoDTO> Actualizar(@PathVariable Integer id, @RequestBody TraAnNuevoIngresoDTO dto){
        TraAnNuevoIngresoDTO dtoUpdate = service.updateTraNuIn(id, dto);
        if (dtoUpdate != null){
            return ResponseEntity.ok(dtoUpdate);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Eliminar(@PathVariable Integer id){
        service.deleteTraNuIn(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/encabezado/{id}")
    public List<TraAnNuevoIngresoDTO> listarPorConstanciaId(@PathVariable Integer id){
        return service.getTraByNuIn(id);
    }
}
