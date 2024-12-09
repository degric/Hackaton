package com.api.login.Documentos.ListaDeAsistencia.Controller;

import com.api.login.Documentos.ListaDeAsistencia.DTO.ListaAsistenciaDTO;
import com.api.login.Documentos.ListaDeAsistencia.Service.ListaAsistenciaService;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/listaAsistencia")
public class ListaAsistenciaController {

    @Autowired
    private ListaAsistenciaService listaAsistenciaService;

    @GetMapping
    public List<ListaAsistenciaDTO> getAllListaAsistencia() {
        return listaAsistenciaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListaAsistenciaDTO> getListaAsistenciaById(@PathVariable Long id) {
        ListaAsistenciaDTO dto = listaAsistenciaService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ListaAsistenciaDTO> createListaAsistencia(@RequestBody ListaAsistenciaDTO listaAsistenciaDTO) {
        ListaAsistenciaDTO savedDTO = listaAsistenciaService.save(listaAsistenciaDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListaAsistenciaDTO> updateListaAsistencia(@PathVariable Long id, @RequestBody ListaAsistenciaDTO listaAsistenciaDTO) {
        ListaAsistenciaDTO updatedDTO = listaAsistenciaService.update(id, listaAsistenciaDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteListaAsistencia(@PathVariable Long id) {
        listaAsistenciaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/reporte/pdf/{id}")
    public ResponseEntity<byte[]> descargarReportePdf(@PathVariable Long id) {
        try {
            byte[] pdfContents = listaAsistenciaService.generarPdf(id);

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

