package com.api.login.Documentos.Planauditoria.Controller;

import com.api.login.Documentos.Planauditoria.DTO.PlanAuditoriaDTO;
import com.api.login.Documentos.Planauditoria.Service.PlanAuditoriaService;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/planAuditoria")
public class PlanAuditoriaController {

    @Autowired
    private PlanAuditoriaService planAuditoriaService;

    @GetMapping
    public List<PlanAuditoriaDTO> getAllPlans() {
        return planAuditoriaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanAuditoriaDTO> getPlanById(@PathVariable Long id) {
        PlanAuditoriaDTO dto = planAuditoriaService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<PlanAuditoriaDTO> createPlan(@RequestBody PlanAuditoriaDTO planAuditoriaDTO) {
        PlanAuditoriaDTO savedDTO = planAuditoriaService.save(planAuditoriaDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanAuditoriaDTO> updatePlan(@PathVariable Long id, @RequestBody PlanAuditoriaDTO planAuditoriaDTO) {
        PlanAuditoriaDTO updatedDTO = planAuditoriaService.update(id, planAuditoriaDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlan(@PathVariable Long id) {
        planAuditoriaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/reporte/pdf/{id}")
    public ResponseEntity<byte[]> descargarReportePdf(@PathVariable Long id) {
        try {
            byte[] pdfContents = planAuditoriaService.generarBSCPdf(id);

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

