package com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.rest;

import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.DTO.DatosGeneralesDNCDTO;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Mapper.DatosGeneralesDNCMapper;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Pojo.DatosGeneralesDNC;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Service.DatosGeneralesDNCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/datosGeneralesDNC")
public class DatosGeneralesDNCController {

    @Autowired
    private DatosGeneralesDNCService datosService;

    @GetMapping
    public List<DatosGeneralesDNCDTO> getAllDatosGenerales() {
        return datosService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosGeneralesDNCDTO> getDatosGeneralesById(@PathVariable Long id) {
        DatosGeneralesDNCDTO dto = datosService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/detecionNeCaDNC/{idDetecionNeCaDNC}")
    public ResponseEntity<DatosGeneralesDNCDTO> getDatosGeneralesByDetecionNeCaDNC(@PathVariable Long idDetecionNeCaDNC) {
        DatosGeneralesDNCDTO dto = datosService.findByDetecionNeCaDNC(idDetecionNeCaDNC);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<DatosGeneralesDNCDTO> createDatosGenerales(@RequestBody DatosGeneralesDNCDTO datosGeneralesDNCDTO) {
        DatosGeneralesDNCDTO savedDTO = datosService.save(datosGeneralesDNCDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DatosGeneralesDNCDTO> updateDatosGenerales(@PathVariable Long id, @RequestBody DatosGeneralesDNCDTO datosGeneralesDNCDTO) {
        DatosGeneralesDNCDTO updatedDTO = datosService.update(id, datosGeneralesDNCDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDatosGenerales(@PathVariable Long id) {
        datosService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
