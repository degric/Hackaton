package com.api.login.Documentos.ProgramaAuditoriasInternas.rest;

import com.api.login.Documentos.ProgramaAuditoriasInternas.DTO.ObservacionesProAuInternasDTO;
import com.api.login.Documentos.ProgramaAuditoriasInternas.DTO.TablaProAuInternasDTO;
import com.api.login.Documentos.ProgramaAuditoriasInternas.Mapper.ObservacionesProAuInternasMapper;
import com.api.login.Documentos.ProgramaAuditoriasInternas.Pojo.ObservacionesProAuInternas;
import com.api.login.Documentos.ProgramaAuditoriasInternas.Pojo.TablaProAuInternas;
import com.api.login.Documentos.ProgramaAuditoriasInternas.Service.ObservacionesProAuInternasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obpernuevoingreso")
public class ObservacionesProAuInternasController {

    @Autowired
    private ObservacionesProAuInternasService service;

    @Autowired
    private ObservacionesProAuInternasMapper mapper;

    @GetMapping
    private ResponseEntity<List<ObservacionesProAuInternasDTO>> listarTodo(){
        List<ObservacionesProAuInternasDTO> firmas = service.getAllObProAuIn();
        return new ResponseEntity<>(firmas, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<ObservacionesProAuInternasDTO> Guardar(@RequestBody ObservacionesProAuInternasDTO dto){
        ObservacionesProAuInternas newDocumentos = service.createObProAuIn(dto);

        if (newDocumentos == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ObservacionesProAuInternasDTO newDTO = mapper.toDTOObProAuIn(newDocumentos);
        return new ResponseEntity<>(newDTO,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ObservacionesProAuInternasDTO> Actualizar(@PathVariable Integer id, @RequestBody ObservacionesProAuInternasDTO dto){
        ObservacionesProAuInternasDTO dtoUpdate = service.updateObProAuIn(id, dto);
        if (dtoUpdate != null){
            return ResponseEntity.ok(dtoUpdate);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Eliminar(@PathVariable Integer id){
        service.deleteObProAuIn(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/encabezado/{id}")
    public List<ObservacionesProAuInternasDTO> listarPorConstanciaId(@PathVariable Integer id){
        return service.getObProAuInByIdProAuIn(id);
    }


}
