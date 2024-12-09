package com.api.login.Documentos.NuevoIngreso.rest;

import com.api.login.Documentos.NuevoIngreso.DTO.NuevoIngresoDTO;
import com.api.login.Documentos.NuevoIngreso.Service.NuevoIngresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/nuevoingreso")
public class NuevoIngresoController {

    @Autowired
    private NuevoIngresoService service;

    @GetMapping
    public ResponseEntity<List<NuevoIngresoDTO>> listarEnProceso(){
        List<NuevoIngresoDTO> enProcesoDTOS = service.getAllNuIn();
        return new ResponseEntity<>(enProcesoDTOS, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<NuevoIngresoDTO> ListarPorId(@PathVariable Integer id){
        return service.getByIdNuIn(id)
                .map(enProcesoDTO -> new ResponseEntity<>(enProcesoDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<NuevoIngresoDTO> guardar(@RequestBody NuevoIngresoDTO dto){
        NuevoIngresoDTO createDTO = service.createNuIn(dto);
        return new ResponseEntity<>(createDTO,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NuevoIngresoDTO>actualizar(@PathVariable Integer id, @RequestBody NuevoIngresoDTO dto){
        NuevoIngresoDTO update = service.updateNuIn(id, dto);
        if (update != null){
            return new ResponseEntity<>(update, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id){
        service.deleteNuIn(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
