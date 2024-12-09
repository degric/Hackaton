package com.api.login.Documentos.ConstanciaInduccion.Controller;

import com.api.login.Documentos.ConstanciaInduccion.DTO.InformacionConsInduDTO;
import com.api.login.Documentos.ConstanciaInduccion.Service.InformacionConsInduService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/informacionConsIndu")
public class InformacionConsInduController {

    @Autowired
    private InformacionConsInduService service;

    @GetMapping
    public List<InformacionConsInduDTO> getAllInformacionConsIndu() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InformacionConsInduDTO> getInformacionConsInduById(@PathVariable Long id) {
        InformacionConsInduDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/constanciaInduccion/{idConstanciaInduccion}")
    public List<InformacionConsInduDTO> getInformacionConsInduByConstanciaInduccionId(@PathVariable Long idConstanciaInduccion) {
        return service.findByConstanciaInduccionId(idConstanciaInduccion);
    }

    @PostMapping
    public ResponseEntity<InformacionConsInduDTO> createInformacionConsIndu(@RequestBody InformacionConsInduDTO dto) {
        InformacionConsInduDTO savedDTO = service.save(dto);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InformacionConsInduDTO> updateInformacionConsIndu(@PathVariable Long id, @RequestBody InformacionConsInduDTO dto) {
        InformacionConsInduDTO updatedDTO = service.update(id, dto);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInformacionConsIndu(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
