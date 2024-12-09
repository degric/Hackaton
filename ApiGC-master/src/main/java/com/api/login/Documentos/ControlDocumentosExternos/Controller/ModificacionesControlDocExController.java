package com.api.login.Documentos.ControlDocumentosExternos.Controller;

import com.api.login.Documentos.ControlDocumentosExternos.DTO.ModificacionesControlDocExDTO;
import com.api.login.Documentos.ControlDocumentosExternos.Mapper.ModificacionesControlDocExMapper;
import com.api.login.Documentos.ControlDocumentosExternos.Pojo.ControlDocumentosExternos;
import com.api.login.Documentos.ControlDocumentosExternos.Pojo.ModificacionesControlDocEx;
import com.api.login.Documentos.ControlDocumentosExternos.Service.ControlDocumentosExternosService;
import com.api.login.Documentos.ControlDocumentosExternos.Service.ModificacionesControlDocExService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/modificacionesControlDocEx")
public class ModificacionesControlDocExController {

    @Autowired
    private ModificacionesControlDocExService modificacionesControlDocExService;

    @Autowired
    private ModificacionesControlDocExMapper modificacionesControlDocExMapper;

    @Autowired
    private ControlDocumentosExternosService controlDocumentosExternosService;

    @PostMapping
    public ResponseEntity<ModificacionesControlDocExDTO> createModificacionControlDocEx(@RequestBody ModificacionesControlDocExDTO modificacionesControlDocExDTO) {
        // Obtener la entidad ControlDocumentosExternos por el ID
        ControlDocumentosExternos controlDocumentosExternos = controlDocumentosExternosService.findById(modificacionesControlDocExDTO.getIdControlDocumentosExternos());

        if (controlDocumentosExternos == null) {
            return ResponseEntity.badRequest().build(); // Si no existe, devuelve un error 400
        }

        // Mapear el DTO a la entidad
        ModificacionesControlDocEx modificacionesControlDocEx = modificacionesControlDocExMapper.toEntity(modificacionesControlDocExDTO, controlDocumentosExternos);

        // Guardar la entidad
        ModificacionesControlDocEx savedModificacionesControlDocEx = modificacionesControlDocExService.save(modificacionesControlDocEx);

        // Convertir la entidad guardada en DTO para la respuesta
        ModificacionesControlDocExDTO savedDTO = modificacionesControlDocExMapper.toDTO(savedModificacionesControlDocEx);
        return ResponseEntity.ok(savedDTO);
    }

    @GetMapping
    public List<ModificacionesControlDocExDTO> getAllModificaciones() {
        List<ModificacionesControlDocEx> modificaciones = modificacionesControlDocExService.findAll();
        return modificaciones.stream()
                .map(modificacionesControlDocExMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/encabezado/{id}")
    public List<ModificacionesControlDocExDTO> getAllModificacionesByEncabezado(@PathVariable Long id) {
        List<ModificacionesControlDocEx> modificaciones = modificacionesControlDocExService.findByEncabezado(id);
        return modificaciones.stream()
                .map(modificacionesControlDocExMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModificacionesControlDocExDTO> getModificacionById(@PathVariable Long id) {
        ModificacionesControlDocEx modificacionesControlDocEx = modificacionesControlDocExService.findById(id);
        if (modificacionesControlDocEx == null) {
            return ResponseEntity.notFound().build();
        }
        ModificacionesControlDocExDTO dto = modificacionesControlDocExMapper.toDTO(modificacionesControlDocEx);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModificacionesControlDocExDTO> updateModificacionControlDocEx(@PathVariable Long id, @RequestBody ModificacionesControlDocExDTO modificacionesControlDocExDTO) {
        // Buscar la modificación existente
        ModificacionesControlDocEx existingModificacionesControlDocEx = modificacionesControlDocExService.findById(id);
        if (existingModificacionesControlDocEx == null) {
            return ResponseEntity.notFound().build();
        }

        // Buscar la entidad ControlDocumentosExternos por el ID
        ControlDocumentosExternos controlDocumentosExternos = controlDocumentosExternosService.findById(modificacionesControlDocExDTO.getIdControlDocumentosExternos());
        if (controlDocumentosExternos == null) {
            return ResponseEntity.badRequest().build();
        }

        // Actualizar los campos de la modificación
        existingModificacionesControlDocEx.setFechaCambio(modificacionesControlDocExDTO.getFechaCambio());
        existingModificacionesControlDocEx.setEdRev(modificacionesControlDocExDTO.getEdRev());
        existingModificacionesControlDocEx.setCambiosRealizadosVerAn(modificacionesControlDocExDTO.getCambiosRealizadosVerAn());
        existingModificacionesControlDocEx.setControlDocumentosExternos(controlDocumentosExternos);

        // Guardar los cambios
        ModificacionesControlDocEx updatedModificacionesControlDocEx = modificacionesControlDocExService.update(id, existingModificacionesControlDocEx);

        // Convertir la entidad actualizada a DTO para devolverla
        ModificacionesControlDocExDTO updatedDTO = modificacionesControlDocExMapper.toDTO(updatedModificacionesControlDocEx);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModificacionControlDocEx(@PathVariable Long id) {
        modificacionesControlDocExService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}