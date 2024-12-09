package com.api.login.Documentos.EvaluacionHabilidadesPersonal.rest;

import com.api.login.Documentos.EvaluacionHabilidadesPersonal.DTO.EvaluacionHabiPersonalDTO;
import com.api.login.Documentos.EvaluacionHabilidadesPersonal.Service.EvaluacionHabiPersonalService;
import com.api.login.Documentos.NuevoIngreso.DTO.NuevoIngresoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/evaluacionper")
public class EvaluacionHabiPersonalController {

    @Autowired
    private EvaluacionHabiPersonalService service;

    @GetMapping
    public ResponseEntity<List<EvaluacionHabiPersonalDTO>> listarEnProceso(){
        List<EvaluacionHabiPersonalDTO> enProcesoDTOS = service.getAllEHaPe();
        return new ResponseEntity<>(enProcesoDTOS, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<EvaluacionHabiPersonalDTO> ListarPorId(@PathVariable Long id){
        return service.getByIdEHaPe(id)
                .map(enProcesoDTO -> new ResponseEntity<>(enProcesoDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<EvaluacionHabiPersonalDTO> guardar(@RequestBody EvaluacionHabiPersonalDTO dto){
        EvaluacionHabiPersonalDTO createDTO = service.createEHaPe(dto);
        return new ResponseEntity<>(createDTO,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EvaluacionHabiPersonalDTO>actualizar(@PathVariable Long id, @RequestBody EvaluacionHabiPersonalDTO dto){
        EvaluacionHabiPersonalDTO update = service.updateEHaPe(id, dto);
        if (update != null){
            return new ResponseEntity<>(update, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        service.deleteEHaPe(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
