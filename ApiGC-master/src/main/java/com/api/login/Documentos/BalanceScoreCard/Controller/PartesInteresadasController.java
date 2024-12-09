package com.api.login.Documentos.BalanceScoreCard.Controller;

import com.api.login.Documentos.BalanceScoreCard.DTO.PartesInteresadasDTO;
import com.api.login.Documentos.BalanceScoreCard.Service.PartesInteresadasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partesInteresadas")
public class PartesInteresadasController {

    @Autowired
    private PartesInteresadasService partesInteresadasService;

    @GetMapping
    public List<PartesInteresadasDTO> getAllPartes() {
        return partesInteresadasService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartesInteresadasDTO> getParteById(@PathVariable Long id) {
        PartesInteresadasDTO dto = partesInteresadasService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/balanceSCPrespectiva/{idBalanceSCPrespectiva}")
    public List<PartesInteresadasDTO> getPartesByBalanceSCPrespectiva(@PathVariable Long idBalanceSCPrespectiva) {
        return partesInteresadasService.findByBalanceSCPrespectiva(idBalanceSCPrespectiva);
    }

    @PostMapping
    public ResponseEntity<PartesInteresadasDTO> createParte(@RequestBody PartesInteresadasDTO partesInteresadasDTO) {
        PartesInteresadasDTO savedDTO = partesInteresadasService.save(partesInteresadasDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PartesInteresadasDTO> updateParte(@PathVariable Long id, @RequestBody PartesInteresadasDTO partesInteresadasDTO) {
        PartesInteresadasDTO updatedDTO = partesInteresadasService.update(id, partesInteresadasDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParte(@PathVariable Long id) {
        partesInteresadasService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

