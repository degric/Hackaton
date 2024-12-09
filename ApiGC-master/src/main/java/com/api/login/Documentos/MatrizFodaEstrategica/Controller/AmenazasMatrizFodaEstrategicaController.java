package com.api.login.Documentos.MatrizFodaEstrategica.Controller;

import com.api.login.Documentos.MatrizFodaEstrategica.DTO.AmenazasMatrizFodaEstrategicaDTO;
import com.api.login.Documentos.MatrizFodaEstrategica.Mapper.AmenazasMatrizFodaEstrategicaMapper;
import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.AmenazasMatrizFodaEstrategica;
import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.MatrizFodaEstrategica;
import com.api.login.Documentos.MatrizFodaEstrategica.Service.AmenazasMatrizFodaEstrategicaService;
import com.api.login.Documentos.MatrizFodaEstrategica.Service.MatrizFodaEstrategicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/amenazasMatrizFodaEstrategica")
public class AmenazasMatrizFodaEstrategicaController {

    @Autowired
    private AmenazasMatrizFodaEstrategicaService amenazasService;

    @Autowired
    private AmenazasMatrizFodaEstrategicaMapper amenazasMapper;

    @Autowired
    private MatrizFodaEstrategicaService matrizFodaEstrategicaService;

    @PostMapping
    public ResponseEntity<AmenazasMatrizFodaEstrategicaDTO> createAmenaza(
            @RequestBody AmenazasMatrizFodaEstrategicaDTO amenazasDTO) {

        MatrizFodaEstrategica matriz = matrizFodaEstrategicaService
                .findById(amenazasDTO.getIdMatrizFodaEstrategica());

        if (matriz == null) {
            return ResponseEntity.badRequest().build();
        }

        AmenazasMatrizFodaEstrategica amenaza = amenazasMapper.toEntity(amenazasDTO, matriz);

        AmenazasMatrizFodaEstrategica savedAmenaza = amenazasService.save(amenaza);

        AmenazasMatrizFodaEstrategicaDTO savedDTO = amenazasMapper.toDTO(savedAmenaza);

        return ResponseEntity.ok(savedDTO);
    }

    @GetMapping
    public List<AmenazasMatrizFodaEstrategicaDTO> getAllAmenazas() {
        List<AmenazasMatrizFodaEstrategica> amenazas = amenazasService.findAll();
        return amenazas.stream()
                .map(amenazasMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/matriz/{idMatrizFodaEstrategica}")
    public List<AmenazasMatrizFodaEstrategicaDTO> getAmenazasByMatrizId(
            @PathVariable Long idMatrizFodaEstrategica) {
        List<AmenazasMatrizFodaEstrategica> amenazas = amenazasService.findByMatrizFodaEstrategicaId(idMatrizFodaEstrategica);
        return amenazas.stream()
                .map(amenazasMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AmenazasMatrizFodaEstrategicaDTO> getAmenazaById(@PathVariable Long id) {
        AmenazasMatrizFodaEstrategica amenaza = amenazasService.findById(id);
        if (amenaza == null) {
            return ResponseEntity.notFound().build();
        }
        AmenazasMatrizFodaEstrategicaDTO dto = amenazasMapper.toDTO(amenaza);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AmenazasMatrizFodaEstrategicaDTO> updateAmenaza(@PathVariable Long id, @RequestBody AmenazasMatrizFodaEstrategicaDTO amenazasDTO) {

        AmenazasMatrizFodaEstrategica existingAmenaza = amenazasService.findById(id);
        if (existingAmenaza == null) {
            return ResponseEntity.notFound().build();
        }

        MatrizFodaEstrategica matriz = matrizFodaEstrategicaService.findById(amenazasDTO.getIdMatrizFodaEstrategica());
        if (matriz == null) {
            return ResponseEntity.badRequest().build();
        }

        existingAmenaza.setContenido(amenazasDTO.getContenido());
        existingAmenaza.setMatrizFodaEstrategica(matriz);

        AmenazasMatrizFodaEstrategica updatedAmenaza = amenazasService.update(id, existingAmenaza);

        AmenazasMatrizFodaEstrategicaDTO updatedDTO = amenazasMapper.toDTO(updatedAmenaza);

        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAmenaza(@PathVariable Long id) {
        amenazasService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
