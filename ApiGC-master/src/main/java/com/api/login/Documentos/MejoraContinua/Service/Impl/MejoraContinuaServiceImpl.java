package com.api.login.Documentos.MejoraContinua.Service.Impl;

import com.api.login.Documentos.MejoraContinua.DTO.*;
import com.api.login.Documentos.MejoraContinua.Mapper.MejoraContinuaMapper;
import com.api.login.Documentos.MejoraContinua.Pojo.MejoraContinua;
import com.api.login.Documentos.MejoraContinua.Repository.MejoraContinuaRepository;
import com.api.login.Documentos.MejoraContinua.Service.MejoraContinuaService;
import com.api.login.Documentos.ReporteDeAuditoria.Service.Impl.HeaderFooterPageEventReporteAuditoria;
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
public class MejoraContinuaServiceImpl implements MejoraContinuaService {

    @Autowired
    private MejoraContinuaRepository mejoraContinuaRepository;

    @Autowired
    private MejoraContinuaMapper mejoraContinuaMapper;

    @Override
    public List<MejoraContinuaDTO> findAll() {
        return mejoraContinuaRepository.findAll().stream()
                .map(mejoraContinuaMapper::toDTO)
                .collect(Collectors.toList());
    }
    @Override
    public MejoraContinuaDTO findById(Long id) {
        MejoraContinua mejoraContinua = mejoraContinuaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Mejora Continua no encontrada"));
        return mejoraContinuaMapper.toDTO(mejoraContinua);
    }
    @Override
    public MejoraContinuaDTO save(MejoraContinuaDTO mejoraContinuaDTO) {
        MejoraContinua mejoraContinua = mejoraContinuaMapper.toEntity(mejoraContinuaDTO);
        MejoraContinua savedMejoraContinua = mejoraContinuaRepository.save(mejoraContinua);
        return mejoraContinuaMapper.toDTO(savedMejoraContinua);
    }

    @Override
    public MejoraContinuaDTO update(Long id, MejoraContinuaDTO mejoraContinuaDTO) {
        MejoraContinua existingMejoraContinua = mejoraContinuaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Mejora Continua no encontrada"));

        existingMejoraContinua.setCoDocumento(mejoraContinuaDTO.getCoDocumento());
        existingMejoraContinua.setNoRevision(mejoraContinuaDTO.getNoRevision());
        existingMejoraContinua.setFechaEmicion(mejoraContinuaDTO.getFechaEmicion());
        existingMejoraContinua.setFechaRevision(mejoraContinuaDTO.getFechaRevision());

        MejoraContinua updatedMejoraContinua = mejoraContinuaRepository.save(existingMejoraContinua);
        return mejoraContinuaMapper.toDTO(updatedMejoraContinua);
    }

    @Override
    public void deleteById(Long id) {
        mejoraContinuaRepository.deleteById(id);
    }

    @Override
    public byte[] generarPdf(Long id) throws DocumentException {

        MejoraContinuaDTO BSC = findById(id);

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
        headerImage.scaleToFit(25, 25); // Ajustar el tamaño de la imagen

        // Crear el evento del encabezado y registrarlo
        HeaderFooterPageEventMejoraContinua event = new HeaderFooterPageEventMejoraContinua("MEJORA CONTINUA",headerImage, BSC);
        writer.setPageEvent(event);


        document.open();

        DatosMejoraContinuaDTO datos = BSC.getDatosMejoraContinua();
        // Datos generales
        document.add(new Paragraph("No. de Control: "+ datos.getNumeroControl()));
        document.add(new Paragraph("Objetivo de la mejora: "+ datos.getObjetivo()));
        document.add(new Paragraph("Origen de la mejora: "+ datos.getOrigenMejora()));
        document.add(new Paragraph("Descripción de la acción: "+ datos.getDescriocion()));
        document.add(new Paragraph("Cuantificación de mejora: "+ datos.getCuantificacion()));
        document.add(new Paragraph("Período: "+ datos.getPeriodo()));
        document.add(new Paragraph("Resultados: "+ datos.getResultado()));
        document.add(new Paragraph(" "));


        List<TablaMejoraContinuaDTO> tabla1 = BSC.getTablaMejoraContinuaList();

        // Tabla de Acciones
        PdfPTable actionTable = new PdfPTable(2);
        actionTable.setWidthPercentage(100);
        actionTable.addCell("¿Qué se va a hacer?");
        actionTable.addCell("Meta esperada");
        for (TablaMejoraContinuaDTO y: tabla1) {
            actionTable.addCell(y.getQueSeVaHacer());
            actionTable.addCell(y.getMetaEsperada());
        }
        document.add(actionTable);
        document.add(new Paragraph(" "));


        EvaluacionEficienciaMejoraContinuaDTO eva= BSC.getEvaluacionEficienciaMejoraContinua();
        // Evaluación de la eficacia
        document.add(new Paragraph("EVALUACIÓN DE LA EFICACIA DE LAS ACCIONES"));
        document.add(new Paragraph("1. ¿Se cumplieron las acciones propuestas? " + eva.getPreguntaSeCumAccPro()));
        document.add(new Paragraph("Observaciones: "+eva.getObservacion1()));
        document.add(new Paragraph("2. ¿Aun hay acciones pendientes? "+ eva.getPreguntaAunHayAccPen()));
        document.add(new Paragraph("Observaciones: "+ eva.getObservacion2()));

        document.add(new Paragraph("¿ Se requiere actualizar o modificar algun documento del SGC  para estandarizar y asegurar la mejora implementada?"+ eva.getPreguntaSeReAc()));
        document.add(new Paragraph(" "));

        List<IntegrantesMejoraContinuaDTO> inme = BSC.getIntegrantesMejoraContinuaList();
        // Integrantes
        PdfPTable memberTable = new PdfPTable(3);
        memberTable.setWidthPercentage(100);
        memberTable.addCell("Nombre");
        memberTable.addCell("Puesto");
        memberTable.addCell("Fecha de término");
        for (IntegrantesMejoraContinuaDTO h: inme) {
            memberTable.addCell(h.getIntegrante());
            memberTable.addCell(h.getPuesto());
            memberTable.addCell(h.getFirma());
        }
        document.add(memberTable);
        document.add(new Paragraph(" "));

        // Criterios de llenado
        //document.add(new Paragraph("Criterios de llenado de formato:"));
        //document.add(new Paragraph("No dejar espacios en blanco... [Agregar criterios completos]"));





        document.close();

        return byteArrayOutputStream.toByteArray();



    }
}
