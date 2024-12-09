package com.api.login.ManualDeCalidad.rest;

import com.api.login.ManualDeCalidad.DTO.TablaEvaluacionDesempenoManualDTO;
import com.api.login.ManualDeCalidad.pojo.TablaEvaluacionDesempenoManual;
import com.api.login.ManualDeCalidad.pojo.ManualCalidad;
import com.api.login.ManualDeCalidad.Service.TablaEvaluacionDesempenoManualService;
import com.api.login.ManualDeCalidad.Service.ManualCalidadService;
import com.api.login.ManualDeCalidad.Mapper.TablaEvaluacionDesempenoManualMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tablaEvaluacionDesempenoManual")
public class TablaEvaluacionDesempenoManualController {

    @Autowired
    private TablaEvaluacionDesempenoManualService tablaEvaluacionDesempenoManualService;

    @Autowired
    private ManualCalidadService manualCalidadService;

    @Autowired
    private TablaEvaluacionDesempenoManualMapper tablaEvaluacionDesempenoManualMapper;

    @GetMapping
    public List<TablaEvaluacionDesempenoManualDTO> getAllTablaEvaluacionDesempenoManual() {
        List<TablaEvaluacionDesempenoManual> tablas = tablaEvaluacionDesempenoManualService.findAll();
        return tablas.stream().map(tablaEvaluacionDesempenoManualMapper::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TablaEvaluacionDesempenoManualDTO> getTablaEvaluacionDesempenoManualById(@PathVariable Long id) {
        TablaEvaluacionDesempenoManual tabla = tablaEvaluacionDesempenoManualService.findById(id);
        if (tabla == null) {
            return ResponseEntity.notFound().build();
        }
        TablaEvaluacionDesempenoManualDTO dto = tablaEvaluacionDesempenoManualMapper.toDTO(tabla);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/manualCalidad/{idManualCalidad}")
    public List<TablaEvaluacionDesempenoManualDTO> getTablasByManualCalidadId(@PathVariable Long idManualCalidad) {
        List<TablaEvaluacionDesempenoManual> tablas = tablaEvaluacionDesempenoManualService.findByManualCalidadId(idManualCalidad);
        return tablas.stream().map(tablaEvaluacionDesempenoManualMapper::toDTO).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<TablaEvaluacionDesempenoManualDTO> createTablaEvaluacionDesempenoManual(@Validated @RequestBody TablaEvaluacionDesempenoManualDTO tablaEvaluacionDesempenoManualDTO) {
        ManualCalidad manualCalidad = manualCalidadService.findByIdManualC(tablaEvaluacionDesempenoManualDTO.getIdManualCalidad());
        if (manualCalidad == null) {
            return ResponseEntity.badRequest().build();
        }
        TablaEvaluacionDesempenoManual tabla = tablaEvaluacionDesempenoManualMapper.toEntity(tablaEvaluacionDesempenoManualDTO, manualCalidad);
        TablaEvaluacionDesempenoManual savedTabla = tablaEvaluacionDesempenoManualService.save(tabla);
        TablaEvaluacionDesempenoManualDTO dto = tablaEvaluacionDesempenoManualMapper.toDTO(savedTabla);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TablaEvaluacionDesempenoManualDTO> updateTablaEvaluacionDesempenoManual(@PathVariable Long id, @Validated @RequestBody TablaEvaluacionDesempenoManualDTO tablaEvaluacionDesempenoManualDTO) {
        ManualCalidad manualCalidad = manualCalidadService.findByIdManualC(tablaEvaluacionDesempenoManualDTO.getIdManualCalidad());
        if (manualCalidad == null) {
            return ResponseEntity.badRequest().build();
        }
        TablaEvaluacionDesempenoManual tabla = tablaEvaluacionDesempenoManualService.findById(id);
        if (tabla == null) {
            return ResponseEntity.notFound().build();
        }
        tabla = tablaEvaluacionDesempenoManualMapper.toEntity(tablaEvaluacionDesempenoManualDTO, manualCalidad);
        tabla.setIdTablaEvaluacionDesempenoManual(id); // Ensure the ID remains unchanged
        TablaEvaluacionDesempenoManual updatedTabla = tablaEvaluacionDesempenoManualService.update(id, tabla);
        TablaEvaluacionDesempenoManualDTO dto = tablaEvaluacionDesempenoManualMapper.toDTO(updatedTabla);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTablaEvaluacionDesempenoManual(@PathVariable Long id) {
        tablaEvaluacionDesempenoManualService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

