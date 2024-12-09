package com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.rest;

import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.DTO.DetecionNeCaDNCDTO;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Service.DetecionNeCaDNCService;
import com.api.login.Documentos.NuevoIngreso.DTO.NuevoIngresoDTO;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detecionNeCaDNC")
public class DetecionNeCaDNCController {

    @Autowired
    private DetecionNeCaDNCService service;

    @GetMapping
    public List<DetecionNeCaDNCDTO> getAllDetections() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetecionNeCaDNCDTO> getDetectionById(@PathVariable Long id) {
        DetecionNeCaDNCDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<DetecionNeCaDNCDTO> createDetection(@RequestBody DetecionNeCaDNCDTO detecionNeCaDNCDTO) {
        DetecionNeCaDNCDTO savedDTO = service.save(detecionNeCaDNCDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetecionNeCaDNCDTO> updateDetection(@PathVariable Long id, @RequestBody DetecionNeCaDNCDTO detecionNeCaDNCDTO) {
        DetecionNeCaDNCDTO updatedDTO = service.update(id, detecionNeCaDNCDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetection(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/reporte/pdf/{id}")
    public ResponseEntity<byte[]> descargarReportePdf(@PathVariable Long id) {
        try {
            byte[] pdfContents = service.generarPdf(id);

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
