package com.api.login.Documentos.ProgramaAnualCapacitacion.Controller;

import com.api.login.Documentos.ProgramaAnualCapacitacion.DTO.TablaProAnualCapacitacionDTO;
import com.api.login.Documentos.ProgramaAnualCapacitacion.Service.TablaProAnualCapacitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tablaProAnualCapacitacion")
public class TablaProAnualCapacitacionController {

    @Autowired
    private TablaProAnualCapacitacionService service;

    @GetMapping
    public List<TablaProAnualCapacitacionDTO> getAllTablas() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TablaProAnualCapacitacionDTO> getTablaById(@PathVariable Long id) {
        TablaProAnualCapacitacionDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/proAnualCapacitacion/{idProAnualCapacitacion}")
    public List<TablaProAnualCapacitacionDTO> getTablasByProAnualCapacitacionId(@PathVariable Long idProAnualCapacitacion) {
        return service.findByProAnualCapacitacionId(idProAnualCapacitacion);
    }

    @PostMapping
    public ResponseEntity<TablaProAnualCapacitacionDTO> createTabla(@RequestBody TablaProAnualCapacitacionDTO dto) {
        TablaProAnualCapacitacionDTO savedDTO = service.save(dto);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TablaProAnualCapacitacionDTO> updateTabla(@PathVariable Long id, @RequestBody TablaProAnualCapacitacionDTO dto) {
        TablaProAnualCapacitacionDTO updatedDTO = service.update(id, dto);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTabla(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

