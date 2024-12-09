package com.api.login.Documentos.ListaDeAsistencia.Controller;

import com.api.login.Documentos.ListaDeAsistencia.DTO.DatosListaAsistenciaDTO;
import com.api.login.Documentos.ListaDeAsistencia.Service.DatosListaAsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/datosListaAsistencia")
public class DatosListaAsistenciaController {

    @Autowired
    private DatosListaAsistenciaService datosService;

    @GetMapping
    public List<DatosListaAsistenciaDTO> getAllDatos() {
        return datosService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosListaAsistenciaDTO> getDatosById(@PathVariable Long id) {
        DatosListaAsistenciaDTO dto = datosService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/listaAsistencia/{idListaAsistencia}")
    public ResponseEntity<DatosListaAsistenciaDTO> getDatosByListaAsistencia(@PathVariable Long idListaAsistencia) {
        DatosListaAsistenciaDTO dto = datosService.findByListaAsistencia(idListaAsistencia);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<DatosListaAsistenciaDTO> createDatos(@RequestBody DatosListaAsistenciaDTO datosDTO) {
        DatosListaAsistenciaDTO savedDTO = datosService.save(datosDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DatosListaAsistenciaDTO> updateDatos(@PathVariable Long id, @RequestBody DatosListaAsistenciaDTO datosDTO) {
        DatosListaAsistenciaDTO updatedDTO = datosService.update(id, datosDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDatos(@PathVariable Long id) {
        datosService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
