package com.api.login.Documentos.ProgramaAnualCapacitacion.Controller;

import com.api.login.Documentos.ProgramaAnualCapacitacion.DTO.ProAnualCapacitacionDTO;
import com.api.login.Documentos.ProgramaAnualCapacitacion.Service.ProAnualCapacitacionService;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proAnualCapacitacion")
public class ProAnualCapacitacionController {

    @Autowired
    private ProAnualCapacitacionService service;

    @GetMapping
    public List<ProAnualCapacitacionDTO> getAllProAnualCapacitacion() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProAnualCapacitacionDTO> getProAnualCapacitacionById(@PathVariable Long id) {
        ProAnualCapacitacionDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ProAnualCapacitacionDTO> createProAnualCapacitacion(@RequestBody ProAnualCapacitacionDTO dto) {
        ProAnualCapacitacionDTO savedDTO = service.save(dto);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProAnualCapacitacionDTO> updateProAnualCapacitacion(@PathVariable Long id, @RequestBody ProAnualCapacitacionDTO dto) {
        ProAnualCapacitacionDTO updatedDTO = service.update(id, dto);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProAnualCapacitacion(@PathVariable Long id) {
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
