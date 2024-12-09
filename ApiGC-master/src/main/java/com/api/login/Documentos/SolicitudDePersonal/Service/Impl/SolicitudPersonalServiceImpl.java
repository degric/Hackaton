package com.api.login.Documentos.SolicitudDePersonal.Service.Impl;

import com.api.login.Documentos.ListaDeAsistencia.Service.Impl.HeaderFooterPageEventListaAsistencia;
import com.api.login.Documentos.SolicitudDePersonal.DTO.SolicitudPersonalDTO;
import com.api.login.Documentos.SolicitudDePersonal.Mapper.SolicitudPersonalMapper;
import com.api.login.Documentos.SolicitudDePersonal.Pojo.SolicitudPersonal;
import com.api.login.Documentos.SolicitudDePersonal.Repository.SolicitudPersonalRepository;
import com.api.login.Documentos.SolicitudDePersonal.Service.SolicitudPersonalService;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SolicitudPersonalServiceImpl implements SolicitudPersonalService {

    @Autowired
    private SolicitudPersonalRepository solicitudPersonalRepository;

    @Autowired
    private SolicitudPersonalMapper solicitudPersonalMapper;

    @Override
    public List<SolicitudPersonalDTO> findAll() {
        return solicitudPersonalRepository.findAll().stream()
                .map(solicitudPersonalMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SolicitudPersonalDTO findById(Long id) {
        SolicitudPersonal solicitudPersonal = solicitudPersonalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Solicitud Personal no encontrada"));
        return solicitudPersonalMapper.toDTO(solicitudPersonal);
    }

    @Override
    public SolicitudPersonalDTO save(SolicitudPersonalDTO solicitudPersonalDTO) {
        SolicitudPersonal solicitudPersonal = solicitudPersonalMapper.toEntity(solicitudPersonalDTO);
        SolicitudPersonal savedSolicitudPersonal = solicitudPersonalRepository.save(solicitudPersonal);
        return solicitudPersonalMapper.toDTO(savedSolicitudPersonal);
    }

    @Override
    public SolicitudPersonalDTO update(Long id, SolicitudPersonalDTO solicitudPersonalDTO) {
        SolicitudPersonal existingSolicitudPersonal = solicitudPersonalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Solicitud Personal no encontrada"));

        existingSolicitudPersonal.setCoDocumento(solicitudPersonalDTO.getCoDocumento());
        existingSolicitudPersonal.setNoRevision(solicitudPersonalDTO.getNoRevision());
        existingSolicitudPersonal.setFechaEmicion(solicitudPersonalDTO.getFechaEmicion());
        existingSolicitudPersonal.setFechaRevision(solicitudPersonalDTO.getFechaRevision());

        SolicitudPersonal updatedSolicitudPersonal = solicitudPersonalRepository.save(existingSolicitudPersonal);
        return solicitudPersonalMapper.toDTO(updatedSolicitudPersonal);
    }

    @Override
    public void deleteById(Long id) {
        solicitudPersonalRepository.deleteById(id);
    }

    @Override
    public byte[] generarPdf(Long id) throws DocumentException {

        SolicitudPersonalDTO BSC = findById(id);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Document document = new Document(PageSize.A4.rotate(), 36, 36, 120, 10);

        PdfWriter writer = PdfWriter.getInstance(document, byteArrayOutputStream);

        // Cargar imagen para el encabezado (opcional)
        Image headerImage = null;
        try {
            headerImage = Image.getInstance("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTSawRmzt3V3qLZ9MnxxaYkr6n2lWr-bQClTw&s");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        headerImage.scaleToFit(25, 25); // Ajustar el tamaño de la imagen

        // Crear el evento del encabezado y registrarlo
        HeaderFooterPageEventSolicitudPersonal event = new HeaderFooterPageEventSolicitudPersonal("SOLICITUD DE PERSONAL",headerImage, BSC);
        writer.setPageEvent(event);


        document.open();
        document.add(new Paragraph(""));

        // Datos del solicitante
        document.add(new Paragraph("Datos del solicitante"));
        PdfPTable applicantTable = new PdfPTable(4);
        applicantTable.setWidthPercentage(100);
        applicantTable.addCell("Nombre del Solicitante");
        applicantTable.addCell("Cargo");
        applicantTable.addCell("Área");
        applicantTable.addCell("Fecha de Solicitud");
        applicantTable.addCell("[Nombre]");
        applicantTable.addCell("[Cargo]");
        applicantTable.addCell("[Área]");
        applicantTable.addCell("[Fecha]");
        document.add(applicantTable);
        document.add(new Paragraph(" "));

        // Datos de la vacante
        document.add(new Paragraph("Datos de la vacante"));
        PdfPTable vacancyTable = new PdfPTable(4);
        vacancyTable.setWidthPercentage(100);
        vacancyTable.addCell("Puesto Solicitado");
        vacancyTable.addCell("Área");
        vacancyTable.addCell("Número de Vacantes");
        vacancyTable.addCell("Fecha Prevista de Inicio");
        vacancyTable.addCell("[Puesto]");
        vacancyTable.addCell("[Área]");
        vacancyTable.addCell("[Número]");
        vacancyTable.addCell("[Fecha]");
        document.add(vacancyTable);
        document.add(new Paragraph(" "));

        // Motivo de la solicitud y tipo de contrato
        document.add(new Paragraph("Motivo de la Solicitud y Tipo de Contrato:"));
        document.add(new Paragraph("(  ) Vacante abierta   (  ) Por expansión | (  )Incapacidad| (  ) Temporal | Tiempo:  |(  ) Otro:    |"));
        document.add(new Paragraph("                                          |                | (  ) Indefinido          |Especifique:  |"));

        document.add(new Paragraph(" "));

        // Estatus del puesto
        document.add(new Paragraph("Estatus del Puesto:"));
        document.add(new Paragraph("(   ) Existente   (   ) Puesto nuevo Especifique:"));
        document.add(new Paragraph(" "));

        // Firmas
        PdfPTable signatureTable = new PdfPTable(3);
        signatureTable.setWidthPercentage(100);
        signatureTable.addCell("Solicitante");
        signatureTable.addCell("Recursos Humanos");
        signatureTable.addCell("Dirección");
        signatureTable.addCell(" ");
        signatureTable.addCell(" ");
        signatureTable.addCell(" ");
        document.add(signatureTable);



        document.close();

        return byteArrayOutputStream.toByteArray();



    }
}

