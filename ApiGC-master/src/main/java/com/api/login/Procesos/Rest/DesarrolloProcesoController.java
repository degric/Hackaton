package com.api.login.Procesos.Rest;

import com.api.login.Procesos.DTO.DesarrolloProcesoDTO;
import com.api.login.Procesos.DTO.EnProcesoDTO;
import com.api.login.Procesos.DTO.SubClausulasProcesoDTO;
import com.api.login.Procesos.Mapper.DesarrolloProcesoMapper;
import com.api.login.Procesos.Mapper.EnProcesoMapper;
import com.api.login.Procesos.Pojo.DesarrolloProceso;
import com.api.login.Procesos.Pojo.EnProceso;
import com.api.login.Procesos.Pojo.SubClausulasProceso;
import com.api.login.Procesos.Service.DesarrolloProcesoService;
import com.api.login.Procesos.Service.EnProcesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/desarrolloproceso")
public class DesarrolloProcesoController {

    @Autowired
    private DesarrolloProcesoService service;

    @Autowired
    private DesarrolloProcesoMapper mapper;

    @Autowired
    private EnProcesoService enProcesoService;

    @Autowired
    private EnProcesoMapper enProcesoMapper;

    @GetMapping
    private ResponseEntity<List<DesarrolloProcesoDTO>> listarTodo(){
        List<DesarrolloProcesoDTO> desarrollos = service.getAllDesarrolloProceso();
        return new ResponseEntity<>(desarrollos, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DesarrolloProcesoDTO> getSubClausulaById(@PathVariable Long id) {
        DesarrolloProceso desarrolloProceso = service.findById(id);
        if(desarrolloProceso == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mapper.toDTODesarrolloProceso(desarrolloProceso));
    }
    @PostMapping
    private ResponseEntity<DesarrolloProcesoDTO> Guardar(@RequestBody DesarrolloProcesoDTO dto){
        DesarrolloProcesoDTO newData = service.createDesarrolloProceso(dto);

        if (newData == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(newData,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DesarrolloProcesoDTO> Actualizar(@PathVariable Long id, @RequestBody DesarrolloProcesoDTO dto){
        DesarrolloProceso dtoUpdate = service.findById(id);
        if (dtoUpdate == null){
            return ResponseEntity.notFound().build();
        }
        EnProcesoDTO enProcesoDTO = enProcesoService.getByIdEnProceso(dto.getIdEnProceso()).orElse(null);
        if (enProcesoDTO == null){
            return ResponseEntity.badRequest().build();
        }
        EnProceso enProceso = enProcesoMapper.toEntityEnProceso(enProcesoDTO);
        dtoUpdate = mapper.toEntityDesarrolloProceso(dto,enProceso);

        dtoUpdate.setIdDesarrolloProceso(id);
        DesarrolloProceso updateDesarrollo = service.updateDesarrolloProceso(id,dtoUpdate);
        return ResponseEntity.ok(mapper.toDTODesarrolloProceso(updateDesarrollo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Eliminar(@PathVariable Long id){
        service.deleteDesarrolloProceso(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/encabezado/{id}")
    public List<DesarrolloProcesoDTO> listarPorConstanciaId(@PathVariable Long id){
        return service.findByIdEnProceso(id);
    }
}

