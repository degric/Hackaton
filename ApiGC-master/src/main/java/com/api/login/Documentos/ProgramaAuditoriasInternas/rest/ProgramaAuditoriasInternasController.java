package com.api.login.Documentos.ProgramaAuditoriasInternas.rest;

import com.api.login.Documentos.NuevoIngreso.DTO.NuevoIngresoDTO;
import com.api.login.Documentos.ProgramaAuditoriasInternas.DTO.ProgramaAuditoriasInternasDTO;
import com.api.login.Documentos.ProgramaAuditoriasInternas.Service.ProgramaAuditoriasInternasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/programaauditoriasinternas")
public class ProgramaAuditoriasInternasController {

    @Autowired
    private ProgramaAuditoriasInternasService service;

    @GetMapping
    public ResponseEntity<List<ProgramaAuditoriasInternasDTO>> listarEnProceso(){
        List<ProgramaAuditoriasInternasDTO> enProcesoDTOS = service.getAllProAuIn();
        return new ResponseEntity<>(enProcesoDTOS, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProgramaAuditoriasInternasDTO> ListarPorId(@PathVariable Integer id){
        return service.getByIdProAuIn(id)
                .map(enProcesoDTO -> new ResponseEntity<>(enProcesoDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ProgramaAuditoriasInternasDTO> create(@RequestBody ProgramaAuditoriasInternasDTO dto){
        ProgramaAuditoriasInternasDTO dto1 = service.createProAuIn(dto);
        return new ResponseEntity<>(dto1, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgramaAuditoriasInternasDTO>actualizar(@PathVariable Integer id, @RequestBody ProgramaAuditoriasInternasDTO dto){
        ProgramaAuditoriasInternasDTO update = service.updateProAuIn(id, dto);
        if (update != null){
            return new ResponseEntity<>(update, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id){
        service.deleteProAuIn(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
