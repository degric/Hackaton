package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Controller;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.IRDResultadosSeguimientoMedicionDTO;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service.IRDResultadosSeguimientoMedicionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/irdResultadosSeguimientoMedicion")
public class IRDResultadosSeguimientoMedicionController {

    @Autowired
    private IRDResultadosSeguimientoMedicionService irdResultadosSeguimientoMedicionService;

    @GetMapping
    public List<IRDResultadosSeguimientoMedicionDTO> getAllResultados() {
        return irdResultadosSeguimientoMedicionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<IRDResultadosSeguimientoMedicionDTO> getResultadoById(@PathVariable Long id) {
        IRDResultadosSeguimientoMedicionDTO dto = irdResultadosSeguimientoMedicionService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/informeRevisionDireccion/{idInformeRevisionDireccion}")
    public List<IRDResultadosSeguimientoMedicionDTO> getResultadosByInformeRevision(@PathVariable Long idInformeRevisionDireccion) {
        return irdResultadosSeguimientoMedicionService.findByInformeRevisionDireccion(idInformeRevisionDireccion);
    }

    @PostMapping
    public ResponseEntity<IRDResultadosSeguimientoMedicionDTO> createResultado(@RequestBody IRDResultadosSeguimientoMedicionDTO irdResultadosSeguimientoMedicionDTO) {
        IRDResultadosSeguimientoMedicionDTO savedDTO = irdResultadosSeguimientoMedicionService.save(irdResultadosSeguimientoMedicionDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IRDResultadosSeguimientoMedicionDTO> updateResultado(@PathVariable Long id, @RequestBody IRDResultadosSeguimientoMedicionDTO irdResultadosSeguimientoMedicionDTO) {
        IRDResultadosSeguimientoMedicionDTO updatedDTO = irdResultadosSeguimientoMedicionService.update(id, irdResultadosSeguimientoMedicionDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResultado(@PathVariable Long id) {
        irdResultadosSeguimientoMedicionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

