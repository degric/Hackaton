package com.api.login.ManualDeCalidad.rest;

import com.api.login.ManualDeCalidad.DTO.PlanificacionManualDTO;
import com.api.login.ManualDeCalidad.pojo.PlanificacionManual;
import com.api.login.ManualDeCalidad.pojo.ManualCalidad;
import com.api.login.ManualDeCalidad.Service.PlanificacionManualService;
import com.api.login.ManualDeCalidad.Service.ManualCalidadService;
import com.api.login.ManualDeCalidad.Mapper.PlanificacionManualMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/planificacionManual")
public class PlanificacionManualController {

    @Autowired
    private PlanificacionManualService planificacionManualService;

    @Autowired
    private ManualCalidadService manualCalidadService;

    @Autowired
    private PlanificacionManualMapper planificacionManualMapper;

    @GetMapping
    public List<PlanificacionManualDTO> getAllPlanificacionManual() {
        List<PlanificacionManual> planificaciones = planificacionManualService.findAll();
        return planificaciones.stream().map(planificacionManualMapper::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanificacionManualDTO> getPlanificacionManualById(@PathVariable Long id) {
        PlanificacionManual planificacion = planificacionManualService.findById(id);
        if (planificacion == null) {
            return ResponseEntity.notFound().build();
        }
        PlanificacionManualDTO dto = planificacionManualMapper.toDTO(planificacion);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/manualCalidad/{idManualCalidad}")
    public List<PlanificacionManualDTO> getPlanificacionesByManualCalidadId(@PathVariable Long idManualCalidad) {
        List<PlanificacionManual> planificaciones = planificacionManualService.findByManualCalidadId(idManualCalidad);
        return planificaciones.stream().map(planificacionManualMapper::toDTO).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<PlanificacionManualDTO> createPlanificacionManual(@RequestBody PlanificacionManualDTO planificacionManualDTO) {
        ManualCalidad manualCalidad = manualCalidadService.findByIdManualC(planificacionManualDTO.getIdManualCalidad());
        if (manualCalidad == null) {
            return ResponseEntity.badRequest().build();
        }
        PlanificacionManual planificacion = planificacionManualMapper.toEntity(planificacionManualDTO, manualCalidad);
        PlanificacionManual savedPlanificacion = planificacionManualService.save(planificacion);
        PlanificacionManualDTO dto = planificacionManualMapper.toDTO(savedPlanificacion);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanificacionManualDTO> updatePlanificacionManual(@PathVariable Long id, @RequestBody PlanificacionManualDTO planificacionManualDTO) {
        ManualCalidad manualCalidad = manualCalidadService.findByIdManualC(planificacionManualDTO.getIdManualCalidad());
        if (manualCalidad == null) {
            return ResponseEntity.badRequest().build();
        }
        PlanificacionManual planificacion = planificacionManualService.findById(id);
        if (planificacion == null) {
            return ResponseEntity.notFound().build();
        }
        planificacion = planificacionManualMapper.toEntity(planificacionManualDTO, manualCalidad);
        planificacion.setIdPlanificacionManual(id); // Ensure the ID remains unchanged
        PlanificacionManual updatedPlanificacion = planificacionManualService.update(id, planificacion);
        PlanificacionManualDTO dto = planificacionManualMapper.toDTO(updatedPlanificacion);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlanificacionManual(@PathVariable Long id) {
        planificacionManualService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

