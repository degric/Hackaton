package com.api.login.Documentos.BalanceScoreCard.Controller;

import com.api.login.Documentos.BalanceScoreCard.DTO.BalanceScoreCardDTO;
import com.api.login.Documentos.BalanceScoreCard.Service.BalanceScoreCardService;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/balanceScoreCard")
public class BalanceScoreCardController {

    @Autowired
    private BalanceScoreCardService balanceScoreCardService;

    @GetMapping
    public List<BalanceScoreCardDTO> getAllBalanceScoreCards() {
        return balanceScoreCardService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BalanceScoreCardDTO> getBalanceScoreCardById(@PathVariable Long id) {
        BalanceScoreCardDTO dto = balanceScoreCardService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<BalanceScoreCardDTO> createBalanceScoreCard(@RequestBody BalanceScoreCardDTO balanceScoreCardDTO) {
        BalanceScoreCardDTO savedDTO = balanceScoreCardService.save(balanceScoreCardDTO);
        return ResponseEntity.ok(savedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BalanceScoreCardDTO> updateBalanceScoreCard(@PathVariable Long id, @RequestBody BalanceScoreCardDTO balanceScoreCardDTO) {
        BalanceScoreCardDTO updatedDTO = balanceScoreCardService.update(id, balanceScoreCardDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBalanceScoreCard(@PathVariable Long id) {
        balanceScoreCardService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/reporte/pdf/{id}")
    public ResponseEntity<byte[]> descargarReportePdf(@PathVariable Long id) {
        try {
            byte[] pdfContents = balanceScoreCardService.generarBSCPdf(id);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDisposition(ContentDisposition.builder("attachment")
                    .filename("BalanceScoreCard.pdf")
                    .build());

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(pdfContents);
        } catch (DocumentException e) {
            // Manejo de excepciones
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

