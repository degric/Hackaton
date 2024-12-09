package com.api.login.Documentos.ConstanciaInduccion.Controller;

import com.api.login.Documentos.ConstanciaInduccion.DTO.ColaboradoresConsInduDTO;
import com.api.login.Documentos.ConstanciaInduccion.Service.ColaboradoresConsInduService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colaboradoresConsIndu")
public class ColaboradoresConsInduController {

    @Autowired
    private ColaboradoresConsInduService service;

    @GetMapping
    public List<ColaboradoresConsInduDTO> getAllColaboradores() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ColaboradoresConsInduDTO> getColaboradorById(@PathVariable Long id) {
        ColaboradoresConsInduDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/constanciaInduccion/{idConstanciaInduccion}")
    public List<ColaboradoresConsInduDTO> getColaboradoresByConstanciaInduccionId(@PathVariable Long idConstanciaInduccion) {
        return service.findByConstanciaInduccionId(idConstanciaInduccion);
    }

    @PostMapping
    public ResponseEntity<ColaboradoresConsInduDTO> createColaborador(@RequestBody ColaboradoresConsInduDTO dto) {
        ColaboradoresConsInduDTO savedDTO = service.save(dto);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ColaboradoresConsInduDTO> updateColaborador(@PathVariable Long id, @RequestBody ColaboradoresConsInduDTO dto) {
        ColaboradoresConsInduDTO updatedDTO = service.update(id, dto);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteColaborador(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
