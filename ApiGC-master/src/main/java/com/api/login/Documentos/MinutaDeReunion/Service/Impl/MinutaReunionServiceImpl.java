package com.api.login.Documentos.MinutaDeReunion.Service.Impl;

import com.api.login.Documentos.ControlDocumentosExternos.Service.Impl.HeaderFooterPageEventControlDocEx;
import com.api.login.Documentos.MinutaDeReunion.DTO.*;
import com.api.login.Documentos.MinutaDeReunion.Mapper.MinutaReunionMapper;
import com.api.login.Documentos.MinutaDeReunion.Pojo.MinutaReunion;
import com.api.login.Documentos.MinutaDeReunion.Repository.MinutaReunionRepository;
import com.api.login.Documentos.MinutaDeReunion.Service.MinutaReunionService;
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
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MinutaReunionServiceImpl implements MinutaReunionService {

    @Autowired
    private MinutaReunionRepository minutaReunionRepository;

    @Autowired
    private MinutaReunionMapper minutaReunionMapper;

    @Override
    public List<MinutaReunionDTO> findAll() {
        return minutaReunionRepository.findAll().stream()
                .map(minutaReunionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MinutaReunionDTO findById(Long id) {
        MinutaReunion minutaReunion = minutaReunionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Minuta de reunión no encontrada"));
        return minutaReunionMapper.toDTO(minutaReunion);
    }

    @Override
    public MinutaReunionDTO save(MinutaReunionDTO minutaReunionDTO) {
        MinutaReunion minutaReunion = minutaReunionMapper.toEntity(minutaReunionDTO);
        MinutaReunion savedMinutaReunion = minutaReunionRepository.save(minutaReunion);
        return minutaReunionMapper.toDTO(savedMinutaReunion);
    }

    @Override
    public MinutaReunionDTO update(Long id, MinutaReunionDTO minutaReunionDTO) {
        MinutaReunion existingMinutaReunion = minutaReunionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Minuta de reunión no encontrada"));

        existingMinutaReunion.setCoDocumento(minutaReunionDTO.getCoDocumento());
        existingMinutaReunion.setNoRevision(minutaReunionDTO.getNoRevision());
        existingMinutaReunion.setFechaEmicion(minutaReunionDTO.getFechaEmicion());
        existingMinutaReunion.setFechaRevision(minutaReunionDTO.getFechaRevision());

        MinutaReunion updatedMinutaReunion = minutaReunionRepository.save(existingMinutaReunion);
        return minutaReunionMapper.toDTO(updatedMinutaReunion);
    }

    @Override
    public void deleteById(Long id) {
        minutaReunionRepository.deleteById(id);
    }

    @Override
    public byte[] generarMinutaPdf(Long id) throws DocumentException {
        MinutaReunionDTO documento = findById(id);



        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Document document = new Document(PageSize.A4, 36, 36, 120, 10);

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
        HeaderFooterPageEventMinutaReunion event = new HeaderFooterPageEventMinutaReunion("MINUTA DE REUNIÓN",headerImage, documento);
        writer.setPageEvent(event);




        document.open();

        // Formato de fuentes
        Font titleFont = new Font(Font.HELVETICA, 16, Font.BOLD);
        Font headerFont = new Font(Font.HELVETICA, 12, Font.BOLD);
        Font normalFont = new Font(Font.HELVETICA, 12, Font.NORMAL);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        document.add(new Paragraph(" ")); // Espacio en blanco

        // Sección de datos de la reunión
        PdfPTable datosReunionTable = new PdfPTable(2);
        datosReunionTable.setWidthPercentage(100);
        datosReunionTable.setSpacingBefore(10);
        datosReunionTable.setWidths(new float[]{1, 3});
        List<MinuReunDatosDTO> datos = documento.getMinuReunDatos();

        for(MinuReunDatosDTO dto: datos){
            datosReunionTable.addCell(new PdfPCell(new Phrase("Fecha:", headerFont)));
            datosReunionTable.addCell(new PdfPCell(new Phrase(dto.getFecha().format(formatter), normalFont)));

            datosReunionTable.addCell(new PdfPCell(new Phrase("Departamento:", headerFont)));
            datosReunionTable.addCell(new PdfPCell(new Phrase(dto.getDepartamento(), normalFont)));

            datosReunionTable.addCell(new PdfPCell(new Phrase("Asunto a Tratar:", headerFont)));
            datosReunionTable.addCell(new PdfPCell(new Phrase(dto.getAsuntoATratar(), normalFont)));

            document.add(datosReunionTable);
            document.add(new Paragraph(" ")); // Espacio en blanco

        }


        // Sección de participantes
        Paragraph participantesTitle = new Paragraph("PARTICIPANTES", titleFont);
        participantesTitle.setAlignment(Element.ALIGN_CENTER);
        document.add(participantesTitle);

        PdfPTable participantesTable = new PdfPTable(1);
        participantesTable.setWidthPercentage(100);

        //consulta de la base de datos
        List<MinuReunParticipantesDTO> participantes = documento.getMinuReunParticipantes();

        for (int i = 0; i < participantes.size(); i++) {
            participantesTable.addCell(new PdfPCell(new Phrase((i + 1) + ". " + participantes.get(i).getNombre(), normalFont)));
        }

        document.add(participantesTable);
        document.add(new Paragraph(" ")); // Espacio en blanco

        // Sección de puntos a tratar
        Paragraph puntosTitle = new Paragraph("PUNTOS A TRATAR", titleFont);
        puntosTitle.setAlignment(Element.ALIGN_CENTER);
        document.add(puntosTitle);

        PdfPTable puntosTable = new PdfPTable(1);
        puntosTable.setWidthPercentage(100);

        List<MinuReunPuntosTratarDTO> puntosATratar = documento.getMinuReunPuntosTratar();

        for (int i = 0; i < puntosATratar.size(); i++) {
            puntosTable.addCell(new PdfPCell(new Phrase((i + 1) + ". " + puntosATratar.get(i).getPunto(), normalFont)));
        }

        document.add(puntosTable);
        document.add(new Paragraph(" ")); // Espacio en blanco

        // Sección de resultados y acuerdos
        Paragraph acuerdosTitle = new Paragraph("RESULTADOS Y ACUERDOS", titleFont);
        acuerdosTitle.setAlignment(Element.ALIGN_CENTER);
        document.add(acuerdosTitle);

        PdfPTable acuerdosTable = new PdfPTable(1);
        acuerdosTable.setWidthPercentage(100);

        List<MinuReunResultadosAcuerdosDTO> resultadosYAcuerdos = documento.getMinuReunResultadosAcuerdos();
        for (int i = 0; i < resultadosYAcuerdos.size(); i++) {
            acuerdosTable.addCell(new PdfPCell(new Phrase((i + 1) + ". " + resultadosYAcuerdos.get(i).getContenido(), normalFont)));
        }

        document.add(acuerdosTable);
        document.add(new Paragraph(" ")); // Espacio en blanco

        // Sección de seguimiento a acuerdos
        Paragraph seguimientoTitle = new Paragraph("SEGUIMIENTO A ACUERDOS", titleFont);
        seguimientoTitle.setAlignment(Element.ALIGN_CENTER);
        document.add(seguimientoTitle);

        PdfPTable seguimientoTable = new PdfPTable(1);
        seguimientoTable.setWidthPercentage(100);

        List<MinutaReunionSeguimientoDTO> seguimientoAcuerdos = documento.getMinutaReunionSeguimientos();
        for (int i = 0; i < seguimientoAcuerdos.size(); i++) {
            seguimientoTable.addCell(new PdfPCell(new Phrase((i + 1) + ". " + seguimientoAcuerdos.get(i).getContenido(), normalFont)));
        }

        document.add(seguimientoTable);
        document.close();

        return byteArrayOutputStream.toByteArray();
    }
}
