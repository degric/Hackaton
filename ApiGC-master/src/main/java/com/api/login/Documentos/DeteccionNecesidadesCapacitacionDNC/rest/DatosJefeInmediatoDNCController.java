package com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.rest;

import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.DTO.DatosGeneralesDNCDTO;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.DTO.DatosJefeInmediatoDNCDTO;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Mapper.DatosJefeInmediatoDNCMapper;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Service.DatosJefeInmediatoDNCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/datosJefeInmediatoDNC")
public class DatosJefeInmediatoDNCController {

    @Autowired
    private DatosJefeInmediatoDNCService datosService;

    @GetMapping
    public List<DatosJefeInmediatoDNCDTO> getAllDatosJefeInmediato() {
        return datosService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosJefeInmediatoDNCDTO> getDatosJefeInmediatoById(@PathVariable Long id) {
        DatosJefeInmediatoDNCDTO dto = datosService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/detecionNeCaDNC/{idDetecionNeCaDNC}")
    public ResponseEntity<DatosJefeInmediatoDNCDTO> getDatosJefeInmediatoByDetecionNeCaDNC(@PathVariable Long idDetecionNeCaDNC) {
        DatosJefeInmediatoDNCDTO dto = datosService.findByDetecionNeCaDNC(idDetecionNeCaDNC);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<DatosJefeInmediatoDNCDTO> createDatosJefeInmediato(@RequestBody DatosJefeInmediatoDNCDTO datosJefeInmediatoDNCDTO) {
        DatosJefeInmediatoDNCDTO savedDTO = datosService.save(datosJefeInmediatoDNCDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DatosJefeInmediatoDNCDTO> updateDatosJefeInmediato(@PathVariable Long id, @RequestBody DatosJefeInmediatoDNCDTO datosJefeInmediatoDNCDTO) {
        DatosJefeInmediatoDNCDTO updatedDTO = datosService.update(id, datosJefeInmediatoDNCDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDatosJefeInmediato(@PathVariable Long id) {
        datosService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
