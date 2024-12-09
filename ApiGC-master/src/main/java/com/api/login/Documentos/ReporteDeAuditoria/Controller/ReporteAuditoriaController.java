package com.api.login.Documentos.ReporteDeAuditoria.Controller;

import com.api.login.Documentos.ReporteDeAuditoria.DTO.ReporteAuditoriaDTO;
import com.api.login.Documentos.ReporteDeAuditoria.Service.ReporteAuditoriaService;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reporteAuditoria")
public class ReporteAuditoriaController {

    @Autowired
    private ReporteAuditoriaService reporteAuditoriaService;

    @GetMapping
    public List<ReporteAuditoriaDTO> getAllReportes() {
        return reporteAuditoriaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReporteAuditoriaDTO> getReporteById(@PathVariable Long id) {
        ReporteAuditoriaDTO dto = reporteAuditoriaService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ReporteAuditoriaDTO> createReporte(@RequestBody ReporteAuditoriaDTO reporteAuditoriaDTO) {
        ReporteAuditoriaDTO savedDTO = reporteAuditoriaService.save(reporteAuditoriaDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReporteAuditoriaDTO> updateReporte(@PathVariable Long id, @RequestBody ReporteAuditoriaDTO reporteAuditoriaDTO) {
        ReporteAuditoriaDTO updatedDTO = reporteAuditoriaService.update(id, reporteAuditoriaDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReporte(@PathVariable Long id) {
        reporteAuditoriaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/reporte/pdf/{id}")
    public ResponseEntity<byte[]> descargarReportePdf(@PathVariable Long id) {
        try {
            byte[] pdfContents = reporteAuditoriaService.generarPdf(id);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDisposition(ContentDisposition.builder("attachment")
                    .filename("Plan Auditoria.pdf")
                    .build());

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(pdfContents);
        } catch (DocumentException e) {
            // Manejo de excepciones
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

