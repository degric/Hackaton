package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Controller;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.InformeRevisionDireccionEntradaDTO;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service.InformeRevisionDireccionEntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/informeRevisionDireccionEntrada")
public class InformeRevisionDireccionEntradaController {

    @Autowired
    private InformeRevisionDireccionEntradaService informeRevisionDireccionEntradaService;

    @GetMapping
    public List<InformeRevisionDireccionEntradaDTO> getAllEntradas() {
        return informeRevisionDireccionEntradaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InformeRevisionDireccionEntradaDTO> getEntradaById(@PathVariable Long id) {
        InformeRevisionDireccionEntradaDTO dto = informeRevisionDireccionEntradaService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/informeRevisionDireccion/{idInformeRevisionDireccion}")
    public List<InformeRevisionDireccionEntradaDTO> getEntradasByInformeRevision(@PathVariable Long idInformeRevisionDireccion) {
        return informeRevisionDireccionEntradaService.findByInformeRevisionDireccion(idInformeRevisionDireccion);
    }

    @PostMapping
    public ResponseEntity<InformeRevisionDireccionEntradaDTO> createEntrada(@RequestBody InformeRevisionDireccionEntradaDTO informeRevisionDireccionEntradaDTO) {
        InformeRevisionDireccionEntradaDTO savedDTO = informeRevisionDireccionEntradaService.save(informeRevisionDireccionEntradaDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InformeRevisionDireccionEntradaDTO> updateEntrada(@PathVariable Long id, @RequestBody InformeRevisionDireccionEntradaDTO informeRevisionDireccionEntradaDTO) {
        InformeRevisionDireccionEntradaDTO updatedDTO = informeRevisionDireccionEntradaService.update(id, informeRevisionDireccionEntradaDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntrada(@PathVariable Long id) {
        informeRevisionDireccionEntradaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
