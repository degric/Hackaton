package com.api.login.Documentos.MinutaDeReunion.Controller;

import com.api.login.Documentos.MinutaDeReunion.DTO.MinuReunDatosDTO;
import com.api.login.Documentos.MinutaDeReunion.Service.MinuReunDatosService;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/minuReunDatos")
public class MinuReunDatosController {

    @Autowired
    private MinuReunDatosService minuReunDatosService;

    @GetMapping
    public List<MinuReunDatosDTO> getAllDatos() {
        return minuReunDatosService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MinuReunDatosDTO> getDatosById(@PathVariable Long id) {
        MinuReunDatosDTO dto = minuReunDatosService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/minutaReunion/{idMinutaReunion}")
    public List<MinuReunDatosDTO> getDatosByMinutaReunion(@PathVariable Long idMinutaReunion) {
        return minuReunDatosService.findByMinutaReunion(idMinutaReunion);
    }

    @PostMapping
    public ResponseEntity<MinuReunDatosDTO> createDatos(@RequestBody MinuReunDatosDTO minuReunDatosDTO) {
        MinuReunDatosDTO savedDTO = minuReunDatosService.save(minuReunDatosDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MinuReunDatosDTO> updateDatos(@PathVariable Long id, @RequestBody MinuReunDatosDTO minuReunDatosDTO) {
        MinuReunDatosDTO updatedDTO = minuReunDatosService.update(id, minuReunDatosDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDatos(@PathVariable Long id) {
        minuReunDatosService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}

