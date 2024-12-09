package com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Controller;

import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.DTO.LDDDescricionDocumentoDTO;
import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Service.LDDDescricionDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lddDescricionDocumento")
public class LDDDescricionDocumentoController {

    @Autowired
    private LDDDescricionDocumentoService lddDescricionDocumentoService;

    @GetMapping
    public List<LDDDescricionDocumentoDTO> getAllDocumentos() {
        return lddDescricionDocumentoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LDDDescricionDocumentoDTO> getDocumentoById(@PathVariable Long id) {
        LDDDescricionDocumentoDTO dto = lddDescricionDocumentoService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/listadoDistribucionDocumentos/{idListadoDistribucionDocumentos}")
    public List<LDDDescricionDocumentoDTO> getDocumentosByListadoDistribucion(@PathVariable Long idListadoDistribucionDocumentos) {
        return lddDescricionDocumentoService.findByListadoDistribucionDocumentos(idListadoDistribucionDocumentos);
    }

    @PostMapping
    public ResponseEntity<LDDDescricionDocumentoDTO> createDocumento(@RequestBody LDDDescricionDocumentoDTO lddDescricionDocumentoDTO) {
        LDDDescricionDocumentoDTO savedDTO = lddDescricionDocumentoService.save(lddDescricionDocumentoDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LDDDescricionDocumentoDTO> updateDocumento(@PathVariable Long id, @RequestBody LDDDescricionDocumentoDTO lddDescricionDocumentoDTO) {
        LDDDescricionDocumentoDTO updatedDTO = lddDescricionDocumentoService.update(id, lddDescricionDocumentoDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocumento(@PathVariable Long id) {
        lddDescricionDocumentoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
