package com.api.login.Documentos.ListaDeVerificacion.Controller;

import com.api.login.Documentos.ListaDeVerificacion.DTO.ListaVerificacionDTO;
import com.api.login.Documentos.ListaDeVerificacion.Service.ListaVerificacionService;
import com.lowagie.text.DocumentException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/listaVerificacion")
public class ListaVerificacionController {

    @Autowired
    private ListaVerificacionService listaVerificacionService;

    @GetMapping
    public List<ListaVerificacionDTO> getAllListas() {
        return listaVerificacionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListaVerificacionDTO> getListaById(@PathVariable Long id) {
        ListaVerificacionDTO dto = listaVerificacionService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ListaVerificacionDTO> createLista(@RequestBody ListaVerificacionDTO listaVerificacionDTO) {
        ListaVerificacionDTO savedDTO = listaVerificacionService.save(listaVerificacionDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListaVerificacionDTO> updateLista(@PathVariable Long id, @RequestBody ListaVerificacionDTO listaVerificacionDTO) {
        ListaVerificacionDTO updatedDTO = listaVerificacionService.update(id, listaVerificacionDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLista(@PathVariable Long id) {
        listaVerificacionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/reporte/pdf/{id}")
    public ResponseEntity<byte[]> descargarReportePdf(@PathVariable Long id) {
        try {
            byte[] pdfContents = listaVerificacionService.generarBSCPdf(id);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDisposition(ContentDisposition.builder("attachment")
                    .filename("Listado Verificacion.pdf")
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

