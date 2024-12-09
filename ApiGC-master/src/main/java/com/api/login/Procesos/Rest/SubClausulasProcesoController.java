package com.api.login.Procesos.Rest;

import com.api.login.Procesos.DTO.SubClausulasProcesoDTO;
import com.api.login.Procesos.Mapper.SubClausulasProcesoMapper;
import com.api.login.Procesos.Pojo.DesarrolloProceso;
import com.api.login.Procesos.Pojo.SubClausulasProceso;
import com.api.login.Procesos.Service.DesarrolloProcesoService;
import com.api.login.Procesos.Service.SubClausulasProcesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/subClausulasProceso")
public class SubClausulasProcesoController {

    @Autowired
    private SubClausulasProcesoService subClausulasProcesoService;

    @Autowired
    private SubClausulasProcesoMapper subClausulasProcesoMapper;

    @Autowired
    private DesarrolloProcesoService desarrolloProcesoService;

    @GetMapping
    public List<SubClausulasProcesoDTO> getAllSubClausulas() {
        return subClausulasProcesoService.findAll().stream()
                .map(subClausulasProcesoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubClausulasProcesoDTO> getSubClausulaById(@PathVariable Long id) {
        SubClausulasProceso subClausula = subClausulasProcesoService.findById(id);
        if (subClausula == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(subClausulasProcesoMapper.toDTO(subClausula));
    }

    @GetMapping("/desarrollo/{id}")
    public List<SubClausulasProcesoDTO> getSubClausulaByIddesarrollo(@PathVariable Long id) {
        return subClausulasProcesoService.findByclausula(id)
                .stream().map(subClausulasProcesoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<SubClausulasProcesoDTO> createSubClausula(@RequestBody SubClausulasProcesoDTO subClausulasProcesoDTO) {
        DesarrolloProceso desarrolloProceso = desarrolloProcesoService.findById(subClausulasProcesoDTO.getIdDesarrolloProceso());
        if (desarrolloProceso == null) {
            return ResponseEntity.badRequest().build();
        }
        SubClausulasProceso subClausula = subClausulasProcesoMapper.toEntity(subClausulasProcesoDTO, desarrolloProceso);
        SubClausulasProceso savedSubClausula = subClausulasProcesoService.save(subClausula);
        return ResponseEntity.ok(subClausulasProcesoMapper.toDTO(savedSubClausula));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubClausulasProcesoDTO> updateSubClausula(@PathVariable Long id, @RequestBody SubClausulasProcesoDTO subClausulasProcesoDTO) {
        SubClausulasProceso subClausula = subClausulasProcesoService.findById(id);
        if (subClausula == null) {
            return ResponseEntity.notFound().build();
        }
        DesarrolloProceso desarrolloProceso = desarrolloProcesoService.findById(subClausulasProcesoDTO.getIdDesarrolloProceso());
        if (desarrolloProceso == null) {
            return ResponseEntity.badRequest().build();
        }
        subClausula = subClausulasProcesoMapper.toEntity(subClausulasProcesoDTO, desarrolloProceso);

        subClausula.setIdSubClausulasProceso(id);
        SubClausulasProceso updatedSubClausula = subClausulasProcesoService.update(id, subClausula);
        return ResponseEntity.ok(subClausulasProcesoMapper.toDTO(updatedSubClausula));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubClausula(@PathVariable Long id) {
        subClausulasProcesoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

