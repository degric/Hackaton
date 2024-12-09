package com.api.login.Procesos.Rest;

import com.api.login.Procesos.DTO.SubSubClausulasProcesoDTO;
import com.api.login.Procesos.Mapper.SubSubClausulasProcesoMapper;
import com.api.login.Procesos.Pojo.SubClausulasProceso;
import com.api.login.Procesos.Pojo.SubSubClausulasProceso;
import com.api.login.Procesos.Service.SubClausulasProcesoService;
import com.api.login.Procesos.Service.SubSubClausulasProcesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/subSubClausulasProceso")
public class SubSubClausulasProcesoController {

    @Autowired
    private SubSubClausulasProcesoService subSubClausulasProcesoService;

    @Autowired
    private SubSubClausulasProcesoMapper subSubClausulasProcesoMapper;

    @Autowired
    private SubClausulasProcesoService subClausulasProcesoService;

    @GetMapping
    public List<SubSubClausulasProcesoDTO> getAllSubSubClausulas() {
        List<SubSubClausulasProceso> subSubClausulas = subSubClausulasProcesoService.findAll();
        return subSubClausulas.stream()
                .map(subSubClausulasProcesoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/subclausula/{id}")
    public List<SubSubClausulasProcesoDTO> getAllSubSubClausulasbyclausula(@PathVariable Long id) {
        List<SubSubClausulasProceso> subSubClausulas = subSubClausulasProcesoService.findBySubPunto(id);
        return subSubClausulas.stream()
                .map(subSubClausulasProcesoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubSubClausulasProcesoDTO> getSubSubClausulasById(@PathVariable Long id) {
        SubSubClausulasProceso subSubClausulas = subSubClausulasProcesoService.findById(id);
        if (subSubClausulas == null) {
            return ResponseEntity.notFound().build();
        }
        SubSubClausulasProcesoDTO dto = subSubClausulasProcesoMapper.toDTO(subSubClausulas);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<SubSubClausulasProcesoDTO> createSubSubClausulas(@RequestBody SubSubClausulasProcesoDTO subSubClausulasDTO) {
        SubClausulasProceso subClausulas = subClausulasProcesoService.findById(subSubClausulasDTO.getIdSubClausulasProceso());
        if (subClausulas == null) {
            return ResponseEntity.badRequest().build();
        }
        SubSubClausulasProceso subSubClausulas = subSubClausulasProcesoMapper.toEntity(subSubClausulasDTO, subClausulas);
        SubSubClausulasProceso savedSubSubClausulas = subSubClausulasProcesoService.save(subSubClausulas);
        SubSubClausulasProcesoDTO dto = subSubClausulasProcesoMapper.toDTO(savedSubSubClausulas);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubSubClausulasProcesoDTO> updateSubSubClausulas(@PathVariable Long id, @RequestBody SubSubClausulasProcesoDTO subSubClausulasDTO) {
        SubSubClausulasProceso subSubClausulas = subSubClausulasProcesoService.findById(id);
        if (subSubClausulas == null) {
            return ResponseEntity.notFound().build();
        }
        SubClausulasProceso subClausulas = subClausulasProcesoService.findById(subSubClausulasDTO.getIdSubClausulasProceso());
        if (subClausulas == null) {
            return ResponseEntity.badRequest().build();
        }
        subSubClausulas = subSubClausulasProcesoMapper.toEntity(subSubClausulasDTO, subClausulas);
        subSubClausulas.setIdSubSubClausulasProceso(id);
        SubSubClausulasProceso updatedSubSubClausulas = subSubClausulasProcesoService.update(id, subSubClausulas);
        SubSubClausulasProcesoDTO dto = subSubClausulasProcesoMapper.toDTO(updatedSubSubClausulas);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubSubClausulas(@PathVariable Long id) {
        subSubClausulasProcesoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
