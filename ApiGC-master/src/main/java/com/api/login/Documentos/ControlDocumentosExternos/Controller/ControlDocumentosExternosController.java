package com.api.login.Documentos.ControlDocumentosExternos.Controller;

import com.api.login.Documentos.ControlDocumentosExternos.DTO.ControlDocumentosExternosDTO;
import com.api.login.Documentos.ControlDocumentosExternos.DTO.ControlDocumentosExternosDTOSinListas;
import com.api.login.Documentos.ControlDocumentosExternos.Mapper.ControlDocumentosExternosMapper;
import com.api.login.Documentos.ControlDocumentosExternos.Pojo.ControlDocumentosExternos;
import com.api.login.Documentos.ControlDocumentosExternos.Service.ControlDocumentosExternosService;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/controlDocumentosExternos")
public class ControlDocumentosExternosController {

    @Autowired
    private ControlDocumentosExternosService controlDocumentosExternosService;

    @Autowired
    private ControlDocumentosExternosMapper controlDocumentosExternosMapper;

    @GetMapping
    public List<ControlDocumentosExternosDTO> getAllControlDocumentosExternos() {
        List<ControlDocumentosExternos> controlDocumentosExternosList = controlDocumentosExternosService.findAll();
        return controlDocumentosExternosList.stream()
                .map(controlDocumentosExternosMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/entidad")
    public List<ControlDocumentosExternosDTOSinListas> getAllControlDocumentosExternosSinListas() {
        List<ControlDocumentosExternos> controlDocumentosExternosList = controlDocumentosExternosService.findAll();
        return controlDocumentosExternosList.stream()
                .map(controlDocumentosExternosMapper::toDTOSinListas)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ControlDocumentosExternosDTO> getControlDocumentosExternosById(@PathVariable Long id) {
        ControlDocumentosExternos controlDocumentosExternos = controlDocumentosExternosService.findById(id);
        if (controlDocumentosExternos == null) {
            return ResponseEntity.notFound().build();
        }
        ControlDocumentosExternosDTO dto = controlDocumentosExternosMapper.toDTO(controlDocumentosExternos);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ControlDocumentosExternosDTO> createControlDocumentosExternos(@RequestBody ControlDocumentosExternosDTO controlDocumentosExternosDTO) {
        ControlDocumentosExternos controlDocumentosExternos = controlDocumentosExternosMapper.toEntity(controlDocumentosExternosDTO);
        ControlDocumentosExternos savedControlDocumentosExternos = controlDocumentosExternosService.save(controlDocumentosExternos);
        ControlDocumentosExternosDTO dto = controlDocumentosExternosMapper.toDTO(savedControlDocumentosExternos);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ControlDocumentosExternosDTOSinListas> updateControlDocumentosExternos(
            @PathVariable Long id, @RequestBody ControlDocumentosExternosDTOSinListas controlDocumentosExternosDTO) {

        // Delegar la actualización al servicio
        ControlDocumentosExternos updatedControlDocumentosExternos = controlDocumentosExternosService.update(id, controlDocumentosExternosDTO);

        // Convertir a DTO y devolver la respuesta
        ControlDocumentosExternosDTOSinListas updatedDTO = controlDocumentosExternosMapper.toDTOSinListas(updatedControlDocumentosExternos);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteControlDocumentosExternos(@PathVariable Long id) {
        controlDocumentosExternosService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/reporte/pdf/{id}")
    public ResponseEntity<byte[]> descargarReportePdf(@PathVariable Long id) {
        try {
            byte[] pdfContents = controlDocumentosExternosService.generarReportePdf(id);

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

