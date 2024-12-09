package com.api.login.Documentos.ListadoMaestroDocumentos.Controller;

import com.api.login.Documentos.ListadoMaestroDocumentos.DTO.ListadoMaestroDocumentosDTO;
import com.api.login.Documentos.ListadoMaestroDocumentos.Mapper.ListadoMaestroDocumentosMapper;
import com.api.login.Documentos.ListadoMaestroDocumentos.Pojo.ListadoMaestroDocumentos;
import com.api.login.Documentos.ListadoMaestroDocumentos.Service.ListadoMaestroDocumentosService;
import com.lowagie.text.DocumentException;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/listadoMaestroDocumentos")
public class ListadoMaestroDocumentosController {

    @Autowired
    private ListadoMaestroDocumentosService listadoMaestroDocumentosService;

    @Autowired
    private ListadoMaestroDocumentosMapper listadoMaestroDocumentosMapper;

    @GetMapping
    public List<ListadoMaestroDocumentosDTO> getAllDocumentos() {
        List<ListadoMaestroDocumentos> documentos = listadoMaestroDocumentosService.findAll();
        return documentos.stream()
                .map(listadoMaestroDocumentosMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListadoMaestroDocumentosDTO> getDocumentoById(@PathVariable Long id) {
        ListadoMaestroDocumentos documento = listadoMaestroDocumentosService.findById(id);
        ListadoMaestroDocumentosDTO dto = listadoMaestroDocumentosMapper.toDTO(documento);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ListadoMaestroDocumentosDTO> createDocumento(@RequestBody ListadoMaestroDocumentosDTO listadoMaestroDocumentosDTO) {
        ListadoMaestroDocumentos documento = listadoMaestroDocumentosMapper.toEntity(listadoMaestroDocumentosDTO);
        ListadoMaestroDocumentos savedDocumento = listadoMaestroDocumentosService.save(documento);
        ListadoMaestroDocumentosDTO savedDTO = listadoMaestroDocumentosMapper.toDTO(savedDocumento);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListadoMaestroDocumentosDTO> updateDocumento(@PathVariable Long id, @RequestBody ListadoMaestroDocumentosDTO listadoMaestroDocumentosDTO) {
        ListadoMaestroDocumentos updatedDocumento = listadoMaestroDocumentosService.update(id, listadoMaestroDocumentosDTO);
        ListadoMaestroDocumentosDTO updatedDTO = listadoMaestroDocumentosMapper.toDTO(updatedDocumento);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocumento(@PathVariable Long id) {
        listadoMaestroDocumentosService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/reporte/pdf/{id}")
    public ResponseEntity<byte[]> descargarReportePdf(@PathVariable Long id) {
        try {
            byte[] pdfContents = listadoMaestroDocumentosService.generarListadoMaestroPdf(id);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDisposition(ContentDisposition.builder("attachment")
                    .filename("listado_maestro_documentos.pdf")
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

