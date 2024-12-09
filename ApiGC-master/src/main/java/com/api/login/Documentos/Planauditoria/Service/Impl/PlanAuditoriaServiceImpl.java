package com.api.login.Documentos.Planauditoria.Service.Impl;

import com.api.login.Documentos.BalanceScoreCard.DTO.BalanceScoreCardDTO;
import com.api.login.Documentos.BalanceScoreCard.Service.Impl.HeaderFooterPageEventBalanceScoreCard;
import com.api.login.Documentos.Planauditoria.DTO.*;
import com.api.login.Documentos.Planauditoria.Mapper.PlanAuditoriaMapper;
import com.api.login.Documentos.Planauditoria.Pojo.PlanAuditoria;
import com.api.login.Documentos.Planauditoria.Repository.PlanAuditoriaRepository;
import com.api.login.Documentos.Planauditoria.Service.PlanAuditoriaService;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanAuditoriaServiceImpl implements PlanAuditoriaService {

    @Autowired
    private PlanAuditoriaRepository planAuditoriaRepository;

    @Autowired
    private PlanAuditoriaMapper planAuditoriaMapper;

    @Override
    public List<PlanAuditoriaDTO> findAll() {
        return planAuditoriaRepository.findAll().stream()
                .map(planAuditoriaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PlanAuditoriaDTO findById(Long id) {
        PlanAuditoria planAuditoria = planAuditoriaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Plan de Auditoría no encontrado"));
        return planAuditoriaMapper.toDTO(planAuditoria);
    }

    @Override
    public PlanAuditoriaDTO save(PlanAuditoriaDTO planAuditoriaDTO) {
        PlanAuditoria planAuditoria = planAuditoriaMapper.toEntity(planAuditoriaDTO);
        PlanAuditoria savedPlanAuditoria = planAuditoriaRepository.save(planAuditoria);
        return planAuditoriaMapper.toDTO(savedPlanAuditoria);
    }

    @Override
    public PlanAuditoriaDTO update(Long id, PlanAuditoriaDTO planAuditoriaDTO) {
        PlanAuditoria existingPlanAuditoria = planAuditoriaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Plan de Auditoría no encontrado"));

        existingPlanAuditoria.setCoDocumento(planAuditoriaDTO.getCoDocumento());
        existingPlanAuditoria.setNoRevision(planAuditoriaDTO.getNoRevision());
        existingPlanAuditoria.setFechaEmicion(planAuditoriaDTO.getFechaEmicion());
        existingPlanAuditoria.setFechaRevision(planAuditoriaDTO.getFechaRevision());

        PlanAuditoria updatedPlanAuditoria = planAuditoriaRepository.save(existingPlanAuditoria);
        return planAuditoriaMapper.toDTO(updatedPlanAuditoria);
    }

    @Override
    public void deleteById(Long id) {
        planAuditoriaRepository.deleteById(id);
    }


    @Override
    public byte[] generarBSCPdf(Long id) throws DocumentException {

        PlanAuditoriaDTO BSC = findById(id);

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
        HeaderFooterPageEventPlanAuditoria event = new HeaderFooterPageEventPlanAuditoria("Plan Auditorias",headerImage, BSC);
        writer.setPageEvent(event);


        document.open();

        List<DatosPlanAuditoriaDTO> datos = BSC.getDatosPlanAuditoriaList();

        for (DatosPlanAuditoriaDTO d: datos){

        // Objetivo de la Auditoría
        document.add(new Paragraph("Objetivo de la Auditoría: "+ d.getObjetivoAuditoria()));
        document.add(new Paragraph("No. de Auditoría: "+d.getNoAuditoria()));
        document.add(new Paragraph("Fecha de Inicio: "+ d.getFechaInicio()));
        document.add(new Paragraph("Fecha de Término: "+d.getFechaTermino()));
        document.add(new Paragraph("Fecha Elaboracion "+d.getFechaElaboracion()));
        document.add(new Paragraph(" "));

        // Alcance y Criterios
        document.add(new Paragraph("Alcance de la Auditoría:"));
        document.add(new Paragraph(d.getAlcanceAuditoria()));
        document.add(new Paragraph(" "));

        document.add(new Paragraph("Criterios de Auditoría:"));
        document.add(new Paragraph(d.getCriteriosAuditorias()));
        document.add(new Paragraph(" "));
        }



        // Equipo Auditor
        document.add(new Paragraph("Equipo Auditor:"));
        PdfPTable teamTable = new PdfPTable(3);
        teamTable.setWidthPercentage(100);
        List<EquipoAuditorPlanAuditoriaDTO> equipo = BSC.getEquipoAuditorList();
        teamTable.addCell("Auditor Líder");
        teamTable.addCell("Auditores");
        teamTable.addCell("Auditores en Entrenamiento");

        for (EquipoAuditorPlanAuditoriaDTO e: equipo){
            teamTable.addCell(e.getAuditorLider());
            teamTable.addCell(e.getAuditores());
            teamTable.addCell(e.getAuditoresEntrenamiento());
        }



        document.add(teamTable);
        document.add(new Paragraph(" "));

        // Tabla de Programación
        PdfPTable scheduleTable = new PdfPTable(6);
        scheduleTable.setWidthPercentage(100);

        List<CuerpoPlanAuditoriaDTO> cuerpo = BSC.getCuerpoPlanAuditoriaList();

        scheduleTable.addCell("Inicio");
        scheduleTable.addCell("Término");
        scheduleTable.addCell("Proceso a Auditar");
        scheduleTable.addCell("Requisitos de la Norma");
        scheduleTable.addCell("Contraparte Auditada");
        scheduleTable.addCell("Auditor");

        for (CuerpoPlanAuditoriaDTO dto: cuerpo) { // Ejemplo con 5 filas
            scheduleTable.addCell(dto.getInicio());
            scheduleTable.addCell(dto.getTermino());
            scheduleTable.addCell(dto.getProcesoAuditar());
            scheduleTable.addCell(dto.getRequisitosNorma());
            scheduleTable.addCell(dto.getContraparteAuditada());
            scheduleTable.addCell(dto.getAuditor());
        }

        document.add(scheduleTable);
        document.add(new Paragraph(" "));

        List<ObservacionesPlanAuditoriasDTO> ob = BSC.getObservacionesList();

        // Observaciones

        document.add(new Paragraph("Observaciones:"));
        document.add(new Paragraph("_________________________________________________________________________________________"));
        for (ObservacionesPlanAuditoriasDTO dto: ob){
            document.add(new Paragraph("*"+ dto.getObservacion()));
        }
        document.add(new Paragraph(" "));

        // Firmas
        PdfPTable signatureTable = new PdfPTable(2);
        signatureTable.setWidthPercentage(100);

        signatureTable.addCell("Elaboró");
        signatureTable.addCell("Autorizó");
        signatureTable.addCell("Coordinador del SGC");
        signatureTable.addCell("Director General");
        document.add(signatureTable);





        document.close();

        return byteArrayOutputStream.toByteArray();
    }
}
