package com.api.login.Documentos.MejoraContinua.Controller;

import com.api.login.Documentos.MejoraContinua.DTO.EvaluacionEficienciaMejoraContinuaDTO;
import com.api.login.Documentos.MejoraContinua.Service.EvaluacionEficienciaMejoraContinuaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evaluacionEficienciaMejoraContinua")
public class EvaluacionEficienciaMejoraContinuaController {

    @Autowired
    private EvaluacionEficienciaMejoraContinuaService evaluacionService;

    @GetMapping
    public List<EvaluacionEficienciaMejoraContinuaDTO> getAllEvaluaciones() {
        return evaluacionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EvaluacionEficienciaMejoraContinuaDTO> getEvaluacionById(@PathVariable Long id) {
        EvaluacionEficienciaMejoraContinuaDTO dto = evaluacionService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/mejoraContinua/{idMejoraContinua}")
    public ResponseEntity<EvaluacionEficienciaMejoraContinuaDTO> getEvaluacionByMejoraContinua(@PathVariable Long idMejoraContinua) {
        EvaluacionEficienciaMejoraContinuaDTO dto = evaluacionService.findByMejoraContinua(idMejoraContinua);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<EvaluacionEficienciaMejoraContinuaDTO> createEvaluacion(@RequestBody EvaluacionEficienciaMejoraContinuaDTO evaluacionDTO) {
        EvaluacionEficienciaMejoraContinuaDTO savedDTO = evaluacionService.save(evaluacionDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EvaluacionEficienciaMejoraContinuaDTO> updateEvaluacion(@PathVariable Long id, @RequestBody EvaluacionEficienciaMejoraContinuaDTO evaluacionDTO) {
        EvaluacionEficienciaMejoraContinuaDTO updatedDTO = evaluacionService.update(id, evaluacionDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvaluacion(@PathVariable Long id) {
        evaluacionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
