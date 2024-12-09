package com.api.login.Documentos.DocumentoElaborarProcesos;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Importaciones adicionales si son necesarias
import java.io.ByteArrayOutputStream;

@RestController
public class PdfController {

    @GetMapping("/pdf")
    public ResponseEntity<byte[]> generarPdf() throws DocumentException {
        // Crear un documento PDF
        Document document = new Document();

        // Crear un stream en memoria para el PDF
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        // Obtener el escritor de PDF
        PdfWriter.getInstance(document, baos);

        // Abrir el documento para escribir
        document.open();

        // Agregar contenido al documento
        document.add(new Paragraph("¡Hola, mundo! Este es un PDF generado con OpenPDF en Spring Boot."));

        document.add(new Paragraph("hola como estas"));

        PdfPTable tabla = new PdfPTable(3);

        tabla.addCell("encabezado 1");
        tabla.addCell("encabezado 2");
        tabla.addCell("encabezado 3");

        for (int i = 0 ; i<9; i++){
            tabla.addCell("celda " + (i+1));
        }

        document.add(tabla);

        // Cerrar el documento
        document.close();

        // Configurar los headers de la respuesta
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("filename", "ejemplo.pdf");

        // Retornar el PDF como arreglo de bytes
        return ResponseEntity.ok()
                .headers(headers)
                .body(baos.toByteArray());
    }
}
