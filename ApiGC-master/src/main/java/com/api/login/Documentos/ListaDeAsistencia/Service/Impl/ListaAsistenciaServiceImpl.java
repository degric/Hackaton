package com.api.login.Documentos.ListaDeAsistencia.Service.Impl;

import com.api.login.Documentos.ListaDeAsistencia.DTO.DatosListaAsistenciaDTO;
import com.api.login.Documentos.ListaDeAsistencia.DTO.ListaAsistenciaDTO;
import com.api.login.Documentos.ListaDeAsistencia.DTO.TablaListaAsistenciaDTO;
import com.api.login.Documentos.ListaDeAsistencia.Mapper.ListaAsistenciaMapper;
import com.api.login.Documentos.ListaDeAsistencia.Pojo.ListaAsistencia;
import com.api.login.Documentos.ListaDeAsistencia.Repository.ListaAsistenciaRepository;
import com.api.login.Documentos.ListaDeAsistencia.Service.ListaAsistenciaService;
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
public class ListaAsistenciaServiceImpl implements ListaAsistenciaService {

    @Autowired
    private ListaAsistenciaRepository listaAsistenciaRepository;

    @Autowired
    private ListaAsistenciaMapper listaAsistenciaMapper;

    @Override
    public List<ListaAsistenciaDTO> findAll() {
        return listaAsistenciaRepository.findAll().stream()
                .map(listaAsistenciaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ListaAsistenciaDTO findById(Long id) {
        ListaAsistencia listaAsistencia = listaAsistenciaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lista de Asistencia no encontrada"));
        return listaAsistenciaMapper.toDTO(listaAsistencia);
    }

    @Override
    public ListaAsistenciaDTO save(ListaAsistenciaDTO listaAsistenciaDTO) {
        ListaAsistencia listaAsistencia = listaAsistenciaMapper.toEntity(listaAsistenciaDTO);
        ListaAsistencia savedListaAsistencia = listaAsistenciaRepository.save(listaAsistencia);
        return listaAsistenciaMapper.toDTO(savedListaAsistencia);
    }

    @Override
    public ListaAsistenciaDTO update(Long id, ListaAsistenciaDTO listaAsistenciaDTO) {
        ListaAsistencia existingListaAsistencia = listaAsistenciaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lista de Asistencia no encontrada"));

        existingListaAsistencia.setCoDocumento(listaAsistenciaDTO.getCoDocumento());
        existingListaAsistencia.setNoRevision(listaAsistenciaDTO.getNoRevision());
        existingListaAsistencia.setFechaEmicion(listaAsistenciaDTO.getFechaEmicion());
        existingListaAsistencia.setFechaRevision(listaAsistenciaDTO.getFechaRevision());

        ListaAsistencia updatedListaAsistencia = listaAsistenciaRepository.save(existingListaAsistencia);
        return listaAsistenciaMapper.toDTO(updatedListaAsistencia);
    }

    @Override
    public void deleteById(Long id) {
        listaAsistenciaRepository.deleteById(id);
    }

    @Override
    public byte[] generarPdf(Long id) throws DocumentException {

        ListaAsistenciaDTO BSC = findById(id);

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
        HeaderFooterPageEventListaAsistencia event = new HeaderFooterPageEventListaAsistencia("LISTA DE ASISTENCIA",headerImage, BSC);
        writer.setPageEvent(event);


        document.open();

        DatosListaAsistenciaDTO datos = BSC.getDatosListaAsistencia();


        // Datos Generales
        document.add(new Paragraph("Departamento Coordinador: "+ datos.getDepartamentoCoordinador()));
        document.add(new Paragraph("Responsable: "+datos.getResponable()));
        document.add(new Paragraph("Título: "+datos.getTitulo()));
        document.add(new Paragraph("Fecha: "+datos.getFecha()));
        document.add(new Paragraph(" "));

        // Tabla de Asistencia
        PdfPTable attendanceTable = new PdfPTable(3);
        attendanceTable.setWidthPercentage(100);
        attendanceTable.addCell("Nombre de Participante");
        attendanceTable.addCell("Puesto");
        attendanceTable.addCell("Firma");
        List<TablaListaAsistenciaDTO> tabla = BSC.getTablaListaAsistenciaList();

        // Filas de ejemplo (pueden ser dinámicas)
        for (TablaListaAsistenciaDTO d : tabla) {
            attendanceTable.addCell(d.getNombreParticipante());
            attendanceTable.addCell(d.getPuesto());
            attendanceTable.addCell(d.getFirma());
        }

        document.add(attendanceTable);




        document.close();

        return byteArrayOutputStream.toByteArray();

    }
}
