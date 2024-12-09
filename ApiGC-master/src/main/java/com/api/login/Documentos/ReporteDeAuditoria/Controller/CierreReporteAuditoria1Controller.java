package com.api.login.Documentos.ReporteDeAuditoria.Controller;

import com.api.login.Documentos.ReporteDeAuditoria.DTO.CierreReporteAuditoria1DTO;
import com.api.login.Documentos.ReporteDeAuditoria.Service.CierreReporteAuditoria1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cierreReporteAuditoria1")
public class CierreReporteAuditoria1Controller {

    @Autowired
    private CierreReporteAuditoria1Service cierreService;

    @GetMapping
    public List<CierreReporteAuditoria1DTO> getAllCierres() {
        return cierreService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CierreReporteAuditoria1DTO> getCierreById(@PathVariable Long id) {
        CierreReporteAuditoria1DTO dto = cierreService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/reporteAuditoria/{idReporteAuditoria}")
    public List<CierreReporteAuditoria1DTO> getCierresByReporteAuditoria(@PathVariable Long idReporteAuditoria) {
        return cierreService.findByReporteAuditoria(idReporteAuditoria);
    }

    @PostMapping
    public ResponseEntity<CierreReporteAuditoria1DTO> createCierre(@RequestBody CierreReporteAuditoria1DTO cierreDTO) {
        CierreReporteAuditoria1DTO savedDTO = cierreService.save(cierreDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CierreReporteAuditoria1DTO> updateCierre(@PathVariable Long id, @RequestBody CierreReporteAuditoria1DTO cierreDTO) {
        CierreReporteAuditoria1DTO updatedDTO = cierreService.update(id, cierreDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCierre(@PathVariable Long id) {
        cierreService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

