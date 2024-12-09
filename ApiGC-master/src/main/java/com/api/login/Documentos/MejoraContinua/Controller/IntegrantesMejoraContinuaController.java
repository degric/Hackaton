package com.api.login.Documentos.MejoraContinua.Controller;

import com.api.login.Documentos.MejoraContinua.DTO.IntegrantesMejoraContinuaDTO;
import com.api.login.Documentos.MejoraContinua.Service.IntegrantesMejoraContinuaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/integrantesMejoraContinua")
public class IntegrantesMejoraContinuaController {

    @Autowired
    private IntegrantesMejoraContinuaService integrantesService;

    @GetMapping
    public List<IntegrantesMejoraContinuaDTO> getAllIntegrantes() {
        return integrantesService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<IntegrantesMejoraContinuaDTO> getIntegranteById(@PathVariable Long id) {
        IntegrantesMejoraContinuaDTO dto = integrantesService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/mejoraContinua/{idMejoraContinua}")
    public List<IntegrantesMejoraContinuaDTO> getIntegrantesByMejoraContinua(@PathVariable Long idMejoraContinua) {
        return integrantesService.findByMejoraContinua(idMejoraContinua);
    }

    @PostMapping
    public ResponseEntity<IntegrantesMejoraContinuaDTO> createIntegrante(@RequestBody IntegrantesMejoraContinuaDTO integranteDTO) {
        IntegrantesMejoraContinuaDTO savedDTO = integrantesService.save(integranteDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IntegrantesMejoraContinuaDTO> updateIntegrante(@PathVariable Long id, @RequestBody IntegrantesMejoraContinuaDTO integranteDTO) {
        IntegrantesMejoraContinuaDTO updatedDTO = integrantesService.update(id, integranteDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIntegrante(@PathVariable Long id) {
        integrantesService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

