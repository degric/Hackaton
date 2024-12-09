package com.api.login.Documentos.ListadoMaestroDocumentos.Controller;

import com.api.login.Documentos.ListadoMaestroDocumentos.DTO.TablaLisMaDocumentosAnexosDTO;
import com.api.login.Documentos.ListadoMaestroDocumentos.Mapper.TablaLisMaDocumentosAnexosMapper;
import com.api.login.Documentos.ListadoMaestroDocumentos.Pojo.ListadoMaestroDocumentos;
import com.api.login.Documentos.ListadoMaestroDocumentos.Pojo.TablaLisMaDocumentosAnexos;
import com.api.login.Documentos.ListadoMaestroDocumentos.Service.TablaLisMaDocumentosAnexosService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tablaLisMaDocumentosAnexos")
public class TablaLisMaDocumentosAnexosController {

    @Autowired
    private TablaLisMaDocumentosAnexosService tablaLisMaDocumentosAnexosService;

    @GetMapping
    public List<TablaLisMaDocumentosAnexosDTO> getAllAnexos() {
        return tablaLisMaDocumentosAnexosService.findAllDTOs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TablaLisMaDocumentosAnexosDTO> getAnexoById(@PathVariable Long id) {
        TablaLisMaDocumentosAnexosDTO dto = tablaLisMaDocumentosAnexosService.findDTOById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/listadoMaestro/{idListadoMaestroDocumentos}")
    public List<TablaLisMaDocumentosAnexosDTO> getAnexosByListadoMaestro(@PathVariable Long idListadoMaestroDocumentos) {
        return tablaLisMaDocumentosAnexosService.findDTOsByListadoMaestroDocumentos(idListadoMaestroDocumentos);
    }

    @PostMapping
    public ResponseEntity<TablaLisMaDocumentosAnexosDTO> createAnexo(@RequestBody TablaLisMaDocumentosAnexosDTO tablaLisMaDocumentosAnexosDTO) {
        TablaLisMaDocumentosAnexosDTO savedDTO = tablaLisMaDocumentosAnexosService.createAnexo(tablaLisMaDocumentosAnexosDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TablaLisMaDocumentosAnexosDTO> updateAnexo(@PathVariable Long id, @RequestBody TablaLisMaDocumentosAnexosDTO tablaLisMaDocumentosAnexosDTO) {
        TablaLisMaDocumentosAnexosDTO updatedDTO = tablaLisMaDocumentosAnexosService.updateAnexo(id, tablaLisMaDocumentosAnexosDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnexo(@PathVariable Long id) {
        tablaLisMaDocumentosAnexosService.deleteAnexo(id);
        return ResponseEntity.noContent().build();
    }
}


