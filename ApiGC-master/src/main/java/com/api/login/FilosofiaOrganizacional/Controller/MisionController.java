package com.api.login.FilosofiaOrganizacional.Controller;

import com.api.login.FilosofiaOrganizacional.DTO.MisionDTO;
import com.api.login.FilosofiaOrganizacional.pojo.Mision;
import com.api.login.FilosofiaOrganizacional.Service.MisionService;
import com.api.login.FilosofiaOrganizacional.Mapper.MisionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/mision")
public class MisionController {

    @Autowired
    private MisionService misionService;

    @Autowired
    private MisionMapper misionMapper;

    @GetMapping
    public List<MisionDTO> getAllMision() {
        List<Mision> misiones = misionService.findAll();
        return misiones.stream().map(misionMapper::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MisionDTO> getMisionById(@PathVariable Integer id) {
        Mision mision = misionService.findById(id);
        if (mision == null) {
            return ResponseEntity.notFound().build();
        }
        MisionDTO dto = misionMapper.toDTO(mision);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/fecha/{fecha}")
    public List<MisionDTO> getMisionesByFecha(@PathVariable String fecha) {
        LocalDate localDate = LocalDate.parse(fecha);
        List<Mision> misiones = misionService.findByFecha(localDate);
        return misiones.stream().map(misionMapper::toDTO).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<MisionDTO> createMision(@Validated @RequestBody MisionDTO misionDTO) {
        Mision mision = misionMapper.toEntity(misionDTO);
        Mision savedMision = misionService.save(mision);
        MisionDTO dto = misionMapper.toDTO(savedMision);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MisionDTO> updateMision(@PathVariable Integer id, @Validated @RequestBody MisionDTO misionDTO) {
        Mision mision = misionService.findById(id);
        if (mision == null) {
            return ResponseEntity.notFound().build();
        }
        mision = misionMapper.toEntity(misionDTO);
        mision.setIdMision(id); // Ensure the ID remains unchanged
        Mision updatedMision = misionService.update(id, mision);
        MisionDTO dto = misionMapper.toDTO(updatedMision);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMision(@PathVariable Integer id) {
        misionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

