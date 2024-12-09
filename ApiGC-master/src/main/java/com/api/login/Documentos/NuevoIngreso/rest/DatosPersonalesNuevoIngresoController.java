package com.api.login.Documentos.NuevoIngreso.rest;

import com.api.login.Documentos.NuevoIngreso.DTO.DatosPersonalesNuevoIngresoDTO;
import com.api.login.Documentos.NuevoIngreso.Mapper.DatosPersonalesNuevoIngresoMapper;
import com.api.login.Documentos.NuevoIngreso.Pojo.DatosPersonalesNuevoIngreso;
import com.api.login.Documentos.NuevoIngreso.Service.DatosPersonalesNuevoIngresoService;
import com.api.login.Documentos.SolicitudCotizacion.DTO.CondicionesSolicitudCotizacionDTO;
import com.api.login.Documentos.SolicitudCotizacion.pojo.CondicionesSolicitudCotizacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dapernuevoingreso")
public class DatosPersonalesNuevoIngresoController {

    @Autowired
    private DatosPersonalesNuevoIngresoService service;

    @Autowired
    private DatosPersonalesNuevoIngresoMapper mapper;

    @GetMapping
    private ResponseEntity<List<DatosPersonalesNuevoIngresoDTO>> listarTodo(){
        List<DatosPersonalesNuevoIngresoDTO> firmas = service.GetAllDaPer();
        return new ResponseEntity<>(firmas, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<DatosPersonalesNuevoIngresoDTO> Guardar(@RequestBody DatosPersonalesNuevoIngresoDTO dto){
        DatosPersonalesNuevoIngreso newDocumentos = service.createDaPer(dto);

        if (newDocumentos == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        DatosPersonalesNuevoIngresoDTO newDTO = mapper.toDtoDaPer(newDocumentos);
        return new ResponseEntity<>(newDTO,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DatosPersonalesNuevoIngresoDTO> Actualizar(@PathVariable Integer id, @RequestBody DatosPersonalesNuevoIngresoDTO dto){
        DatosPersonalesNuevoIngresoDTO dtoUpdate = service.updateDaPer(id, dto);
        if (dtoUpdate != null){
            return ResponseEntity.ok(dtoUpdate);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Eliminar(@PathVariable Integer id){
        service.deleteDaPer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/encabezado/{id}")
    public List<DatosPersonalesNuevoIngresoDTO> listarPorConstanciaId(@PathVariable Integer id){
        return service.getDaPerByNuevoIngreso(id);
    }
}
