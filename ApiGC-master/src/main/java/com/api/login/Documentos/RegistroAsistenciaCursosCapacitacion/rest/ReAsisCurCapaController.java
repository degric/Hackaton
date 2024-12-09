package com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.rest;

import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.DTO.DetecionNeCaDNCDTO;
import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.DTO.ReAsisCurCapaDTO;
import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Service.ReAsisCurCapaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/reasiscurcapa")
public class ReAsisCurCapaController {

    @Autowired
    private ReAsisCurCapaService service;

    @GetMapping
    public ResponseEntity<List<ReAsisCurCapaDTO>> listarEnProceso(){
        List<ReAsisCurCapaDTO> DTOS = service.getAllReAsCur();
        return new ResponseEntity<>(DTOS, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ReAsisCurCapaDTO> ListarPorId(@PathVariable Long id){
        return service.getById(id)
                .map(enProcesoDTO -> new ResponseEntity<>(enProcesoDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ReAsisCurCapaDTO> guardar(@RequestBody ReAsisCurCapaDTO dto){
        ReAsisCurCapaDTO createDTO = service.createReAsCur(dto);
        return new ResponseEntity<>(createDTO,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReAsisCurCapaDTO>actualizar(@PathVariable Long id, @RequestBody ReAsisCurCapaDTO dto){
        ReAsisCurCapaDTO update = service.updateReAsCur(id, dto);
        if (update != null){
            return new ResponseEntity<>(update, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        service.deleteReAsCur(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
