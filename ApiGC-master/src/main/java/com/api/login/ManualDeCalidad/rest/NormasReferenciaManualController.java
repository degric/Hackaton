package com.api.login.ManualDeCalidad.rest;

import com.api.login.ManualDeCalidad.DTO.NormasReferenciaManualDTO;
import com.api.login.ManualDeCalidad.pojo.NormasReferenciaManual;
import com.api.login.ManualDeCalidad.pojo.ManualCalidad;
import com.api.login.ManualDeCalidad.Service.NormasReferenciaManualService;
import com.api.login.ManualDeCalidad.Service.ManualCalidadService;
import com.api.login.ManualDeCalidad.Mapper.NormasReferenciaManualMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/normasReferenciaManual")
public class NormasReferenciaManualController {

    @Autowired
    private NormasReferenciaManualService normasReferenciaManualService;

    @Autowired
    private ManualCalidadService manualCalidadService;

    @Autowired
    private NormasReferenciaManualMapper normasReferenciaManualMapper;

    @GetMapping
    public List<NormasReferenciaManualDTO> getAllNormasReferenciaManual() {
        List<NormasReferenciaManual> normas = normasReferenciaManualService.findAll();
        return normas.stream().map(normasReferenciaManualMapper::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NormasReferenciaManualDTO> getNormasReferenciaManualById(@PathVariable Long id) {
        NormasReferenciaManual norma = normasReferenciaManualService.findById(id);
        if (norma == null) {
            return ResponseEntity.notFound().build();
        }
        NormasReferenciaManualDTO dto = normasReferenciaManualMapper.toDTO(norma);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/manualCalidad/{idManualCalidad}")
    public List<NormasReferenciaManualDTO> getNormasByManualCalidadId(@PathVariable Long idManualCalidad) {
        List<NormasReferenciaManual> normas = normasReferenciaManualService.findByManualCalidadId(idManualCalidad);
        return normas.stream().map(normasReferenciaManualMapper::toDTO).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<NormasReferenciaManualDTO> createNormasReferenciaManual(@RequestBody NormasReferenciaManualDTO normasReferenciaManualDTO) {
        ManualCalidad manualCalidad = manualCalidadService.findByIdManualC(normasReferenciaManualDTO.getIdManualCalidad());
        if (manualCalidad == null) {
            return ResponseEntity.badRequest().build();
        }
        NormasReferenciaManual norma = normasReferenciaManualMapper.toEntity(normasReferenciaManualDTO, manualCalidad);
        NormasReferenciaManual savedNorma = normasReferenciaManualService.save(norma);
        NormasReferenciaManualDTO dto = normasReferenciaManualMapper.toDTO(savedNorma);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NormasReferenciaManualDTO> updateNormasReferenciaManual(@PathVariable Long id,@RequestBody NormasReferenciaManualDTO normasReferenciaManualDTO) {
        ManualCalidad manualCalidad = manualCalidadService.findByIdManualC(normasReferenciaManualDTO.getIdManualCalidad());
        if (manualCalidad == null) {
            return ResponseEntity.badRequest().build();
        }
        NormasReferenciaManual norma = normasReferenciaManualService.findById(id);
        if (norma == null) {
            return ResponseEntity.notFound().build();
        }
        norma = normasReferenciaManualMapper.toEntity(normasReferenciaManualDTO, manualCalidad);
        norma.setIdNormasReferenciaManual(id); // Ensure the ID remains unchanged
        NormasReferenciaManual updatedNorma = normasReferenciaManualService.update(id, norma);
        NormasReferenciaManualDTO dto = normasReferenciaManualMapper.toDTO(updatedNorma);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNormasReferenciaManual(@PathVariable Long id) {
        normasReferenciaManualService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

