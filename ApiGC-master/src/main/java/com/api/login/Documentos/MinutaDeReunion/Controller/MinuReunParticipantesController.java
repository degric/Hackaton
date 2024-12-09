package com.api.login.Documentos.MinutaDeReunion.Controller;

import com.api.login.Documentos.MinutaDeReunion.DTO.MinuReunParticipantesDTO;
import com.api.login.Documentos.MinutaDeReunion.Service.MinuReunParticipantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/minuReunParticipantes")
public class MinuReunParticipantesController {

    @Autowired
    private MinuReunParticipantesService minuReunParticipantesService;

    @GetMapping
    public List<MinuReunParticipantesDTO> getAllParticipantes() {
        return minuReunParticipantesService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MinuReunParticipantesDTO> getParticipantesById(@PathVariable Long id) {
        MinuReunParticipantesDTO dto = minuReunParticipantesService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/minutaReunion/{idMinutaReunion}")
    public List<MinuReunParticipantesDTO> getParticipantesByMinutaReunion(@PathVariable Long idMinutaReunion) {
        return minuReunParticipantesService.findByMinutaReunion(idMinutaReunion);
    }

    @PostMapping
    public ResponseEntity<MinuReunParticipantesDTO> createParticipantes(@RequestBody MinuReunParticipantesDTO minuReunParticipantesDTO) {
        MinuReunParticipantesDTO savedDTO = minuReunParticipantesService.save(minuReunParticipantesDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MinuReunParticipantesDTO> updateParticipantes(@PathVariable Long id, @RequestBody MinuReunParticipantesDTO minuReunParticipantesDTO) {
        MinuReunParticipantesDTO updatedDTO = minuReunParticipantesService.update(id, minuReunParticipantesDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParticipantes(@PathVariable Long id) {
        minuReunParticipantesService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

