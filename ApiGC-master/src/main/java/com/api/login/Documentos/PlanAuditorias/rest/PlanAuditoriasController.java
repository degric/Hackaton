package com.api.login.Documentos.PlanAuditorias.rest;

import com.api.login.Documentos.NuevoIngreso.DTO.NuevoIngresoDTO;
import com.api.login.Documentos.PlanAuditorias.DTO.PlanAuditoriasDTO;
import com.api.login.Documentos.PlanAuditorias.Service.PlanAuditoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/planauditorias")
public class PlanAuditoriasController  {

    @Autowired
    private PlanAuditoriasService service;

    @GetMapping
    public ResponseEntity<List<PlanAuditoriasDTO>> listarEnProceso(){
        List<PlanAuditoriasDTO> enProcesoDTOS = service.getAllPlanAun();
        return new ResponseEntity<>(enProcesoDTOS, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<PlanAuditoriasDTO> ListarPorId(@PathVariable Long id){
        return service.getPlanAuById(id)
                .map(PlanAuDTO -> new ResponseEntity<>(PlanAuDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<PlanAuditoriasDTO> guardar(@RequestBody PlanAuditoriasDTO dto){
        PlanAuditoriasDTO createDTO = service.createPlanAu(dto);
        return new ResponseEntity<>(createDTO,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanAuditoriasDTO>actualizar(@PathVariable Long id, @RequestBody PlanAuditoriasDTO dto){
        PlanAuditoriasDTO update = service.updatePlanAu(id, dto);
        if (update != null){
            return new ResponseEntity<>(update, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        service.deletePlanAu(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
