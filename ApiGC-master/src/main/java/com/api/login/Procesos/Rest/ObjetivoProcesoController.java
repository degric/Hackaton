package com.api.login.Procesos.Rest;

import com.api.login.Documentos.NuevoIngreso.DTO.DatosPersonalesNuevoIngresoDTO;
import com.api.login.Documentos.NuevoIngreso.Pojo.DatosPersonalesNuevoIngreso;
import com.api.login.Procesos.DTO.ObjetivoProcesoDTO;
import com.api.login.Procesos.Mapper.ObjetivoProcesoMapper;
import com.api.login.Procesos.Pojo.ObjetivoProceso;
import com.api.login.Procesos.Service.ObjetivoProcesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/obproceso")
public class ObjetivoProcesoController {

    @Autowired
    private ObjetivoProcesoService service;

    @Autowired
    private ObjetivoProcesoMapper mapper;

    @GetMapping
    private ResponseEntity<List<ObjetivoProcesoDTO>> listarTodo(){
        List<ObjetivoProcesoDTO> firmas = service.getAllObProceso();
        return new ResponseEntity<>(firmas, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<ObjetivoProcesoDTO> Guardar(@RequestBody ObjetivoProcesoDTO dto){
        ObjetivoProcesoDTO newData = service.createObProceso(dto);

        if (newData == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        //ObjetivoProcesoDTO newDTO = mapper.toDTOObProceso(newDocumentos);
        return new ResponseEntity<>(newData,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ObjetivoProcesoDTO> Actualizar(@PathVariable Long id, @RequestBody ObjetivoProcesoDTO dto){
        ObjetivoProcesoDTO dtoUpdate = service.updateObProceso(id, dto);
        if (dtoUpdate != null){
            return ResponseEntity.ok(dtoUpdate);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Eliminar(@PathVariable Long id){
        service.deleteObProceso(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/encabezado/{id}")
    public Optional<ObjetivoProcesoDTO> listarPorConstanciaId(@PathVariable Long id){
        return service.findByIdEnProceso(id);
    }
}
