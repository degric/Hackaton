package com.api.login.Documentos.ControlDocumentosExternos.Service.Impl;

import com.api.login.Documentos.ControlDocumentosExternos.DTO.ControlDocumentosExternosDTO;
import com.api.login.Documentos.ControlDocumentosExternos.DTO.ControlDocumentosExternosDTOSinListas;
import com.api.login.Documentos.ControlDocumentosExternos.DTO.TablaControlDocumentosExternosDTO;
import com.api.login.Documentos.ControlDocumentosExternos.Mapper.ControlDocumentosExternosMapper;
import com.api.login.Documentos.ControlDocumentosExternos.Pojo.ControlDocumentosExternos;
import com.api.login.Documentos.ControlDocumentosExternos.Pojo.ModificacionesControlDocEx;
import com.api.login.Documentos.ControlDocumentosExternos.Pojo.TablaControlDocumentosExternos;
import com.api.login.Documentos.ControlDocumentosExternos.Repository.ControlDocumentosExternosRepository;
import com.api.login.Documentos.ControlDocumentosExternos.Service.ControlDocumentosExternosService;
import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.DTO.LDDDescricionDocumentoDTO;
import com.api.login.Documentos.SeguimientoAAccionesDeMejoraCorrectivasYPreventivas.Service.Impl.HeaderFooterPageEventSeguiAcc;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ControlDocumentosExternosServiceImpl implements ControlDocumentosExternosService {

    @Autowired
    private ControlDocumentosExternosRepository controlDocumentosExternosRepository;

    @Autowired
    private ControlDocumentosExternosMapper controlDocumentosExternosMapper;

    @Override
    public List<ControlDocumentosExternos> findAll() {
        return controlDocumentosExternosRepository.findAll();
    }

    @Override
    public ControlDocumentosExternos findById(Long id) {
        Optional<ControlDocumentosExternos> optional = controlDocumentosExternosRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public ControlDocumentosExternos save(ControlDocumentosExternos controlDocumentosExternos) {
        return controlDocumentosExternosRepository.save(controlDocumentosExternos);
    }

    @Override
    public ControlDocumentosExternos update(Long id, ControlDocumentosExternosDTOSinListas controlDocumentosExternosDTO) {
        ControlDocumentosExternos existingControlDocumentosExternos = controlDocumentosExternosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ControlDocumentosExternos not found"));

        // Actualizar solo los campos de la entidad principal sin afectar las tablas relacionadas
        existingControlDocumentosExternos.setCoDocumento(controlDocumentosExternosDTO.getCoDocumento());
        existingControlDocumentosExternos.setNoRevision(controlDocumentosExternosDTO.getNoRevision());
        existingControlDocumentosExternos.setFechaEmicion(controlDocumentosExternosDTO.getFechaEmicion());
        existingControlDocumentosExternos.setFechaRevision(controlDocumentosExternosDTO.getFechaRevision());
        existingControlDocumentosExternos.setArea(controlDocumentosExternosDTO.getArea());
        existingControlDocumentosExternos.setSeccion(controlDocumentosExternosDTO.getSeccion());
        existingControlDocumentosExternos.setFecha(controlDocumentosExternosDTO.getFecha());

        // Mantener la lista de tablas relacionada intacta, ya que no se actualiza en este caso
        return controlDocumentosExternosRepository.save(existingControlDocumentosExternos);
    }

    @Override
    public void deleteById(Long id) {
        controlDocumentosExternosRepository.deleteById(id);
    }

    @Override
    public byte[] generarReportePdf(Long id) throws DocumentException {
        ControlDocumentosExternos documento = findById(id);

        // Datos simulados para la tabla de documentos externos
        List<TablaControlDocumentosExternos> tabla = documento.getTablasControlDocumentosExternos();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Document document = new Document(PageSize.A4, 36, 36, 120, 10); // Configurar márgenes

        PdfWriter writer = PdfWriter.getInstance(document, byteArrayOutputStream);

        // Cargar imagen para el encabezado (opcional)
        Image headerImage = null;
        try {
            headerImage = Image.getInstance("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTSawRmzt3V3qLZ9MnxxaYkr6n2lWr-bQClTw&s");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        headerImage.scaleToFit(15, 15); // Ajustar el tamaño de la imagen

        // Crear el evento del encabezado y registrarlo
        HeaderFooterPageEventControlDocEx event = new HeaderFooterPageEventControlDocEx("CONTROL DE DOCUMENTOS EXTERNOS",headerImage, documento);
        writer.setPageEvent(event);




        document.open();

        // Formato de fuentes
        Font titleFont = new Font(Font.HELVETICA, 16, Font.BOLD);
        Font headerFont = new Font(Font.HELVETICA, 12, Font.BOLD);
        Font normalFont = new Font(Font.HELVETICA, 12, Font.NORMAL);

        document.add(new Paragraph(" ")); // Espacio en blanco

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        document.add(new Paragraph(" ")); // Espacio en blanco

        PdfPTable descTable = new PdfPTable(2);
        descTable.setWidthPercentage(100);
        descTable.setSpacingBefore(10);
        descTable.setWidths(new float[]{1, 3});

        //Datos del documentos


            descTable.addCell(new PdfPCell(new Phrase("Area:", headerFont)));
            descTable.addCell(new PdfPCell(new Phrase(documento.getArea(), normalFont)));

            descTable.addCell(new PdfPCell(new Phrase("Seccion:", headerFont)));
            descTable.addCell(new PdfPCell(new Phrase(documento.getSeccion(), normalFont)));

            descTable.addCell(new PdfPCell(new Phrase("Fecha:", headerFont)));
            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy"); // Define el formato
            String fechaTexto = documento.getFecha().format(formatter1); // Convierte la fecha a texto

            descTable.addCell(new PdfPCell(new Phrase(fechaTexto)));

            document.add(descTable);

        document.add(new Paragraph(" ")); // Espacio en blanco




        PdfPTable documentosTable = new PdfPTable(8);
        documentosTable.setWidthPercentage(100);
        documentosTable.setSpacingBefore(10);
        documentosTable.setWidths(new float[]{1, 2, 2, 3, 2, 2, 2, 2});

        // Encabezados de la tabla
        documentosTable.addCell(new PdfPCell(new Phrase("Número", headerFont)));
        documentosTable.addCell(new PdfPCell(new Phrase("Externo", headerFont)));
        documentosTable.addCell(new PdfPCell(new Phrase("Código", headerFont)));
        documentosTable.addCell(new PdfPCell(new Phrase("Nombre del Documento", headerFont)));
        documentosTable.addCell(new PdfPCell(new Phrase("Revisión", headerFont)));
        documentosTable.addCell(new PdfPCell(new Phrase("Fecha de Emisión", headerFont)));
        documentosTable.addCell(new PdfPCell(new Phrase("Fecha de Revisión", headerFont)));
        documentosTable.addCell(new PdfPCell(new Phrase("Fecha Último Cambio", headerFont)));

        // Añadir los datos de documentos externos
        for (TablaControlDocumentosExternos doc : tabla) {
            documentosTable.addCell(new PdfPCell(new Phrase(doc.getNumero(), normalFont)));
            documentosTable.addCell(new PdfPCell(new Phrase(doc.getExterno(), normalFont)));
            documentosTable.addCell(new PdfPCell(new Phrase(doc.getCodigo(), normalFont)));
            documentosTable.addCell(new PdfPCell(new Phrase(doc.getNombreDocumento(), normalFont)));
            documentosTable.addCell(new PdfPCell(new Phrase(doc.getRevision(), normalFont)));
            documentosTable.addCell(new PdfPCell(new Phrase(doc.getFechaEmocion().format(formatter), normalFont)));
            documentosTable.addCell(new PdfPCell(new Phrase(doc.getFechaRevision().format(formatter), normalFont)));
            documentosTable.addCell(new PdfPCell(new Phrase(doc.getFechaUltimoCambio().format(formatter), normalFont)));
        }

        document.add(documentosTable);

        //tabla final

        document.add(new Paragraph(" "));
        document.add(new Paragraph("Modificaciones a la revisión anterior."));

        PdfPTable documentosTableFinal = new PdfPTable(3);
        documentosTableFinal.setWidthPercentage(100);
        documentosTableFinal.setSpacingBefore(10);
        documentosTableFinal.setWidths(new float[]{2, 1, 7});

        // Encabezados de la tabla
        documentosTableFinal.addCell(new PdfPCell(new Phrase("Fecha de cambio", headerFont)));
        documentosTableFinal.addCell(new PdfPCell(new Phrase("Ed/Rev.", headerFont)));
        documentosTableFinal.addCell(new PdfPCell(new Phrase("Cambios realizados a la versión anterior", headerFont)));

        // Añadir los datos de documentos externos
        for (ModificacionesControlDocEx doc : documento.getModificacionesControlDocExes()) {
            documentosTableFinal.addCell(new PdfPCell(new Phrase(doc.getFechaCambio().format(formatter), normalFont)));
            documentosTableFinal.addCell(new PdfPCell(new Phrase(doc.getEdRev(), normalFont)));
            documentosTableFinal.addCell(new PdfPCell(new Phrase(doc.getCambiosRealizadosVerAn(), normalFont)));

        }

        document.add(documentosTableFinal);


        document.close();

        return byteArrayOutputStream.toByteArray();
    }

}

