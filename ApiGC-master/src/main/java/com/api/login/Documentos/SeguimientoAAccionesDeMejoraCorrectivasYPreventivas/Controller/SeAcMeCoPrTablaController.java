package com.api.login.Documentos.SeguimientoAAccionesDeMejoraCorrectivasYPreventivas.Controller;

import com.api.login.Documentos.SeguimientoAAccionesDeMejoraCorrectivasYPreventivas.DTO.SeAcMeCoPrTablaDTO;
import com.api.login.Documentos.SeguimientoAAccionesDeMejoraCorrectivasYPreventivas.Service.SeAcMeCoPrTablaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seAcMeCoPrTabla")
public class SeAcMeCoPrTablaController {

    @Autowired
    private SeAcMeCoPrTablaService seAcMeCoPrTablaService;

    @GetMapping
    public List<SeAcMeCoPrTablaDTO> getAllTablas() {
        return seAcMeCoPrTablaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeAcMeCoPrTablaDTO> getTablaById(@PathVariable Long id) {
        SeAcMeCoPrTablaDTO dto = seAcMeCoPrTablaService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/seguiAccioMejoCorrePrev/{idSeguiAccioMejoCorrePrev}")
    public List<SeAcMeCoPrTablaDTO> getTablasBySeguiAccioMejoCorrePrev(@PathVariable Long idSeguiAccioMejoCorrePrev) {
        return seAcMeCoPrTablaService.findBySeguiAccioMejoCorrePrev(idSeguiAccioMejoCorrePrev);
    }

    @PostMapping
    public ResponseEntity<SeAcMeCoPrTablaDTO> createTabla(@RequestBody SeAcMeCoPrTablaDTO seAcMeCoPrTablaDTO) {
        SeAcMeCoPrTablaDTO savedDTO = seAcMeCoPrTablaService.save(seAcMeCoPrTablaDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SeAcMeCoPrTablaDTO> updateTabla(@PathVariable Long id, @RequestBody SeAcMeCoPrTablaDTO seAcMeCoPrTablaDTO) {
        SeAcMeCoPrTablaDTO updatedDTO = seAcMeCoPrTablaService.update(id, seAcMeCoPrTablaDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTabla(@PathVariable Long id) {
        seAcMeCoPrTablaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

