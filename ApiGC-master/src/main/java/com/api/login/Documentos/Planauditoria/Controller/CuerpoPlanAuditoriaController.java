package com.api.login.Documentos.Planauditoria.Controller;

import com.api.login.Documentos.Planauditoria.DTO.CuerpoPlanAuditoriaDTO;
import com.api.login.Documentos.Planauditoria.Service.CuerpoPlanAuditoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cuerpoPlanAuditoria")
public class CuerpoPlanAuditoriaController {

    @Autowired
    private CuerpoPlanAuditoriaService cuerpoService;

    @GetMapping
    public List<CuerpoPlanAuditoriaDTO> getAllCuerpos() {
        return cuerpoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CuerpoPlanAuditoriaDTO> getCuerpoById(@PathVariable Long id) {
        CuerpoPlanAuditoriaDTO dto = cuerpoService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/planAuditoria/{idPlanAuditoria}")
    public List<CuerpoPlanAuditoriaDTO> getCuerposByPlanAuditoria(@PathVariable Long idPlanAuditoria) {
        return cuerpoService.findByPlanAuditoria(idPlanAuditoria);
    }

    @PostMapping
    public ResponseEntity<CuerpoPlanAuditoriaDTO> createCuerpo(@RequestBody CuerpoPlanAuditoriaDTO cuerpoDTO) {
        CuerpoPlanAuditoriaDTO savedDTO = cuerpoService.save(cuerpoDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CuerpoPlanAuditoriaDTO> updateCuerpo(@PathVariable Long id, @RequestBody CuerpoPlanAuditoriaDTO cuerpoDTO) {
        CuerpoPlanAuditoriaDTO updatedDTO = cuerpoService.update(id, cuerpoDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCuerpo(@PathVariable Long id) {
        cuerpoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

