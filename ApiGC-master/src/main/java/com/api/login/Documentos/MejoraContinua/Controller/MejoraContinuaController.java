package com.api.login.Documentos.MejoraContinua.Controller;

import com.api.login.Documentos.MejoraContinua.DTO.MejoraContinuaDTO;
import com.api.login.Documentos.MejoraContinua.Service.MejoraContinuaService;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mejoraContinua")
public class MejoraContinuaController {

    @Autowired
    private MejoraContinuaService mejoraContinuaService;

    @GetMapping
    public List<MejoraContinuaDTO> getAllMejorasContinuas() {
        return mejoraContinuaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MejoraContinuaDTO> getMejoraContinuaById(@PathVariable Long id) {
        MejoraContinuaDTO dto = mejoraContinuaService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<MejoraContinuaDTO> createMejoraContinua(@RequestBody MejoraContinuaDTO mejoraContinuaDTO) {
        MejoraContinuaDTO savedDTO = mejoraContinuaService.save(mejoraContinuaDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MejoraContinuaDTO> updateMejoraContinua(@PathVariable Long id, @RequestBody MejoraContinuaDTO mejoraContinuaDTO) {
        MejoraContinuaDTO updatedDTO = mejoraContinuaService.update(id, mejoraContinuaDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMejoraContinua(@PathVariable Long id) {
        mejoraContinuaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/reporte/pdf/{id}")
    public ResponseEntity<byte[]> descargarReportePdf(@PathVariable Long id) {
        try {
            byte[] pdfContents = mejoraContinuaService.generarPdf(id);

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

