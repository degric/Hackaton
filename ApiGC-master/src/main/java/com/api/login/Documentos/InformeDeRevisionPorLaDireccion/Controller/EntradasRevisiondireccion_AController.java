package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Controller;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.EntradasRevisiondireccion_ADTO;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service.EntradasRevisiondireccion_AService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entradasRevisiondireccion_A")
public class EntradasRevisiondireccion_AController {

    @Autowired
    private EntradasRevisiondireccion_AService entradasRevisiondireccion_AService;

    @GetMapping
    public List<EntradasRevisiondireccion_ADTO> getAllEntradas() {
        return entradasRevisiondireccion_AService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntradasRevisiondireccion_ADTO> getEntradaById(@PathVariable Long id) {
        EntradasRevisiondireccion_ADTO dto = entradasRevisiondireccion_AService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/informeRevisionDireccion/{idInformeRevisionDireccion}")
    public List<EntradasRevisiondireccion_ADTO> getEntradasByInformeRevision(@PathVariable Long idInformeRevisionDireccion) {
        return entradasRevisiondireccion_AService.findByInformeRevisionDireccion(idInformeRevisionDireccion);
    }

    @PostMapping
    public ResponseEntity<EntradasRevisiondireccion_ADTO> createEntrada(@RequestBody EntradasRevisiondireccion_ADTO entradasRevisiondireccion_ADTO) {
        EntradasRevisiondireccion_ADTO savedDTO = entradasRevisiondireccion_AService.save(entradasRevisiondireccion_ADTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntradasRevisiondireccion_ADTO> updateEntrada(@PathVariable Long id, @RequestBody EntradasRevisiondireccion_ADTO entradasRevisiondireccion_ADTO) {
        EntradasRevisiondireccion_ADTO updatedDTO = entradasRevisiondireccion_AService.update(id, entradasRevisiondireccion_ADTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntrada(@PathVariable Long id) {
        entradasRevisiondireccion_AService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

