package com.api.login.Documentos.MatrizFodaEstrategica.Controller;

import com.api.login.Documentos.MatrizFodaEstrategica.DTO.EstrategiasFOMatrizFodaEstrategicaDTO;
import com.api.login.Documentos.MatrizFodaEstrategica.Mapper.EstrategiasFOMatrizFodaEstrategicaMapper;
import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.EstrategiasFOMatrizFodaEstrategica;
import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.MatrizFodaEstrategica;
import com.api.login.Documentos.MatrizFodaEstrategica.Service.EstrategiasFOMatrizFodaEstrategicaService;
import com.api.login.Documentos.MatrizFodaEstrategica.Service.MatrizFodaEstrategicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/estrategiasFOMatrizFodaEstrategica")
public class EstrategiasFOMatrizFodaEstrategicaController {

    @Autowired
    private EstrategiasFOMatrizFodaEstrategicaService estrategiasFOService;

    @Autowired
    private EstrategiasFOMatrizFodaEstrategicaMapper estrategiasFOMapper;

    @Autowired
    private MatrizFodaEstrategicaService matrizFodaEstrategicaService;

    @PostMapping
    public ResponseEntity<EstrategiasFOMatrizFodaEstrategicaDTO> createEstrategiaFO(@RequestBody EstrategiasFOMatrizFodaEstrategicaDTO estrategiasFODTO) {
        // Obtener la entidad MatrizFodaEstrategica por el ID
        MatrizFodaEstrategica matrizFodaEstrategica = matrizFodaEstrategicaService.findById(estrategiasFODTO.getIdMatrizFodaEstrategica());

        if (matrizFodaEstrategica == null) {
            return ResponseEntity.badRequest().build(); // Si no existe, devuelve un error 400
        }

        // Mapear el DTO a la entidad
        EstrategiasFOMatrizFodaEstrategica estrategiaFO = estrategiasFOMapper.toEntity(estrategiasFODTO, matrizFodaEstrategica);

        // Guardar la entidad
        EstrategiasFOMatrizFodaEstrategica savedEstrategiaFO = estrategiasFOService.save(estrategiaFO);

        // Convertir la entidad guardada en DTO para la respuesta
        EstrategiasFOMatrizFodaEstrategicaDTO savedDTO = estrategiasFOMapper.toDTO(savedEstrategiaFO);
        return ResponseEntity.ok(savedDTO);
    }

    @GetMapping
    public List<EstrategiasFOMatrizFodaEstrategicaDTO> getAllEstrategiasFO() {
        List<EstrategiasFOMatrizFodaEstrategica> estrategiasFO = estrategiasFOService.findAll();
        return estrategiasFO.stream()
                .map(estrategiasFOMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/matriz/{idMatrizFodaEstrategica}")
    public List<EstrategiasFOMatrizFodaEstrategicaDTO> getEstrategiasFOByMatrizId(@PathVariable Long idMatrizFodaEstrategica) {
        List<EstrategiasFOMatrizFodaEstrategica> estrategiasFO = estrategiasFOService.findByMatrizFodaEstrategicaId(idMatrizFodaEstrategica);
        return estrategiasFO.stream()
                .map(estrategiasFOMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstrategiasFOMatrizFodaEstrategicaDTO> getEstrategiaFOById(@PathVariable Long id) {
        EstrategiasFOMatrizFodaEstrategica estrategiaFO = estrategiasFOService.findById(id);
        if (estrategiaFO == null) {
            return ResponseEntity.notFound().build();
        }
        EstrategiasFOMatrizFodaEstrategicaDTO dto = estrategiasFOMapper.toDTO(estrategiaFO);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstrategiasFOMatrizFodaEstrategicaDTO> updateEstrategiaFO(@PathVariable Long id, @RequestBody EstrategiasFOMatrizFodaEstrategicaDTO estrategiasFODTO) {
        // Buscar la estrategia existente
        EstrategiasFOMatrizFodaEstrategica existingEstrategiaFO = estrategiasFOService.findById(id);
        if (existingEstrategiaFO == null) {
            return ResponseEntity.notFound().build();
        }

        // Buscar la entidad MatrizFodaEstrategica por el ID
        MatrizFodaEstrategica matrizFodaEstrategica = matrizFodaEstrategicaService.findById(estrategiasFODTO.getIdMatrizFodaEstrategica());
        if (matrizFodaEstrategica == null) {
            return ResponseEntity.badRequest().build();
        }

        // Actualizar los campos de la estrategia
        existingEstrategiaFO.setContenido(estrategiasFODTO.getContenido());
        existingEstrategiaFO.setMatrizFodaEstrategica(matrizFodaEstrategica);

        // Guardar los cambios
        EstrategiasFOMatrizFodaEstrategica updatedEstrategiaFO = estrategiasFOService.update(id, existingEstrategiaFO);

        // Convertir la entidad actualizada a DTO para devolverla
        EstrategiasFOMatrizFodaEstrategicaDTO updatedDTO = estrategiasFOMapper.toDTO(updatedEstrategiaFO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstrategiaFO(@PathVariable Long id) {
        estrategiasFOService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

