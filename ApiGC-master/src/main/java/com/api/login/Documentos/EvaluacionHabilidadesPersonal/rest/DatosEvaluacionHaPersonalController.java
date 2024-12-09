package com.api.login.Documentos.EvaluacionHabilidadesPersonal.rest;

import com.api.login.Documentos.EvaluacionHabilidadesPersonal.DTO.DatosEvaluacionHaPersonalDTO;
import com.api.login.Documentos.EvaluacionHabilidadesPersonal.Service.DatosEvaluacionHaPersonalService;
import com.api.login.Procesos.DTO.ObjetivoProcesoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/datosevaluacionper")
public class DatosEvaluacionHaPersonalController {

    @Autowired
    private DatosEvaluacionHaPersonalService service;

    @GetMapping
    private ResponseEntity<List<DatosEvaluacionHaPersonalDTO>> listarTodo(){
        List<DatosEvaluacionHaPersonalDTO> firmas = service.getAllDaEvaPer();
        return new ResponseEntity<>(firmas, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<DatosEvaluacionHaPersonalDTO> Guardar(@RequestBody DatosEvaluacionHaPersonalDTO dto){
        DatosEvaluacionHaPersonalDTO newData = service.createDaEvaPer(dto);

        if (newData == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        //ObjetivoProcesoDTO newDTO = mapper.toDTOObProceso(newDocumentos);
        return new ResponseEntity<>(newData,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DatosEvaluacionHaPersonalDTO> Actualizar(@PathVariable Long id, @RequestBody DatosEvaluacionHaPersonalDTO dto){
        DatosEvaluacionHaPersonalDTO dtoUpdate = service.updateDaEvaPer(id, dto);
        if (dtoUpdate != null){
            return ResponseEntity.ok(dtoUpdate);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Eliminar(@PathVariable Long id){
        service.deleteDaEvaPer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/encabezado/{id}")
    public Optional<DatosEvaluacionHaPersonalDTO> listarPorConstanciaId(@PathVariable Long id){
        return service.findByEncabezado(id);
    }
}
