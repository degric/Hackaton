package com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.rest;

import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.DTO.Preguntas2DNCDTO;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Service.Preguntas2DNCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/preguntas2DNC")
public class Preguntas2DNCController {

    @Autowired
    private Preguntas2DNCService preguntasService;

    @GetMapping
    public List<Preguntas2DNCDTO> getAllPreguntas() {
        return preguntasService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Preguntas2DNCDTO> getPreguntaById(@PathVariable Long id) {
        Preguntas2DNCDTO dto = preguntasService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/detecionNeCaDNC/{idDetecionNeCaDNC}")
    public List<Preguntas2DNCDTO> getPreguntasByDetecionNeCaDNC(@PathVariable Long idDetecionNeCaDNC) {
        return preguntasService.findByDetecionNeCaDNC(idDetecionNeCaDNC);
    }

    @PostMapping
    public ResponseEntity<Preguntas2DNCDTO> createPregunta(@RequestBody Preguntas2DNCDTO preguntas2DNCDTO) {
        Preguntas2DNCDTO savedDTO = preguntasService.save(preguntas2DNCDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Preguntas2DNCDTO> updatePregunta(@PathVariable Long id, @RequestBody Preguntas2DNCDTO preguntas2DNCDTO) {
        Preguntas2DNCDTO updatedDTO = preguntasService.update(id, preguntas2DNCDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePregunta(@PathVariable Long id) {
        preguntasService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

