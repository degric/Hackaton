package com.api.login.ManualDeCalidad.rest;

import com.api.login.ManualDeCalidad.DTO.IntroduccionManualDTO;
import com.api.login.ManualDeCalidad.pojo.IntroduccionManual;
import com.api.login.ManualDeCalidad.pojo.ManualCalidad;
import com.api.login.ManualDeCalidad.Service.IntroduccionManualService;
import com.api.login.ManualDeCalidad.Service.ManualCalidadService;
import com.api.login.ManualDeCalidad.Mapper.IntroduccionManualMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/introduccionManual")
public class IntroduccionManualController {

    @Autowired
    private IntroduccionManualService introduccionManualService;

    @Autowired
    private ManualCalidadService manualCalidadService;

    @Autowired
    private IntroduccionManualMapper introduccionManualMapper;

    @GetMapping
    public List<IntroduccionManualDTO> getAllIntroduccionManual() {
        List<IntroduccionManual> introducciones = introduccionManualService.findAll();
        return introducciones.stream().map(introduccionManualMapper::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<IntroduccionManualDTO> getIntroduccionManualById(@PathVariable Long id) {
        IntroduccionManual introduccion = introduccionManualService.findById(id);
        if (introduccion == null) {
            return ResponseEntity.notFound().build();
        }
        IntroduccionManualDTO dto = introduccionManualMapper.toDTO(introduccion);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/manualCalidad/{id}")
    public List<IntroduccionManualDTO> getIntroduccionesByManualCalidadId(@PathVariable Long id) {
        List<IntroduccionManual> introducciones = introduccionManualService.findByManualCalidadId(id);
        return introducciones.stream().map(introduccionManualMapper::toDTO).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<IntroduccionManualDTO> createIntroduccionManual(@RequestBody IntroduccionManualDTO introduccionManualDTO) {
        ManualCalidad manualCalidad = manualCalidadService.findByIdManualC(introduccionManualDTO.getIdManualCalidad());
        if (manualCalidad == null) {
            return ResponseEntity.badRequest().build();
        }
        IntroduccionManual introduccion = introduccionManualMapper.toEntity(introduccionManualDTO, manualCalidad);
        IntroduccionManual savedIntroduccion = introduccionManualService.save(introduccion);
        IntroduccionManualDTO dto = introduccionManualMapper.toDTO(savedIntroduccion);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IntroduccionManualDTO> updateIntroduccionManual(@PathVariable Long id, @RequestBody IntroduccionManualDTO introduccionManualDTO) {
        ManualCalidad manualCalidad = manualCalidadService.findByIdManualC(introduccionManualDTO.getIdManualCalidad());
        if (manualCalidad == null) {
            return ResponseEntity.badRequest().build();
        }
        IntroduccionManual introduccion = introduccionManualService.findById(id);
        if (introduccion == null) {
            return ResponseEntity.notFound().build();
        }
        introduccion = introduccionManualMapper.toEntity(introduccionManualDTO, manualCalidad);
        introduccion.setIdIntroduccionManual(id); // Ensure the ID remains unchanged
        IntroduccionManual updatedIntroduccion = introduccionManualService.update(id, introduccion);
        IntroduccionManualDTO dto = introduccionManualMapper.toDTO(updatedIntroduccion);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIntroduccionManual(@PathVariable Long id) {
        introduccionManualService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

