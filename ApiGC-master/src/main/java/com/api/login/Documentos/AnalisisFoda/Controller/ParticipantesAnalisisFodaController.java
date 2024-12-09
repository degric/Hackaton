package com.api.login.Documentos.AnalisisFoda.Controller;

import com.api.login.Documentos.AnalisisFoda.DTO.ParticipantesAnalisisFodaDTO;
import com.api.login.Documentos.AnalisisFoda.Mapper.ParticipantesAnalisisFodaMapper;
import com.api.login.Documentos.AnalisisFoda.Pojo.AnalisisFoda;
import com.api.login.Documentos.AnalisisFoda.Pojo.ParticipantesAnalisisFoda;
import com.api.login.Documentos.AnalisisFoda.Service.AnalisisFodaService;
import com.api.login.Documentos.AnalisisFoda.Service.ParticipantesAnalisisFodaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/participantesAnalisisFoda")
public class ParticipantesAnalisisFodaController {

    @Autowired
    private ParticipantesAnalisisFodaService participantesAnalisisFodaService;

    @Autowired
    private ParticipantesAnalisisFodaMapper participantesAnalisisFodaMapper;

    @Autowired
    private AnalisisFodaService analisisFodaService;

    @PostMapping
    public ResponseEntity<ParticipantesAnalisisFodaDTO> createParticipanteAnalisisFoda(@RequestBody ParticipantesAnalisisFodaDTO participantesAnalisisFodaDTO) {
        // Obtener la entidad AnalisisFoda por el ID
        AnalisisFoda analisisFoda = analisisFodaService.findById(participantesAnalisisFodaDTO.getIdAnalisisFoda());

        if (analisisFoda == null) {
            return ResponseEntity.badRequest().build(); // Si no existe, devuelve un error 400
        }

        // Mapear el DTO a la entidad
        ParticipantesAnalisisFoda participante = participantesAnalisisFodaMapper.toEntity(participantesAnalisisFodaDTO, analisisFoda);

        // Guardar la entidad
        ParticipantesAnalisisFoda savedParticipante = participantesAnalisisFodaService.save(participante);

        // Convertir la entidad guardada en DTO para la respuesta
        ParticipantesAnalisisFodaDTO savedDTO = participantesAnalisisFodaMapper.toDTO(savedParticipante);
        return ResponseEntity.ok(savedDTO);
    }

    @GetMapping
    public List<ParticipantesAnalisisFodaDTO> getAllParticipantesAnalisisFoda() {
        List<ParticipantesAnalisisFoda> participantes = participantesAnalisisFodaService.findAll();
        return participantes.stream()
                .map(participantesAnalisisFodaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/analisisFoda/{idAnalisisFoda}")
    public List<ParticipantesAnalisisFodaDTO> getParticipantesByAnalisisFodaId(@PathVariable Long idAnalisisFoda) {
        List<ParticipantesAnalisisFoda> participantes = participantesAnalisisFodaService.findByAnalisisFodaId(idAnalisisFoda);
        return participantes.stream()
                .map(participantesAnalisisFodaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParticipantesAnalisisFodaDTO> getParticipanteAnalisisFodaById(@PathVariable Long id) {
        ParticipantesAnalisisFoda participante = participantesAnalisisFodaService.findById(id);
        if (participante == null) {
            return ResponseEntity.notFound().build();
        }
        ParticipantesAnalisisFodaDTO dto = participantesAnalisisFodaMapper.toDTO(participante);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParticipantesAnalisisFodaDTO> updateParticipanteAnalisisFoda(@PathVariable Long id, @RequestBody ParticipantesAnalisisFodaDTO participantesAnalisisFodaDTO) {
        // Buscar el participante existente
        ParticipantesAnalisisFoda existingParticipante = participantesAnalisisFodaService.findById(id);
        if (existingParticipante == null) {
            return ResponseEntity.notFound().build();
        }

        // Buscar la entidad AnalisisFoda por el ID
        AnalisisFoda analisisFoda = analisisFodaService.findById(participantesAnalisisFodaDTO.getIdAnalisisFoda());
        if (analisisFoda == null) {
            return ResponseEntity.badRequest().build();
        }

        // Actualizar los campos del participante
        existingParticipante.setNombre(participantesAnalisisFodaDTO.getNombre());
        existingParticipante.setPuesto(participantesAnalisisFodaDTO.getPuesto());
        existingParticipante.setAnalisisFoda(analisisFoda);

        // Guardar los cambios
        ParticipantesAnalisisFoda updatedParticipante = participantesAnalisisFodaService.update(id, existingParticipante);

        // Convertir la entidad actualizada a DTO para devolverla
        ParticipantesAnalisisFodaDTO updatedDTO = participantesAnalisisFodaMapper.toDTO(updatedParticipante);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParticipanteAnalisisFoda(@PathVariable Long id) {
        participantesAnalisisFodaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

