package com.api.login.Documentos.SeguimientoAAccionesDeMejoraCorrectivasYPreventivas.Service.Impl;

import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Service.Impl.HeaderFooterPageEventDis;
import com.api.login.Documentos.SeguimientoAAccionesDeMejoraCorrectivasYPreventivas.DTO.SeAcMeCoPrTablaDTO;
import com.api.login.Documentos.SeguimientoAAccionesDeMejoraCorrectivasYPreventivas.DTO.SeguiAccioMejoCorrePrevDTO;
import com.api.login.Documentos.SeguimientoAAccionesDeMejoraCorrectivasYPreventivas.Mapper.SeguiAccioMejoCorrePrevMapper;
import com.api.login.Documentos.SeguimientoAAccionesDeMejoraCorrectivasYPreventivas.Pojo.SeguiAccioMejoCorrePrev;
import com.api.login.Documentos.SeguimientoAAccionesDeMejoraCorrectivasYPreventivas.Repository.SeguiAccioMejoCorrePrevRepository;
import com.api.login.Documentos.SeguimientoAAccionesDeMejoraCorrectivasYPreventivas.Service.SeguiAccioMejoCorrePrevService;
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
import java.util.stream.Collectors;

@Service
public class SeguiAccioMejoCorrePrevServiceImpl implements SeguiAccioMejoCorrePrevService {

    @Autowired
    private SeguiAccioMejoCorrePrevRepository seguiAccioMejoCorrePrevRepository;

    @Autowired
    private SeguiAccioMejoCorrePrevMapper seguiAccioMejoCorrePrevMapper;

    @Override
    public List<SeguiAccioMejoCorrePrevDTO> findAll() {
        return seguiAccioMejoCorrePrevRepository.findAll().stream()
                .map(seguiAccioMejoCorrePrevMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SeguiAccioMejoCorrePrevDTO findById(Long id) {
        SeguiAccioMejoCorrePrev seguiAccioMejoCorrePrev = seguiAccioMejoCorrePrevRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Seguimiento no encontrado"));
        return seguiAccioMejoCorrePrevMapper.toDTO(seguiAccioMejoCorrePrev);
    }

    @Override
    public SeguiAccioMejoCorrePrevDTO save(SeguiAccioMejoCorrePrevDTO seguiAccioMejoCorrePrevDTO) {
        SeguiAccioMejoCorrePrev seguiAccioMejoCorrePrev = seguiAccioMejoCorrePrevMapper.toEntity(seguiAccioMejoCorrePrevDTO);
        SeguiAccioMejoCorrePrev savedSeguiAccioMejoCorrePrev = seguiAccioMejoCorrePrevRepository.save(seguiAccioMejoCorrePrev);
        return seguiAccioMejoCorrePrevMapper.toDTO(savedSeguiAccioMejoCorrePrev);
    }

    @Override
    public SeguiAccioMejoCorrePrevDTO update(Long id, SeguiAccioMejoCorrePrevDTO seguiAccioMejoCorrePrevDTO) {
        SeguiAccioMejoCorrePrev existingSeguiAccioMejoCorrePrev = seguiAccioMejoCorrePrevRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Seguimiento no encontrado"));

        existingSeguiAccioMejoCorrePrev.setCoDocumento(seguiAccioMejoCorrePrevDTO.getCoDocumento());
        existingSeguiAccioMejoCorrePrev.setNoRevision(seguiAccioMejoCorrePrevDTO.getNoRevision());
        existingSeguiAccioMejoCorrePrev.setFechaEmicion(seguiAccioMejoCorrePrevDTO.getFechaEmicion());
        existingSeguiAccioMejoCorrePrev.setFechaRevision(seguiAccioMejoCorrePrevDTO.getFechaRevision());

        SeguiAccioMejoCorrePrev updatedSeguiAccioMejoCorrePrev = seguiAccioMejoCorrePrevRepository.save(existingSeguiAccioMejoCorrePrev);
        return seguiAccioMejoCorrePrevMapper.toDTO(updatedSeguiAccioMejoCorrePrev);
    }

    @Override
    public void deleteById(Long id) {
        seguiAccioMejoCorrePrevRepository.deleteById(id);
    }

    @Override
    public byte[] generarReportePdf(Long id) throws DocumentException {
        SeguiAccioMejoCorrePrevDTO documento = findById(id);

        // Datos simulados para la tabla de seguimiento
        List<SeAcMeCoPrTablaDTO> seguimientoDataList = documento.getSeAcMeCoPrTablas();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Document document = new Document(PageSize.A4.rotate(), 36, 36, 120, 10); // Configurar márgenes

        PdfWriter writer = PdfWriter.getInstance(document, byteArrayOutputStream);
        // Cargar imagen para el encabezado (opcional)
        Image headerImage = null;
        try {
            headerImage = Image.getInstance("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTSawRmzt3V3qLZ9MnxxaYkr6n2lWr-bQClTw&s");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        headerImage.scaleToFit(30, 30); // Ajustar el tamaño de la imagen

        // Crear el evento del encabezado y registrarlo
        HeaderFooterPageEventSeguiAcc event = new HeaderFooterPageEventSeguiAcc("SEGUIMIENTO A ACCIONES DE MEJORA, CORRECTIVAS Y PREVENTIVAS",headerImage, documento);
        writer.setPageEvent(event);

        document.open();

        // Formato de fuentes
        Font titleFont = new Font(Font.HELVETICA, 16, Font.BOLD);
        Font headerFont = new Font(Font.HELVETICA, 12, Font.BOLD);
        Font normalFont = new Font(Font.HELVETICA, 12, Font.NORMAL);

        document.add(new Paragraph(" ")); // Espacio en blanco

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        // Tabla de seguimiento
        Paragraph seguimientoTitle = new Paragraph("Seguimiento de Acciones", titleFont);
        seguimientoTitle.setAlignment(Element.ALIGN_CENTER);
        document.add(seguimientoTitle);

        PdfPTable seguimientoTable = new PdfPTable(8);
        seguimientoTable.setWidthPercentage(100);
        seguimientoTable.setSpacingBefore(10);
        seguimientoTable.setWidths(new float[]{2, 2, 3, 2, 2, 2, 2, 2});

        // Encabezados de la tabla
        seguimientoTable.addCell(new PdfPCell(new Phrase("Folio", headerFont)));
        seguimientoTable.addCell(new PdfPCell(new Phrase("Hallazgo", headerFont)));
        seguimientoTable.addCell(new PdfPCell(new Phrase("Evidencias Observadas", headerFont)));
        seguimientoTable.addCell(new PdfPCell(new Phrase("Responsable Área", headerFont)));
        seguimientoTable.addCell(new PdfPCell(new Phrase("Fecha Inicio", headerFont)));
        seguimientoTable.addCell(new PdfPCell(new Phrase("Fecha Término", headerFont)));
        seguimientoTable.addCell(new PdfPCell(new Phrase("Avance", headerFont)));
        seguimientoTable.addCell(new PdfPCell(new Phrase("Revisión Valoración", headerFont)));

        // Añadir los datos de seguimiento con un folio autogenerado
        int folioCounter = 1;
        for (SeAcMeCoPrTablaDTO data : seguimientoDataList) {
            seguimientoTable.addCell(new PdfPCell(new Phrase("AM-"+(folioCounter++), normalFont)));
            seguimientoTable.addCell(new PdfPCell(new Phrase(data.getHallazgo(), normalFont)));
            seguimientoTable.addCell(new PdfPCell(new Phrase(data.getEvidenciasObservadas(), normalFont)));
            seguimientoTable.addCell(new PdfPCell(new Phrase(data.getResponsableAreaImplantacion(), normalFont)));
            seguimientoTable.addCell(new PdfPCell(new Phrase(data.getFechaInicio().format(formatter), normalFont)));
            seguimientoTable.addCell(new PdfPCell(new Phrase(data.getFechaTermino().format(formatter), normalFont)));
            seguimientoTable.addCell(new PdfPCell(new Phrase(data.getAvance(), normalFont)));
            seguimientoTable.addCell(new PdfPCell(new Phrase(data.getRevisionValoracion(), normalFont)));
        }

        document.add(seguimientoTable);
        document.close();

        return byteArrayOutputStream.toByteArray();
    }

}
