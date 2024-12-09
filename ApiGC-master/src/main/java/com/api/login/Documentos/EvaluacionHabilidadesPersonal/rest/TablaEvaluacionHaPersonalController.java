package com.api.login.Documentos.EvaluacionHabilidadesPersonal.rest;

import com.api.login.Documentos.EvaluacionHabilidadesPersonal.DTO.TablaEvaluacionHaPersonalDTO;
import com.api.login.Documentos.EvaluacionHabilidadesPersonal.Pojo.promedio;
import com.api.login.Documentos.EvaluacionHabilidadesPersonal.Service.TablaEvaluacionHaPersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tablaevaluacionper")
public class TablaEvaluacionHaPersonalController {
    @Autowired
    private TablaEvaluacionHaPersonalService service;

    @GetMapping
    private ResponseEntity<List<TablaEvaluacionHaPersonalDTO>> listarTodo() {
        List<TablaEvaluacionHaPersonalDTO> firmas = service.getAllDaEvaPer();
        return new ResponseEntity<>(firmas, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<TablaEvaluacionHaPersonalDTO> Guardar(@RequestBody TablaEvaluacionHaPersonalDTO dto) {
        TablaEvaluacionHaPersonalDTO newData = service.createDaEvaPer(dto);
        if (newData == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(newData, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TablaEvaluacionHaPersonalDTO> Actualizar(@PathVariable Long id, @RequestBody TablaEvaluacionHaPersonalDTO dto) {
        TablaEvaluacionHaPersonalDTO dtoUpdate = service.updateDaEvaPer(id, dto);
        if (dtoUpdate != null) {
            return ResponseEntity.ok(dtoUpdate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Eliminar(@PathVariable Long id) {
        service.deleteDaEvaPer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/encabezado/{id}")
    public List<TablaEvaluacionHaPersonalDTO> listarPorConstanciaId(@PathVariable Long id) {
        return service.findByEncabezado(id);
    }

    @GetMapping("/promedio/{id}")
    public ResponseEntity<promedio> resultado(@PathVariable Long id){
        Integer promedio = service.promedio(id);
        if (promedio == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            promedio p = new promedio(promedio);
            return new ResponseEntity<>(p, HttpStatus.OK);
        }
    }
}
