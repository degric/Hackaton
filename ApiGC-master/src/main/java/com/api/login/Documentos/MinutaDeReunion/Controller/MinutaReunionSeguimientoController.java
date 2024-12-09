package com.api.login.Documentos.MinutaDeReunion.Controller;

import com.api.login.Documentos.MinutaDeReunion.DTO.MinutaReunionSeguimientoDTO;
import com.api.login.Documentos.MinutaDeReunion.Service.MinutaReunionSeguimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/minutaReunionSeguimiento")
public class MinutaReunionSeguimientoController {

    @Autowired
    private MinutaReunionSeguimientoService minutaReunionSeguimientoService;

    @GetMapping
    public List<MinutaReunionSeguimientoDTO> getAllSeguimientos() {
        return minutaReunionSeguimientoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MinutaReunionSeguimientoDTO> getSeguimientoById(@PathVariable Long id) {
        MinutaReunionSeguimientoDTO dto = minutaReunionSeguimientoService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/minutaReunion/{idMinutaReunion}")
    public List<MinutaReunionSeguimientoDTO> getSeguimientosByMinutaReunion(@PathVariable Long idMinutaReunion) {
        return minutaReunionSeguimientoService.findByMinutaReunion(idMinutaReunion);
    }

    @PostMapping
    public ResponseEntity<MinutaReunionSeguimientoDTO> createSeguimiento(@RequestBody MinutaReunionSeguimientoDTO minutaReunionSeguimientoDTO) {
        MinutaReunionSeguimientoDTO savedDTO = minutaReunionSeguimientoService.save(minutaReunionSeguimientoDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MinutaReunionSeguimientoDTO> updateSeguimiento(@PathVariable Long id, @RequestBody MinutaReunionSeguimientoDTO minutaReunionSeguimientoDTO) {
        MinutaReunionSeguimientoDTO updatedDTO = minutaReunionSeguimientoService.update(id, minutaReunionSeguimientoDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeguimiento(@PathVariable Long id) {
        minutaReunionSeguimientoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

