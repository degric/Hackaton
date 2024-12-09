package com.api.login.ManualDeCalidad.rest;

import com.api.login.ManualDeCalidad.DTO.ApoyoManualDTO;
import com.api.login.ManualDeCalidad.pojo.ApoyoManual;
import com.api.login.ManualDeCalidad.pojo.ManualCalidad;
import com.api.login.ManualDeCalidad.Service.ApoyoManualService;
import com.api.login.ManualDeCalidad.Service.ManualCalidadService;
import com.api.login.ManualDeCalidad.Mapper.ApoyoManualMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/apoyoManual")
public class ApoyoManualController {

    @Autowired
    private ApoyoManualService apoyoManualService;

    @Autowired
    private ManualCalidadService manualCalidadService;

    @Autowired
    private ApoyoManualMapper apoyoManualMapper;

    @GetMapping
    public List<ApoyoManualDTO> getAllApoyoManual() {
        List<ApoyoManual> apoyos = apoyoManualService.findAll();
        return apoyos.stream().map(apoyoManualMapper::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApoyoManualDTO> getApoyoManualById(@PathVariable Long id) {
        ApoyoManual apoyo = apoyoManualService.findById(id);
        if (apoyo == null) {
            return ResponseEntity.notFound().build();
        }
        ApoyoManualDTO dto = apoyoManualMapper.toDTO(apoyo);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/manualCalidad/{idManualCalidad}")
    public List<ApoyoManualDTO> getApoyosByManualCalidadId(@PathVariable Long idManualCalidad) {
        List<ApoyoManual> apoyos = apoyoManualService.findByManualCalidadId(idManualCalidad);
        return apoyos.stream().map(apoyoManualMapper::toDTO).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<ApoyoManualDTO> createApoyoManual(@RequestBody ApoyoManualDTO apoyoManualDTO) {
        ManualCalidad manualCalidad = manualCalidadService.findByIdManualC(apoyoManualDTO.getIdManualCalidad());
        if (manualCalidad == null) {
            return ResponseEntity.badRequest().build();
        }
        ApoyoManual apoyo = apoyoManualMapper.toEntity(apoyoManualDTO, manualCalidad);
        ApoyoManual savedApoyo = apoyoManualService.save(apoyo);
        ApoyoManualDTO dto = apoyoManualMapper.toDTO(savedApoyo);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApoyoManualDTO> updateApoyoManual(@PathVariable Long id,@RequestBody ApoyoManualDTO apoyoManualDTO) {
        ManualCalidad manualCalidad = manualCalidadService.findByIdManualC(apoyoManualDTO.getIdManualCalidad());
        if (manualCalidad == null) {
            return ResponseEntity.badRequest().build();
        }
        ApoyoManual apoyo = apoyoManualService.findById(id);
        if (apoyo == null) {
            return ResponseEntity.notFound().build();
        }
        apoyo = apoyoManualMapper.toEntity(apoyoManualDTO, manualCalidad);
        apoyo.setIdApoyoManual(id); // Ensure the ID remains unchanged
        ApoyoManual updatedApoyo = apoyoManualService.update(id, apoyo);
        ApoyoManualDTO dto = apoyoManualMapper.toDTO(updatedApoyo);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApoyoManual(@PathVariable Long id) {
        apoyoManualService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

