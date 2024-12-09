package com.api.login.ManualDeCalidad.rest;

import com.api.login.ManualDeCalidad.DTO.OperacionManualDTO;
import com.api.login.ManualDeCalidad.pojo.OperacionManual;
import com.api.login.ManualDeCalidad.pojo.ManualCalidad;
import com.api.login.ManualDeCalidad.Service.OperacionManualService;
import com.api.login.ManualDeCalidad.Service.ManualCalidadService;
import com.api.login.ManualDeCalidad.Mapper.OperacionManualMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/operacionManual")
public class OperacionManualController {

    @Autowired
    private OperacionManualService operacionManualService;

    @Autowired
    private ManualCalidadService manualCalidadService;

    @Autowired
    private OperacionManualMapper operacionManualMapper;

    @GetMapping
    public List<OperacionManualDTO> getAllOperacionManual() {
        List<OperacionManual> operaciones = operacionManualService.findAll();
        return operaciones.stream().map(operacionManualMapper::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OperacionManualDTO> getOperacionManualById(@PathVariable Long id) {
        OperacionManual operacion = operacionManualService.findById(id);
        if (operacion == null) {
            return ResponseEntity.notFound().build();
        }
        OperacionManualDTO dto = operacionManualMapper.toDTO(operacion);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/manualCalidad/{idManualCalidad}")
    public List<OperacionManualDTO> getOperacionesByManualCalidadId(@PathVariable Long idManualCalidad) {
        List<OperacionManual> operaciones = operacionManualService.findByManualCalidadId(idManualCalidad);
        return operaciones.stream().map(operacionManualMapper::toDTO).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<OperacionManualDTO> createOperacionManual(@RequestBody OperacionManualDTO operacionManualDTO) {
        ManualCalidad manualCalidad = manualCalidadService.findByIdManualC(operacionManualDTO.getIdManualCalidad());
        if (manualCalidad == null) {
            return ResponseEntity.badRequest().build();
        }
        OperacionManual operacion = operacionManualMapper.toEntity(operacionManualDTO, manualCalidad);
        OperacionManual savedOperacion = operacionManualService.save(operacion);
        OperacionManualDTO dto = operacionManualMapper.toDTO(savedOperacion);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OperacionManualDTO> updateOperacionManual(@PathVariable Long id, @RequestBody OperacionManualDTO operacionManualDTO) {
        ManualCalidad manualCalidad = manualCalidadService.findByIdManualC(operacionManualDTO.getIdManualCalidad());
        if (manualCalidad == null) {
            return ResponseEntity.badRequest().build();
        }
        OperacionManual operacion = operacionManualService.findById(id);
        if (operacion == null) {
            return ResponseEntity.notFound().build();
        }
        operacion = operacionManualMapper.toEntity(operacionManualDTO, manualCalidad);
        operacion.setIdOperacionManual(id); // Ensure the ID remains unchanged
        OperacionManual updatedOperacion = operacionManualService.update(id, operacion);
        OperacionManualDTO dto = operacionManualMapper.toDTO(updatedOperacion);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOperacionManual(@PathVariable Long id) {
        operacionManualService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

