package com.api.login.Documentos.NuevoIngreso.rest;

import com.api.login.Documentos.NuevoIngreso.DTO.DatPersonalNuevoIngresoDTO;
import com.api.login.Documentos.NuevoIngreso.DTO.DatosPersonalesNuevoIngresoDTO;
import com.api.login.Documentos.NuevoIngreso.Mapper.DatPersonalNuevoIngresoMapper;
import com.api.login.Documentos.NuevoIngreso.Pojo.DatPersonalNuevoIngreso;
import com.api.login.Documentos.NuevoIngreso.Pojo.DatosPersonalesNuevoIngreso;
import com.api.login.Documentos.NuevoIngreso.Service.DatPersonalNuevoIngresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/datpersonalnuevo")
public class DatPersonalNuevoIngresoController {

    @Autowired
    private DatPersonalNuevoIngresoService service;

    @Autowired
    private DatPersonalNuevoIngresoMapper mapper;

    @GetMapping
    private ResponseEntity<List<DatPersonalNuevoIngresoDTO>> listarTodo(){
        List<DatPersonalNuevoIngresoDTO> firmas = service.GetAllDatPer();
        return new ResponseEntity<>(firmas, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<DatPersonalNuevoIngresoDTO> Guardar(@RequestBody DatPersonalNuevoIngresoDTO dto){
        DatPersonalNuevoIngreso newDocumentos = service.CreateDatPer(dto);

        if (newDocumentos == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        DatPersonalNuevoIngresoDTO newDTO = mapper.toDTODatPerNu(newDocumentos);
        return new ResponseEntity<>(newDTO,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DatPersonalNuevoIngresoDTO> Actualizar(@PathVariable Integer id, @RequestBody DatPersonalNuevoIngresoDTO dto){
        DatPersonalNuevoIngresoDTO dtoUpdate = service.updateDatPer(id, dto);
        if (dtoUpdate != null){
            return ResponseEntity.ok(dtoUpdate);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Eliminar(@PathVariable Integer id){
        service.deleteDatPer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/encabezado/{id}")
    public List<DatPersonalNuevoIngresoDTO> listarPorConstanciaId(@PathVariable Integer id){
        return service.getDatPersonalByNuevoIngreso(id);
    }

}
