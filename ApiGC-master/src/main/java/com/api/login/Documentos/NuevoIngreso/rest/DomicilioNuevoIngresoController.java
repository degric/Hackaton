package com.api.login.Documentos.NuevoIngreso.rest;


import com.api.login.Documentos.NuevoIngreso.DTO.DatPersonalNuevoIngresoDTO;
import com.api.login.Documentos.NuevoIngreso.DTO.DomicilioNuevoIngresoDTO;
import com.api.login.Documentos.NuevoIngreso.Mapper.DomicilioNuevoIngresoMapper;
import com.api.login.Documentos.NuevoIngreso.Pojo.DatPersonalNuevoIngreso;
import com.api.login.Documentos.NuevoIngreso.Pojo.DomicilioNuevoIngreso;
import com.api.login.Documentos.NuevoIngreso.Service.DomicilioNuevoIngresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donuevoingreso")
public class DomicilioNuevoIngresoController {

    @Autowired
    private DomicilioNuevoIngresoService service;

    @Autowired
    private DomicilioNuevoIngresoMapper mapper;

    @GetMapping
    private ResponseEntity<List<DomicilioNuevoIngresoDTO>> listarTodo(){
        List<DomicilioNuevoIngresoDTO> firmas = service.getAllDoNuIn();
        return new ResponseEntity<>(firmas, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<DomicilioNuevoIngresoDTO> Guardar(@RequestBody DomicilioNuevoIngresoDTO dto){
        DomicilioNuevoIngreso newDocumentos = service.createDoNuIn(dto);

        if (newDocumentos == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        DomicilioNuevoIngresoDTO newDTO = mapper.toDTODoNuIn(newDocumentos);
        return new ResponseEntity<>(newDTO,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DomicilioNuevoIngresoDTO> Actualizar(@PathVariable Integer id, @RequestBody DomicilioNuevoIngresoDTO dto){
        DomicilioNuevoIngresoDTO dtoUpdate = service.updateDoNuIn(id, dto);
        if (dtoUpdate != null){
            return ResponseEntity.ok(dtoUpdate);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Eliminar(@PathVariable Integer id){
        service.eliminarDoNuIn(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/encabezado/{id}")
    public List<DomicilioNuevoIngresoDTO> listarPorConstanciaId(@PathVariable Integer id){
        return service.getByIdNuevoIngreso(id);
    }
}
