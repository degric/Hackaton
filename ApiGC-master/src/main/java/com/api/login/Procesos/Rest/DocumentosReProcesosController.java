package com.api.login.Procesos.Rest;
import com.api.login.ManualDeCalidad.DTO.DocumentosReManualCalidadDTO;
import com.api.login.ManualDeCalidad.Service.DocumentosReManualCalidadService;
import com.api.login.Procesos.DTO.DocumentosReProcesosDTO;
import com.api.login.Procesos.Service.DocumentosReProcesosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documentosReProcesos")
public class DocumentosReProcesosController {

    @Autowired
    private DocumentosReProcesosService service;

    @PostMapping
    public ResponseEntity<DocumentosReProcesosDTO> createDocumentosReManualCalidad(@RequestBody DocumentosReProcesosDTO dto) {
        DocumentosReProcesosDTO createdDTO = service.create(dto);
        return new ResponseEntity<>(createdDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentosReProcesosDTO> getDocumentosReManualCalidadById(@PathVariable Long id) {
        DocumentosReProcesosDTO dto = service.getById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<DocumentosReProcesosDTO>> getAllDocumentosReManualCalidad() {
        List<DocumentosReProcesosDTO> list = service.getAll();
        return ResponseEntity.ok(list);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocumentosReProcesosDTO> updateDocumentosReManualCalidad(@PathVariable Long id, @RequestBody DocumentosReProcesosDTO dto) {
        DocumentosReProcesosDTO updatedDTO = service.update(id, dto);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocumentosReManualCalidad(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/encabezado/{id}")
    public ResponseEntity<List<DocumentosReProcesosDTO>> getDocumentosByIdManual(@PathVariable Long id) {
        List<DocumentosReProcesosDTO> dto = service.getIdproceso(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/orden/{nivel}/{idSubPunto}")
    public ResponseEntity<List<DocumentosReProcesosDTO>> getDocumentosByNivel(@PathVariable Long nivel, @PathVariable Long idSubPunto) {
        List<DocumentosReProcesosDTO> dto = service.getByNivel(nivel,idSubPunto);
        return ResponseEntity.ok(dto);
    }
}
