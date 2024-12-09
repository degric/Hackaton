package com.api.login.ManualDeCalidad.rest;

import com.api.login.ManualDeCalidad.DTO.MejoraManualDTO;
import com.api.login.ManualDeCalidad.pojo.MejoraManual;
import com.api.login.ManualDeCalidad.pojo.ManualCalidad;
import com.api.login.ManualDeCalidad.Service.MejoraManualService;
import com.api.login.ManualDeCalidad.Service.ManualCalidadService;
import com.api.login.ManualDeCalidad.Mapper.MejoraManualMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mejora")
@Validated
public class MejoraManualController {

    @Autowired
    private MejoraManualService mejoraManualService;

    @Autowired
    private ManualCalidadService manualCalidadService;

    @Autowired
    private MejoraManualMapper mejoraManualMapper;

    @GetMapping
    public List<MejoraManualDTO> getAllMejora() {
        List<MejoraManual> mejoraManuals = mejoraManualService.findAll();
        return mejoraManuals.stream().map(mejoraManualMapper::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MejoraManualDTO> getMejoraById(@PathVariable Long id) {
        MejoraManual mejoraManual = mejoraManualService.findById(id);
        if (mejoraManual == null) {
            return ResponseEntity.notFound().build();
        }
        MejoraManualDTO dto = mejoraManualMapper.toDTO(mejoraManual);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/manualCalidad/{idManualCalidad}")
    public List<MejoraManualDTO> getMejorasByManualCalidadId(@PathVariable Long idManualCalidad) {
        List<MejoraManual> mejoraManuals = mejoraManualService.findByManualCalidadId(idManualCalidad);
        return mejoraManuals.stream().map(mejoraManualMapper::toDTO).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<MejoraManualDTO> createMejora(@Validated @RequestBody MejoraManualDTO mejoraManualDTO) {
        ManualCalidad manualCalidad = manualCalidadService.findByIdManualC(mejoraManualDTO.getIdManualCalidad());
        if (manualCalidad == null) {
            return ResponseEntity.badRequest().build();
        }
        MejoraManual mejoraManual = mejoraManualMapper.toEntity(mejoraManualDTO, manualCalidad);
        MejoraManual savedMejoraManual = mejoraManualService.save(mejoraManual);
        MejoraManualDTO dto = mejoraManualMapper.toDTO(savedMejoraManual);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MejoraManualDTO> updateMejora(@PathVariable Long id, @Validated @RequestBody MejoraManualDTO mejoraManualDTO) {
        ManualCalidad manualCalidad = manualCalidadService.findByIdManualC(mejoraManualDTO.getIdManualCalidad());
        if (manualCalidad == null) {
            return ResponseEntity.badRequest().build();
        }
        MejoraManual mejoraManual = mejoraManualService.findById(id);
        if (mejoraManual == null) {
            return ResponseEntity.notFound().build();
        }
        mejoraManual = mejoraManualMapper.toEntity(mejoraManualDTO, manualCalidad);
        mejoraManual.setIdMejora(id); // Ensure the ID remains unchanged
        MejoraManual updatedMejoraManual = mejoraManualService.update(id, mejoraManual);
        MejoraManualDTO dto = mejoraManualMapper.toDTO(updatedMejoraManual);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMejora(@PathVariable Long id) {
        mejoraManualService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
