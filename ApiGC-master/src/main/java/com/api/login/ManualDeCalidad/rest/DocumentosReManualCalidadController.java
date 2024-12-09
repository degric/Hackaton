package com.api.login.ManualDeCalidad.rest;
import com.api.login.ManualDeCalidad.DTO.DocumentosReManualCalidadDTO;
import com.api.login.ManualDeCalidad.Service.DocumentosReManualCalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documentosReManualCalidad")
public class DocumentosReManualCalidadController {

    @Autowired
    private DocumentosReManualCalidadService service;

    @PostMapping
    public ResponseEntity<DocumentosReManualCalidadDTO> createDocumentosReManualCalidad(@RequestBody DocumentosReManualCalidadDTO dto) {
        DocumentosReManualCalidadDTO createdDTO = service.createDocumentosReManualCalidad(dto);
        return new ResponseEntity<>(createdDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentosReManualCalidadDTO> getDocumentosReManualCalidadById(@PathVariable Long id) {
        DocumentosReManualCalidadDTO dto = service.getDocumentosReManualCalidadById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<DocumentosReManualCalidadDTO>> getAllDocumentosReManualCalidad() {
        List<DocumentosReManualCalidadDTO> list = service.getAllDocumentosReManualCalidad();
        return ResponseEntity.ok(list);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocumentosReManualCalidadDTO> updateDocumentosReManualCalidad(@PathVariable Long id, @RequestBody DocumentosReManualCalidadDTO dto) {
        DocumentosReManualCalidadDTO updatedDTO = service.updateDocumentosReManualCalidad(id, dto);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocumentosReManualCalidad(@PathVariable Long id) {
        service.deleteDocumentosReManualCalidad(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("Manual/{id}")
    public ResponseEntity<List<DocumentosReManualCalidadDTO>> getDocumentosByIdManual(@PathVariable Long id) {
        List<DocumentosReManualCalidadDTO> dto = service.getIdManual(id);
        return ResponseEntity.ok(dto);
    }
}
