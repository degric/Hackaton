package com.api.login.Documentos.Planauditoria.Controller;

import com.api.login.Documentos.Planauditoria.DTO.ObservacionesPlanAuditoriasDTO;
import com.api.login.Documentos.Planauditoria.Service.ObservacionesPlanAuditoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/observacionesPlanAuditorias")
public class ObservacionesPlanAuditoriasController {

    @Autowired
    private ObservacionesPlanAuditoriasService observacionesService;

    @GetMapping
    public List<ObservacionesPlanAuditoriasDTO> getAllObservaciones() {
        return observacionesService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ObservacionesPlanAuditoriasDTO> getObservacionById(@PathVariable Long id) {
        ObservacionesPlanAuditoriasDTO dto = observacionesService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/planAuditoria/{idPlanAuditoria}")
    public List<ObservacionesPlanAuditoriasDTO> getObservacionesByPlanAuditoria(@PathVariable Long idPlanAuditoria) {
        return observacionesService.findByPlanAuditoria(idPlanAuditoria);
    }

    @PostMapping
    public ResponseEntity<ObservacionesPlanAuditoriasDTO> createObservacion(@RequestBody ObservacionesPlanAuditoriasDTO observacionesDTO) {
        ObservacionesPlanAuditoriasDTO savedDTO = observacionesService.save(observacionesDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ObservacionesPlanAuditoriasDTO> updateObservacion(@PathVariable Long id, @RequestBody ObservacionesPlanAuditoriasDTO observacionesDTO) {
        ObservacionesPlanAuditoriasDTO updatedDTO = observacionesService.update(id, observacionesDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteObservacion(@PathVariable Long id) {
        observacionesService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
