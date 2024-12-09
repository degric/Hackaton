package com.api.login.Documentos.Planauditoria.Controller;

import com.api.login.Documentos.Planauditoria.DTO.EquipoAuditorPlanAuditoriaDTO;
import com.api.login.Documentos.Planauditoria.Service.EquipoAuditorPlanAuditoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipoAuditorPlanAuditoria")
public class EquipoAuditorPlanAuditoriaController {

    @Autowired
    private EquipoAuditorPlanAuditoriaService equipoAuditorService;

    @GetMapping
    public List<EquipoAuditorPlanAuditoriaDTO> getAllEquipos() {
        return equipoAuditorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipoAuditorPlanAuditoriaDTO> getEquipoById(@PathVariable Long id) {
        EquipoAuditorPlanAuditoriaDTO dto = equipoAuditorService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/planAuditoria/{idPlanAuditoria}")
    public List<EquipoAuditorPlanAuditoriaDTO> getEquiposByPlanAuditoria(@PathVariable Long idPlanAuditoria) {
        return equipoAuditorService.findByPlanAuditoria(idPlanAuditoria);
    }

    @PostMapping
    public ResponseEntity<EquipoAuditorPlanAuditoriaDTO> createEquipo(@RequestBody EquipoAuditorPlanAuditoriaDTO equipoAuditorDTO) {
        EquipoAuditorPlanAuditoriaDTO savedDTO = equipoAuditorService.save(equipoAuditorDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipoAuditorPlanAuditoriaDTO> updateEquipo(@PathVariable Long id, @RequestBody EquipoAuditorPlanAuditoriaDTO equipoAuditorDTO) {
        EquipoAuditorPlanAuditoriaDTO updatedDTO = equipoAuditorService.update(id, equipoAuditorDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipo(@PathVariable Long id) {
        equipoAuditorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
