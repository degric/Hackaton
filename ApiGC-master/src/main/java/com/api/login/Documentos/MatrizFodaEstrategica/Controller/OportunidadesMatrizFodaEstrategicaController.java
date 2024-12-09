package com.api.login.Documentos.MatrizFodaEstrategica.Controller;

import com.api.login.Documentos.MatrizFodaEstrategica.DTO.OportunidadesMatrizFodaEstrategicaDTO;
import com.api.login.Documentos.MatrizFodaEstrategica.Mapper.OportunidadesMatrizFodaEstrategicaMapper;
import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.MatrizFodaEstrategica;
import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.OportunidadesMatrizFodaEstrategica;
import com.api.login.Documentos.MatrizFodaEstrategica.Service.MatrizFodaEstrategicaService;
import com.api.login.Documentos.MatrizFodaEstrategica.Service.OportunidadesMatrizFodaEstrategicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/oportunidadesMatrizFodaEstrategica")
public class OportunidadesMatrizFodaEstrategicaController {

    @Autowired
    private OportunidadesMatrizFodaEstrategicaService oportunidadesService;

    @Autowired
    private OportunidadesMatrizFodaEstrategicaMapper oportunidadesMapper;

    @Autowired
    private MatrizFodaEstrategicaService matrizFodaEstrategicaService;

    @PostMapping
    public ResponseEntity<OportunidadesMatrizFodaEstrategicaDTO> createOportunidad(@RequestBody OportunidadesMatrizFodaEstrategicaDTO oportunidadesDTO) {
        // Obtener la entidad MatrizFodaEstrategica por el ID
        MatrizFodaEstrategica matrizFodaEstrategica = matrizFodaEstrategicaService.findById(oportunidadesDTO.getIdMatrizFodaEstrategica());

        if (matrizFodaEstrategica == null) {
            return ResponseEntity.badRequest().build(); // Si no existe, devuelve un error 400
        }

        // Mapear el DTO a la entidad
        OportunidadesMatrizFodaEstrategica oportunidad = oportunidadesMapper.toEntity(oportunidadesDTO, matrizFodaEstrategica);

        // Guardar la entidad
        OportunidadesMatrizFodaEstrategica savedOportunidad = oportunidadesService.save(oportunidad);

        // Convertir la entidad guardada en DTO para la respuesta
        OportunidadesMatrizFodaEstrategicaDTO savedDTO = oportunidadesMapper.toDTO(savedOportunidad);
        return ResponseEntity.ok(savedDTO);
    }

    @GetMapping
    public List<OportunidadesMatrizFodaEstrategicaDTO> getAllOportunidades() {
        List<OportunidadesMatrizFodaEstrategica> oportunidades = oportunidadesService.findAll();
        return oportunidades.stream()
                .map(oportunidadesMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/matriz/{idMatrizFodaEstrategica}")
    public List<OportunidadesMatrizFodaEstrategicaDTO> getOportunidadesByMatrizId(@PathVariable Long idMatrizFodaEstrategica) {
        List<OportunidadesMatrizFodaEstrategica> oportunidades = oportunidadesService.findByMatrizFodaEstrategicaId(idMatrizFodaEstrategica);
        return oportunidades.stream()
                .map(oportunidadesMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OportunidadesMatrizFodaEstrategicaDTO> getOportunidadById(@PathVariable Long id) {
        OportunidadesMatrizFodaEstrategica oportunidad = oportunidadesService.findById(id);
        if (oportunidad == null) {
            return ResponseEntity.notFound().build();
        }
        OportunidadesMatrizFodaEstrategicaDTO dto = oportunidadesMapper.toDTO(oportunidad);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OportunidadesMatrizFodaEstrategicaDTO> updateOportunidad(@PathVariable Long id, @RequestBody OportunidadesMatrizFodaEstrategicaDTO oportunidadesDTO) {
        // Buscar la oportunidad existente
        OportunidadesMatrizFodaEstrategica existingOportunidad = oportunidadesService.findById(id);
        if (existingOportunidad == null) {
            return ResponseEntity.notFound().build();
        }

        // Buscar la entidad MatrizFodaEstrategica por el ID
        MatrizFodaEstrategica matrizFodaEstrategica = matrizFodaEstrategicaService.findById(oportunidadesDTO.getIdMatrizFodaEstrategica());
        if (matrizFodaEstrategica == null) {
            return ResponseEntity.badRequest().build();
        }

        // Actualizar los campos de la oportunidad
        existingOportunidad.setContenido(oportunidadesDTO.getContenido());
        existingOportunidad.setMatrizFodaEstrategica(matrizFodaEstrategica);

        // Guardar los cambios
        OportunidadesMatrizFodaEstrategica updatedOportunidad = oportunidadesService.update(id, existingOportunidad);

        // Convertir la entidad actualizada a DTO para devolverla
        OportunidadesMatrizFodaEstrategicaDTO updatedDTO = oportunidadesMapper.toDTO(updatedOportunidad);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOportunidad(@PathVariable Long id) {
        oportunidadesService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

