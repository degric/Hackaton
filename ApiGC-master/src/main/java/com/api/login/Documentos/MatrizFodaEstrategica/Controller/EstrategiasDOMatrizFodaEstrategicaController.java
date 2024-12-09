package com.api.login.Documentos.MatrizFodaEstrategica.Controller;

import com.api.login.Documentos.MatrizFodaEstrategica.DTO.EstrategiasDOMatrizFodaEstrategicaDTO;
import com.api.login.Documentos.MatrizFodaEstrategica.Mapper.EstrategiasDOMatrizFodaEstrategicaMapper;
import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.EstrategiasDOMatrizFodaEstrategica;
import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.MatrizFodaEstrategica;
import com.api.login.Documentos.MatrizFodaEstrategica.Service.EstrategiasDOMatrizFodaEstrategicaService;
import com.api.login.Documentos.MatrizFodaEstrategica.Service.MatrizFodaEstrategicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/estrategiasDOMatrizFodaEstrategica")
public class EstrategiasDOMatrizFodaEstrategicaController {

    @Autowired
    private EstrategiasDOMatrizFodaEstrategicaService estrategiasDOService;

    @Autowired
    private EstrategiasDOMatrizFodaEstrategicaMapper estrategiasDOMapper;

    @Autowired
    private MatrizFodaEstrategicaService matrizFodaEstrategicaService;

    @PostMapping
    public ResponseEntity<EstrategiasDOMatrizFodaEstrategicaDTO> createEstrategiaDO(@RequestBody EstrategiasDOMatrizFodaEstrategicaDTO estrategiasDODTO) {
        // Obtener la entidad MatrizFodaEstrategica por el ID
        MatrizFodaEstrategica matrizFodaEstrategica = matrizFodaEstrategicaService.findById(estrategiasDODTO.getIdMatrizFodaEstrategica());

        if (matrizFodaEstrategica == null) {
            return ResponseEntity.badRequest().build(); // Si no existe, devuelve un error 400
        }

        // Mapear el DTO a la entidad
        EstrategiasDOMatrizFodaEstrategica estrategiaDO = estrategiasDOMapper.toEntity(estrategiasDODTO, matrizFodaEstrategica);

        // Guardar la entidad
        EstrategiasDOMatrizFodaEstrategica savedEstrategiaDO = estrategiasDOService.save(estrategiaDO);

        // Convertir la entidad guardada en DTO para la respuesta
        EstrategiasDOMatrizFodaEstrategicaDTO savedDTO = estrategiasDOMapper.toDTO(savedEstrategiaDO);
        return ResponseEntity.ok(savedDTO);
    }

    @GetMapping
    public List<EstrategiasDOMatrizFodaEstrategicaDTO> getAllEstrategiasDO() {
        List<EstrategiasDOMatrizFodaEstrategica> estrategiasDO = estrategiasDOService.findAll();
        return estrategiasDO.stream()
                .map(estrategiasDOMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/matriz/{idMatrizFodaEstrategica}")
    public List<EstrategiasDOMatrizFodaEstrategicaDTO> getEstrategiasDOByMatrizId(@PathVariable Long idMatrizFodaEstrategica) {
        List<EstrategiasDOMatrizFodaEstrategica> estrategiasDO = estrategiasDOService.findByMatrizFodaEstrategicaId(idMatrizFodaEstrategica);
        return estrategiasDO.stream()
                .map(estrategiasDOMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstrategiasDOMatrizFodaEstrategicaDTO> getEstrategiaDOById(@PathVariable Long id) {
        EstrategiasDOMatrizFodaEstrategica estrategiaDO = estrategiasDOService.findById(id);
        if (estrategiaDO == null) {
            return ResponseEntity.notFound().build();
        }
        EstrategiasDOMatrizFodaEstrategicaDTO dto = estrategiasDOMapper.toDTO(estrategiaDO);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstrategiasDOMatrizFodaEstrategicaDTO> updateEstrategiaDO(@PathVariable Long id, @RequestBody EstrategiasDOMatrizFodaEstrategicaDTO estrategiasDODTO) {
        // Buscar la estrategia existente
        EstrategiasDOMatrizFodaEstrategica existingEstrategiaDO = estrategiasDOService.findById(id);
        if (existingEstrategiaDO == null) {
            return ResponseEntity.notFound().build();
        }

        // Buscar la entidad MatrizFodaEstrategica por el ID
        MatrizFodaEstrategica matrizFodaEstrategica = matrizFodaEstrategicaService.findById(estrategiasDODTO.getIdMatrizFodaEstrategica());
        if (matrizFodaEstrategica == null) {
            return ResponseEntity.badRequest().build();
        }

        // Actualizar los campos de la estrategia
        existingEstrategiaDO.setContenido(estrategiasDODTO.getContenido());
        existingEstrategiaDO.setMatrizFodaEstrategica(matrizFodaEstrategica);

        // Guardar los cambios
        EstrategiasDOMatrizFodaEstrategica updatedEstrategiaDO = estrategiasDOService.update(id, existingEstrategiaDO);

        // Convertir la entidad actualizada a DTO para devolverla
        EstrategiasDOMatrizFodaEstrategicaDTO updatedDTO = estrategiasDOMapper.toDTO(updatedEstrategiaDO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstrategiaDO(@PathVariable Long id) {
        estrategiasDOService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
