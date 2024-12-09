package com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Controller;

import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.DTO.ListadoDistribucionDocumentosDTO;
import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Service.ListadoDistribucionDocumentosService;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/listadoDistribucionDocumentos")
public class ListadoDistribucionDocumentosController {

    @Autowired
    private ListadoDistribucionDocumentosService listadoDistribucionDocumentosService;

    @GetMapping
    public List<ListadoDistribucionDocumentosDTO> getAllListados() {
        return listadoDistribucionDocumentosService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListadoDistribucionDocumentosDTO> getListadoById(@PathVariable Long id) {
        ListadoDistribucionDocumentosDTO dto = listadoDistribucionDocumentosService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ListadoDistribucionDocumentosDTO> createListado(@RequestBody ListadoDistribucionDocumentosDTO listadoDistribucionDocumentosDTO) {
        ListadoDistribucionDocumentosDTO savedDTO = listadoDistribucionDocumentosService.save(listadoDistribucionDocumentosDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListadoDistribucionDocumentosDTO> updateListado(@PathVariable Long id, @RequestBody ListadoDistribucionDocumentosDTO listadoDistribucionDocumentosDTO) {
        ListadoDistribucionDocumentosDTO updatedDTO = listadoDistribucionDocumentosService.update(id, listadoDistribucionDocumentosDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteListado(@PathVariable Long id) {
        listadoDistribucionDocumentosService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/reporte/pdf/{id}")
    public ResponseEntity<byte[]> descargarReportePdf(@PathVariable Long id) {
        try {
            byte[] pdfContents = listadoDistribucionDocumentosService.generarReportePdf(id);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDisposition(ContentDisposition.builder("inline") // "inline" para abrir en el navegador
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

