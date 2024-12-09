package com.api.login.ManualDeCalidad.rest;

import com.api.login.ManualDeCalidad.DTO.EvaluacionDesemManualDTO;
import com.api.login.ManualDeCalidad.pojo.EvaluacionDesemManual;
import com.api.login.ManualDeCalidad.pojo.ManualCalidad;
import com.api.login.ManualDeCalidad.Service.EvaluacionDesemManualService;
import com.api.login.ManualDeCalidad.Service.ManualCalidadService;
import com.api.login.ManualDeCalidad.Mapper.EvaluacionDesemManualMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/evaluacionDesemManual")
public class EvaluacionDesemManualController {

    @Autowired
    private EvaluacionDesemManualService evaluacionDesemManualService;

    @Autowired
    private ManualCalidadService manualCalidadService;

    @Autowired
    private EvaluacionDesemManualMapper evaluacionDesemManualMapper;

    @GetMapping
    public List<EvaluacionDesemManualDTO> getAllEvaluacionDesemManual() {
        List<EvaluacionDesemManual> evaluaciones = evaluacionDesemManualService.findAll();
        return evaluaciones.stream().map(evaluacionDesemManualMapper::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EvaluacionDesemManualDTO> getEvaluacionDesemManualById(@PathVariable Long id) {
        EvaluacionDesemManual evaluacion = evaluacionDesemManualService.findById(id);
        if (evaluacion == null) {
            return ResponseEntity.notFound().build();
        }
        EvaluacionDesemManualDTO dto = evaluacionDesemManualMapper.toDTO(evaluacion);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/manualCalidad/{idManualCalidad}")
    public List<EvaluacionDesemManualDTO> getEvaluacionesByManualCalidadId(@PathVariable Long idManualCalidad) {
        List<EvaluacionDesemManual> evaluaciones = evaluacionDesemManualService.findByManualCalidadId(idManualCalidad);
        return evaluaciones.stream().map(evaluacionDesemManualMapper::toDTO).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<EvaluacionDesemManualDTO> createEvaluacionDesemManual(@RequestBody EvaluacionDesemManualDTO evaluacionDesemManualDTO) {
        ManualCalidad manualCalidad = manualCalidadService.findByIdManualC(evaluacionDesemManualDTO.getIdManualCalidad());
        if (manualCalidad == null) {
            return ResponseEntity.badRequest().build();
        }
        EvaluacionDesemManual evaluacion = evaluacionDesemManualMapper.toEntity(evaluacionDesemManualDTO, manualCalidad);
        EvaluacionDesemManual savedEvaluacion = evaluacionDesemManualService.save(evaluacion);
        EvaluacionDesemManualDTO dto = evaluacionDesemManualMapper.toDTO(savedEvaluacion);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EvaluacionDesemManualDTO> updateEvaluacionDesemManual(@PathVariable Long id,@RequestBody EvaluacionDesemManualDTO evaluacionDesemManualDTO) {
        ManualCalidad manualCalidad = manualCalidadService.findByIdManualC(evaluacionDesemManualDTO.getIdManualCalidad());
        if (manualCalidad == null) {
            return ResponseEntity.badRequest().build();
        }
        EvaluacionDesemManual evaluacion = evaluacionDesemManualService.findById(id);
        if (evaluacion == null) {
            return ResponseEntity.notFound().build();
        }
        evaluacion = evaluacionDesemManualMapper.toEntity(evaluacionDesemManualDTO, manualCalidad);
        evaluacion.setIdEvaluacionDesemManual(id); // Ensure the ID remains unchanged
        EvaluacionDesemManual updatedEvaluacion = evaluacionDesemManualService.update(id, evaluacion);
        EvaluacionDesemManualDTO dto = evaluacionDesemManualMapper.toDTO(updatedEvaluacion);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvaluacionDesemManual(@PathVariable Long id) {
        evaluacionDesemManualService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

