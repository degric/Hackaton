package com.api.login.Documentos.PlanAuditorias.rest;

import com.api.login.Documentos.NuevoIngreso.DTO.DatosPersonalesNuevoIngresoDTO;
import com.api.login.Documentos.PlanAuditorias.DTO.ContenidoPlanAuditoriasDTO;
import com.api.login.Documentos.PlanAuditorias.DTO.PlanAuditoriasDTO;
import com.api.login.Documentos.PlanAuditorias.Service.ContenidoPlanAuditoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/conplanauditorias")
public class ContenidoPlanAuditoriasController {

    @Autowired
    private ContenidoPlanAuditoriasService service;

    @GetMapping
    public ResponseEntity<List<ContenidoPlanAuditoriasDTO>> listarEnProceso(){
        List<ContenidoPlanAuditoriasDTO> enDTOS = service.getAllConPlanAu();
        return new ResponseEntity<>(enDTOS, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ContenidoPlanAuditoriasDTO> guardar(@RequestBody ContenidoPlanAuditoriasDTO dto){
        ContenidoPlanAuditoriasDTO createDTO = service.createConPlanAu(dto);
        if (createDTO != null) {
            return new ResponseEntity<>(createDTO, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContenidoPlanAuditoriasDTO>actualizar(@PathVariable Long id, @RequestBody ContenidoPlanAuditoriasDTO dto){
        ContenidoPlanAuditoriasDTO update = service.updateConPlanAu(id, dto);
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
    public Optional<ContenidoPlanAuditoriasDTO> listarPorConstanciaId(@PathVariable Long id){
        return service.getByIdEncabezado(id);
    }
}
