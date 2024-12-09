package com.api.login.Documentos.MatrizFodaEstrategica.Controller;

import com.api.login.Documentos.MatrizFodaEstrategica.DTO.EstrategiasFAMatrizFodaEstrategicaDTO;
import com.api.login.Documentos.MatrizFodaEstrategica.Mapper.EstrategiasFAMatrizFodaEstrategicaMapper;
import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.EstrategiasFAMatrizFodaEstrategica;
import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.MatrizFodaEstrategica;
import com.api.login.Documentos.MatrizFodaEstrategica.Service.EstrategiasFAMatrizFodaEstrategicaService;
import com.api.login.Documentos.MatrizFodaEstrategica.Service.MatrizFodaEstrategicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/estrategiasFAMatrizFodaEstrategica")
public class EstrategiasFAMatrizFodaEstrategicaController {

    @Autowired
    private EstrategiasFAMatrizFodaEstrategicaService estrategiasFAService;

    @Autowired
    private EstrategiasFAMatrizFodaEstrategicaMapper estrategiasFAMapper;

    @Autowired
    private MatrizFodaEstrategicaService matrizFodaEstrategicaService;

    @PostMapping
    public ResponseEntity<EstrategiasFAMatrizFodaEstrategicaDTO> createEstrategiaFA(@RequestBody EstrategiasFAMatrizFodaEstrategicaDTO estrategiasFADTO) {

        MatrizFodaEstrategica matriz = matrizFodaEstrategicaService.findById(estrategiasFADTO.getIdMatrizFodaEstrategica());

        if (matriz == null) {
            return ResponseEntity.badRequest().build();
        }

        EstrategiasFAMatrizFodaEstrategica estrategiaFA = estrategiasFAMapper.toEntity(estrategiasFADTO, matriz);

        EstrategiasFAMatrizFodaEstrategica savedEstrategiaFA = estrategiasFAService.save(estrategiaFA);

        EstrategiasFAMatrizFodaEstrategicaDTO savedDTO = estrategiasFAMapper.toDTO(savedEstrategiaFA);

        return ResponseEntity.ok(savedDTO);
    }

    @GetMapping
    public List<EstrategiasFAMatrizFodaEstrategicaDTO> getAllEstrategiasFA() {
        List<EstrategiasFAMatrizFodaEstrategica> estrategiasFA = estrategiasFAService.findAll();
        return estrategiasFA.stream()
                .map(estrategiasFAMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/matriz/{idMatrizFodaEstrategica}")
    public List<EstrategiasFAMatrizFodaEstrategicaDTO> getEstrategiasFAByMatrizId(@PathVariable Long idMatrizFodaEstrategica) {
        List<EstrategiasFAMatrizFodaEstrategica> estrategiasFA = estrategiasFAService.findByMatrizFodaEstrategicaId(idMatrizFodaEstrategica);
        return estrategiasFA.stream()
                .map(estrategiasFAMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstrategiasFAMatrizFodaEstrategicaDTO> getEstrategiaFAById(@PathVariable Long id) {
        EstrategiasFAMatrizFodaEstrategica estrategiaFA = estrategiasFAService.findById(id);
        if (estrategiaFA == null) {
            return ResponseEntity.notFound().build();
        }
        EstrategiasFAMatrizFodaEstrategicaDTO dto = estrategiasFAMapper.toDTO(estrategiaFA);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstrategiasFAMatrizFodaEstrategicaDTO> updateEstrategiaFA(@PathVariable Long id, @RequestBody EstrategiasFAMatrizFodaEstrategicaDTO estrategiasFADTO) {

        EstrategiasFAMatrizFodaEstrategica existingEstrategiaFA = estrategiasFAService.findById(id);
        if (existingEstrategiaFA == null) {
            return ResponseEntity.notFound().build();
        }

        MatrizFodaEstrategica matriz = matrizFodaEstrategicaService.findById(estrategiasFADTO.getIdMatrizFodaEstrategica());
        if (matriz == null) {
            return ResponseEntity.badRequest().build();
        }

        existingEstrategiaFA.setContenido(estrategiasFADTO.getContenido());
        existingEstrategiaFA.setMatrizFodaEstrategica(matriz);

        EstrategiasFAMatrizFodaEstrategica updatedEstrategiaFA = estrategiasFAService.update(id, existingEstrategiaFA);

        EstrategiasFAMatrizFodaEstrategicaDTO updatedDTO = estrategiasFAMapper.toDTO(updatedEstrategiaFA);

        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstrategiaFA(@PathVariable Long id) {
        estrategiasFAService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

