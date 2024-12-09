package com.api.login.Documentos.SolicitudCotizacion.rest;

import com.api.login.Documentos.SolicitudCotizacion.DTO.CondicionesSolicitudCotizacionDTO;
import com.api.login.Documentos.SolicitudCotizacion.DTO.DatosSolicitudCotizacionDTO;
import com.api.login.Documentos.SolicitudCotizacion.Mapper.DatosSolicitudCotizacionMapper;
import com.api.login.Documentos.SolicitudCotizacion.Service.DatosSolicitudCotizacionService;
import com.api.login.Documentos.SolicitudCotizacion.pojo.CondicionesSolicitudCotizacion;
import com.api.login.Documentos.SolicitudCotizacion.pojo.DatosSolicitudCotizacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/datossolicitudco")
public class DatosSolicitudCotizacionController {

    @Autowired
    private DatosSolicitudCotizacionService service;

    @Autowired
    private DatosSolicitudCotizacionMapper mapper;

    @GetMapping
    private ResponseEntity<List<DatosSolicitudCotizacionDTO>> listarTodo(){
        List<DatosSolicitudCotizacionDTO> firmas = service.GetAllDaSoCo();
        return new ResponseEntity<>(firmas, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<DatosSolicitudCotizacionDTO> Guardar(@RequestBody DatosSolicitudCotizacionDTO dto){
        DatosSolicitudCotizacion newDocumentos = service.createDaSoCo(dto);

        if (newDocumentos == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        DatosSolicitudCotizacionDTO newDTO = mapper.toDTODatosSoCo(newDocumentos);
        return new ResponseEntity<>(newDTO,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DatosSolicitudCotizacionDTO> Actualizar(@PathVariable Integer id, @RequestBody DatosSolicitudCotizacionDTO dto){
        DatosSolicitudCotizacionDTO dtoUpdate = service.updateDaSoCo(id, dto);
        if (dtoUpdate != null){
            return ResponseEntity.ok(dtoUpdate);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Eliminar(@PathVariable Integer id){
        service.deleteDaSoCo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/encabezado/{id}")
    public List<DatosSolicitudCotizacionDTO> listarPorConstanciaId(@PathVariable Integer id){
        return service.getDandiSoliCoti(id);
    }

}
