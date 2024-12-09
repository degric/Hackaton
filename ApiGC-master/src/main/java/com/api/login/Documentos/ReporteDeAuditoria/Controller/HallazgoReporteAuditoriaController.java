package com.api.login.Documentos.ReporteDeAuditoria.Controller;

import com.api.login.Documentos.ReporteDeAuditoria.DTO.HallazgoReporteAuditoriaDTO;
import com.api.login.Documentos.ReporteDeAuditoria.Service.HallazgoReporteAuditoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hallazgoReporteAuditoria")
public class HallazgoReporteAuditoriaController {

    @Autowired
    private HallazgoReporteAuditoriaService hallazgoService;

    @GetMapping
    public List<HallazgoReporteAuditoriaDTO> getAllHallazgos() {
        return hallazgoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HallazgoReporteAuditoriaDTO> getHallazgoById(@PathVariable Long id) {
        HallazgoReporteAuditoriaDTO dto = hallazgoService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/reporteAuditoria/{idReporteAuditoria}")
    public List<HallazgoReporteAuditoriaDTO> getHallazgosByReporteAuditoria(@PathVariable Long idReporteAuditoria) {
        return hallazgoService.findByReporteAuditoria(idReporteAuditoria);
    }

    @PostMapping
    public ResponseEntity<HallazgoReporteAuditoriaDTO> createHallazgo(@RequestBody HallazgoReporteAuditoriaDTO hallazgoDTO) {
        HallazgoReporteAuditoriaDTO savedDTO = hallazgoService.save(hallazgoDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HallazgoReporteAuditoriaDTO> updateHallazgo(@PathVariable Long id, @RequestBody HallazgoReporteAuditoriaDTO hallazgoDTO) {
        HallazgoReporteAuditoriaDTO updatedDTO = hallazgoService.update(id, hallazgoDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHallazgo(@PathVariable Long id) {
        hallazgoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

