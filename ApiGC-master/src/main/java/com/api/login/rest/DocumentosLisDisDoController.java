package com.api.login.rest;

import com.api.login.DTO.DocumentosLisDisDoDTO;
import com.api.login.mapper.DocumentosLisDisDoMapper;
import com.api.login.pojo.DocumentosLisDisDo;
import com.api.login.service.DocumentosLisDisDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lisdisdocumentos")
public class DocumentosLisDisDoController {

    @Autowired
    private DocumentosLisDisDoService documentosLisDisDoService;

    @Autowired
    private DocumentosLisDisDoMapper documentosLisDisDoMapper;

    @GetMapping
    private ResponseEntity<List<DocumentosLisDisDoDTO>> listarTodo(){
        List<DocumentosLisDisDoDTO> firmas = documentosLisDisDoService.getAll();
        return new ResponseEntity<>(firmas, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<DocumentosLisDisDoDTO> Guardar(@RequestBody DocumentosLisDisDoDTO dto){
        DocumentosLisDisDo newDocumentos = documentosLisDisDoService.create(dto,dto.getIdLisDisDocumentos());

        if (newDocumentos == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        DocumentosLisDisDoDTO newDocumentosDTO = documentosLisDisDoMapper.toDTO(newDocumentos);
        return new ResponseEntity<>(newDocumentosDTO,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocumentosLisDisDoDTO> Actualizar(@PathVariable Integer id, @RequestBody DocumentosLisDisDoDTO dto){
        DocumentosLisDisDoDTO dtoUpdate = documentosLisDisDoService.update(id, dto);
        if (dtoUpdate != null){
            return ResponseEntity.ok(dtoUpdate);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Eliminar(@PathVariable Integer id){
        documentosLisDisDoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/encabezado/{id}")
    public List<DocumentosLisDisDoDTO> listarPorConstanciaId(@PathVariable Integer id){
        return documentosLisDisDoService.getDocimentosByIdEncabezado(id);
    }

}
