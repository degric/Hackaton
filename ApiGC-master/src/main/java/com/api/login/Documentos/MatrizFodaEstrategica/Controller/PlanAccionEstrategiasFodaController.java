package com.api.login.Documentos.MatrizFodaEstrategica.Controller;

import com.api.login.Documentos.MatrizFodaEstrategica.DTO.PlanAccionEstrategiasFodaDTO;
import com.api.login.Documentos.MatrizFodaEstrategica.Mapper.PlanAccionEstrategiasFodaMapper;
import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.MatrizFodaEstrategica;
import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.PlanAccionEstrategiasFoda;
import com.api.login.Documentos.MatrizFodaEstrategica.Service.MatrizFodaEstrategicaService;
import com.api.login.Documentos.MatrizFodaEstrategica.Service.PlanAccionEstrategiasFodaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/planAccionEstrategiasFoda")
public class PlanAccionEstrategiasFodaController {

    @Autowired
    private PlanAccionEstrategiasFodaService planAccionService;

    @Autowired
    private PlanAccionEstrategiasFodaMapper planAccionMapper;

    @Autowired
    private MatrizFodaEstrategicaService matrizFodaEstrategicaService;

    /*
    @PostMapping
    public ResponseEntity<PlanAccionEstrategiasFodaDTO> createPlanAccion(@RequestBody PlanAccionEstrategiasFodaDTO planAccionDTO) {

        MatrizFodaEstrategica matriz = matrizFodaEstrategicaService.findById(planAccionDTO.getIdMatrizFodaEstrategica());

        if (matriz == null) {
            return ResponseEntity.badRequest().build();
        }

        PlanAccionEstrategiasFoda planAccion = planAccionMapper.toEntity(planAccionDTO, matriz);

        PlanAccionEstrategiasFoda savedPlanAccion = planAccionService.save(planAccion);

        PlanAccionEstrategiasFodaDTO savedDTO = planAccionMapper.toDTO(savedPlanAccion);

        return ResponseEntity.ok(savedDTO);
    }

     */

    @GetMapping
    public List<PlanAccionEstrategiasFodaDTO> getAllPlanesAccion() {
        List<PlanAccionEstrategiasFoda> planesAccion = planAccionService.findAll();
        return planesAccion.stream()
                .map(planAccionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/matriz/{idMatrizFodaEstrategica}")
    public List<PlanAccionEstrategiasFodaDTO> getPlanesAccionByMatrizId(@PathVariable Long idMatrizFodaEstrategica) {
        List<PlanAccionEstrategiasFoda> planesAccion = planAccionService.findByMatrizFodaEstrategicaId(idMatrizFodaEstrategica);
        return planesAccion.stream()
                .map(planAccionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanAccionEstrategiasFodaDTO> getPlanAccionById(@PathVariable Long id) {
        PlanAccionEstrategiasFoda planAccion = planAccionService.findById(id);
        if (planAccion == null) {
            return ResponseEntity.notFound().build();
        }
        PlanAccionEstrategiasFodaDTO dto = planAccionMapper.toDTO(planAccion);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanAccionEstrategiasFodaDTO> updatePlanAccion(@PathVariable Long id, @RequestBody PlanAccionEstrategiasFodaDTO planAccionDTO) {

        PlanAccionEstrategiasFoda existingPlanAccion = planAccionService.findById(id);
        if (existingPlanAccion == null) {
            return ResponseEntity.notFound().build();
        }

        MatrizFodaEstrategica matriz = matrizFodaEstrategicaService.findById(planAccionDTO.getIdMatrizFodaEstrategica());
        if (matriz == null) {
            return ResponseEntity.badRequest().build();
        }

        existingPlanAccion.setTipo(planAccionDTO.getTipo());
        existingPlanAccion.setEstrategias(planAccionDTO.getEstrategias());
        existingPlanAccion.setObjetivo(planAccionDTO.getObjetivo());
        existingPlanAccion.setFolio(planAccionDTO.getFolio());
        existingPlanAccion.setResponsable(planAccionDTO.getResponsable());
        existingPlanAccion.setFechaMeta(planAccionDTO.getFechaMeta());
        existingPlanAccion.setMatrizFodaEstrategica(matriz);

        PlanAccionEstrategiasFoda updatedPlanAccion = planAccionService.update(id, existingPlanAccion);

        PlanAccionEstrategiasFodaDTO updatedDTO = planAccionMapper.toDTO(updatedPlanAccion);

        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlanAccion(@PathVariable Long id) {
        planAccionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
