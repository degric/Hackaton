package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Controller;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.DTO.IRDProcesosConformidadServiciosDTO;
import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Service.IRDProcesosConformidadServiciosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/irdProcesosConformidadServicios")
public class IRDProcesosConformidadServiciosController {

    @Autowired
    private IRDProcesosConformidadServiciosService irdProcesosConformidadServiciosService;

    @GetMapping
    public List<IRDProcesosConformidadServiciosDTO> getAllProcesos() {
        return irdProcesosConformidadServiciosService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<IRDProcesosConformidadServiciosDTO> getProcesoById(@PathVariable Long id) {
        IRDProcesosConformidadServiciosDTO dto = irdProcesosConformidadServiciosService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/informeRevisionDireccion/{idInformeRevisionDireccion}")
    public List<IRDProcesosConformidadServiciosDTO> getProcesosByInformeRevision(@PathVariable Long idInformeRevisionDireccion) {
        return irdProcesosConformidadServiciosService.findByInformeRevisionDireccion(idInformeRevisionDireccion);
    }

    @PostMapping
    public ResponseEntity<IRDProcesosConformidadServiciosDTO> createProceso(@RequestBody IRDProcesosConformidadServiciosDTO irdProcesosConformidadServiciosDTO) {
        IRDProcesosConformidadServiciosDTO savedDTO = irdProcesosConformidadServiciosService.save(irdProcesosConformidadServiciosDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IRDProcesosConformidadServiciosDTO> updateProceso(@PathVariable Long id, @RequestBody IRDProcesosConformidadServiciosDTO irdProcesosConformidadServiciosDTO) {
        IRDProcesosConformidadServiciosDTO updatedDTO = irdProcesosConformidadServiciosService.update(id, irdProcesosConformidadServiciosDTO);
        return ResponseEntity.ok(updatedDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProceso(@PathVariable Long id) {
        irdProcesosConformidadServiciosService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

