package com.api.login.Documentos.ReporteDeAuditoria.Controller;

import com.api.login.Documentos.ReporteDeAuditoria.DTO.InfoReporteAuditoriaDTO;
import com.api.login.Documentos.ReporteDeAuditoria.Service.InfoReporteAuditoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/infoReporteAuditoria")
public class InfoReporteAuditoriaController {

    @Autowired
    private InfoReporteAuditoriaService infoReporteAuditoriaService;

    @GetMapping
    public List<InfoReporteAuditoriaDTO> getAllInfo() {
        return infoReporteAuditoriaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InfoReporteAuditoriaDTO> getInfoById(@PathVariable Long id) {
        InfoReporteAuditoriaDTO dto = infoReporteAuditoriaService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/reporteAuditoria/{idReporteAuditoria}")
    public ResponseEntity<InfoReporteAuditoriaDTO> getInfoByReporteAuditoria(@PathVariable Long idReporteAuditoria) {
        InfoReporteAuditoriaDTO dto = infoReporteAuditoriaService.findByReporteAuditoria(idReporteAuditoria);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<InfoReporteAuditoriaDTO> createInfo(@RequestBody InfoReporteAuditoriaDTO infoReporteAuditoriaDTO) {
        InfoReporteAuditoriaDTO savedDTO = infoReporteAuditoriaService.save(infoReporteAuditoriaDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InfoReporteAuditoriaDTO> updateInfo(@PathVariable Long id, @RequestBody InfoReporteAuditoriaDTO infoReporteAuditoriaDTO) {
        InfoReporteAuditoriaDTO updatedDTO = infoReporteAuditoriaService.update(id, infoReporteAuditoriaDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInfo(@PathVariable Long id) {
        infoReporteAuditoriaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
