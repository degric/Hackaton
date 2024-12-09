package com.api.login.FilosofiaOrganizacional.Controller;

import com.api.login.FilosofiaOrganizacional.DTO.ValoresDTO;
import com.api.login.FilosofiaOrganizacional.pojo.Valores;
import com.api.login.FilosofiaOrganizacional.Service.ValoresService;
import com.api.login.FilosofiaOrganizacional.Mapper.ValoresMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/valores")
public class ValoresController {

    @Autowired
    private ValoresService valoresService;

    @Autowired
    private ValoresMapper valoresMapper;

    @GetMapping
    public List<ValoresDTO> getAllValores() {
        List<Valores> valoresList = valoresService.findAll();
        return valoresList.stream().map(valoresMapper::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ValoresDTO> getValoresById(@PathVariable Integer id) {
        Valores valores = valoresService.findById(id);
        if (valores == null) {
            return ResponseEntity.notFound().build();
        }
        ValoresDTO dto = valoresMapper.toDTO(valores);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/fecha/{fecha}")
    public List<ValoresDTO> getValoresByFecha(@PathVariable LocalDate fecha) {
        List<Valores> valoresList = valoresService.findByFecha(fecha);
        return valoresList.stream().map(valoresMapper::toDTO).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<ValoresDTO> createValores(@Validated @RequestBody ValoresDTO valoresDTO) {
        Valores valores = valoresMapper.toEntity(valoresDTO);
        Valores savedValores = valoresService.save(valores);
        ValoresDTO dto = valoresMapper.toDTO(savedValores);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ValoresDTO> updateValores(@PathVariable Integer id, @Validated @RequestBody ValoresDTO valoresDTO) {
        Valores valores = valoresService.findById(id);
        if (valores == null) {
            return ResponseEntity.notFound().build();
        }
        valores = valoresMapper.toEntity(valoresDTO);
        valores.setIdValores(id); // Ensure the ID remains unchanged
        Valores updatedValores = valoresService.update(id, valores);
        ValoresDTO dto = valoresMapper.toDTO(updatedValores);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteValores(@PathVariable Integer id) {
        valoresService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

