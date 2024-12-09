package com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.rest;

import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.DTO.DatosJefeInmediatoDNCDTO;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.DTO.Pregunta1DNCDTO;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Mapper.Pregunta1DNCMapper;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Service.Pregunta1DNCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pregunta1DNC")
public class Pregunta1DNCController {

    @Autowired
    private Pregunta1DNCService preguntaService;

    @GetMapping
    public List<Pregunta1DNCDTO> getAllPreguntas() {
        return preguntaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pregunta1DNCDTO> getPreguntaById(@PathVariable Long id) {
        Pregunta1DNCDTO dto = preguntaService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/detecionNeCaDNC/{idDetecionNeCaDNC}")
    public List<Pregunta1DNCDTO> getPreguntasByDetecionNeCaDNC(@PathVariable Long idDetecionNeCaDNC) {
        return preguntaService.findByDetecionNeCaDNC(idDetecionNeCaDNC);
    }

    @PostMapping
    public ResponseEntity<Pregunta1DNCDTO> createPregunta(@RequestBody Pregunta1DNCDTO pregunta1DNCDTO) {
        Pregunta1DNCDTO savedDTO = preguntaService.save(pregunta1DNCDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pregunta1DNCDTO> updatePregunta(@PathVariable Long id, @RequestBody Pregunta1DNCDTO pregunta1DNCDTO) {
        Pregunta1DNCDTO updatedDTO = preguntaService.update(id, pregunta1DNCDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePregunta(@PathVariable Long id) {
        preguntaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
