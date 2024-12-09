package com.api.login.ManualDeCalidad.rest;

import com.api.login.ManualDeCalidad.DTO.RevisionManualDTO;
import com.api.login.ManualDeCalidad.pojo.RevisionManual;
import com.api.login.ManualDeCalidad.pojo.ManualCalidad;
import com.api.login.ManualDeCalidad.Service.RevisionManualService;
import com.api.login.ManualDeCalidad.Service.ManualCalidadService;
import com.api.login.ManualDeCalidad.Mapper.RevisionManualMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/revisionManual")
public class RevisionManualController {

    @Autowired
    private RevisionManualService revisionManualService;

    @Autowired
    private ManualCalidadService manualCalidadService;

    @Autowired
    private RevisionManualMapper revisionManualMapper;

    @GetMapping
    public List<RevisionManualDTO> getAllRevisionManual() {
        List<RevisionManual> revisiones = revisionManualService.findAll();
        return revisiones.stream().map(revisionManualMapper::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RevisionManualDTO> getRevisionManualById(@PathVariable Long id) {
        RevisionManual revision = revisionManualService.findById(id);
        if (revision == null) {
            return ResponseEntity.notFound().build();
        }
        RevisionManualDTO dto = revisionManualMapper.toDTO(revision);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/manualCalidad/{idManualCalidad}")
    public List<RevisionManualDTO> getRevisionesByManualCalidadId(@PathVariable Long idManualCalidad) {
        List<RevisionManual> revisiones = revisionManualService.findByManualCalidadId(idManualCalidad);
        return revisiones.stream().map(revisionManualMapper::toDTO).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<RevisionManualDTO> createRevisionManual(@Validated @RequestBody RevisionManualDTO revisionManualDTO) {
        ManualCalidad manualCalidad = manualCalidadService.findByIdManualC(revisionManualDTO.getIdManualCalidad());
        if (manualCalidad == null) {
            return ResponseEntity.badRequest().build();
        }
        RevisionManual revision = revisionManualMapper.toEntity(revisionManualDTO, manualCalidad);
        RevisionManual savedRevision = revisionManualService.save(revision);
        RevisionManualDTO dto = revisionManualMapper.toDTO(savedRevision);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RevisionManualDTO> updateRevisionManual(@PathVariable Long id, @Validated @RequestBody RevisionManualDTO revisionManualDTO) {
        ManualCalidad manualCalidad = manualCalidadService.findByIdManualC(revisionManualDTO.getIdManualCalidad());
        if (manualCalidad == null) {
            return ResponseEntity.badRequest().build();
        }
        RevisionManual revision = revisionManualService.findById(id);
        if (revision == null) {
            return ResponseEntity.notFound().build();
        }
        revision = revisionManualMapper.toEntity(revisionManualDTO, manualCalidad);
        revision.setIdRevisionManual(id); // Ensure the ID remains unchanged
        RevisionManual updatedRevision = revisionManualService.update(id, revision);
        RevisionManualDTO dto = revisionManualMapper.toDTO(updatedRevision);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRevisionManual(@PathVariable Long id) {
        revisionManualService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

