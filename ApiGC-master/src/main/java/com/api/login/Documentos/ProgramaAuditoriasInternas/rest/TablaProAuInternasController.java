package com.api.login.Documentos.ProgramaAuditoriasInternas.rest;

import com.api.login.Documentos.NuevoIngreso.DTO.DatosPersonalesNuevoIngresoDTO;
import com.api.login.Documentos.NuevoIngreso.Pojo.DatosPersonalesNuevoIngreso;
import com.api.login.Documentos.ProgramaAuditoriasInternas.DTO.TablaProAuInternasDTO;
import com.api.login.Documentos.ProgramaAuditoriasInternas.Mapper.TablaProAuInternasMapper;
import com.api.login.Documentos.ProgramaAuditoriasInternas.Pojo.TablaProAuInternas;
import com.api.login.Documentos.ProgramaAuditoriasInternas.Service.TablaProAuInternasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tablapernuevoingreso")
public class TablaProAuInternasController {

    @Autowired
    private TablaProAuInternasService service;

    @Autowired
    private TablaProAuInternasMapper mapper;

    @GetMapping
    private ResponseEntity<List<TablaProAuInternasDTO>> listarTodo(){
        List<TablaProAuInternasDTO> firmas = service.getAllTaProAuIn();
        return new ResponseEntity<>(firmas, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<TablaProAuInternasDTO> Guardar(@RequestBody TablaProAuInternasDTO dto){
        TablaProAuInternas newDocumentos = service.createTaProAuIn(dto);

        if (newDocumentos == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        TablaProAuInternasDTO newDTO = mapper.toDTOTaProAuIn(newDocumentos);
        return new ResponseEntity<>(newDTO,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TablaProAuInternasDTO> Actualizar(@PathVariable Integer id, @RequestBody TablaProAuInternasDTO dto){
        TablaProAuInternasDTO dtoUpdate = service.updatetaProAuIn(id, dto);
        if (dtoUpdate != null){
            return ResponseEntity.ok(dtoUpdate);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Eliminar(@PathVariable Integer id){
        service.deleteTaProAuIn(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/encabezado/{id}")
    public List<TablaProAuInternasDTO> listarPorConstanciaId(@PathVariable Integer id){
        return service.getByIdProgramaAuInternas(id);
    }

}
