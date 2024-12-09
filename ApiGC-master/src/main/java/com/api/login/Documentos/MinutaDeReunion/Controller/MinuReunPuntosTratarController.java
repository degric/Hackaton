package com.api.login.Documentos.MinutaDeReunion.Controller;

import com.api.login.Documentos.MinutaDeReunion.DTO.MinuReunPuntosTratarDTO;
import com.api.login.Documentos.MinutaDeReunion.Service.MinuReunPuntosTratarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/minuReunPuntosTratar")
public class MinuReunPuntosTratarController {

    @Autowired
    private MinuReunPuntosTratarService minuReunPuntosTratarService;

    @GetMapping
    public List<MinuReunPuntosTratarDTO> getAllPuntos() {
        return minuReunPuntosTratarService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MinuReunPuntosTratarDTO> getPuntoById(@PathVariable Long id) {
        MinuReunPuntosTratarDTO dto = minuReunPuntosTratarService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/minutaReunion/{idMinutaReunion}")
    public List<MinuReunPuntosTratarDTO> getPuntosByMinutaReunion(@PathVariable Long idMinutaReunion) {
        return minuReunPuntosTratarService.findByMinutaReunion(idMinutaReunion);
    }

    @PostMapping
    public ResponseEntity<MinuReunPuntosTratarDTO> createPunto(@RequestBody MinuReunPuntosTratarDTO minuReunPuntosTratarDTO) {
        MinuReunPuntosTratarDTO savedDTO = minuReunPuntosTratarService.save(minuReunPuntosTratarDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MinuReunPuntosTratarDTO> updatePunto(@PathVariable Long id, @RequestBody MinuReunPuntosTratarDTO minuReunPuntosTratarDTO) {
        MinuReunPuntosTratarDTO updatedDTO = minuReunPuntosTratarService.update(id, minuReunPuntosTratarDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePunto(@PathVariable Long id) {
        minuReunPuntosTratarService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

