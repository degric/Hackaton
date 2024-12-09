package com.api.login.Documentos.ReporteDeAuditoria.Service.Impl;


import com.api.login.Documentos.Planauditoria.Service.Impl.HeaderFooterPageEventPlanAuditoria;
import com.api.login.Documentos.ReporteDeAuditoria.DTO.CierreReporteAuditoria1DTO;
import com.api.login.Documentos.ReporteDeAuditoria.DTO.CierreReporteAuditoria2DTO;
import com.api.login.Documentos.ReporteDeAuditoria.DTO.HallazgoReporteAuditoriaDTO;
import com.api.login.Documentos.ReporteDeAuditoria.DTO.ReporteAuditoriaDTO;
import com.api.login.Documentos.ReporteDeAuditoria.Mapper.ReporteAuditoriaMapper;
import com.api.login.Documentos.ReporteDeAuditoria.Pojo.CierreReporteAuditoria1;
import com.api.login.Documentos.ReporteDeAuditoria.Pojo.CierreReporteAuditoria2;
import com.api.login.Documentos.ReporteDeAuditoria.Pojo.ReporteAuditoria;
import com.api.login.Documentos.ReporteDeAuditoria.Repository.ReporteAuditoriaRepository;
import com.api.login.Documentos.ReporteDeAuditoria.Service.ReporteAuditoriaService;
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
public class ReporteAuditoriaServiceImpl implements ReporteAuditoriaService {

    @Autowired
    private ReporteAuditoriaRepository reporteAuditoriaRepository;

    @Autowired
    private ReporteAuditoriaMapper reporteAuditoriaMapper;

    @Override
    public List<ReporteAuditoriaDTO> findAll() {
        return reporteAuditoriaRepository.findAll().stream()
                .map(reporteAuditoriaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReporteAuditoriaDTO findById(Long id) {
        ReporteAuditoria reporte = reporteAuditoriaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reporte de Auditoría no encontrado"));
        return reporteAuditoriaMapper.toDTO(reporte);
    }

    @Override
    public ReporteAuditoriaDTO save(ReporteAuditoriaDTO reporteAuditoriaDTO) {
        ReporteAuditoria reporte = reporteAuditoriaMapper.toEntity(reporteAuditoriaDTO);
        ReporteAuditoria savedReporte = reporteAuditoriaRepository.save(reporte);
        return reporteAuditoriaMapper.toDTO(savedReporte);
    }

    @Override
    public ReporteAuditoriaDTO update(Long id, ReporteAuditoriaDTO reporteAuditoriaDTO) {
        ReporteAuditoria existingReporte = reporteAuditoriaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reporte de Auditoría no encontrado"));

        existingReporte.setCoDocumento(reporteAuditoriaDTO.getCoDocumento());
        existingReporte.setNoRevision(reporteAuditoriaDTO.getNoRevision());
        existingReporte.setFechaEmicion(reporteAuditoriaDTO.getFechaEmicion());
        existingReporte.setFechaRevision(reporteAuditoriaDTO.getFechaRevision());

        ReporteAuditoria updatedReporte = reporteAuditoriaRepository.save(existingReporte);
        return reporteAuditoriaMapper.toDTO(updatedReporte);
    }

    @Override
    public void deleteById(Long id) {
        reporteAuditoriaRepository.deleteById(id);
    }

    @Override
    public byte[] generarPdf(Long id) throws DocumentException {

        ReporteAuditoriaDTO BSC = findById(id);

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
        HeaderFooterPageEventReporteAuditoria event = new HeaderFooterPageEventReporteAuditoria("REPORTE DE AUDITORÍA INTERNA",headerImage, BSC);
        writer.setPageEvent(event);


        document.open();


// Título
        //document.add(new Paragraph("REPORTE DE AUDITORÍA INTERNA",
        //        FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16)));
        //document.add(new Paragraph(" ")); // Espacio en blanco


        // Proceso auditado y datos adicionales
        document.add(new Paragraph("Proceso auditado: "+BSC.getInfoReporteAuditoria().getProcesoAuditado()));
        document.add(new Paragraph("Responsable del SGC: "+ BSC.getInfoReporteAuditoria().getResponSGC()));
        document.add(new Paragraph("Fecha: "+ BSC.getInfoReporteAuditoria().getFecha()));
        document.add(new Paragraph("No. de Auditoría: "+ BSC.getInfoReporteAuditoria().getNoAuditoria()));
        if (BSC.getInfoReporteAuditoria().getCalificacion().equals("Cumple")){
            document.add(new Paragraph("Calificación: Cumple __x__ No Cumple ____"));
        }else{
            document.add(new Paragraph("Calificación: Cumple ____ No Cumple __x__"));
        }
        document.add(new Paragraph(" "));

        List<CierreReporteAuditoria1DTO>  auditorlider = BSC.getCierreReporteAuditoria1List();
        List<CierreReporteAuditoria2DTO> auditor = BSC.getCierreReporteAuditoria2List();

        // Tabla de Firmas
        PdfPTable signatureTable = new PdfPTable(2);
        signatureTable.setWidthPercentage(100);
        signatureTable.addCell("NOMBRE");
        signatureTable.addCell("FIRMA");
        for (CierreReporteAuditoria1DTO d: auditorlider){
            signatureTable.addCell("Auditor líder: "+ d.getNombreAuditor());
            signatureTable.addCell(d.getFirma());
        }


        for (CierreReporteAuditoria2DTO au: auditor) {
            signatureTable.addCell("Auditor: "+ au.getNombreAuditor());
            signatureTable.addCell(au.getFirma());
        }
        document.add(signatureTable);
        document.add(new Paragraph(" "));

        List<HallazgoReporteAuditoriaDTO> hallazgo = BSC.getHallazgoReporteAuditoriaList();
        // Tabla de Hallazgos
        PdfPTable findingsTable = new PdfPTable(3);
        findingsTable.setWidthPercentage(100);
        findingsTable.addCell("Cláusula de la Norma");
        findingsTable.addCell("Tipo de Hallazgo");
        findingsTable.addCell("No Conformidad y/o Comentario");

        // Filas de ejemplo
        for (HallazgoReporteAuditoriaDTO ha: hallazgo) {
            findingsTable.addCell(ha.getClausulaNorma());
            findingsTable.addCell(ha.getTipoHallazgo());
            findingsTable.addCell(ha.getComentario());
        }

        document.add(findingsTable);
        document.add(new Paragraph(" "));

        // Notas
        //document.add(new Paragraph("Criterios de llenado de formato:"));
        //document.add(new Paragraph("No dejar espacios en blanco, marque los espacios en blanco con una línea diagonal."));
        //document.add(new Paragraph("En caso de error, coloque una línea transversal sobre el error y escriba la corrección."));
        //document.add(new Paragraph("Si no hay información: use 'Sin [dato]' o 'No Aplica' según corresponda."));






        document.close();

        return byteArrayOutputStream.toByteArray();


    }
}
