package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Controller;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.InformeRevisionDireccionDTO;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service.InformeRevisionDireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/informeRevisionDireccion")
public class InformeRevisionDireccionController {

    @Autowired
    private InformeRevisionDireccionService informeRevisionDireccionService;

    @GetMapping
    public List<InformeRevisionDireccionDTO> getAllInformes() {
        return informeRevisionDireccionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InformeRevisionDireccionDTO> getInformeById(@PathVariable Long id) {
        InformeRevisionDireccionDTO dto = informeRevisionDireccionService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<InformeRevisionDireccionDTO> createInforme(@RequestBody InformeRevisionDireccionDTO informeRevisionDireccionDTO) {
        InformeRevisionDireccionDTO savedDTO = informeRevisionDireccionService.save(informeRevisionDireccionDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InformeRevisionDireccionDTO> updateInforme(@PathVariable Long id, @RequestBody InformeRevisionDireccionDTO informeRevisionDireccionDTO) {
        InformeRevisionDireccionDTO updatedDTO = informeRevisionDireccionService.update(id, informeRevisionDireccionDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInforme(@PathVariable Long id) {
        informeRevisionDireccionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
