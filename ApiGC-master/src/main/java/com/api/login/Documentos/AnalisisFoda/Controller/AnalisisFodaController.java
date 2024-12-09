package com.api.login.Documentos.AnalisisFoda.Controller;

import com.api.login.Documentos.AnalisisFoda.DTO.AnalisisFodaDTO;
import com.api.login.Documentos.AnalisisFoda.DTO.AnalisisFodaDTOSinListas;
import com.api.login.Documentos.AnalisisFoda.Mapper.AnalisisFodaMapper;
import com.api.login.Documentos.AnalisisFoda.Pojo.AnalisisFoda;
import com.api.login.Documentos.AnalisisFoda.Service.AnalisisFodaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/analisisFoda")
public class AnalisisFodaController {

    @Autowired
    private AnalisisFodaService analisisFodaService;

    @Autowired
    private AnalisisFodaMapper analisisFodaMapper;

    @GetMapping
    public List<AnalisisFodaDTO> getAllAnalisisFoda() {
        List<AnalisisFoda> analisisFodaList = analisisFodaService.findAll();
        return analisisFodaList.stream()
                .map(analisisFodaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/entity")
    public List<AnalisisFodaDTOSinListas> getAllAnalisisFodaEntity() {
        List<AnalisisFoda> analisisFodaList = analisisFodaService.findAll();
        return analisisFodaList.stream()
                .map(analisisFodaMapper::toDTOSinListas)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnalisisFodaDTO> getAnalisisFodaById(@PathVariable Long id) {
        AnalisisFoda analisisFoda = analisisFodaService.findById(id);
        if (analisisFoda == null) {
            return ResponseEntity.notFound().build();
        }
        AnalisisFodaDTO dto = analisisFodaMapper.toDTO(analisisFoda);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<AnalisisFodaDTO> createAnalisisFoda(@RequestBody AnalisisFodaDTO analisisFodaDTO) {
        AnalisisFoda analisisFoda = analisisFodaMapper.toEntity(analisisFodaDTO);
        AnalisisFoda savedAnalisisFoda = analisisFodaService.save(analisisFoda);
        AnalisisFodaDTO savedDTO = analisisFodaMapper.toDTO(savedAnalisisFoda);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnalisisFodaDTOSinListas> updateAnalisisFoda(@PathVariable Long id, @RequestBody AnalisisFodaDTOSinListas analisisFodaDTO) {
        AnalisisFoda existingAnalisisFoda = analisisFodaService.findById(id);
        if (existingAnalisisFoda == null) {
            return ResponseEntity.notFound().build();
        }
        //AnalisisFoda analisisFoda = analisisFodaMapper.toEntitysinListas(analisisFodaDTO);
        //analisisFoda.setIdAnalisisFoda(id); // Aseguramos que el ID se mantenga
        AnalisisFoda updatedAnalisisFoda = analisisFodaService.update(id, analisisFodaDTO);
        AnalisisFodaDTOSinListas updatedDTO = analisisFodaMapper.toDTOSinListas(updatedAnalisisFoda);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnalisisFoda(@PathVariable Long id) {
        analisisFodaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

