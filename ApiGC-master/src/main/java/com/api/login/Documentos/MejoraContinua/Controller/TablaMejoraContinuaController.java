package com.api.login.Documentos.MejoraContinua.Controller;

import com.api.login.Documentos.MejoraContinua.DTO.TablaMejoraContinuaDTO;
import com.api.login.Documentos.MejoraContinua.Service.TablaMejoraContinuaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tablaMejoraContinua")
public class TablaMejoraContinuaController {

    @Autowired
    private TablaMejoraContinuaService tablaService;

    @GetMapping
    public List<TablaMejoraContinuaDTO> getAllTablas() {
        return tablaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TablaMejoraContinuaDTO> getTablaById(@PathVariable Long id) {
        TablaMejoraContinuaDTO dto = tablaService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/mejoraContinua/{idMejoraContinua}")
    public List<TablaMejoraContinuaDTO> getTablasByMejoraContinua(@PathVariable Long idMejoraContinua) {
        return tablaService.findByMejoraContinua(idMejoraContinua);
    }

    @PostMapping
    public ResponseEntity<TablaMejoraContinuaDTO> createTabla(@RequestBody TablaMejoraContinuaDTO tablaDTO) {
        TablaMejoraContinuaDTO savedDTO = tablaService.save(tablaDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TablaMejoraContinuaDTO> updateTabla(@PathVariable Long id, @RequestBody TablaMejoraContinuaDTO tablaDTO) {
        TablaMejoraContinuaDTO updatedDTO = tablaService.update(id, tablaDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTabla(@PathVariable Long id) {
        tablaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

