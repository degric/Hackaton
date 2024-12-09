package com.api.login.Documentos.PlanAuditorias.rest;

import com.api.login.Documentos.PlanAuditorias.DTO.AuditoresPlanAuDTO;
import com.api.login.Documentos.PlanAuditorias.Service.AuditoresPlanAuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/auditoresplanauditorias")
public class AuditoresPlanAuController {

    @Autowired
    private AuditoresPlanAuService service;

    @GetMapping
    public ResponseEntity<List<AuditoresPlanAuDTO>> listarEnProceso() {
        List<AuditoresPlanAuDTO> enDTOS = service.getAllConPlanAu();
        return new ResponseEntity<>(enDTOS, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AuditoresPlanAuDTO> guardar(@RequestBody AuditoresPlanAuDTO dto) {
        AuditoresPlanAuDTO createDTO = service.createConPlanAu(dto);
        if (createDTO != null) {
            return new ResponseEntity<>(createDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuditoresPlanAuDTO> actualizar(@PathVariable Long id, @RequestBody AuditoresPlanAuDTO dto) {
        AuditoresPlanAuDTO update = service.updateConPlanAu(id, dto);
        if (update != null) {
            return new ResponseEntity<>(update, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.deleteConPlanAu(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/encabezado/{id}")
    public List<AuditoresPlanAuDTO> listarPorConstanciaId(@PathVariable Long id) {
        return service.getByIdEncabezado(id);
    }
}

