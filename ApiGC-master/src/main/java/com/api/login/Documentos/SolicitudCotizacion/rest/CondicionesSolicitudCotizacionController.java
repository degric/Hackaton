package com.api.login.Documentos.SolicitudCotizacion.rest;

import com.api.login.DTO.FirmaLisDisDocumentosDTO;
import com.api.login.Documentos.SolicitudCotizacion.DTO.CondicionesSolicitudCotizacionDTO;
import com.api.login.Documentos.SolicitudCotizacion.Mapper.CondicionesSolicitudCotizacionMapper;
import com.api.login.Documentos.SolicitudCotizacion.Service.CondicionesSolicitudCotizacionService;
import com.api.login.Documentos.SolicitudCotizacion.pojo.CondicionesSolicitudCotizacion;
import com.api.login.pojo.FirmaLisDisDocumentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/condisolicotizacion")
public class CondicionesSolicitudCotizacionController {

    @Autowired
    private CondicionesSolicitudCotizacionService service;

    @Autowired
    private CondicionesSolicitudCotizacionMapper mapper;

    @GetMapping
    private ResponseEntity<List<CondicionesSolicitudCotizacionDTO>> listarTodo(){
        List<CondicionesSolicitudCotizacionDTO> firmas = service.GetAllCoSoCo();
        return new ResponseEntity<>(firmas, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<CondicionesSolicitudCotizacionDTO> Guardar(@RequestBody CondicionesSolicitudCotizacionDTO dto){
        CondicionesSolicitudCotizacion newDocumentos = service.createCoSoCo(dto);

        if (newDocumentos == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        CondicionesSolicitudCotizacionDTO newDTO = mapper.toDtoCoSoCo(newDocumentos);
        return new ResponseEntity<>(newDTO,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CondicionesSolicitudCotizacionDTO> Actualizar(@PathVariable Integer id, @RequestBody CondicionesSolicitudCotizacionDTO dto){
        CondicionesSolicitudCotizacionDTO dtoUpdate = service.updateCoSoCo(id, dto);
        if (dtoUpdate != null){
            return ResponseEntity.ok(dtoUpdate);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Eliminar(@PathVariable Integer id){
        service.deleteCoSoCo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/encabezado/{id}")
    public List<CondicionesSolicitudCotizacionDTO> listarPorConstanciaId(@PathVariable Integer id){
        return service.getCondiSoliCoti(id);
    }

}
