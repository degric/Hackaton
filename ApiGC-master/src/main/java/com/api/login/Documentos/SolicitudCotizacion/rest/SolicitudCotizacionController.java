package com.api.login.Documentos.SolicitudCotizacion.rest;

import com.api.login.Documentos.SolicitudCotizacion.DTO.SolicitudCotizacionDTO;
import com.api.login.Documentos.SolicitudCotizacion.Service.SolicitudCotizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/socotizacion")
public class SolicitudCotizacionController {

    @Autowired
    private SolicitudCotizacionService service;

    @GetMapping
    public ResponseEntity<List<SolicitudCotizacionDTO>> listarEnProceso(){
        List<SolicitudCotizacionDTO> enProcesoDTOS = service.getAllSoCoo();
        return new ResponseEntity<>(enProcesoDTOS, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<SolicitudCotizacionDTO> ListarPorId(@PathVariable Integer id){
        return service.getSoCo(id)
                .map(enProcesoDTO -> new ResponseEntity<>(enProcesoDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<SolicitudCotizacionDTO> guardar(@RequestBody SolicitudCotizacionDTO dto){
        SolicitudCotizacionDTO createDTO = service.createSoCo(dto);
        return new ResponseEntity<>(createDTO,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SolicitudCotizacionDTO>actualizar(@PathVariable Integer id, @RequestBody SolicitudCotizacionDTO dto){
        SolicitudCotizacionDTO update = service.updateSoCo(id, dto);
        if (update != null){
            return new ResponseEntity<>(update, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id){
        service.deleteSoCo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
