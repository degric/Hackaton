package com.api.login.Documentos.ReporteDeAuditoria.Controller;

import com.api.login.Documentos.ReporteDeAuditoria.DTO.CierreReporteAuditoria2DTO;
import com.api.login.Documentos.ReporteDeAuditoria.Service.CierreReporteAuditoria2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cierreReporteAuditoria2")
public class CierreReporteAuditoria2Controller {

    @Autowired
    private CierreReporteAuditoria2Service cierreService;

    @GetMapping
    public List<CierreReporteAuditoria2DTO> getAllCierres() {
        return cierreService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CierreReporteAuditoria2DTO> getCierreById(@PathVariable Long id) {
        CierreReporteAuditoria2DTO dto = cierreService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/reporteAuditoria/{idReporteAuditoria}")
    public List<CierreReporteAuditoria2DTO> getCierresByReporteAuditoria(@PathVariable Long idReporteAuditoria) {
        return cierreService.findByReporteAuditoria(idReporteAuditoria);
    }

    @PostMapping
    public ResponseEntity<CierreReporteAuditoria2DTO> createCierre(@RequestBody CierreReporteAuditoria2DTO cierreDTO) {
        CierreReporteAuditoria2DTO savedDTO = cierreService.save(cierreDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CierreReporteAuditoria2DTO> updateCierre(@PathVariable Long id, @RequestBody CierreReporteAuditoria2DTO cierreDTO) {
        CierreReporteAuditoria2DTO updatedDTO = cierreService.update(id, cierreDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCierre(@PathVariable Long id) {
        cierreService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

