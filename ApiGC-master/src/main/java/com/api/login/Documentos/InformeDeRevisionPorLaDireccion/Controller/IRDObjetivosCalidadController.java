package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Controller;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.IRDObjetivosCalidadDTO;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service.IRDObjetivosCalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/irdObjetivosCalidad")
public class IRDObjetivosCalidadController {

    @Autowired
    private IRDObjetivosCalidadService irdObjetivosCalidadService;

    @GetMapping
    public List<IRDObjetivosCalidadDTO> getAllObjetivos() {
        return irdObjetivosCalidadService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<IRDObjetivosCalidadDTO> getObjetivoById(@PathVariable Long id) {
        IRDObjetivosCalidadDTO dto = irdObjetivosCalidadService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/informeRevisionDireccion/{idInformeRevisionDireccion}")
    public List<IRDObjetivosCalidadDTO> getObjetivosByInformeRevision(@PathVariable Long idInformeRevisionDireccion) {
        return irdObjetivosCalidadService.findByInformeRevisionDireccion(idInformeRevisionDireccion);
    }

    @PostMapping
    public ResponseEntity<IRDObjetivosCalidadDTO> createObjetivo(@RequestBody IRDObjetivosCalidadDTO irdObjetivosCalidadDTO) {
        IRDObjetivosCalidadDTO savedDTO = irdObjetivosCalidadService.save(irdObjetivosCalidadDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IRDObjetivosCalidadDTO> updateObjetivo(@PathVariable Long id, @RequestBody IRDObjetivosCalidadDTO irdObjetivosCalidadDTO) {
        IRDObjetivosCalidadDTO updatedDTO = irdObjetivosCalidadService.update(id, irdObjetivosCalidadDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteObjetivo(@PathVariable Long id) {
        irdObjetivosCalidadService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

