package com.api.login.FilosofiaOrganizacional.Controller;

import com.api.login.FilosofiaOrganizacional.DTO.VisionDTO;
import com.api.login.FilosofiaOrganizacional.pojo.Vision;
import com.api.login.FilosofiaOrganizacional.Service.VisionService;
import com.api.login.FilosofiaOrganizacional.Mapper.VisionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/vision")
public class VisionController {

    @Autowired
    private VisionService visionService;

    @Autowired
    private VisionMapper visionMapper;

    @GetMapping
    public List<VisionDTO> getAllVision() {
        List<Vision> visiones = visionService.findAll();
        return visiones.stream().map(visionMapper::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisionDTO> getVisionById(@PathVariable Integer id) {
        Vision vision = visionService.findById(id);
        if (vision == null) {
            return ResponseEntity.notFound().build();
        }
        VisionDTO dto = visionMapper.toDTO(vision);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/fecha/{fecha}")
    public List<VisionDTO> getVisionByFecha(@PathVariable String fecha) {
        LocalDate localDate = LocalDate.parse(fecha);
        List<Vision> visiones = visionService.findByFecha(localDate);
        return visiones.stream().map(visionMapper::toDTO).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<VisionDTO> createVision(@Validated @RequestBody VisionDTO visionDTO) {
        Vision vision = visionMapper.toEntity(visionDTO);
        Vision savedVision = visionService.save(vision);
        VisionDTO dto = visionMapper.toDTO(savedVision);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VisionDTO> updateVision(@PathVariable Integer id, @Validated @RequestBody VisionDTO visionDTO) {
        Vision vision = visionService.findById(id);
        if (vision == null) {
            return ResponseEntity.notFound().build();
        }
        vision = visionMapper.toEntity(visionDTO);
        vision.setIdVision(id); // Ensure the ID remains unchanged
        Vision updatedVision = visionService.update(id, vision);
        VisionDTO dto = visionMapper.toDTO(updatedVision);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVision(@PathVariable Integer id) {
        visionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

