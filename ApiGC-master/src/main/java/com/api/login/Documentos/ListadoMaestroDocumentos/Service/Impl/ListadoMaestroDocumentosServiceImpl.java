package com.api.login.Documentos.ListadoMaestroDocumentos.Service.Impl;

import com.api.login.Documentos.ListadoMaestroDocumentos.DTO.ListadoMaestroDocumentosDTO;
import com.api.login.Documentos.ListadoMaestroDocumentos.DTO.TablaLisMaDocumentosProcesosDTO;
import com.api.login.Documentos.ListadoMaestroDocumentos.Mapper.ListadoMaestroDocumentosMapper;
import com.api.login.Documentos.ListadoMaestroDocumentos.Pojo.ListadoMaestroDocumentos;
import com.api.login.Documentos.ListadoMaestroDocumentos.Pojo.TablaLisMaDocumentosAnexos;
import com.api.login.Documentos.ListadoMaestroDocumentos.Pojo.TablaLisMaDocumentosFormatos;
import com.api.login.Documentos.ListadoMaestroDocumentos.Pojo.TablaLisMaDocumentosProcesos;
import com.api.login.Documentos.ListadoMaestroDocumentos.Repository.ListadoMaestroDocumentosRepository;
import com.api.login.Documentos.ListadoMaestroDocumentos.Service.ListadoMaestroDocumentosService;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ListadoMaestroDocumentosServiceImpl implements ListadoMaestroDocumentosService {

    @Autowired
    private ListadoMaestroDocumentosRepository listadoMaestroDocumentosRepository;

    @Autowired
    private ListadoMaestroDocumentosMapper listadoMaestroDocumentosMapper;

    @Override
    public List<ListadoMaestroDocumentos> findAll() {
        return listadoMaestroDocumentosRepository.findAll();
    }

    @Override
    public ListadoMaestroDocumentos findById(Long id) {
        return listadoMaestroDocumentosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Documento no encontrado"));
    }

    @Override
    public ListadoMaestroDocumentos save(ListadoMaestroDocumentos listadoMaestroDocumentos) {
        return listadoMaestroDocumentosRepository.save(listadoMaestroDocumentos);
    }

    @Override
    public ListadoMaestroDocumentos update(Long id, ListadoMaestroDocumentosDTO listadoMaestroDocumentosDTO) {
        ListadoMaestroDocumentos existingDocument = listadoMaestroDocumentosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Documento no encontrado"));

        existingDocument.setCoDocumento(listadoMaestroDocumentosDTO.getCoDocumento());
        existingDocument.setNoRevision(listadoMaestroDocumentosDTO.getNoRevision());
        existingDocument.setFechaEmicion(listadoMaestroDocumentosDTO.getFechaEmicion());
        existingDocument.setFechaRevision(listadoMaestroDocumentosDTO.getFechaRevision());

        return listadoMaestroDocumentosRepository.save(existingDocument);
    }

    @Override
    public void deleteById(Long id) {
        listadoMaestroDocumentosRepository.deleteById(id);
    }

    // Implementaciones de los demás métodos...

    @Override
    public byte[] generarListadoMaestroPdf(Long id) throws DocumentException {
        ListadoMaestroDocumentos documento = findById(id);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        float marginLeft = 36;
        float marginRight = 36;
        float marginTop = 110;
        float marginBottom = 10;
        Document document = new Document(PageSize.A4.rotate(), marginLeft, marginRight, marginTop, marginBottom);
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
        HeaderFooterPageEvent event = new HeaderFooterPageEvent("Listado Maestro de Documentos", headerImage, documento);
        writer.setPageEvent(event);

        document.open();

        Font titleFont = new Font(Font.HELVETICA, 16, Font.BOLD);
        Font headerFont = new Font(Font.HELVETICA, 12, Font.BOLD);
        Font dataFont = new Font(Font.HELVETICA, 12, Font.NORMAL);

        // Procesos
        document.add(new Paragraph("PROCESOS", titleFont));
        document.add(new Paragraph(" "));

        PdfPTable tableProcesos = new PdfPTable(9);
        tableProcesos.setWidthPercentage(100);
        tableProcesos.setWidths(new float[]{1f, 2f, 5f, 3f, 3f, 2f, 2f, 2f, 2f});

        // Encabezados de Procesos
        addTableHeaders(tableProcesos, headerFont);

        // Filas de Procesos
        int contadorProcesos = 1;
        for (TablaLisMaDocumentosProcesos proceso : documento.getProcesos()) {
            addTableRow(tableProcesos, contadorProcesos++, proceso, dataFont);
        }

        document.add(tableProcesos);

        // Formatos
        document.add(new Paragraph("FORMATOS", titleFont));
        document.add(new Paragraph(" "));

        PdfPTable tableFormatos = new PdfPTable(9);
        tableFormatos.setWidthPercentage(100);
        tableFormatos.setWidths(new float[]{1f, 2f, 5f, 3f, 3f, 2f, 2f, 2f, 2f});

        // Encabezados de Formatos
        addTableHeaders(tableFormatos, headerFont);

        // Filas de Formatos
        int contadorFormatos = 1;
        for (TablaLisMaDocumentosFormatos formato : documento.getFormatos()) {
            addTableRow(tableFormatos, contadorFormatos++, formato, dataFont);
        }

        document.add(tableFormatos);

        // Anexos
        document.add(new Paragraph("ANEXOS", titleFont));
        document.add(new Paragraph(" "));

        PdfPTable tableAnexos = new PdfPTable(9);
        tableAnexos.setWidthPercentage(100);
        tableAnexos.setWidths(new float[]{1f, 2f, 5f, 3f, 3f, 2f, 2f, 2f, 2f});

        // Encabezados de Anexos
        addTableHeaders(tableAnexos, headerFont);

        // Filas de Anexos
        int contadorAnexos = 1;
        for (TablaLisMaDocumentosAnexos anexo : documento.getAnexos()) {
            addTableRow(tableAnexos, contadorAnexos++, anexo, dataFont);
        }

        document.add(tableAnexos);

        document.close();

        return byteArrayOutputStream.toByteArray();
    }

    // Método para añadir encabezados a una tabla
    private void addTableHeaders(PdfPTable table, Font headerFont) {
        PdfPCell cell = new PdfPCell(new Phrase("ITEM", headerFont));
        cell.setBackgroundColor(Color.green);
        table.addCell(cell);

        table.addCell(new PdfPCell(new Phrase("CÓDIGO", headerFont))).setBackgroundColor(Color.green);
        table.addCell(new PdfPCell(new Phrase("NOMBRE DEL PROCESO", headerFont))).setBackgroundColor(Color.green);
        table.addCell(new PdfPCell(new Phrase("DEPARTAMENTO", headerFont))).setBackgroundColor(Color.green);
        table.addCell(new PdfPCell(new Phrase("RESPONSABLE", headerFont))).setBackgroundColor(Color.green);
        table.addCell(new PdfPCell(new Phrase("No. REVISIÓN", headerFont))).setBackgroundColor(Color.green);
        table.addCell(new PdfPCell(new Phrase("Elaborado", headerFont))).setBackgroundColor(Color.green);
        table.addCell(new PdfPCell(new Phrase("Revisado", headerFont))).setBackgroundColor(Color.green);
        table.addCell(new PdfPCell(new Phrase("Modificado", headerFont))).setBackgroundColor(Color.green);
    }

    // Método para añadir filas a una tabla
    private void addTableRow(PdfPTable table, int contador, TablaLisMaDocumentosProcesos documento, Font dataFont) {
        table.addCell(new PdfPCell(new Phrase(String.valueOf(contador), dataFont)));
        table.addCell(new PdfPCell(new Phrase(documento.getCodigo(), dataFont)));
        table.addCell(new PdfPCell(new Phrase(documento.getNombredocumento(), dataFont)));
        table.addCell(new PdfPCell(new Phrase(documento.getDepartamento(), dataFont)));
        table.addCell(new PdfPCell(new Phrase(documento.getResponsable(), dataFont)));
        table.addCell(new PdfPCell(new Phrase(documento.getNoRevision(), dataFont)));
        table.addCell(new PdfPCell(new Phrase(documento.getElaborado().toString(), dataFont)));
        table.addCell(new PdfPCell(new Phrase(documento.getRevisado().toString(), dataFont)));
        table.addCell(new PdfPCell(new Phrase(documento.getModificado().toString(), dataFont)));
    }

    private void addTableRow(PdfPTable table, int contador, TablaLisMaDocumentosFormatos documento, Font dataFont) {
        table.addCell(new PdfPCell(new Phrase(String.valueOf(contador), dataFont)));
        table.addCell(new PdfPCell(new Phrase(documento.getCodigo(), dataFont)));
        table.addCell(new PdfPCell(new Phrase(documento.getNombredocumento(), dataFont)));
        table.addCell(new PdfPCell(new Phrase(documento.getDepartamento(), dataFont)));
        table.addCell(new PdfPCell(new Phrase(documento.getResponsable(), dataFont)));
        table.addCell(new PdfPCell(new Phrase(documento.getNoRevision(), dataFont)));
        table.addCell(new PdfPCell(new Phrase(documento.getElaborado().toString(), dataFont)));
        table.addCell(new PdfPCell(new Phrase(documento.getRevisado().toString(), dataFont)));
        table.addCell(new PdfPCell(new Phrase(documento.getModificado().toString(), dataFont)));
    }

    private void addTableRow(PdfPTable table, int contador, TablaLisMaDocumentosAnexos documento, Font dataFont) {
        table.addCell(new PdfPCell(new Phrase(String.valueOf(contador), dataFont)));
        table.addCell(new PdfPCell(new Phrase(documento.getCodigo(), dataFont)));
        table.addCell(new PdfPCell(new Phrase(documento.getNombredocumento(), dataFont)));
        table.addCell(new PdfPCell(new Phrase(documento.getDepartamento(), dataFont)));
        table.addCell(new PdfPCell(new Phrase(documento.getResponsable(), dataFont)));
        table.addCell(new PdfPCell(new Phrase(documento.getNoRevision(), dataFont)));
        table.addCell(new PdfPCell(new Phrase(documento.getElaborado().toString(), dataFont)));
        table.addCell(new PdfPCell(new Phrase(documento.getRevisado().toString(), dataFont)));
        table.addCell(new PdfPCell(new Phrase(documento.getModificado().toString(), dataFont)));
    }



}


