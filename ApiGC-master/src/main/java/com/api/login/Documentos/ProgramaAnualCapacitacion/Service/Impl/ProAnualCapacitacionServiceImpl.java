package com.api.login.Documentos.ProgramaAnualCapacitacion.Service.Impl;

import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.DTO.DetecionNeCaDNCDTO;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Service.Impl.HeaderFooterPageEventDNC;
import com.api.login.Documentos.ProgramaAnualCapacitacion.DTO.ProAnualCapacitacionDTO;
import com.api.login.Documentos.ProgramaAnualCapacitacion.DTO.TablaProAnualCapacitacionDTO;
import com.api.login.Documentos.ProgramaAnualCapacitacion.Mapper.ProAnualCapacitacionMapper;
import com.api.login.Documentos.ProgramaAnualCapacitacion.Pojo.ProAnualCapacitacion;
import com.api.login.Documentos.ProgramaAnualCapacitacion.Repository.ProAnualCapacitacionRepository;
import com.api.login.Documentos.ProgramaAnualCapacitacion.Service.ProAnualCapacitacionService;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
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
public class ProAnualCapacitacionServiceImpl implements ProAnualCapacitacionService {

    @Autowired
    private ProAnualCapacitacionRepository repository;

    @Autowired
    private ProAnualCapacitacionMapper mapper;

    @Override
    public List<ProAnualCapacitacionDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProAnualCapacitacionDTO findById(Long id) {
        ProAnualCapacitacion entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ProAnualCapacitacion no encontrada"));
        return mapper.toDTO(entity);
    }

    @Override
    public ProAnualCapacitacionDTO save(ProAnualCapacitacionDTO dto) {
        ProAnualCapacitacion entity = mapper.toEntity(dto);
        ProAnualCapacitacion savedEntity = repository.save(entity);
        return mapper.toDTO(savedEntity);
    }

    @Override
    public ProAnualCapacitacionDTO update(Long id, ProAnualCapacitacionDTO dto) {
        ProAnualCapacitacion existingEntity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ProAnualCapacitacion no encontrada"));

        existingEntity.setCoDocumento(dto.getCoDocumento());
        existingEntity.setNoRevision(dto.getNoRevision());
        existingEntity.setFechaEmicion(dto.getFechaEmicion());
        existingEntity.setFechaRevision(dto.getFechaRevision());

        ProAnualCapacitacion updatedEntity = repository.save(existingEntity);
        return mapper.toDTO(updatedEntity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }


    @Override
    public byte[] generarPdf(Long id) throws DocumentException {

        ProAnualCapacitacionDTO BSC = findById(id);

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
        HeaderFooterPageEventProgramaAnualCapacitacion event = new HeaderFooterPageEventProgramaAnualCapacitacion("PROGRAMA ANUAL DE CAPACITACIÓN",headerImage, BSC);
        writer.setPageEvent(event);


        document.open();

        // Fuentes
        Font titleFont = new Font(Font.HELVETICA, 16, Font.BOLD);
        Font sectionFont = new Font(Font.HELVETICA, 12, Font.BOLD);
        Font normalFont = new Font(Font.HELVETICA, 10, Font.NORMAL);


        List<TablaProAnualCapacitacionDTO> datos = BSC.getTablasProAnualCapacitacion();

        // Tabla de Cursos Programados
        PdfPTable tableCursos = new PdfPTable(7); // Número de columnas
        tableCursos.setWidthPercentage(100);
        tableCursos.setWidths(new float[]{1f, 3f, 3f, 2f, 3f, 2f, 2f}); // Anchos relativos

        // Encabezados de la tabla
        tableCursos.addCell(new PdfPCell(new Phrase("ITEM", sectionFont)));
        tableCursos.addCell(new PdfPCell(new Phrase("TÍTULO DEL CURSO", sectionFont)));
        tableCursos.addCell(new PdfPCell(new Phrase("PERSONAL/DEPARTAMENTO", sectionFont)));
        tableCursos.addCell(new PdfPCell(new Phrase("TIPO", sectionFont)));
        tableCursos.addCell(new PdfPCell(new Phrase("CAPACITADOR", sectionFont)));
        tableCursos.addCell(new PdfPCell(new Phrase("DURACIÓN", sectionFont)));
        tableCursos.addCell(new PdfPCell(new Phrase("ESTATUS", sectionFont)));

        int registroNumero = 1; // Inicializa el contador

        for (TablaProAnualCapacitacionDTO d: datos){
            // Añadir filas con datos de ejemplo
            tableCursos.addCell(new PdfPCell(new Phrase(String.valueOf(registroNumero), normalFont)));
            tableCursos.addCell(new PdfPCell(new Phrase(d.getTitulo(), normalFont)));
            tableCursos.addCell(new PdfPCell(new Phrase(d.getPerDepartamento(), normalFont)));
            tableCursos.addCell(new PdfPCell(new Phrase(d.getTipo(), normalFont)));
            tableCursos.addCell(new PdfPCell(new Phrase(d.getCapacitador(), normalFont)));
            tableCursos.addCell(new PdfPCell(new Phrase(d.getDuracion(), normalFont)));
            tableCursos.addCell(new PdfPCell(new Phrase(d.getEstatus(), normalFont)));

            registroNumero++; // Incrementa el contador para la siguiente fila
        }

        // Repite la lógica para más cursos
        document.add(tableCursos);

        document.add(new Paragraph(" "));

        // Tabla de Especificaciones (Meses y Semanas)
        PdfPTable tableEspecificaciones = new PdfPTable(13); // 13 columnas para los meses y semanas
        tableEspecificaciones.setWidthPercentage(100);

        // Encabezados de los meses
        tableEspecificaciones.addCell(new PdfPCell(new Phrase("ENERO", sectionFont)));
        tableEspecificaciones.addCell(new PdfPCell(new Phrase("FEBRERO", sectionFont)));
        tableEspecificaciones.addCell(new PdfPCell(new Phrase("MARZO", sectionFont)));
        tableEspecificaciones.addCell(new PdfPCell(new Phrase("ABRIL", sectionFont)));
        tableEspecificaciones.addCell(new PdfPCell(new Phrase("MAYO", sectionFont)));
        tableEspecificaciones.addCell(new PdfPCell(new Phrase("JUNIO", sectionFont)));
        tableEspecificaciones.addCell(new PdfPCell(new Phrase("JULIO", sectionFont)));
        tableEspecificaciones.addCell(new PdfPCell(new Phrase("AGOSTO", sectionFont)));
        tableEspecificaciones.addCell(new PdfPCell(new Phrase("SEPTIEMBRE", sectionFont)));
        tableEspecificaciones.addCell(new PdfPCell(new Phrase("OCTUBRE", sectionFont)));
        tableEspecificaciones.addCell(new PdfPCell(new Phrase("NOVIEMBRE", sectionFont)));
        tableEspecificaciones.addCell(new PdfPCell(new Phrase("DICIEMBRE", sectionFont)));

        // Filas de ejemplo (semanas marcadas)
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 12; j++) {
                if ((i + j) % 2 == 0) {
                    tableEspecificaciones.addCell(new PdfPCell(new Phrase("X", normalFont))); // Semana marcada
                } else {
                    tableEspecificaciones.addCell(new PdfPCell(new Phrase(" ", normalFont))); // Semana vacía
                }
            }
        }

        document.add(tableEspecificaciones);


        document.close();

        return byteArrayOutputStream.toByteArray();

    }


}
