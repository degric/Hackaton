package com.api.login.ManualDeCalidad.rest;

import com.api.login.ManualDeCalidad.DTO.ObjetivoManualDTO;
import com.api.login.ManualDeCalidad.pojo.ObjetivoManual;
import com.api.login.ManualDeCalidad.pojo.ManualCalidad;
import com.api.login.ManualDeCalidad.Service.ObjetivoManualService;
import com.api.login.ManualDeCalidad.Service.ManualCalidadService;
import com.api.login.ManualDeCalidad.Mapper.ObjetivoManualMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/objetivoManual")
public class ObjetivoManualController {

    @Autowired
    private ObjetivoManualService objetivoManualService;

    @Autowired
    private ManualCalidadService manualCalidadService;

    @Autowired
    private ObjetivoManualMapper objetivoManualMapper;

    @GetMapping
    public List<ObjetivoManualDTO> getAllObjetivoManual() {
        List<ObjetivoManual> objetivos = objetivoManualService.findAll();
        return objetivos.stream().map(objetivoManualMapper::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ObjetivoManualDTO> getObjetivoManualById(@PathVariable Long id) {
        ObjetivoManual objetivo = objetivoManualService.findById(id);
        if (objetivo == null) {
            return ResponseEntity.notFound().build();
        }
        ObjetivoManualDTO dto = objetivoManualMapper.toDTO(objetivo);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/manualCalidad/{idManualCalidad}")
    public List<ObjetivoManualDTO> getObjetivosByManualCalidadId(@PathVariable Long idManualCalidad) {
        List<ObjetivoManual> objetivos = objetivoManualService.findByManualCalidadId(idManualCalidad);
        return objetivos.stream().map(objetivoManualMapper::toDTO).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<ObjetivoManualDTO> createObjetivoManual( @RequestBody ObjetivoManualDTO objetivoManualDTO) {
        ManualCalidad manualCalidad = manualCalidadService.findByIdManualC(objetivoManualDTO.getIdManualCalidad());
        if (manualCalidad == null) {
            return ResponseEntity.badRequest().build();
        }
        ObjetivoManual objetivo = objetivoManualMapper.toEntity(objetivoManualDTO, manualCalidad);
        ObjetivoManual savedObjetivo = objetivoManualService.save(objetivo);
        ObjetivoManualDTO dto = objetivoManualMapper.toDTO(savedObjetivo);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ObjetivoManualDTO> updateObjetivoManual(@PathVariable Long id, @RequestBody ObjetivoManualDTO objetivoManualDTO) {
        ManualCalidad manualCalidad = manualCalidadService.findByIdManualC(objetivoManualDTO.getIdManualCalidad());
        if (manualCalidad == null) {
            return ResponseEntity.badRequest().build();
        }
        ObjetivoManual objetivo = objetivoManualService.findById(id);
        if (objetivo == null) {
            return ResponseEntity.notFound().build();
        }
        objetivo = objetivoManualMapper.toEntity(objetivoManualDTO, manualCalidad);
        objetivo.setIdObjetivoManual(id); // Ensure the ID remains unchanged
        ObjetivoManual updatedObjetivo = objetivoManualService.update(id, objetivo);
        ObjetivoManualDTO dto = objetivoManualMapper.toDTO(updatedObjetivo);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteObjetivoManual(@PathVariable Long id) {
        objetivoManualService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

