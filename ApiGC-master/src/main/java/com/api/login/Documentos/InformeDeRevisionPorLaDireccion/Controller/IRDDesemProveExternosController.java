package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Controller;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.IRDDesemProveExternosDTO;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service.IRDDesemProveExternosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/irdDesemProveExternos")
public class IRDDesemProveExternosController {

    @Autowired
    private IRDDesemProveExternosService irdDesemProveExternosService;

    @GetMapping
    public List<IRDDesemProveExternosDTO> getAllProveedores() {
        return irdDesemProveExternosService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<IRDDesemProveExternosDTO> getProveedorById(@PathVariable Long id) {
        IRDDesemProveExternosDTO dto = irdDesemProveExternosService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/informeRevisionDireccion/{idInformeRevisionDireccion}")
    public List<IRDDesemProveExternosDTO> getProveedoresByInformeRevision(@PathVariable Long idInformeRevisionDireccion) {
        return irdDesemProveExternosService.findByInformeRevisionDireccion(idInformeRevisionDireccion);
    }

    @PostMapping
    public ResponseEntity<IRDDesemProveExternosDTO> createProveedor(@RequestBody IRDDesemProveExternosDTO irdDesemProveExternosDTO) {
        IRDDesemProveExternosDTO savedDTO = irdDesemProveExternosService.save(irdDesemProveExternosDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IRDDesemProveExternosDTO> updateProveedor(@PathVariable Long id, @RequestBody IRDDesemProveExternosDTO irdDesemProveExternosDTO) {
        IRDDesemProveExternosDTO updatedDTO = irdDesemProveExternosService.update(id, irdDesemProveExternosDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProveedor(@PathVariable Long id) {
        irdDesemProveExternosService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

