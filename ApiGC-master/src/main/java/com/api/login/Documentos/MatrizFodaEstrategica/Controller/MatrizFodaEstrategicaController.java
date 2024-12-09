package com.api.login.Documentos.MatrizFodaEstrategica.Controller;

import com.api.login.Documentos.MatrizFodaEstrategica.DTO.MatrizFodaEstrategicaDTO;
import com.api.login.Documentos.MatrizFodaEstrategica.DTO.MatrizFodaEstrategicaDTOSinListas;
import com.api.login.Documentos.MatrizFodaEstrategica.Mapper.MatrizFodaEstrategicaMapper;
import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.MatrizFodaEstrategica;
import com.api.login.Documentos.MatrizFodaEstrategica.Service.MatrizFodaEstrategicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/matrizFodaEstrategica")
public class MatrizFodaEstrategicaController {

    @Autowired
    private MatrizFodaEstrategicaService matrizFodaEstrategicaService;

    @Autowired
    private MatrizFodaEstrategicaMapper matrizFodaEstrategicaMapper;

    @GetMapping
    public List<MatrizFodaEstrategicaDTO> getAllMatrizFodaEstrategica() {
        List<MatrizFodaEstrategica> matrizList = matrizFodaEstrategicaService.findAll();
        return matrizList.stream()
                .map(matrizFodaEstrategicaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/entity")
    public List<MatrizFodaEstrategicaDTOSinListas> getAllMatrizFodaEstrategicasinListas() {
        List<MatrizFodaEstrategica> matrizList = matrizFodaEstrategicaService.findAll();
        return matrizList.stream()
                .map(matrizFodaEstrategicaMapper::toDTOSinListas)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatrizFodaEstrategicaDTO> getMatrizFodaEstrategicaById(@PathVariable Long id) {
        MatrizFodaEstrategica matriz = matrizFodaEstrategicaService.findById(id);
        if (matriz == null) {
            return ResponseEntity.notFound().build();
        }
        MatrizFodaEstrategicaDTO dto = matrizFodaEstrategicaMapper.toDTO(matriz);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<MatrizFodaEstrategicaDTO> createMatrizFodaEstrategica(@RequestBody MatrizFodaEstrategicaDTO matrizFodaEstrategicaDTO) {
        MatrizFodaEstrategica matriz = matrizFodaEstrategicaMapper.toEntity(matrizFodaEstrategicaDTO);
        MatrizFodaEstrategica savedMatriz = matrizFodaEstrategicaService.save(matriz);
        MatrizFodaEstrategicaDTO savedDTO = matrizFodaEstrategicaMapper.toDTO(savedMatriz);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatrizFodaEstrategicaDTOSinListas> updateMatrizFodaEstrategica(@PathVariable Long id, @RequestBody MatrizFodaEstrategicaDTOSinListas matrizFodaEstrategicaDTO) {
        MatrizFodaEstrategica existingMatriz = matrizFodaEstrategicaService.findById(id);
        if (existingMatriz == null) {
            return ResponseEntity.notFound().build();
        }
        // Actualizar los campos
        existingMatriz.setCoDocumento(matrizFodaEstrategicaDTO.getCoDocumento());
        existingMatriz.setNoRevision(matrizFodaEstrategicaDTO.getNoRevision());
        existingMatriz.setFechaEmicion(matrizFodaEstrategicaDTO.getFechaEmicion());
        existingMatriz.setFechaRevision(matrizFodaEstrategicaDTO.getFechaRevision());
        existingMatriz.setFechaRegistro(matrizFodaEstrategicaDTO.getFechaRegistro());

        MatrizFodaEstrategica updatedMatriz = matrizFodaEstrategicaService.update(id, existingMatriz);
        MatrizFodaEstrategicaDTOSinListas updatedDTO = matrizFodaEstrategicaMapper.toDTOSinListas(updatedMatriz);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatrizFodaEstrategica(@PathVariable Long id) {
        matrizFodaEstrategicaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
