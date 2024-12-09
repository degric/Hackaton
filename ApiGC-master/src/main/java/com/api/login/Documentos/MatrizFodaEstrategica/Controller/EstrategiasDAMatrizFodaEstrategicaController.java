package com.api.login.Documentos.MatrizFodaEstrategica.Controller;

import com.api.login.Documentos.MatrizFodaEstrategica.DTO.EstrategiasDAMatrizFodaEstrategicaDTO;
import com.api.login.Documentos.MatrizFodaEstrategica.Mapper.EstrategiasDAMatrizFodaEstrategicaMapper;
import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.EstrategiasDAMatrizFodaEstrategica;
import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.MatrizFodaEstrategica;
import com.api.login.Documentos.MatrizFodaEstrategica.Service.EstrategiasDAMatrizFodaEstrategicaService;
import com.api.login.Documentos.MatrizFodaEstrategica.Service.MatrizFodaEstrategicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/estrategiasDAMatrizFodaEstrategica")
public class EstrategiasDAMatrizFodaEstrategicaController {

    @Autowired
    private EstrategiasDAMatrizFodaEstrategicaService estrategiasDAService;

    @Autowired
    private EstrategiasDAMatrizFodaEstrategicaMapper estrategiasDAMapper;

    @Autowired
    private MatrizFodaEstrategicaService matrizFodaEstrategicaService;

    @PostMapping
    public ResponseEntity<EstrategiasDAMatrizFodaEstrategicaDTO> createEstrategiaDA(@RequestBody EstrategiasDAMatrizFodaEstrategicaDTO estrategiasDADTO) {

        MatrizFodaEstrategica matriz = matrizFodaEstrategicaService.findById(estrategiasDADTO.getIdMatrizFodaEstrategica());

        if (matriz == null) {
            return ResponseEntity.badRequest().build();
        }

        EstrategiasDAMatrizFodaEstrategica estrategiaDA = estrategiasDAMapper.toEntity(estrategiasDADTO, matriz);

        EstrategiasDAMatrizFodaEstrategica savedEstrategiaDA = estrategiasDAService.save(estrategiaDA);

        EstrategiasDAMatrizFodaEstrategicaDTO savedDTO = estrategiasDAMapper.toDTO(savedEstrategiaDA);

        return ResponseEntity.ok(savedDTO);
    }

    @GetMapping
    public List<EstrategiasDAMatrizFodaEstrategicaDTO> getAllEstrategiasDA() {
        List<EstrategiasDAMatrizFodaEstrategica> estrategiasDA = estrategiasDAService.findAll();
        return estrategiasDA.stream()
                .map(estrategiasDAMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/matriz/{idMatrizFodaEstrategica}")
    public List<EstrategiasDAMatrizFodaEstrategicaDTO> getEstrategiasDAByMatrizId(@PathVariable Long idMatrizFodaEstrategica) {
        List<EstrategiasDAMatrizFodaEstrategica> estrategiasDA = estrategiasDAService.findByMatrizFodaEstrategicaId(idMatrizFodaEstrategica);
        return estrategiasDA.stream()
                .map(estrategiasDAMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstrategiasDAMatrizFodaEstrategicaDTO> getEstrategiaDAById(@PathVariable Long id) {
        EstrategiasDAMatrizFodaEstrategica estrategiaDA = estrategiasDAService.findById(id);
        if (estrategiaDA == null) {
            return ResponseEntity.notFound().build();
        }
        EstrategiasDAMatrizFodaEstrategicaDTO dto = estrategiasDAMapper.toDTO(estrategiaDA);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstrategiasDAMatrizFodaEstrategicaDTO> updateEstrategiaDA(@PathVariable Long id, @RequestBody EstrategiasDAMatrizFodaEstrategicaDTO estrategiasDADTO) {

        EstrategiasDAMatrizFodaEstrategica existingEstrategiaDA = estrategiasDAService.findById(id);
        if (existingEstrategiaDA == null) {
            return ResponseEntity.notFound().build();
        }

        MatrizFodaEstrategica matriz = matrizFodaEstrategicaService.findById(estrategiasDADTO.getIdMatrizFodaEstrategica());
        if (matriz == null) {
            return ResponseEntity.badRequest().build();
        }

        existingEstrategiaDA.setContenido(estrategiasDADTO.getContenido());
        existingEstrategiaDA.setMatrizFodaEstrategica(matriz);

        EstrategiasDAMatrizFodaEstrategica updatedEstrategiaDA = estrategiasDAService.update(id, existingEstrategiaDA);

        EstrategiasDAMatrizFodaEstrategicaDTO updatedDTO = estrategiasDAMapper.toDTO(updatedEstrategiaDA);

        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstrategiaDA(@PathVariable Long id) {
        estrategiasDAService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
