package com.api.login.Documentos.ControlDocumentosExternos.Controller;

import com.api.login.Documentos.ControlDocumentosExternos.DTO.TablaControlDocumentosExternosDTO;
import com.api.login.Documentos.ControlDocumentosExternos.Mapper.TablaControlDocumentosExternosMapper;
import com.api.login.Documentos.ControlDocumentosExternos.Pojo.ControlDocumentosExternos;
import com.api.login.Documentos.ControlDocumentosExternos.Pojo.TablaControlDocumentosExternos;
import com.api.login.Documentos.ControlDocumentosExternos.Service.ControlDocumentosExternosService;
import com.api.login.Documentos.ControlDocumentosExternos.Service.TablaControlDocumentosExternosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tablaControlDocumentosExternos")
public class TablaControlDocumentosExternosController {

    @Autowired
    private TablaControlDocumentosExternosService tablaControlDocumentosExternosService;

    @Autowired
    private TablaControlDocumentosExternosMapper tablaControlDocumentosExternosMapper;

    @Autowired
    private ControlDocumentosExternosService controlDocumentosExternosService;

    @GetMapping
    public List<TablaControlDocumentosExternosDTO> getAllTablasControlDocumentosExternos() {
        List<TablaControlDocumentosExternos> tablas = tablaControlDocumentosExternosService.findAll();
        return tablas.stream()
                .map(tablaControlDocumentosExternosMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TablaControlDocumentosExternosDTO> getTablaControlDocumentosExternosById(@PathVariable Long id) {
        TablaControlDocumentosExternos tabla = tablaControlDocumentosExternosService.findById(id);
        if (tabla == null) {
            return ResponseEntity.notFound().build();
        }
        TablaControlDocumentosExternosDTO dto = tablaControlDocumentosExternosMapper.toDTO(tabla);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<TablaControlDocumentosExternosDTO> createTablaControlDocumentosExternos(@RequestBody TablaControlDocumentosExternosDTO tablaControlDocumentosExternosDTO) {
        // Obtener el registro de ControlDocumentosExternos usando el ID proporcionado en el DTO
        ControlDocumentosExternos controlDocumentosExternos = controlDocumentosExternosService.findById(tablaControlDocumentosExternosDTO.getIdControlDocumentosExternos());

        if (controlDocumentosExternos == null) {
            return ResponseEntity.badRequest().build(); // Si el controlDocumentosExternos no existe, devolvemos un error
        }

        // Asignar la relación ControlDocumentosExternos
        TablaControlDocumentosExternos tablaControlDocumentosExternos = tablaControlDocumentosExternosMapper.toEntity(tablaControlDocumentosExternosDTO, controlDocumentosExternos);

        // Guardar el registro
        TablaControlDocumentosExternos savedTabla = tablaControlDocumentosExternosService.save(tablaControlDocumentosExternos);

        // Convertir a DTO para devolver
        TablaControlDocumentosExternosDTO dto = tablaControlDocumentosExternosMapper.toDTO(savedTabla);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TablaControlDocumentosExternosDTO> updateTablaControlDocumentosExternos(@PathVariable Long id, @RequestBody TablaControlDocumentosExternosDTO tablaControlDocumentosExternosDTO) {
        TablaControlDocumentosExternos tabla = tablaControlDocumentosExternosService.findById(id);
        if (tabla == null) {
            return ResponseEntity.notFound().build();
        }
        tabla = tablaControlDocumentosExternosMapper.toEntity(tablaControlDocumentosExternosDTO, tabla.getControlDocumentosExternos());
        tabla.setIdTablaControlDocumentosExternos(id);
        TablaControlDocumentosExternos updatedTabla = tablaControlDocumentosExternosService.update(id, tabla);
        TablaControlDocumentosExternosDTO dto = tablaControlDocumentosExternosMapper.toDTO(updatedTabla);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTablaControlDocumentosExternos(@PathVariable Long id) {
        tablaControlDocumentosExternosService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/encabezado/{id}")
    public List<TablaControlDocumentosExternosDTO> getTablasControlDocumentosExternosByEncabezado(@PathVariable Long id) {
        List<TablaControlDocumentosExternos> tablas = tablaControlDocumentosExternosService.findByEncabezado(id);
        return tablas.stream()
                .map(tablaControlDocumentosExternosMapper::toDTO)
                .collect(Collectors.toList());
    }
}
