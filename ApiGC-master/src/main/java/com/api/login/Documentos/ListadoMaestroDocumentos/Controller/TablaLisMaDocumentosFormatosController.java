package com.api.login.Documentos.ListadoMaestroDocumentos.Controller;

import com.api.login.Documentos.ListadoMaestroDocumentos.DTO.TablaLisMaDocumentosFormatosDTO;
import com.api.login.Documentos.ListadoMaestroDocumentos.Mapper.TablaLisMaDocumentosFormatosMapper;
import com.api.login.Documentos.ListadoMaestroDocumentos.Pojo.ListadoMaestroDocumentos;
import com.api.login.Documentos.ListadoMaestroDocumentos.Pojo.TablaLisMaDocumentosFormatos;
import com.api.login.Documentos.ListadoMaestroDocumentos.Repository.ListadoMaestroDocumentosRepository;
import com.api.login.Documentos.ListadoMaestroDocumentos.Service.TablaLisMaDocumentosFormatosService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tablaLisMaDocumentosFormatos")
public class TablaLisMaDocumentosFormatosController {

    @Autowired
    private TablaLisMaDocumentosFormatosService tablaLisMaDocumentosFormatosService;

    @Autowired
    private TablaLisMaDocumentosFormatosMapper tablaLisMaDocumentosFormatosMapper;

    @Autowired
    private ListadoMaestroDocumentosRepository listadoMaestroDocumentosRepository;

    @GetMapping
    public List<TablaLisMaDocumentosFormatosDTO> getAllFormatos() {
        List<TablaLisMaDocumentosFormatos> formatos = tablaLisMaDocumentosFormatosService.findAll();
        return formatos.stream()
                .map(tablaLisMaDocumentosFormatosMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TablaLisMaDocumentosFormatosDTO> getFormatoById(@PathVariable Long id) {
        TablaLisMaDocumentosFormatos formato = tablaLisMaDocumentosFormatosService.findById(id);
        TablaLisMaDocumentosFormatosDTO dto = tablaLisMaDocumentosFormatosMapper.toDTO(formato);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/listadoMaestro/{idListadoMaestroDocumentos}")
    public List<TablaLisMaDocumentosFormatosDTO> getFormatosByListadoMaestro(@PathVariable Long idListadoMaestroDocumentos) {
        List<TablaLisMaDocumentosFormatos> formatos = tablaLisMaDocumentosFormatosService.findByListadoMaestroDocumentos(idListadoMaestroDocumentos);
        return formatos.stream()
                .map(tablaLisMaDocumentosFormatosMapper::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<TablaLisMaDocumentosFormatosDTO> createFormato(@RequestBody TablaLisMaDocumentosFormatosDTO tablaLisMaDocumentosFormatosDTO) {
        ListadoMaestroDocumentos listadoMaestroDocumentos = listadoMaestroDocumentosRepository
                .findById(tablaLisMaDocumentosFormatosDTO.getIdListadoMaestroDocumentos())
                .orElseThrow(() -> new EntityNotFoundException("Listado Maestro no encontrado"));

        TablaLisMaDocumentosFormatos formato = tablaLisMaDocumentosFormatosMapper.toEntity(tablaLisMaDocumentosFormatosDTO, listadoMaestroDocumentos);
        TablaLisMaDocumentosFormatos savedFormato = tablaLisMaDocumentosFormatosService.save(formato);
        TablaLisMaDocumentosFormatosDTO savedDTO = tablaLisMaDocumentosFormatosMapper.toDTO(savedFormato);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TablaLisMaDocumentosFormatosDTO> updateFormato(@PathVariable Long id, @RequestBody TablaLisMaDocumentosFormatosDTO tablaLisMaDocumentosFormatosDTO) {
        TablaLisMaDocumentosFormatos updatedFormato = tablaLisMaDocumentosFormatosService.update(id, tablaLisMaDocumentosFormatosDTO);
        TablaLisMaDocumentosFormatosDTO updatedDTO = tablaLisMaDocumentosFormatosMapper.toDTO(updatedFormato);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFormato(@PathVariable Long id) {
        tablaLisMaDocumentosFormatosService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

