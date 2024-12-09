package com.api.login.Documentos.BalanceScoreCard.Controller;

import com.api.login.Documentos.BalanceScoreCard.DTO.BalanceSCPrespectivaDTO;
import com.api.login.Documentos.BalanceScoreCard.Service.BalanceSCPrespectivaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/balanceSCPrespectiva")
public class BalanceSCPrespectivaController {

    @Autowired
    private BalanceSCPrespectivaService balanceSCPrespectivaService;

    @GetMapping
    public List<BalanceSCPrespectivaDTO> getAllBalances() {
        return balanceSCPrespectivaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BalanceSCPrespectivaDTO> getBalanceById(@PathVariable Long id) {
        BalanceSCPrespectivaDTO dto = balanceSCPrespectivaService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/balanceScoreCard/{idBalanceScoreCard}")
    public List<BalanceSCPrespectivaDTO> getBalancesByScoreCard(@PathVariable Long idBalanceScoreCard) {
        return balanceSCPrespectivaService.findByBalanceScoreCard(idBalanceScoreCard);
    }

    @PostMapping
    public ResponseEntity<BalanceSCPrespectivaDTO> createBalance(@RequestBody BalanceSCPrespectivaDTO balanceSCPrespectivaDTO) {
        BalanceSCPrespectivaDTO savedDTO = balanceSCPrespectivaService.save(balanceSCPrespectivaDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BalanceSCPrespectivaDTO> updateBalance(@PathVariable Long id, @RequestBody BalanceSCPrespectivaDTO balanceSCPrespectivaDTO) {
        BalanceSCPrespectivaDTO updatedDTO = balanceSCPrespectivaService.update(id, balanceSCPrespectivaDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBalance(@PathVariable Long id) {
        balanceSCPrespectivaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

