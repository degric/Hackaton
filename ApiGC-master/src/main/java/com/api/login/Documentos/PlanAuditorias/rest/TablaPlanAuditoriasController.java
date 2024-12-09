package com.api.login.Documentos.PlanAuditorias.rest;

import com.api.login.Documentos.PlanAuditorias.DTO.TablaPlanAuditoriasDTO;
import com.api.login.Documentos.PlanAuditorias.Service.TablaPlanAuditoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/tablaplanauditorias")
public class TablaPlanAuditoriasController {

    @Autowired
    private TablaPlanAuditoriasService service;

    @GetMapping
    public ResponseEntity<List<TablaPlanAuditoriasDTO>> listarEnProceso(){
        List<TablaPlanAuditoriasDTO> enDTOS = service.getAllConPlanAu();
        return new ResponseEntity<>(enDTOS, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TablaPlanAuditoriasDTO> guardar(@RequestBody TablaPlanAuditoriasDTO dto){
        TablaPlanAuditoriasDTO createDTO = service.createConPlanAu(dto);
        if (createDTO != null) {
            return new ResponseEntity<>(createDTO, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TablaPlanAuditoriasDTO> actualizar(@PathVariable Long id, @RequestBody TablaPlanAuditoriasDTO dto){
        TablaPlanAuditoriasDTO update = service.updateConPlanAu(id, dto);
        if (update != null){
            return new ResponseEntity<>(update, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        service.deleteConPlanAu(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/encabezado/{id}")
    public List<TablaPlanAuditoriasDTO> listarPorConstanciaId(@PathVariable Long id){
        return service.getByIdEncabezado(id);
    }
}

