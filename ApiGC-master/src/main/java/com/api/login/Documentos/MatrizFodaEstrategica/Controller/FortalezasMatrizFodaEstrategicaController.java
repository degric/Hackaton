package com.api.login.Documentos.MatrizFodaEstrategica.Controller;

import com.api.login.Documentos.MatrizFodaEstrategica.DTO.FortalezasMatrizFodaEstrategicaDTO;
import com.api.login.Documentos.MatrizFodaEstrategica.Mapper.FortalezasMatrizFodaEstrategicaMapper;
import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.FortalezasMatrizFodaEstrategica;
import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.MatrizFodaEstrategica;
import com.api.login.Documentos.MatrizFodaEstrategica.Service.FortalezasMatrizFodaEstrategicaService;
import com.api.login.Documentos.MatrizFodaEstrategica.Service.MatrizFodaEstrategicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/fortalezasMatrizFodaEstrategica")
public class FortalezasMatrizFodaEstrategicaController {

    @Autowired
    private FortalezasMatrizFodaEstrategicaService fortalezasService;

    @Autowired
    private FortalezasMatrizFodaEstrategicaMapper fortalezasMapper;

    @Autowired
    private MatrizFodaEstrategicaService matrizFodaEstrategicaService;

    @PostMapping
    public ResponseEntity<FortalezasMatrizFodaEstrategicaDTO> createFortaleza(@RequestBody FortalezasMatrizFodaEstrategicaDTO fortalezasDTO) {
        // Obtener la entidad MatrizFodaEstrategica por el ID
        MatrizFodaEstrategica matrizFodaEstrategica = matrizFodaEstrategicaService.findById(fortalezasDTO.getIdMatrizFodaEstrategica());

        if (matrizFodaEstrategica == null) {
            return ResponseEntity.badRequest().build(); // Si no existe, devuelve un error 400
        }

        // Mapear el DTO a la entidad
        FortalezasMatrizFodaEstrategica fortaleza = fortalezasMapper.toEntity(fortalezasDTO, matrizFodaEstrategica);

        // Guardar la entidad
        FortalezasMatrizFodaEstrategica savedFortaleza = fortalezasService.save(fortaleza);

        // Convertir la entidad guardada en DTO para la respuesta
        FortalezasMatrizFodaEstrategicaDTO savedDTO = fortalezasMapper.toDTO(savedFortaleza);
        return ResponseEntity.ok(savedDTO);
    }

    @GetMapping
    public List<FortalezasMatrizFodaEstrategicaDTO> getAllFortalezas() {
        List<FortalezasMatrizFodaEstrategica> fortalezas = fortalezasService.findAll();
        return fortalezas.stream()
                .map(fortalezasMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/matriz/{idMatrizFodaEstrategica}")
    public List<FortalezasMatrizFodaEstrategicaDTO> getFortalezasByMatrizId(@PathVariable Long idMatrizFodaEstrategica) {
        List<FortalezasMatrizFodaEstrategica> fortalezas = fortalezasService.findByMatrizFodaEstrategicaId(idMatrizFodaEstrategica);
        return fortalezas.stream()
                .map(fortalezasMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FortalezasMatrizFodaEstrategicaDTO> getFortalezaById(@PathVariable Long id) {
        FortalezasMatrizFodaEstrategica fortaleza = fortalezasService.findById(id);
        if (fortaleza == null) {
            return ResponseEntity.notFound().build();
        }
        FortalezasMatrizFodaEstrategicaDTO dto = fortalezasMapper.toDTO(fortaleza);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FortalezasMatrizFodaEstrategicaDTO> updateFortaleza(@PathVariable Long id, @RequestBody FortalezasMatrizFodaEstrategicaDTO fortalezasDTO) {
        // Buscar la fortaleza existente
        FortalezasMatrizFodaEstrategica existingFortaleza = fortalezasService.findById(id);
        if (existingFortaleza == null) {
            return ResponseEntity.notFound().build();
        }

        // Buscar la entidad MatrizFodaEstrategica por el ID
        MatrizFodaEstrategica matrizFodaEstrategica = matrizFodaEstrategicaService.findById(fortalezasDTO.getIdMatrizFodaEstrategica());
        if (matrizFodaEstrategica == null) {
            return ResponseEntity.badRequest().build();
        }

        // Actualizar los campos de la fortaleza
        existingFortaleza.setContenido(fortalezasDTO.getContenido());
        existingFortaleza.setMatrizFodaEstrategica(matrizFodaEstrategica);

        // Guardar los cambios
        FortalezasMatrizFodaEstrategica updatedFortaleza = fortalezasService.update(id, existingFortaleza);

        // Convertir la entidad actualizada a DTO para devolverla
        FortalezasMatrizFodaEstrategicaDTO updatedDTO = fortalezasMapper.toDTO(updatedFortaleza);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFortaleza(@PathVariable Long id) {
        fortalezasService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
