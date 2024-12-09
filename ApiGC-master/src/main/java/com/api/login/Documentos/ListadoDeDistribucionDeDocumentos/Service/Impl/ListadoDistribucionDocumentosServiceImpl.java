package com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Service.Impl;

import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.DTO.LDDDescricionDocumentoDTO;
import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.DTO.LDDocTablaDTO;
import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.DTO.ListadoDistribucionDocumentosDTO;
import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Mapper.ListadoDistribucionDocumentosMapper;
import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Pojo.LDDDescricionDocumento;
import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Pojo.ListadoDistribucionDocumentos;
import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Repository.ListadoDistribucionDocumentosRepository;
import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Service.ListadoDistribucionDocumentosService;
import com.api.login.Documentos.ListadoMaestroDocumentos.Service.Impl.HeaderFooterPageEvent;
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
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListadoDistribucionDocumentosServiceImpl implements ListadoDistribucionDocumentosService {

    @Autowired
    private ListadoDistribucionDocumentosRepository listadoDistribucionDocumentosRepository;

    @Autowired
    private ListadoDistribucionDocumentosMapper listadoDistribucionDocumentosMapper;

    @Override
    public List<ListadoDistribucionDocumentosDTO> findAll() {
        return listadoDistribucionDocumentosRepository.findAll().stream()
                .map(listadoDistribucionDocumentosMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ListadoDistribucionDocumentosDTO findById(Long id) {
        ListadoDistribucionDocumentos listado = listadoDistribucionDocumentosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Listado no encontrado"));
        return listadoDistribucionDocumentosMapper.toDTO(listado);
    }

    @Override
    public ListadoDistribucionDocumentosDTO save(ListadoDistribucionDocumentosDTO listadoDistribucionDocumentosDTO) {
        ListadoDistribucionDocumentos listado = listadoDistribucionDocumentosMapper.toEntity(listadoDistribucionDocumentosDTO);
        ListadoDistribucionDocumentos savedListado = listadoDistribucionDocumentosRepository.save(listado);
        return listadoDistribucionDocumentosMapper.toDTO(savedListado);
    }

    @Override
    public ListadoDistribucionDocumentosDTO update(Long id, ListadoDistribucionDocumentosDTO listadoDistribucionDocumentosDTO) {
        ListadoDistribucionDocumentos existingListado = listadoDistribucionDocumentosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Listado no encontrado"));

        existingListado.setCoDocumento(listadoDistribucionDocumentosDTO.getCoDocumento());
        existingListado.setNoRevision(listadoDistribucionDocumentosDTO.getNoRevision());
        existingListado.setFechaEmicion(listadoDistribucionDocumentosDTO.getFechaEmicion());
        existingListado.setFechaRevision(listadoDistribucionDocumentosDTO.getFechaRevision());

        ListadoDistribucionDocumentos updatedListado = listadoDistribucionDocumentosRepository.save(existingListado);
        return listadoDistribucionDocumentosMapper.toDTO(updatedListado);
    }

    @Override
    public void deleteById(Long id) {
        listadoDistribucionDocumentosRepository.deleteById(id);
    }


    @Override
    public byte[] generarReportePdf(Long id) throws DocumentException {

        ListadoDistribucionDocumentosDTO documento = findById(id);
        List<LDDDescricionDocumentoDTO> LDDD = documento.getLddDescricionDocumentos();//lista de la primera seccion
        List<LDDocTablaDTO> tabla = documento.getLddDocTablas(); //Tabla de contenido


        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Document document = new Document(PageSize.A4, 36, 36, 120, 10); // Configura márgenes

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
        HeaderFooterPageEventDis event = new HeaderFooterPageEventDis("LISTADO DE DISTRIBUCIÓN DE DOCUMENTOS",headerImage, documento);
        writer.setPageEvent(event);

        document.open();

        // Formato de fuentes
        Font titleFont = new Font(Font.HELVETICA, 16, Font.BOLD);
        Font headerFont = new Font(Font.HELVETICA, 12, Font.BOLD);
        Font normalFont = new Font(Font.HELVETICA, 12, Font.NORMAL);

        document.add(new Paragraph(" ")); // Espacio en blanco

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Sección de descripción del documento
        Paragraph descTitle = new Paragraph("Descripción del Documento", titleFont);
        descTitle.setAlignment(Element.ALIGN_CENTER);
        document.add(descTitle);

        PdfPTable descTable = new PdfPTable(2);
        descTable.setWidthPercentage(100);
        descTable.setSpacingBefore(10);
        descTable.setWidths(new float[]{1, 3});


        //tabla de informacion del documento
        for (LDDDescricionDocumentoDTO dto : LDDD){

        descTable.addCell(new PdfPCell(new Phrase("Descripción:", headerFont)));
        descTable.addCell(new PdfPCell(new Phrase(dto.getDescripcion(), normalFont)));

        descTable.addCell(new PdfPCell(new Phrase("Documento:", headerFont)));
        descTable.addCell(new PdfPCell(new Phrase(dto.getDocumento(), normalFont)));

        descTable.addCell(new PdfPCell(new Phrase("Área:", headerFont)));
        descTable.addCell(new PdfPCell(new Phrase(dto.getArea(), normalFont)));

        descTable.addCell(new PdfPCell(new Phrase("Código Documento:", headerFont)));
        descTable.addCell(new PdfPCell(new Phrase(dto.getCodigoDocumento(), normalFont)));

        descTable.addCell(new PdfPCell(new Phrase("Revisión:", headerFont)));
        descTable.addCell(new PdfPCell(new Phrase(dto.getRevision(), normalFont)));

        descTable.addCell(new PdfPCell(new Phrase("Fecha de Implantación:", headerFont)));
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy"); // Define el formato
        String fechaTexto = dto.getFechaImplantacion().format(formatter1); // Convierte la fecha a texto

        descTable.addCell(new PdfPCell(new Phrase(fechaTexto)));

        document.add(descTable);

        }
        document.add(new Paragraph(" ")); // Espacio en blanco

        // Tabla de distribución
        Paragraph distribTitle = new Paragraph("Distribución de Documentos", titleFont);
        distribTitle.setAlignment(Element.ALIGN_CENTER);
        document.add(distribTitle);

        PdfPTable distTable = new PdfPTable(3);
        distTable.setWidthPercentage(100);
        distTable.setSpacingBefore(10);
        distTable.setWidths(new float[]{2, 2, 2});

        // Encabezados de la tabla
        distTable.addCell(new PdfPCell(new Phrase("Nombre del Receptor", headerFont)));
        distTable.addCell(new PdfPCell(new Phrase("Puesto", headerFont)));
        distTable.addCell(new PdfPCell(new Phrase("Firma", headerFont)));

        // Añadir los datos de distribución
        for (LDDocTablaDTO dto : tabla) {
            distTable.addCell(new PdfPCell(new Phrase(dto.getNombreReceptor(), normalFont)));
            distTable.addCell(new PdfPCell(new Phrase(dto.getPuesto(), normalFont)));
            distTable.addCell(new PdfPCell(new Phrase(dto.getFirma(), normalFont)));
        }

        document.add(distTable);
        document.close();

        return byteArrayOutputStream.toByteArray();
    }
}
