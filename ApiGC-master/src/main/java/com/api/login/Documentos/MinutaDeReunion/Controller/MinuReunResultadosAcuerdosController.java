package com.api.login.Documentos.MinutaDeReunion.Controller;

import com.api.login.Documentos.MinutaDeReunion.DTO.MinuReunResultadosAcuerdosDTO;
import com.api.login.Documentos.MinutaDeReunion.Service.MinuReunResultadosAcuerdosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/minuReunResultadosAcuerdos")
public class MinuReunResultadosAcuerdosController {

    @Autowired
    private MinuReunResultadosAcuerdosService minuReunResultadosAcuerdosService;

    @GetMapping
    public List<MinuReunResultadosAcuerdosDTO> getAllAcuerdos() {
        return minuReunResultadosAcuerdosService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MinuReunResultadosAcuerdosDTO> getAcuerdosById(@PathVariable Long id) {
        MinuReunResultadosAcuerdosDTO dto = minuReunResultadosAcuerdosService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/minutaReunion/{idMinutaReunion}")
    public List<MinuReunResultadosAcuerdosDTO> getAcuerdosByMinutaReunion(@PathVariable Long idMinutaReunion) {
        return minuReunResultadosAcuerdosService.findByMinutaReunion(idMinutaReunion);
    }

    @PostMapping
    public ResponseEntity<MinuReunResultadosAcuerdosDTO> createAcuerdos(@RequestBody MinuReunResultadosAcuerdosDTO minuReunResultadosAcuerdosDTO) {
        MinuReunResultadosAcuerdosDTO savedDTO = minuReunResultadosAcuerdosService.save(minuReunResultadosAcuerdosDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MinuReunResultadosAcuerdosDTO> updateAcuerdos(@PathVariable Long id, @RequestBody MinuReunResultadosAcuerdosDTO minuReunResultadosAcuerdosDTO) {
        MinuReunResultadosAcuerdosDTO updatedDTO = minuReunResultadosAcuerdosService.update(id, minuReunResultadosAcuerdosDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAcuerdos(@PathVariable Long id) {
        minuReunResultadosAcuerdosService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

