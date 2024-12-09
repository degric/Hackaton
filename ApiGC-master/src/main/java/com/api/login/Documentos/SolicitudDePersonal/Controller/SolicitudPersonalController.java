package com.api.login.Documentos.SolicitudDePersonal.Controller;

import com.api.login.Documentos.SolicitudDePersonal.DTO.SolicitudPersonalDTO;
import com.api.login.Documentos.SolicitudDePersonal.Service.SolicitudPersonalService;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/solicitudPersonal")
public class SolicitudPersonalController {

    @Autowired
    private SolicitudPersonalService solicitudPersonalService;

    @GetMapping
    public List<SolicitudPersonalDTO> getAllSolicitudes() {
        return solicitudPersonalService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitudPersonalDTO> getSolicitudById(@PathVariable Long id) {
        SolicitudPersonalDTO dto = solicitudPersonalService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<SolicitudPersonalDTO> createSolicitud(@RequestBody SolicitudPersonalDTO solicitudPersonalDTO) {
        SolicitudPersonalDTO savedDTO = solicitudPersonalService.save(solicitudPersonalDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SolicitudPersonalDTO> updateSolicitud(@PathVariable Long id, @RequestBody SolicitudPersonalDTO solicitudPersonalDTO) {
        SolicitudPersonalDTO updatedDTO = solicitudPersonalService.update(id, solicitudPersonalDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSolicitud(@PathVariable Long id) {
        solicitudPersonalService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/reporte/pdf/{id}")
    public ResponseEntity<byte[]> descargarReportePdf(@PathVariable Long id) {
        try {
            byte[] pdfContents = solicitudPersonalService.generarPdf(id);

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

