package com.api.login.Documentos.BalanceScoreCard.Controller;

import com.api.login.Documentos.BalanceScoreCard.DTO.MetricasBSCDTO;
import com.api.login.Documentos.BalanceScoreCard.DTO.ObjetivoDTO;
import com.api.login.Documentos.BalanceScoreCard.Service.MetricasBSCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/metricasBSC")
public class MetricasBSCController {

    @Autowired
    private MetricasBSCService metricasBSCService;

    @GetMapping
    public List<MetricasBSCDTO> getAllMetricas() {
        return metricasBSCService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MetricasBSCDTO> getMetricasById(@PathVariable Long id) {
        MetricasBSCDTO dto = metricasBSCService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/balanceSCPrespectiva/{idBalanceSCPrespectiva}")
    public List<MetricasBSCDTO> getMetricasByBalanceSCPrespectiva(@PathVariable Long idBalanceSCPrespectiva) {
        return metricasBSCService.findByBalanceSCPrespectiva(idBalanceSCPrespectiva);
    }

    @PostMapping
    public ResponseEntity<MetricasBSCDTO> createMetricas(@RequestBody MetricasBSCDTO metricasBSCDTO) {
        MetricasBSCDTO savedDTO = metricasBSCService.save(metricasBSCDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MetricasBSCDTO> updateMetricas(@PathVariable Long id, @RequestBody MetricasBSCDTO metricasBSCDTO) {
        MetricasBSCDTO updatedDTO = metricasBSCService.update(id, metricasBSCDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMetricas(@PathVariable Long id) {
        metricasBSCService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/objetivosLista")
    public ResponseEntity<List<ObjetivoDTO>> getDistinctObjetivos() {
        List<ObjetivoDTO> objetivos = metricasBSCService.findDistinctObjetivos();
        return ResponseEntity.ok(objetivos);
    }
    @GetMapping("/buscar-por-objetivo")
    public ResponseEntity<List<MetricasBSCDTO>> getByObjetivo(@RequestParam String objetivo) {
        List<MetricasBSCDTO> metricas = metricasBSCService.findByObjetivo(objetivo);
        return ResponseEntity.ok(metricas);
    }
}

