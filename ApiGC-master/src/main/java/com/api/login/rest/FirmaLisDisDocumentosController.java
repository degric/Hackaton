package com.api.login.rest;

import com.api.login.DTO.DocumentosLisDisDoDTO;
import com.api.login.DTO.FirmaLisDisDocumentosDTO;
import com.api.login.mapper.FirmaLisDisDocumentoMapper;
import com.api.login.pojo.DocumentosLisDisDo;
import com.api.login.pojo.FirmaLisDisDocumentos;
import com.api.login.service.FirmaLisDisDocumentosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lisdisfirma")
public class FirmaLisDisDocumentosController {

    @Autowired
    private FirmaLisDisDocumentosService firmaLisDisDocumentosService;

    @Autowired
    private FirmaLisDisDocumentoMapper firmaLisDisDocumentoMapper;

    @GetMapping
    private ResponseEntity<List<FirmaLisDisDocumentosDTO>> listarTodo(){
        List<FirmaLisDisDocumentosDTO> firmas = firmaLisDisDocumentosService.getAll();
        return new ResponseEntity<>(firmas, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<FirmaLisDisDocumentosDTO> Guardar(@RequestBody FirmaLisDisDocumentosDTO dto){
        FirmaLisDisDocumentos newDocumentos = firmaLisDisDocumentosService.create(dto);

        if (newDocumentos == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        FirmaLisDisDocumentosDTO newDocumentosDTO = firmaLisDisDocumentoMapper.ToDTO(newDocumentos);
        return new ResponseEntity<>(newDocumentosDTO,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FirmaLisDisDocumentosDTO> Actualizar(@PathVariable Integer id, @RequestBody FirmaLisDisDocumentosDTO dto){
        FirmaLisDisDocumentosDTO dtoUpdate = firmaLisDisDocumentosService.update(id, dto);
        if (dtoUpdate != null){
            return ResponseEntity.ok(dtoUpdate);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Eliminar(@PathVariable Integer id){
        firmaLisDisDocumentosService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/encabezado/{id}")
    public List<FirmaLisDisDocumentosDTO> listarPorConstanciaId(@PathVariable Integer id){
        return firmaLisDisDocumentosService.getFirmaLisDisById(id);
    }
}
