package com.api.login.Documentos.Planauditoria.Controller;

import com.api.login.Documentos.Planauditoria.DTO.DatosPlanAuditoriaDTO;
import com.api.login.Documentos.Planauditoria.Service.DatosPlanAuditoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/datosPlanAuditoria")
public class DatosPlanAuditoriaController {

    @Autowired
    private DatosPlanAuditoriaService datosPlanAuditoriaService;

    @GetMapping
    public List<DatosPlanAuditoriaDTO> getAllDatos() {
        return datosPlanAuditoriaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosPlanAuditoriaDTO> getDatosById(@PathVariable Long id) {
        DatosPlanAuditoriaDTO dto = datosPlanAuditoriaService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/planAuditoria/{idPlanAuditoria}")
    public List<DatosPlanAuditoriaDTO> getDatosByPlanAuditoria(@PathVariable Long idPlanAuditoria) {
        return datosPlanAuditoriaService.findByPlanAuditoria(idPlanAuditoria);
    }

    @PostMapping
    public ResponseEntity<DatosPlanAuditoriaDTO> createDatos(@RequestBody DatosPlanAuditoriaDTO datosPlanAuditoriaDTO) {
        DatosPlanAuditoriaDTO savedDTO = datosPlanAuditoriaService.save(datosPlanAuditoriaDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DatosPlanAuditoriaDTO> updateDatos(@PathVariable Long id, @RequestBody DatosPlanAuditoriaDTO datosPlanAuditoriaDTO) {
        DatosPlanAuditoriaDTO updatedDTO = datosPlanAuditoriaService.update(id, datosPlanAuditoriaDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDatos(@PathVariable Long id) {
        datosPlanAuditoriaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

