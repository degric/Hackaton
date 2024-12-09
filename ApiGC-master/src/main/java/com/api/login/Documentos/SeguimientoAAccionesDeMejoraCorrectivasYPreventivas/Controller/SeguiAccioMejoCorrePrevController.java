package com.api.login.Documentos.SeguimientoAAccionesDeMejoraCorrectivasYPreventivas.Controller;

import com.api.login.Documentos.SeguimientoAAccionesDeMejoraCorrectivasYPreventivas.DTO.SeguiAccioMejoCorrePrevDTO;
import com.api.login.Documentos.SeguimientoAAccionesDeMejoraCorrectivasYPreventivas.Service.SeguiAccioMejoCorrePrevService;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seguiAccioMejoCorrePrev")
public class SeguiAccioMejoCorrePrevController {

    @Autowired
    private SeguiAccioMejoCorrePrevService seguiAccioMejoCorrePrevService;

    @GetMapping
    public List<SeguiAccioMejoCorrePrevDTO> getAllSeguimientos() {
        return seguiAccioMejoCorrePrevService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeguiAccioMejoCorrePrevDTO> getSeguimientoById(@PathVariable Long id) {
        SeguiAccioMejoCorrePrevDTO dto = seguiAccioMejoCorrePrevService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<SeguiAccioMejoCorrePrevDTO> createSeguimiento(@RequestBody SeguiAccioMejoCorrePrevDTO seguiAccioMejoCorrePrevDTO) {
        SeguiAccioMejoCorrePrevDTO savedDTO = seguiAccioMejoCorrePrevService.save(seguiAccioMejoCorrePrevDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SeguiAccioMejoCorrePrevDTO> updateSeguimiento(@PathVariable Long id, @RequestBody SeguiAccioMejoCorrePrevDTO seguiAccioMejoCorrePrevDTO) {
        SeguiAccioMejoCorrePrevDTO updatedDTO = seguiAccioMejoCorrePrevService.update(id, seguiAccioMejoCorrePrevDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeguimiento(@PathVariable Long id) {
        seguiAccioMejoCorrePrevService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/reporte/pdf/{id}")
    public ResponseEntity<byte[]> descargarReportePdf(@PathVariable Long id) {
        try {
            byte[] pdfContents = seguiAccioMejoCorrePrevService.generarReportePdf(id);

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

