package com.api.login.Documentos.MinutaDeReunion.Controller;

import com.api.login.Documentos.MinutaDeReunion.DTO.MinutaReunionDTO;
import com.api.login.Documentos.MinutaDeReunion.Service.MinutaReunionService;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/minutaReunion")
public class MinutaReunionController {

    @Autowired
    private MinutaReunionService minutaReunionService;

    @GetMapping
    public List<MinutaReunionDTO> getAllMinutas() {
        return minutaReunionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MinutaReunionDTO> getMinutaById(@PathVariable Long id) {
        MinutaReunionDTO dto = minutaReunionService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<MinutaReunionDTO> createMinuta(@RequestBody MinutaReunionDTO minutaReunionDTO) {
        MinutaReunionDTO savedDTO = minutaReunionService.save(minutaReunionDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MinutaReunionDTO> updateMinuta(@PathVariable Long id, @RequestBody MinutaReunionDTO minutaReunionDTO) {
        MinutaReunionDTO updatedDTO = minutaReunionService.update(id, minutaReunionDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMinuta(@PathVariable Long id) {
        minutaReunionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/reporte/pdf/{id}")
    public ResponseEntity<byte[]> descargarReportePdf(@PathVariable Long id) {
        try {
            byte[] pdfContents = minutaReunionService.generarMinutaPdf(id);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDisposition(ContentDisposition.builder("attachment")
                    .filename("listado_distribucion_documentos.pdf")
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

