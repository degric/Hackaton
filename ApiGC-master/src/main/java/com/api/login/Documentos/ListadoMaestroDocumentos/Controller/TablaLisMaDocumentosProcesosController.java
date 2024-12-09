package com.api.login.Documentos.ListadoMaestroDocumentos.Controller;

import com.api.login.Documentos.ListadoMaestroDocumentos.DTO.TablaLisMaDocumentosProcesosDTO;
import com.api.login.Documentos.ListadoMaestroDocumentos.Mapper.TablaLisMaDocumentosProcesosMapper;
import com.api.login.Documentos.ListadoMaestroDocumentos.Pojo.ListadoMaestroDocumentos;
import com.api.login.Documentos.ListadoMaestroDocumentos.Pojo.TablaLisMaDocumentosProcesos;
import com.api.login.Documentos.ListadoMaestroDocumentos.Repository.ListadoMaestroDocumentosRepository;
import com.api.login.Documentos.ListadoMaestroDocumentos.Service.TablaLisMaDocumentosProcesosService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tablaLisMaDocumentosProcesos")
public class TablaLisMaDocumentosProcesosController {

    @Autowired
    private TablaLisMaDocumentosProcesosService tablaLisMaDocumentosProcesosService;

    @Autowired
    private TablaLisMaDocumentosProcesosMapper tablaLisMaDocumentosProcesosMapper;

    @Autowired
    private ListadoMaestroDocumentosRepository listadoMaestroDocumentosRepository;

    @GetMapping
    public List<TablaLisMaDocumentosProcesosDTO> getAllProcesos() {
        List<TablaLisMaDocumentosProcesos> procesos = tablaLisMaDocumentosProcesosService.findAll();
        return procesos.stream()
                .map(tablaLisMaDocumentosProcesosMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TablaLisMaDocumentosProcesosDTO> getProcesoById(@PathVariable Long id) {
        TablaLisMaDocumentosProcesos proceso = tablaLisMaDocumentosProcesosService.findById(id);
        TablaLisMaDocumentosProcesosDTO dto = tablaLisMaDocumentosProcesosMapper.toDTO(proceso);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/listadoMaestro/{idListadoMaestroDocumentos}")
    public List<TablaLisMaDocumentosProcesosDTO> getProcesosByListadoMaestro(@PathVariable Long idListadoMaestroDocumentos) {
        List<TablaLisMaDocumentosProcesos> procesos = tablaLisMaDocumentosProcesosService.findByListadoMaestroDocumentos(idListadoMaestroDocumentos);
        return procesos.stream()
                .map(tablaLisMaDocumentosProcesosMapper::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<TablaLisMaDocumentosProcesosDTO> createProceso(@RequestBody TablaLisMaDocumentosProcesosDTO tablaLisMaDocumentosProcesosDTO) {
        ListadoMaestroDocumentos listadoMaestroDocumentos = listadoMaestroDocumentosRepository
                .findById(tablaLisMaDocumentosProcesosDTO.getIdListadoMaestroDocumentos())
                .orElseThrow(() -> new EntityNotFoundException("Listado Maestro no encontrado"));

        TablaLisMaDocumentosProcesos proceso = tablaLisMaDocumentosProcesosMapper.toEntity(tablaLisMaDocumentosProcesosDTO, listadoMaestroDocumentos);
        TablaLisMaDocumentosProcesos savedProceso = tablaLisMaDocumentosProcesosService.save(proceso);
        TablaLisMaDocumentosProcesosDTO savedDTO = tablaLisMaDocumentosProcesosMapper.toDTO(savedProceso);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TablaLisMaDocumentosProcesosDTO> updateProceso(@PathVariable Long id, @RequestBody TablaLisMaDocumentosProcesosDTO tablaLisMaDocumentosProcesosDTO) {
        TablaLisMaDocumentosProcesos updatedProceso = tablaLisMaDocumentosProcesosService.update(id, tablaLisMaDocumentosProcesosDTO);
        TablaLisMaDocumentosProcesosDTO updatedDTO = tablaLisMaDocumentosProcesosMapper.toDTO(updatedProceso);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProceso(@PathVariable Long id) {
        tablaLisMaDocumentosProcesosService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}


