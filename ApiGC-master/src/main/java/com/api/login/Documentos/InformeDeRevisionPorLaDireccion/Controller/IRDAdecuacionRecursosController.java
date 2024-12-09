package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Controller;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.IRDAdecuacionRecursosDTO;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service.IRDAdecuacionRecursosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/irdAdecuacionRecursos")
public class IRDAdecuacionRecursosController {

    @Autowired
    private IRDAdecuacionRecursosService irdAdecuacionRecursosService;

    @GetMapping
    public List<IRDAdecuacionRecursosDTO> getAllRecursos() {
        return irdAdecuacionRecursosService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<IRDAdecuacionRecursosDTO> getRecursoById(@PathVariable Long id) {
        IRDAdecuacionRecursosDTO dto = irdAdecuacionRecursosService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/informeRevisionDireccion/{idInformeRevisionDireccion}")
    public List<IRDAdecuacionRecursosDTO> getRecursosByInformeRevision(@PathVariable Long idInformeRevisionDireccion) {
        return irdAdecuacionRecursosService.findByInformeRevisionDireccion(idInformeRevisionDireccion);
    }

    @PostMapping
    public ResponseEntity<IRDAdecuacionRecursosDTO> createRecurso(@RequestBody IRDAdecuacionRecursosDTO irdAdecuacionRecursosDTO) {
        IRDAdecuacionRecursosDTO savedDTO = irdAdecuacionRecursosService.save(irdAdecuacionRecursosDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IRDAdecuacionRecursosDTO> updateRecurso(@PathVariable Long id, @RequestBody IRDAdecuacionRecursosDTO irdAdecuacionRecursosDTO) {
        IRDAdecuacionRecursosDTO updatedDTO = irdAdecuacionRecursosService.update(id, irdAdecuacionRecursosDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecurso(@PathVariable Long id) {
        irdAdecuacionRecursosService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

