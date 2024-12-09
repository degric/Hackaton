package com.api.login.ManualDeCalidad.rest;

import com.api.login.ManualDeCalidad.DTO.ManualCalidadDTO;
import com.api.login.ManualDeCalidad.Mapper.ManualCalidadMapper;
import com.api.login.ManualDeCalidad.Service.ManualCalidadService;
import com.api.login.ManualDeCalidad.pojo.ManualCalidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manualcalidad")
public class ManualCalidadController {

    @Autowired
    private ManualCalidadService manualCalidadService;

    @Autowired
    private ManualCalidadMapper manualCalidadMapper;

    @GetMapping
    public List<ManualCalidadDTO> getAllManualCalidad() {
        List<ManualCalidad> manuals = manualCalidadService.findAllManualC();
        return manuals.stream().map(manualCalidadMapper::toDTOManualC).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ManualCalidadDTO> getManualCalidadById(@PathVariable Long id) {
        ManualCalidad manual = manualCalidadService.findByIdManualC(id);
        if (manual == null) {
            return ResponseEntity.notFound().build();
        }
        ManualCalidadDTO dto = manualCalidadMapper.toDTOManualC(manual);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/copiarManual/{id}")
    public ResponseEntity<ManualCalidadDTO> copyManualCalidad(@PathVariable Long id){
        ManualCalidad savedManual = manualCalidadService.copyManualC(id);
        ManualCalidadDTO dto = manualCalidadMapper.toDTOManualC(savedManual);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ManualCalidadDTO> createManualCalidad( @RequestBody ManualCalidadDTO manualCalidadDTO) {
        ManualCalidad manual = manualCalidadMapper.toEntityManualC(manualCalidadDTO);
        ManualCalidad savedManual = manualCalidadService.saveManualC(manual);
        ManualCalidadDTO dto = manualCalidadMapper.toDTOManualC(savedManual);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ManualCalidadDTO> updateManualCalidad(@PathVariable Long id, @RequestBody ManualCalidadDTO manualCalidadDTO) {
        ManualCalidad manual = manualCalidadService.findByIdManualC(id);
        if (manual == null) {
            return ResponseEntity.notFound().build();
        }
        // Ensure the ID remains unchanged
        ManualCalidadDTO updatedManual = manualCalidadService.updateManualC(id, manualCalidadDTO);
        return ResponseEntity.ok(updatedManual);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteManualCalidad(@PathVariable Long id) {
        manualCalidadService.deleteByIdManualC(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteManualCalidad() {
        manualCalidadService.eleminartodo();
        return ResponseEntity.ok().build();
    }
}