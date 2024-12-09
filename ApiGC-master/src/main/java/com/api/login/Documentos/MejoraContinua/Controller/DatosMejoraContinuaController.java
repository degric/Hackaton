package com.api.login.Documentos.MejoraContinua.Controller;

import com.api.login.Documentos.MejoraContinua.DTO.DatosMejoraContinuaDTO;
import com.api.login.Documentos.MejoraContinua.Service.DatosMejoraContinuaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/datosMejoraContinua")
public class DatosMejoraContinuaController {

    @Autowired
    private DatosMejoraContinuaService datosService;

    @GetMapping
    public List<DatosMejoraContinuaDTO> getAllDatos() {
        return datosService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosMejoraContinuaDTO> getDatosById(@PathVariable Long id) {
        DatosMejoraContinuaDTO dto = datosService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/mejoraContinua/{idMejoraContinua}")
    public ResponseEntity<DatosMejoraContinuaDTO> getDatosByMejoraContinua(@PathVariable Long idMejoraContinua) {
        DatosMejoraContinuaDTO dto = datosService.findByMejoraContinua(idMejoraContinua);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<DatosMejoraContinuaDTO> createDatos(@RequestBody DatosMejoraContinuaDTO datosDTO) {
        DatosMejoraContinuaDTO savedDTO = datosService.save(datosDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DatosMejoraContinuaDTO> updateDatos(@PathVariable Long id, @RequestBody DatosMejoraContinuaDTO datosDTO) {
        DatosMejoraContinuaDTO updatedDTO = datosService.update(id, datosDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDatos(@PathVariable Long id) {
        datosService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
