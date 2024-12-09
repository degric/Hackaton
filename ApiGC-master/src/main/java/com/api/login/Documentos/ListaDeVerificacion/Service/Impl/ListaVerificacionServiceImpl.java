package com.api.login.Documentos.ListaDeVerificacion.Service.Impl;

import com.api.login.Documentos.ListaDeVerificacion.DTO.ListaVerificacionDTO;
import com.api.login.Documentos.ListaDeVerificacion.DTO.ListaVerificacionTablaDTO;
import com.api.login.Documentos.ListaDeVerificacion.Mapper.ListaVerificacionMapper;
import com.api.login.Documentos.ListaDeVerificacion.Pojo.ListaVerificacion;
import com.api.login.Documentos.ListaDeVerificacion.Pojo.ListaVerificacionTabla;
import com.api.login.Documentos.ListaDeVerificacion.Repository.ListaVerificacionRepository;
import com.api.login.Documentos.ListaDeVerificacion.Service.ListaVerificacionService;
import com.api.login.Documentos.Planauditoria.DTO.PlanAuditoriaDTO;
import com.api.login.Documentos.Planauditoria.Service.Impl.HeaderFooterPageEventPlanAuditoria;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListaVerificacionServiceImpl implements ListaVerificacionService {

    @Autowired
    private ListaVerificacionRepository listaVerificacionRepository;

    @Autowired
    private ListaVerificacionMapper listaVerificacionMapper;

    @Override
    public List<ListaVerificacionDTO> findAll() {
        return listaVerificacionRepository.findAll().stream()
                .map(listaVerificacionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ListaVerificacionDTO findById(Long id) {
        ListaVerificacion listaVerificacion = listaVerificacionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lista de verificación no encontrada"));
        return listaVerificacionMapper.toDTO(listaVerificacion);
    }

    @Override
    public ListaVerificacionDTO save(ListaVerificacionDTO listaVerificacionDTO) {
        ListaVerificacion listaVerificacion = listaVerificacionMapper.toEntity(listaVerificacionDTO);
        ListaVerificacion savedListaVerificacion = listaVerificacionRepository.save(listaVerificacion);
        return listaVerificacionMapper.toDTO(savedListaVerificacion);
    }

    @Override
    public ListaVerificacionDTO update(Long id, ListaVerificacionDTO listaVerificacionDTO) {
        ListaVerificacion existingListaVerificacion = listaVerificacionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lista de verificación no encontrada"));

        existingListaVerificacion.setCoDocumento(listaVerificacionDTO.getCoDocumento());
        existingListaVerificacion.setNoRevision(listaVerificacionDTO.getNoRevision());
        existingListaVerificacion.setFechaEmicion(listaVerificacionDTO.getFechaEmicion());
        existingListaVerificacion.setFechaRevision(listaVerificacionDTO.getFechaRevision());

        ListaVerificacion updatedListaVerificacion = listaVerificacionRepository.save(existingListaVerificacion);
        return listaVerificacionMapper.toDTO(updatedListaVerificacion);
    }

    @Override
    public void deleteById(Long id) {
        listaVerificacionRepository.deleteById(id);
    }

    @Override
    public byte[] generarBSCPdf(Long id) throws DocumentException {

        ListaVerificacionDTO BSC = findById(id);

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
        HeaderFooterPageEventListaDeVerificacion event = new HeaderFooterPageEventListaDeVerificacion("Listado de Verificacion",headerImage, BSC);
        writer.setPageEvent(event);


        document.open();


        // Título
        document.add(new Paragraph("LISTA DE VERIFICACIÓN - ISO 9001:2015",
                FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16)));
        document.add(new Paragraph(" "));

        // Información General
        document.add(new Paragraph("Proceso(s): Calidad, Embarques, Ventas y RH"));
        document.add(new Paragraph("Auditados: Jefes de Área"));
        document.add(new Paragraph("Auditor: Axel Colín / Eduardo Pérez"));
        document.add(new Paragraph("Documentos de referencia: Procesos del Área"));
        document.add(new Paragraph("Fecha: 31/07/24 al 01/08/24"));
        document.add(new Paragraph("Auditoría: Interna"));
        document.add(new Paragraph(" "));

        // Encabezados de tabla para los criterios de auditoría
        PdfPTable table = new PdfPTable(8); // 5 columnas: Contexto, C, NCM, NCm, OM
        table.setWidthPercentage(100);
        table.addCell("No.");
        table.addCell("Contexto de la Organización");
        table.addCell("N/A");
        table.addCell("C");
        table.addCell("NCM");
        table.addCell("NCm");
        table.addCell("OM");
        table.addCell("EVIDENCIAS / HALLAZGOS");

        List<ListaVerificacionTablaDTO> tabla = BSC.getListaVerificacionTablas();
        // Filas de ejemplo (puedes reemplazar esto con datos dinámicos)
        for (ListaVerificacionTablaDTO t: tabla) {
            table.addCell(t.getNumero());
            table.addCell(t.getContextoOrganizacion());

            if (t.getMarcador().equals("N/A")){
                table.addCell("x");
            }else{
                table.addCell(" ");
            }
            if (t.getMarcador().equals("C")){
                table.addCell("x");
            }else{
                table.addCell(" ");
            }
            if (t.getMarcador().equals("NCM")){
                table.addCell("x");
            }else{
                table.addCell(" ");
            }
            if (t.getMarcador().equals("NCm")){
                table.addCell("x");
            }else{
                table.addCell(" ");
            }
            if (t.getMarcador().equals("OM")){
                table.addCell("x");
            }else{
                table.addCell(" ");
            }

            if (t.getEvidenciasAllasgos().isEmpty()){
                table.addCell(" ");
            }else {
                table.addCell(t.getEvidenciasAllasgos());
            }

        }

        // Añadir la tabla al documento
        document.add(table);

        // Sección de Evidencias / Hallazgos
        document.add(new Paragraph("Evidencias / Hallazgos:"));
        document.add(new Paragraph("[Escribe aquí las evidencias halladas durante la auditoría]"));





        document.close();

        return byteArrayOutputStream.toByteArray();
    }


}

