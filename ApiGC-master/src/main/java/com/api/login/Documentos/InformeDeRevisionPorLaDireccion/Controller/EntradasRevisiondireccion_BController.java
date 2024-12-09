package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Controller;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.EntradasRevisiondireccion_BDTO;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service.EntradasRevisiondireccion_BService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entradasRevisiondireccion_B")
public class EntradasRevisiondireccion_BController {

    @Autowired
    private EntradasRevisiondireccion_BService entradasRevisiondireccion_BService;

    @GetMapping
    public List<EntradasRevisiondireccion_BDTO> getAllEntradas() {
        return entradasRevisiondireccion_BService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntradasRevisiondireccion_BDTO> getEntradaById(@PathVariable Long id) {
        EntradasRevisiondireccion_BDTO dto = entradasRevisiondireccion_BService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/informeRevisionDireccion/{idInformeRevisionDireccion}")
    public List<EntradasRevisiondireccion_BDTO> getEntradasByInformeRevision(@PathVariable Long idInformeRevisionDireccion) {
        return entradasRevisiondireccion_BService.findByInformeRevisionDireccion(idInformeRevisionDireccion);
    }

    @PostMapping
    public ResponseEntity<EntradasRevisiondireccion_BDTO> createEntrada(@RequestBody EntradasRevisiondireccion_BDTO entradasRevisiondireccion_BDTO) {
        EntradasRevisiondireccion_BDTO savedDTO = entradasRevisiondireccion_BService.save(entradasRevisiondireccion_BDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntradasRevisiondireccion_BDTO> updateEntrada(@PathVariable Long id, @RequestBody EntradasRevisiondireccion_BDTO entradasRevisiondireccion_BDTO) {
        EntradasRevisiondireccion_BDTO updatedDTO = entradasRevisiondireccion_BService.update(id, entradasRevisiondireccion_BDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntrada(@PathVariable Long id) {
        entradasRevisiondireccion_BService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

