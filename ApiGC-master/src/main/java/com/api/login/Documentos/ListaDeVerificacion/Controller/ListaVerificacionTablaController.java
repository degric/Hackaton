package com.api.login.Documentos.ListaDeVerificacion.Controller;

import com.api.login.Documentos.ListaDeVerificacion.DTO.ListaVerificacionTablaDTO;
import com.api.login.Documentos.ListaDeVerificacion.Service.ListaVerificacionTablaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/listaVerificacionTabla")
public class ListaVerificacionTablaController {

    @Autowired
    private ListaVerificacionTablaService listaVerificacionTablaService;

    @GetMapping
    public List<ListaVerificacionTablaDTO> getAllTablas() {
        return listaVerificacionTablaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListaVerificacionTablaDTO> getTablaById(@PathVariable Long id) {
        ListaVerificacionTablaDTO dto = listaVerificacionTablaService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/listaVerificacion/{idListaVerificacion}")
    public List<ListaVerificacionTablaDTO> getTablasByListaVerificacion(@PathVariable Long idListaVerificacion) {
        return listaVerificacionTablaService.findByListaVerificacion(idListaVerificacion);
    }

    @PostMapping
    public ResponseEntity<ListaVerificacionTablaDTO> createTabla(@RequestBody ListaVerificacionTablaDTO listaVerificacionTablaDTO) {
        ListaVerificacionTablaDTO savedDTO = listaVerificacionTablaService.save(listaVerificacionTablaDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListaVerificacionTablaDTO> updateTabla(@PathVariable Long id, @RequestBody ListaVerificacionTablaDTO listaVerificacionTablaDTO) {
        ListaVerificacionTablaDTO updatedDTO = listaVerificacionTablaService.update(id, listaVerificacionTablaDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTabla(@PathVariable Long id) {
        listaVerificacionTablaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

