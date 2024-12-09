package com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.rest;

import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.DTO.DatosGeneralesDNCDTO;
import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.DTO.InformacionReAsisCurCapaDTO;
import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Service.InformacionReAsisCurCapaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/informacionreas")
public class InformacionReAsisCurCapaController {

    @Autowired
    private InformacionReAsisCurCapaService service;

    @GetMapping
    private ResponseEntity<List<InformacionReAsisCurCapaDTO>> listarTodo(){
        List<InformacionReAsisCurCapaDTO> firmas = service.getAllInReAs();
        return new ResponseEntity<>(firmas, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<InformacionReAsisCurCapaDTO> Guardar(@RequestBody InformacionReAsisCurCapaDTO dto){
        InformacionReAsisCurCapaDTO newDocumentos = service.createInReAs(dto);
        if (newDocumentos == null){
            return new ResponseEntity<>(HttpStatus.LOCKED);
        }
        return new ResponseEntity<>(newDocumentos,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InformacionReAsisCurCapaDTO> Actualizar(@PathVariable Long id, @RequestBody InformacionReAsisCurCapaDTO dto){
        InformacionReAsisCurCapaDTO dtoUpdate = service.updateInReAs(id, dto);
        if (dtoUpdate != null){
            return ResponseEntity.ok(dtoUpdate);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Eliminar(@PathVariable Long id){
        service.deleteInReAs(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/encabezado/{id}")
    public Optional<InformacionReAsisCurCapaDTO> listarPorConstanciaId(@PathVariable Long id){
        return service.findByIdEncabezado(id);
    }
}
