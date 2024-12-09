package com.api.login.ManualDeCalidad.rest;

import com.api.login.ManualDeCalidad.DTO.ContextoOrganizacionManualDTO;
import com.api.login.ManualDeCalidad.pojo.ContextoOrganizacionManual;
import com.api.login.ManualDeCalidad.pojo.ManualCalidad;
import com.api.login.ManualDeCalidad.Service.ContextoOrganizacionManualService;
import com.api.login.ManualDeCalidad.Service.ManualCalidadService;
import com.api.login.ManualDeCalidad.Mapper.ContextoOrganizacionManualMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contextoOrganizacionManual")
public class ContextoOrganizacionManualController {

    @Autowired
    private ContextoOrganizacionManualService contextoOrganizacionManualService;

    @Autowired
    private ManualCalidadService manualCalidadService;

    @Autowired
    private ContextoOrganizacionManualMapper contextoOrganizacionManualMapper;

    @GetMapping
    public List<ContextoOrganizacionManualDTO> getAllContextoOrganizacionManual() {
        List<ContextoOrganizacionManual> contextos = contextoOrganizacionManualService.findAll();
        return contextos.stream().map(contextoOrganizacionManualMapper::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContextoOrganizacionManualDTO> getContextoOrganizacionManualById(@PathVariable Long id) {
        ContextoOrganizacionManual contexto = contextoOrganizacionManualService.findById(id);
        if (contexto == null) {
            return ResponseEntity.notFound().build();
        }
        ContextoOrganizacionManualDTO dto = contextoOrganizacionManualMapper.toDTO(contexto);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/manualCalidad/{idManualCalidad}")
    public List<ContextoOrganizacionManualDTO> getContextosByManualCalidadId(@PathVariable Long idManualCalidad) {
        List<ContextoOrganizacionManual> contextos = contextoOrganizacionManualService.findByManualCalidadId(idManualCalidad);
        return contextos.stream().map(contextoOrganizacionManualMapper::toDTO).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<ContextoOrganizacionManualDTO> createContextoOrganizacionManual(@RequestBody ContextoOrganizacionManualDTO contextoOrganizacionManualDTO) {
        ManualCalidad manualCalidad = manualCalidadService.findByIdManualC(contextoOrganizacionManualDTO.getIdManualCalidad());
        if (manualCalidad == null) {
            return ResponseEntity.badRequest().build();
        }
        ContextoOrganizacionManual contexto = contextoOrganizacionManualMapper.toEntity(contextoOrganizacionManualDTO, manualCalidad);
        ContextoOrganizacionManual savedContexto = contextoOrganizacionManualService.save(contexto);
        ContextoOrganizacionManualDTO dto = contextoOrganizacionManualMapper.toDTO(savedContexto);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContextoOrganizacionManualDTO> updateContextoOrganizacionManual(@PathVariable Long id,@RequestBody ContextoOrganizacionManualDTO contextoOrganizacionManualDTO) {
        ManualCalidad manualCalidad = manualCalidadService.findByIdManualC(contextoOrganizacionManualDTO.getIdManualCalidad());
        if (manualCalidad == null) {
            return ResponseEntity.badRequest().build();
        }
        ContextoOrganizacionManual contexto = contextoOrganizacionManualService.findById(id);
        if (contexto == null) {
            return ResponseEntity.notFound().build();
        }
        contexto = contextoOrganizacionManualMapper.toEntity(contextoOrganizacionManualDTO, manualCalidad);
        contexto.setIdContextoOrganizacionManual(id); // Ensure the ID remains unchanged
        ContextoOrganizacionManual updatedContexto = contextoOrganizacionManualService.update(id, contexto);
        ContextoOrganizacionManualDTO dto = contextoOrganizacionManualMapper.toDTO(updatedContexto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContextoOrganizacionManual(@PathVariable Long id) {
        contextoOrganizacionManualService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
