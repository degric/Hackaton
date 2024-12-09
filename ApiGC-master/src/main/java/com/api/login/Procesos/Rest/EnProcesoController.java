package com.api.login.Procesos.Rest;

import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.DTO.DetecionNeCaDNCDTO;
import com.api.login.Procesos.DTO.EnProcesoDTO;
import com.api.login.Procesos.DTO.EnProcesoDTOSinListas;
import com.api.login.Procesos.Service.EnProcesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/enproceso")
public class EnProcesoController {

    @Autowired
    private EnProcesoService service;


    @GetMapping
    public ResponseEntity<List<EnProcesoDTO>> listarEnProcesoentity(){
        List<EnProcesoDTO> DTOS = service.getAllEnProcesoEntity();
        return new ResponseEntity<>(DTOS, HttpStatus.OK);
    }
    @GetMapping("/paguinacion")
    public ResponseEntity<Page<EnProcesoDTO>> paginarEnProcesoentity(@RequestParam(required = false, defaultValue = "0")Integer pageNumber,
                                                                     @RequestParam(required = false, defaultValue = "5")Integer pageSize){

        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        Page<EnProcesoDTO> DTOS = service.listaPagina(pageable);
        return ResponseEntity.ok(DTOS);
    }

    @GetMapping("/entity")
    public ResponseEntity<Page<EnProcesoDTOSinListas>> listarEnProceso(@RequestParam(required = false, defaultValue = "0")Integer pageNumber,
                                                                       @RequestParam(required = false, defaultValue = "5")Integer pageSize){
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<EnProcesoDTOSinListas> DTOS = service.getAllEnProceso(pageable);
        return ResponseEntity.ok(DTOS);
    }

    @GetMapping("/titulo/{nombre}")
    public ResponseEntity<List<EnProcesoDTO>> listarEnProcesoPornombre(@PathVariable String nombre){
        List<EnProcesoDTO> DTOS = service.findbynombre(nombre);
        return new ResponseEntity<>(DTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnProcesoDTO> ListarPorId(@PathVariable Long id){
        return service.getByIdEnProceso(id)
                .map(enProcesoDTO -> new ResponseEntity<>(enProcesoDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<EnProcesoDTO> guardar(@RequestBody EnProcesoDTO dto){
        EnProcesoDTO createDTO = service.createEnProceso(dto);
        return new ResponseEntity<>(createDTO,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnProcesoDTO>actualizar(@PathVariable Long id, @RequestBody EnProcesoDTO dto){
        EnProcesoDTO update = service.updateEnProceso(id, dto);
        if (update != null){
            return new ResponseEntity<>(update, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        service.deleteEnProceso(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
