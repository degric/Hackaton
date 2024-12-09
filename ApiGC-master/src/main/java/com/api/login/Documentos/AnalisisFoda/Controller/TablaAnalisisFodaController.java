package com.api.login.Documentos.AnalisisFoda.Controller;

import com.api.login.Documentos.AnalisisFoda.DTO.TablaAnalisisFodaDTO;
import com.api.login.Documentos.AnalisisFoda.Mapper.TablaAnalisisFodaMapper;
import com.api.login.Documentos.AnalisisFoda.Pojo.AnalisisFoda;
import com.api.login.Documentos.AnalisisFoda.Pojo.TablaAnalisisFoda;
import com.api.login.Documentos.AnalisisFoda.Service.AnalisisFodaService;
import com.api.login.Documentos.AnalisisFoda.Service.TablaAnalisisFodaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tablaAnalisisFoda")
public class TablaAnalisisFodaController {

    @Autowired
    private TablaAnalisisFodaService tablaAnalisisFodaService;

    @Autowired
    private TablaAnalisisFodaMapper tablaAnalisisFodaMapper;
    @Autowired
    private AnalisisFodaService analisisFodaService;

    @PostMapping
    public ResponseEntity<TablaAnalisisFodaDTO> createTablaAnalisisFoda(@RequestBody TablaAnalisisFodaDTO tablaAnalisisFodaDTO) {
        // Obtener la entidad AnalisisFoda por el ID
        AnalisisFoda analisisFoda = analisisFodaService.findById(tablaAnalisisFodaDTO.getIdAnalisisFoda());

        if (analisisFoda == null) {
            return ResponseEntity.badRequest().build(); // Si no existe, devuelve un error 400
        }

        // Mapear el DTO a la entidad
        TablaAnalisisFoda tablaAnalisisFoda = tablaAnalisisFodaMapper.toEntity(tablaAnalisisFodaDTO, analisisFoda);

        // Guardar la entidad
        TablaAnalisisFoda savedTabla = tablaAnalisisFodaService.save(tablaAnalisisFoda);

        // Convertir la entidad guardada en DTO para la respuesta
        TablaAnalisisFodaDTO savedDTO = tablaAnalisisFodaMapper.toDTO(savedTabla);
        return ResponseEntity.ok(savedDTO);
    }

    @GetMapping
    public List<TablaAnalisisFodaDTO> getAllTablaAnalisisFoda() {
        List<TablaAnalisisFoda> tablas = tablaAnalisisFodaService.findAll();
        return tablas.stream()
                .map(tablaAnalisisFodaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/analisisFoda/{idAnalisisFoda}")
    public List<TablaAnalisisFodaDTO> getTablaAnalisisFodaByAnalisisFodaId(@PathVariable Long idAnalisisFoda) {
        List<TablaAnalisisFoda> tablas = tablaAnalisisFodaService.findByAnalisisFodaId(idAnalisisFoda);
        return tablas.stream()
                .map(tablaAnalisisFodaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TablaAnalisisFodaDTO> getTablaAnalisisFodaById(@PathVariable Long id) {
        TablaAnalisisFoda tabla = tablaAnalisisFodaService.findById(id);
        if (tabla == null) {
            return ResponseEntity.notFound().build();
        }
        TablaAnalisisFodaDTO dto = tablaAnalisisFodaMapper.toDTO(tabla);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TablaAnalisisFodaDTO> updateTablaAnalisisFoda(@PathVariable Long id, @RequestBody TablaAnalisisFodaDTO tablaAnalisisFodaDTO) {
        // Buscar la tabla existente
        TablaAnalisisFoda existingTabla = tablaAnalisisFodaService.findById(id);
        if (existingTabla == null) {
            return ResponseEntity.notFound().build();
        }

        // Buscar la entidad AnalisisFoda por el ID
        AnalisisFoda analisisFoda = analisisFodaService.findById(tablaAnalisisFodaDTO.getIdAnalisisFoda());
        if (analisisFoda == null) {
            return ResponseEntity.badRequest().build();
        }

        // Actualizar los campos de la tabla
        existingTabla.setDepartamento(tablaAnalisisFodaDTO.getDepartamento());
        existingTabla.setFortalezas(tablaAnalisisFodaDTO.getFortalezas());
        existingTabla.setOportunidades(tablaAnalisisFodaDTO.getOportunidades());
        existingTabla.setDebilidades(tablaAnalisisFodaDTO.getDebilidades());
        existingTabla.setAmanezas(tablaAnalisisFodaDTO.getAmanezas());
        existingTabla.setAnalisisFoda(analisisFoda);

        // Guardar los cambios
        TablaAnalisisFoda updatedTabla = tablaAnalisisFodaService.update(id, existingTabla);

        // Convertir la entidad actualizada a DTO para devolverla
        TablaAnalisisFodaDTO updatedDTO = tablaAnalisisFodaMapper.toDTO(updatedTabla);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTablaAnalisisFoda(@PathVariable Long id) {
        tablaAnalisisFodaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}


