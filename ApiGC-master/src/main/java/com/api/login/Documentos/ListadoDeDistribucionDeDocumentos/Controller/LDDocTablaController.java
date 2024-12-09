package com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Controller;

import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.DTO.LDDocTablaDTO;
import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Service.LDDocTablaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lddDocTabla")
public class LDDocTablaController {

    @Autowired
    private LDDocTablaService lddDocTablaService;

    @GetMapping
    public List<LDDocTablaDTO> getAllDocumentos() {
        return lddDocTablaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LDDocTablaDTO> getDocumentoById(@PathVariable Long id) {
        LDDocTablaDTO dto = lddDocTablaService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/listadoDistribucionDocumentos/{idListadoDistribucionDocumentos}")
    public List<LDDocTablaDTO> getDocumentosByListadoDistribucion(@PathVariable Long idListadoDistribucionDocumentos) {
        return lddDocTablaService.findByListadoDistribucionDocumentos(idListadoDistribucionDocumentos);
    }

    @PostMapping
    public ResponseEntity<LDDocTablaDTO> createDocumento(@RequestBody LDDocTablaDTO lddDocTablaDTO) {
        LDDocTablaDTO savedDTO = lddDocTablaService.save(lddDocTablaDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LDDocTablaDTO> updateDocumento(@PathVariable Long id, @RequestBody LDDocTablaDTO lddDocTablaDTO) {
        LDDocTablaDTO updatedDTO = lddDocTablaService.update(id, lddDocTablaDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocumento(@PathVariable Long id) {
        lddDocTablaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

