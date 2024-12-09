package com.api.login.Documentos.SolicitudDePersonal.Controller;

import com.api.login.Documentos.SolicitudDePersonal.DTO.DatosSolicitudPersonalDTO;
import com.api.login.Documentos.SolicitudDePersonal.Service.DatosSolicitudPersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/datosSolicitudPersonal")
public class DatosSolicitudPersonalController {

    @Autowired
    private DatosSolicitudPersonalService datosService;

    @GetMapping
    public List<DatosSolicitudPersonalDTO> getAllDatos() {
        return datosService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosSolicitudPersonalDTO> getDatosById(@PathVariable Long id) {
        DatosSolicitudPersonalDTO dto = datosService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/solicitudPersonal/{idSolicitudPersonal}")
    public ResponseEntity<DatosSolicitudPersonalDTO> getDatosBySolicitudPersonal(@PathVariable Long idSolicitudPersonal) {
        DatosSolicitudPersonalDTO dto = datosService.findBySolicitudPersonal(idSolicitudPersonal);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<DatosSolicitudPersonalDTO> createDatos(@RequestBody DatosSolicitudPersonalDTO datosSolicitudPersonalDTO) {
        DatosSolicitudPersonalDTO savedDTO = datosService.save(datosSolicitudPersonalDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DatosSolicitudPersonalDTO> updateDatos(@PathVariable Long id, @RequestBody DatosSolicitudPersonalDTO datosSolicitudPersonalDTO) {
        DatosSolicitudPersonalDTO updatedDTO = datosService.update(id, datosSolicitudPersonalDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDatos(@PathVariable Long id) {
        datosService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
