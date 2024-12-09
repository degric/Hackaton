package com.api.login.ManualDeCalidad.rest;

import com.api.login.ManualDeCalidad.DTO.LiderazgoManualDTO;
import com.api.login.ManualDeCalidad.pojo.LiderazgoManual;
import com.api.login.ManualDeCalidad.pojo.ManualCalidad;
import com.api.login.ManualDeCalidad.Service.LiderazgoManualService;
import com.api.login.ManualDeCalidad.Service.ManualCalidadService;
import com.api.login.ManualDeCalidad.Mapper.LiderazgoManualMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/liderazgoManual")
public class LiderazgoManualController {

    @Autowired
    private LiderazgoManualService liderazgoManualService;

    @Autowired
    private ManualCalidadService manualCalidadService;

    @Autowired
    private LiderazgoManualMapper liderazgoManualMapper;

    @GetMapping
    public List<LiderazgoManualDTO> getAllLiderazgoManual() {
        List<LiderazgoManual> liderazgos = liderazgoManualService.findAll();
        return liderazgos.stream().map(liderazgoManualMapper::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LiderazgoManualDTO> getLiderazgoManualById(@PathVariable Long id) {
        LiderazgoManual liderazgo = liderazgoManualService.findById(id);
        if (liderazgo == null) {
            return ResponseEntity.notFound().build();
        }
        LiderazgoManualDTO dto = liderazgoManualMapper.toDTO(liderazgo);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/manualCalidad/{idManualCalidad}")
    public List<LiderazgoManualDTO> getLiderazgosByManualCalidadId(@PathVariable Long idManualCalidad) {
        List<LiderazgoManual> liderazgos = liderazgoManualService.findByManualCalidadId(idManualCalidad);
        return liderazgos.stream().map(liderazgoManualMapper::toDTO).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<LiderazgoManualDTO> createLiderazgoManual(@RequestBody LiderazgoManualDTO liderazgoManualDTO) {
        ManualCalidad manualCalidad = manualCalidadService.findByIdManualC(liderazgoManualDTO.getIdManualCalidad());
        if (manualCalidad == null) {
            return ResponseEntity.badRequest().build();
        }
        LiderazgoManual liderazgo = liderazgoManualMapper.toEntity(liderazgoManualDTO, manualCalidad);
        LiderazgoManual savedLiderazgo = liderazgoManualService.save(liderazgo);
        LiderazgoManualDTO dto = liderazgoManualMapper.toDTO(savedLiderazgo);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LiderazgoManualDTO> updateLiderazgoManual(@PathVariable Long id,@RequestBody LiderazgoManualDTO liderazgoManualDTO) {
        ManualCalidad manualCalidad = manualCalidadService.findByIdManualC(liderazgoManualDTO.getIdManualCalidad());
        if (manualCalidad == null) {
            return ResponseEntity.badRequest().build();
        }
        LiderazgoManual liderazgo = liderazgoManualService.findById(id);
        if (liderazgo == null) {
            return ResponseEntity.notFound().build();
        }
        liderazgo = liderazgoManualMapper.toEntity(liderazgoManualDTO, manualCalidad);
        liderazgo.setIdLiderazgoManual(id); // Ensure the ID remains unchanged
        LiderazgoManual updatedLiderazgo = liderazgoManualService.update(id, liderazgo);
        LiderazgoManualDTO dto = liderazgoManualMapper.toDTO(updatedLiderazgo);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLiderazgoManual(@PathVariable Long id) {
        liderazgoManualService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

