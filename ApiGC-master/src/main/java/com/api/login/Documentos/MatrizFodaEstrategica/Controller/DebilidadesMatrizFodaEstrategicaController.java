package com.api.login.Documentos.MatrizFodaEstrategica.Controller;

import com.api.login.Documentos.MatrizFodaEstrategica.DTO.DebilidadesMatrizFodaEstrategicaDTO;
import com.api.login.Documentos.MatrizFodaEstrategica.Mapper.DebilidadesMatrizFodaEstrategicaMapper;
import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.DebilidadesMatrizFodaEstrategica;
import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.MatrizFodaEstrategica;
import com.api.login.Documentos.MatrizFodaEstrategica.Service.DebilidadesMatrizFodaEstrategicaService;
import com.api.login.Documentos.MatrizFodaEstrategica.Service.MatrizFodaEstrategicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/debilidadesMatrizFodaEstrategica")
public class DebilidadesMatrizFodaEstrategicaController {

    @Autowired
    private DebilidadesMatrizFodaEstrategicaService debilidadesService;

    @Autowired
    private DebilidadesMatrizFodaEstrategicaMapper debilidadesMapper;

    @Autowired
    private MatrizFodaEstrategicaService matrizFodaEstrategicaService;

    @PostMapping
    public ResponseEntity<DebilidadesMatrizFodaEstrategicaDTO> createDebilidad(@RequestBody DebilidadesMatrizFodaEstrategicaDTO debilidadesDTO) {
        // Obtener la entidad MatrizFodaEstrategica por el ID
        MatrizFodaEstrategica matrizFodaEstrategica = matrizFodaEstrategicaService.findById(debilidadesDTO.getIdMatrizFodaEstrategica());

        if (matrizFodaEstrategica == null) {
            return ResponseEntity.badRequest().build(); // Si no existe, devuelve un error 400
        }

        // Mapear el DTO a la entidad
        DebilidadesMatrizFodaEstrategica debilidad = debilidadesMapper.toEntity(debilidadesDTO, matrizFodaEstrategica);

        // Guardar la entidad
        DebilidadesMatrizFodaEstrategica savedDebilidad = debilidadesService.save(debilidad);

        // Convertir la entidad guardada en DTO para la respuesta
        DebilidadesMatrizFodaEstrategicaDTO savedDTO = debilidadesMapper.toDTO(savedDebilidad);
        return ResponseEntity.ok(savedDTO);
    }

    @GetMapping
    public List<DebilidadesMatrizFodaEstrategicaDTO> getAllDebilidades() {
        List<DebilidadesMatrizFodaEstrategica> debilidades = debilidadesService.findAll();
        return debilidades.stream()
                .map(debilidadesMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/matriz/{idMatrizFodaEstrategica}")
    public List<DebilidadesMatrizFodaEstrategicaDTO> getDebilidadesByMatrizId(@PathVariable Long idMatrizFodaEstrategica) {
        List<DebilidadesMatrizFodaEstrategica> debilidades = debilidadesService.findByMatrizFodaEstrategicaId(idMatrizFodaEstrategica);
        return debilidades.stream()
                .map(debilidadesMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DebilidadesMatrizFodaEstrategicaDTO> getDebilidadById(@PathVariable Long id) {
        DebilidadesMatrizFodaEstrategica debilidad = debilidadesService.findById(id);
        if (debilidad == null) {
            return ResponseEntity.notFound().build();
        }
        DebilidadesMatrizFodaEstrategicaDTO dto = debilidadesMapper.toDTO(debilidad);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DebilidadesMatrizFodaEstrategicaDTO> updateDebilidad(@PathVariable Long id, @RequestBody DebilidadesMatrizFodaEstrategicaDTO debilidadesDTO) {
        // Buscar la debilidad existente
        DebilidadesMatrizFodaEstrategica existingDebilidad = debilidadesService.findById(id);
        if (existingDebilidad == null) {
            return ResponseEntity.notFound().build();
        }

        // Buscar la entidad MatrizFodaEstrategica por el ID
        MatrizFodaEstrategica matrizFodaEstrategica = matrizFodaEstrategicaService.findById(debilidadesDTO.getIdMatrizFodaEstrategica());
        if (matrizFodaEstrategica == null) {
            return ResponseEntity.badRequest().build();
        }

        // Actualizar los campos de la debilidad
        existingDebilidad.setContenido(debilidadesDTO.getContenido());
        existingDebilidad.setMatrizFodaEstrategica(matrizFodaEstrategica);

        // Guardar los cambios
        DebilidadesMatrizFodaEstrategica updatedDebilidad = debilidadesService.update(id, existingDebilidad);

        // Convertir la entidad actualizada a DTO para devolverla
        DebilidadesMatrizFodaEstrategicaDTO updatedDTO = debilidadesMapper.toDTO(updatedDebilidad);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDebilidad(@PathVariable Long id) {
        debilidadesService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
