package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Controller;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.EntradasRevisiondireccion_CDTO;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service.EntradasRevisiondireccion_CService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entradasRevisiondireccion_C")
public class EntradasRevisiondireccion_CController {

    @Autowired
    private EntradasRevisiondireccion_CService entradasRevisiondireccion_CService;

    @GetMapping
    public List<EntradasRevisiondireccion_CDTO> getAllEntradas() {
        return entradasRevisiondireccion_CService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntradasRevisiondireccion_CDTO> getEntradaById(@PathVariable Long id) {
        EntradasRevisiondireccion_CDTO dto = entradasRevisiondireccion_CService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/informeRevisionDireccion/{idInformeRevisionDireccion}")
    public List<EntradasRevisiondireccion_CDTO> getEntradasByInformeRevision(@PathVariable Long idInformeRevisionDireccion) {
        return entradasRevisiondireccion_CService.findByInformeRevisionDireccion(idInformeRevisionDireccion);
    }

    @PostMapping
    public ResponseEntity<EntradasRevisiondireccion_CDTO> createEntrada(@RequestBody EntradasRevisiondireccion_CDTO entradasRevisiondireccion_CDTO) {
        EntradasRevisiondireccion_CDTO savedDTO = entradasRevisiondireccion_CService.save(entradasRevisiondireccion_CDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntradasRevisiondireccion_CDTO> updateEntrada(@PathVariable Long id, @RequestBody EntradasRevisiondireccion_CDTO entradasRevisiondireccion_CDTO) {
        EntradasRevisiondireccion_CDTO updatedDTO = entradasRevisiondireccion_CService.update(id, entradasRevisiondireccion_CDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntrada(@PathVariable Long id) {
        entradasRevisiondireccion_CService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
