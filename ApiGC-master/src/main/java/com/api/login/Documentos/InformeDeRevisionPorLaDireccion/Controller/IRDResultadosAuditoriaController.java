package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Controller;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.IRDResultadosAuditoriaDTO;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service.IRDResultadosAuditoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/irdResultadosAuditoria")
public class IRDResultadosAuditoriaController {

    @Autowired
    private IRDResultadosAuditoriaService irdResultadosAuditoriaService;

    @GetMapping
    public List<IRDResultadosAuditoriaDTO> getAllResultados() {
        return irdResultadosAuditoriaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<IRDResultadosAuditoriaDTO> getResultadoById(@PathVariable Long id) {
        IRDResultadosAuditoriaDTO dto = irdResultadosAuditoriaService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/informeRevisionDireccion/{idInformeRevisionDireccion}")
    public List<IRDResultadosAuditoriaDTO> getResultadosByInformeRevision(@PathVariable Long idInformeRevisionDireccion) {
        return irdResultadosAuditoriaService.findByInformeRevisionDireccion(idInformeRevisionDireccion);
    }

    @PostMapping
    public ResponseEntity<IRDResultadosAuditoriaDTO> createResultado(@RequestBody IRDResultadosAuditoriaDTO irdResultadosAuditoriaDTO) {
        IRDResultadosAuditoriaDTO savedDTO = irdResultadosAuditoriaService.save(irdResultadosAuditoriaDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IRDResultadosAuditoriaDTO> updateResultado(@PathVariable Long id, @RequestBody IRDResultadosAuditoriaDTO irdResultadosAuditoriaDTO) {
        IRDResultadosAuditoriaDTO updatedDTO = irdResultadosAuditoriaService.update(id, irdResultadosAuditoriaDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResultado(@PathVariable Long id) {
        irdResultadosAuditoriaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
