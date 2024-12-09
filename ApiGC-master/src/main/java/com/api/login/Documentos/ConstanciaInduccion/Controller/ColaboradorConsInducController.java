package com.api.login.Documentos.ConstanciaInduccion.Controller;

import com.api.login.Documentos.ConstanciaInduccion.DTO.ColaboradorConsInducDTO;
import com.api.login.Documentos.ConstanciaInduccion.Service.ColaboradorConsInducService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colaboradorConsInduc")
public class ColaboradorConsInducController {

    @Autowired
    private ColaboradorConsInducService service;

    @GetMapping
    public List<ColaboradorConsInducDTO> getAllColaboradores() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ColaboradorConsInducDTO> getColaboradorById(@PathVariable Long id) {
        ColaboradorConsInducDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/constanciaInduccion/{idConstanciaInduccion}")
    public ResponseEntity<ColaboradorConsInducDTO> getColaboradorByConstanciaInduccionId(@PathVariable Long idConstanciaInduccion) {
        ColaboradorConsInducDTO dto = service.findByConstanciaInduccionId(idConstanciaInduccion);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ColaboradorConsInducDTO> createColaborador(@RequestBody ColaboradorConsInducDTO dto) {
        ColaboradorConsInducDTO savedDTO = service.save(dto);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ColaboradorConsInducDTO> updateColaborador(@PathVariable Long id, @RequestBody ColaboradorConsInducDTO dto) {
        ColaboradorConsInducDTO updatedDTO = service.update(id, dto);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteColaborador(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
