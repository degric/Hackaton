package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Controller;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.IRDNoConformidadesAcCorrectivasDTO;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service.IRDNoConformidadesAcCorrectivasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/irdNoConformidadesAcCorrectivas")
public class IRDNoConformidadesAcCorrectivasController {

    @Autowired
    private IRDNoConformidadesAcCorrectivasService irdNoConformidadesAcCorrectivasService;

    @GetMapping
    public List<IRDNoConformidadesAcCorrectivasDTO> getAllNoConformidades() {
        return irdNoConformidadesAcCorrectivasService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<IRDNoConformidadesAcCorrectivasDTO> getNoConformidadById(@PathVariable Long id) {
        IRDNoConformidadesAcCorrectivasDTO dto = irdNoConformidadesAcCorrectivasService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/informeRevisionDireccion/{idInformeRevisionDireccion}")
    public List<IRDNoConformidadesAcCorrectivasDTO> getNoConformidadesByInformeRevision(@PathVariable Long idInformeRevisionDireccion) {
        return irdNoConformidadesAcCorrectivasService.findByInformeRevisionDireccion(idInformeRevisionDireccion);
    }

    @PostMapping
    public ResponseEntity<IRDNoConformidadesAcCorrectivasDTO> createNoConformidad(@RequestBody IRDNoConformidadesAcCorrectivasDTO irdNoConformidadesAcCorrectivasDTO) {
        IRDNoConformidadesAcCorrectivasDTO savedDTO = irdNoConformidadesAcCorrectivasService.save(irdNoConformidadesAcCorrectivasDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IRDNoConformidadesAcCorrectivasDTO> updateNoConformidad(@PathVariable Long id, @RequestBody IRDNoConformidadesAcCorrectivasDTO irdNoConformidadesAcCorrectivasDTO) {
        IRDNoConformidadesAcCorrectivasDTO updatedDTO = irdNoConformidadesAcCorrectivasService.update(id, irdNoConformidadesAcCorrectivasDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNoConformidad(@PathVariable Long id) {
        irdNoConformidadesAcCorrectivasService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
