package com.api.login.Documentos.ConstanciaInduccion.Controller;

import com.api.login.Documentos.ConstanciaInduccion.DTO.ConstanciaInduccionDTO;
import com.api.login.Documentos.ConstanciaInduccion.Service.ConstanciaInduccionService;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/constanciaInduccion")
public class ConstanciaInduccionController {

    @Autowired
    private ConstanciaInduccionService service;

    @GetMapping
    public List<ConstanciaInduccionDTO> getAllConstancias() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConstanciaInduccionDTO> getConstanciaById(@PathVariable Long id) {
        ConstanciaInduccionDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ConstanciaInduccionDTO> createConstancia(@RequestBody ConstanciaInduccionDTO dto) {
        ConstanciaInduccionDTO savedDTO = service.save(dto);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConstanciaInduccionDTO> updateConstancia(@PathVariable Long id, @RequestBody ConstanciaInduccionDTO dto) {
        ConstanciaInduccionDTO updatedDTO = service.update(id, dto);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConstancia(@PathVariable Long id) {
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
