package com.api.login.Documentos.ListaDeAsistencia.Controller;

import com.api.login.Documentos.ListaDeAsistencia.DTO.TablaListaAsistenciaDTO;
import com.api.login.Documentos.ListaDeAsistencia.Service.TablaListaAsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tablaListaAsistencia")
public class TablaListaAsistenciaController {

    @Autowired
    private TablaListaAsistenciaService tablaService;

    @GetMapping
    public List<TablaListaAsistenciaDTO> getAllParticipantes() {
        return tablaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TablaListaAsistenciaDTO> getParticipanteById(@PathVariable Long id) {
        TablaListaAsistenciaDTO dto = tablaService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/listaAsistencia/{idListaAsistencia}")
    public List<TablaListaAsistenciaDTO> getParticipantesByListaAsistencia(@PathVariable Long idListaAsistencia) {
        return tablaService.findByListaAsistencia(idListaAsistencia);
    }

    @PostMapping
    public ResponseEntity<TablaListaAsistenciaDTO> createParticipante(@RequestBody TablaListaAsistenciaDTO tablaDTO) {
        TablaListaAsistenciaDTO savedDTO = tablaService.save(tablaDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TablaListaAsistenciaDTO> updateParticipante(@PathVariable Long id, @RequestBody TablaListaAsistenciaDTO tablaDTO) {
        TablaListaAsistenciaDTO updatedDTO = tablaService.update(id, tablaDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParticipante(@PathVariable Long id) {
        tablaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}


