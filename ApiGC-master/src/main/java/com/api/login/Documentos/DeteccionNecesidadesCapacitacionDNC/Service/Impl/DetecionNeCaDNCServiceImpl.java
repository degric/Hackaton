package com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Service.Impl;

import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.DTO.*;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Dao.DetecionNeCaDNCRepository;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Mapper.DetecionNeCaDNCMapper;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Pojo.DatosGeneralesDNC;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Pojo.DetecionNeCaDNC;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Pojo.Preguntas2DNC;
import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Service.*;
import com.api.login.Documentos.ListaDeAsistencia.DTO.DatosListaAsistenciaDTO;
import com.api.login.Documentos.ListaDeAsistencia.DTO.ListaAsistenciaDTO;
import com.api.login.Documentos.ListaDeAsistencia.DTO.TablaListaAsistenciaDTO;
import com.api.login.Documentos.ListaDeAsistencia.Service.Impl.HeaderFooterPageEventListaAsistencia;
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
public class DetecionNeCaDNCServiceImpl implements DetecionNeCaDNCService {

    @Autowired
    private DetecionNeCaDNCRepository repository;

    @Autowired
    private DetecionNeCaDNCMapper mapper;

    @Override
    public List<DetecionNeCaDNCDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DetecionNeCaDNCDTO findById(Long id) {
        DetecionNeCaDNC entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Detección de Necesidades no encontrada"));
        return mapper.toDTO(entity);
    }

    @Override
    public DetecionNeCaDNCDTO save(DetecionNeCaDNCDTO detecionNeCaDNCDTO) {
        DetecionNeCaDNC entity = mapper.toEntity(detecionNeCaDNCDTO);
        DetecionNeCaDNC savedEntity = repository.save(entity);
        return mapper.toDTO(savedEntity);
    }

    @Override
    public DetecionNeCaDNCDTO update(Long id, DetecionNeCaDNCDTO detecionNeCaDNCDTO) {
        DetecionNeCaDNC existingEntity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Detección de Necesidades no encontrada"));

        existingEntity.setCoDocumento(detecionNeCaDNCDTO.getCoDocumento());
        existingEntity.setNoRevision(detecionNeCaDNCDTO.getNoRevision());
        existingEntity.setFechaEmicion(detecionNeCaDNCDTO.getFechaEmicion());
        existingEntity.setFechaRevision(detecionNeCaDNCDTO.getFechaRevision());

        DetecionNeCaDNC updatedEntity = repository.save(existingEntity);
        return mapper.toDTO(updatedEntity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public byte[] generarPdf(Long id) throws DocumentException {

        DetecionNeCaDNCDTO BSC = findById(id);

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
        HeaderFooterPageEventDNC event = new HeaderFooterPageEventDNC("DETECCIÓN DE NECESIDADES DE CAPACITACIÓN",headerImage, BSC);
        writer.setPageEvent(event);


        document.open();

// Fuentes
        Font titleFont = new Font(Font.HELVETICA, 16, Font.BOLD);
        Font sectionFont = new Font(Font.HELVETICA, 12, Font.BOLD);
        Font normalFont = new Font(Font.HELVETICA, 12, Font.NORMAL);

        document.add(new Paragraph("PROPÓSITO: El objetivo de este cuestionario es detectar las necesidades de capacitación que son necesarias para el buen desempeño de tu trabajo. Los resultados serán utilizados para diseñar nuestro programa de capacitación.\n", normalFont));

        // Criterios de Llenado
        //document.add(new Paragraph("C R I T E R I O S   D E   L L E N A D O", sectionFont));
        //document.add(new Paragraph("No dejar espacios en blanco, marque los espacios en blanco con una línea diagonal. Si se equivoca coloque una línea transversal sobre el error y enseguida escriba la frase o palabra correcta seguida de su firma.", normalFont));
        //document.add(new Paragraph("Si en algún registro no existe información se le coloca la palabra \"Sin\" seguida de la palabra del registro solicitado Ej. \"Sin serie\", \"Sin modelo\". Si no dispone de algún registro solicitado se le coloca la leyenda \"No Aplica\".", normalFont));
        document.add(new Paragraph(" "));


        DatosGeneralesDNCDTO datosGener = BSC.getDatosGeneralesDNC();
        DatosJefeInmediatoDNCDTO datosJefe = BSC.getDatosJefeInmediatoDNC();

        // Datos Generales
        PdfPTable datosGeneralesTable = new PdfPTable(2);
        datosGeneralesTable.setWidthPercentage(100);
        datosGeneralesTable.addCell(new PdfPCell(new Phrase("D A T O S   G E N E R A L E S", sectionFont)));
        datosGeneralesTable.addCell(new PdfPCell(new Phrase("D A T O S   D E L   J E F E   I N M E D I A T O", sectionFont)));

        datosGeneralesTable.addCell(new PdfPCell(new Phrase("NOMBRE: "+ datosGener.getNombre(), normalFont)));
        datosGeneralesTable.addCell(new PdfPCell(new Phrase("NOMBRE: "+ datosJefe.getNombre(), normalFont)));

        datosGeneralesTable.addCell(new PdfPCell(new Phrase("PUESTO: "+ datosGener.getPuesto(), normalFont)));
        datosGeneralesTable.addCell(new PdfPCell(new Phrase("PUESTO: "+ datosJefe.getPuesto(), normalFont)));

        datosGeneralesTable.addCell(new PdfPCell(new Phrase("ANTIGÜEDAD EN LA EMPRESA: "+ datosGener.getAntiguedadEmpresa(), normalFont)));
        datosGeneralesTable.addCell(new PdfPCell(new Phrase("ÁREA: "+ datosJefe.getArea(), normalFont)));

        datosGeneralesTable.addCell(new PdfPCell(new Phrase("ANTIGÜEDAD EN EL PUESTO: "+ datosGener.getAntiguedadPuesto(), normalFont)));
        datosGeneralesTable.addCell(new PdfPCell(new Phrase("FECHA: "+ datosJefe.getFecha(), normalFont)));

        datosGeneralesTable.addCell(new PdfPCell(new Phrase("ESCOLARIDAD: "+datosGener.getEscolaridad(), normalFont)));
        datosGeneralesTable.addCell(new PdfPCell(new Phrase(" ", normalFont))); // Celda vacía
        document.add(datosGeneralesTable);

        document.add(new Paragraph(" "));

        // Preguntas de Conocimientos
        PdfPTable conocimientosTable = new PdfPTable(3);
        conocimientosTable.setWidthPercentage(100);
        conocimientosTable.addCell(new PdfPCell(new Phrase("¿Qué CONOCIMIENTOS necesitas para HACER mejor tu trabajo? (Lo que deberías conocer)", sectionFont)));
        conocimientosTable.addCell(new PdfPCell(new Phrase("¿Por qué consideras que requieres APRENDER esos conocimientos?", sectionFont)));
        conocimientosTable.addCell(new PdfPCell(new Phrase("¿En qué mejorarías tu DESEMPEÑO al capacitarte en dichos conocimientos?", sectionFont)));

        List<Pregunta1DNCDTO> preguntas1 = BSC.getPreguntas1DNC();

        for (Pregunta1DNCDTO pre1: preguntas1){
            conocimientosTable.addCell(new PdfPCell(new Phrase(pre1.getContenido1(), normalFont)));
            conocimientosTable.addCell(new PdfPCell(new Phrase(pre1.getContenido2(), normalFont)));
            conocimientosTable.addCell(new PdfPCell(new Phrase(pre1.getContenido3(), normalFont)));

        }
        document.add(conocimientosTable);
        document.add(new Paragraph(" "));

        // Preguntas de Habilidades
        PdfPTable habilidadesTable = new PdfPTable(3);
        habilidadesTable.setWidthPercentage(100);
        habilidadesTable.addCell(new PdfPCell(new Phrase("¿Qué HABILIDADES necesitas tener para que PUEDAS HACER mejor tu trabajo? (Lo que deberías saber hacer)", sectionFont)));
        habilidadesTable.addCell(new PdfPCell(new Phrase("¿Por qué consideras que requieres aprender estas habilidades?", sectionFont)));
        habilidadesTable.addCell(new PdfPCell(new Phrase("¿En qué mejorarías tu desempeño al capacitarte en estas habilidades?", sectionFont)));

        List<Preguntas2DNCDTO> pre2 = BSC.getPreguntas2DNC();
        for (Preguntas2DNCDTO r: pre2){
            habilidadesTable.addCell(new PdfPCell(new Phrase(r.getContenido1(), normalFont)));
            habilidadesTable.addCell(new PdfPCell(new Phrase(r.getContenido2(), normalFont)));
            habilidadesTable.addCell(new PdfPCell(new Phrase(r.getContenido3(), normalFont))); // Celda vacía

        }

        document.add(habilidadesTable);
        document.add(new Paragraph(" "));

        // Notas de Cambios
        PdfPTable cambiosTable = new PdfPTable(3);
        cambiosTable.setWidthPercentage(100);
        cambiosTable.addCell(new PdfPCell(new Phrase("FECHA DE CAMBIO", sectionFont)));
        cambiosTable.addCell(new PdfPCell(new Phrase("Ed / Rev.", sectionFont)));
        cambiosTable.addCell(new PdfPCell(new Phrase("CAMBIOS REALIZADOS A LA VERSIÓN ANTERIOR", sectionFont)));

        cambiosTable.addCell(new PdfPCell(new Phrase(" ", normalFont))); // Celda vacía
        cambiosTable.addCell(new PdfPCell(new Phrase(" ", normalFont))); // Celda vacía
        cambiosTable.addCell(new PdfPCell(new Phrase(" ", normalFont))); // Celda vacía

        document.add(cambiosTable);

        document.close();

        return byteArrayOutputStream.toByteArray();

    }


}
