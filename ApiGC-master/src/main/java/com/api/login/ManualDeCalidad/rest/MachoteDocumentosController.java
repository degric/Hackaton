package com.api.login.ManualDeCalidad.rest;

import com.api.login.ManualDeCalidad.DTO.LiderazgoManualDTO;
import com.api.login.ManualDeCalidad.DTO.MachoteDocumentosDTO;
import com.api.login.ManualDeCalidad.Service.MachoteDocumentosService;
import com.api.login.ManualDeCalidad.pojo.LiderazgoManual;
import com.api.login.ManualDeCalidad.pojo.MachoteDocumentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/machoteDocumentos")
public class MachoteDocumentosController {

    @Autowired
    private MachoteDocumentosService service;

    @GetMapping("/{id}")
    public ResponseEntity<MachoteDocumentosDTO> getMachoteDocumentosById(@PathVariable Long id) {
        MachoteDocumentosDTO dto = service.getMachoteDocumentosById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<MachoteDocumentosDTO>> getAllMachoteDocumentos() {
        List<MachoteDocumentosDTO> list = service.getAllMachoteDocumentos();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/nivel/{ni}")
    public ResponseEntity<List<MachoteDocumentosDTO>> getbynivel(@PathVariable Long ni) {
        List<MachoteDocumentosDTO> list = service.getByNivel(ni);
        return ResponseEntity.ok(list);
    }
}

