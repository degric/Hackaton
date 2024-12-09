package com.api.login.Documentos.ConstanciaInduccion.Service.Impl;

import com.api.login.Documentos.ConstanciaInduccion.DTO.ColaboradoresConsInduDTO;
import com.api.login.Documentos.ConstanciaInduccion.DTO.ConstanciaInduccionDTO;
import com.api.login.Documentos.ConstanciaInduccion.DTO.InformacionConsInduDTO;
import com.api.login.Documentos.ConstanciaInduccion.Mapper.ConstanciaInduccionMapper;
import com.api.login.Documentos.ConstanciaInduccion.Pojo.ConstanciaInduccion;
import com.api.login.Documentos.ConstanciaInduccion.Repository.ConstanciaInduccionRepository;
import com.api.login.Documentos.ConstanciaInduccion.Service.ConstanciaInduccionService;
import com.api.login.Documentos.ProgramaAnualCapacitacion.DTO.ProAnualCapacitacionDTO;
import com.api.login.Documentos.ProgramaAnualCapacitacion.Service.Impl.HeaderFooterPageEventProgramaAnualCapacitacion;
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
public class ConstanciaInduccionServiceImpl implements ConstanciaInduccionService {

    @Autowired
    private ConstanciaInduccionRepository repository;

    @Autowired
    private ConstanciaInduccionMapper mapper;

    @Override
    public List<ConstanciaInduccionDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ConstanciaInduccionDTO findById(Long id) {
        ConstanciaInduccion entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ConstanciaInduccion no encontrada"));
        return mapper.toDTO(entity);
    }

    @Override
    public ConstanciaInduccionDTO save(ConstanciaInduccionDTO dto) {
        ConstanciaInduccion entity = mapper.toEntity(dto);
        ConstanciaInduccion savedEntity = repository.save(entity);
        return mapper.toDTO(savedEntity);
    }

    @Override
    public ConstanciaInduccionDTO update(Long id, ConstanciaInduccionDTO dto) {
        ConstanciaInduccion existingEntity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ConstanciaInduccion no encontrada"));

        existingEntity.setCoDocumento(dto.getCoDocumento());
        existingEntity.setNoRevision(dto.getNoRevision());
        existingEntity.setFechaEmicion(dto.getFechaEmicion());
        existingEntity.setFechaRevision(dto.getFechaRevision());
        existingEntity.setFecha(dto.getFecha());

        ConstanciaInduccion updatedEntity = repository.save(existingEntity);
        return mapper.toDTO(updatedEntity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public byte[] generarPdf(Long id) throws DocumentException {

        ConstanciaInduccionDTO BSC = findById(id);

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
        HeaderFooterPageEventConstanciaInduccion event = new HeaderFooterPageEventConstanciaInduccion("CONSTANCIA DE INDUCCIÓN",headerImage, BSC);
        writer.setPageEvent(event);


        document.open();


        // Fuentes
        Font titleFont = new Font(Font.HELVETICA, 16, Font.BOLD);
        Font sectionFont = new Font(Font.HELVETICA, 12, Font.BOLD);
        Font normalFont = new Font(Font.HELVETICA, 10, Font.NORMAL);

        // Declaración del Colaborador
        String textoDeclaracion = "Hago constar que recibí inducción de la información abajo mencionada del Sistema de Gestión. "
                + "Declaro en mi juicio pleno que guardaré confidencialidad de la información, así como de mis actividades "
                + "realizadas complementarias. Leída esta constancia, manifiesto mi absoluta conformidad y entendimiento. "
                + "Lo firmo el día ___"+BSC.getFecha().getDayOfMonth()+"______ del mes de ____"+BSC.getFecha().getMonth().name()+"_____ del año __"+BSC.getFecha().getYear()+"_____.";
        document.add(new Paragraph(textoDeclaracion, normalFont));
        document.add(new Paragraph(" ")); // Espacio en blanco


        List<InformacionConsInduDTO> info = BSC.getInformacionConsIndus();

        // Tabla de Información
        PdfPTable tableInformacion = new PdfPTable(3); // 3 columnas: Información, Sí, No
        tableInformacion.setWidthPercentage(100);
        tableInformacion.setWidths(new float[]{6f, 1f, 1f}); // Anchos relativos de las columnas

        tableInformacion.addCell(new PdfPCell(new Phrase("INFORMACIÓN", sectionFont)));
        tableInformacion.addCell(new PdfPCell(new Phrase("Sí", sectionFont)));
        tableInformacion.addCell(new PdfPCell(new Phrase("No", sectionFont)));

        // Añadir filas de información
        for (InformacionConsInduDTO i: info){
            tableInformacion.addCell(new PdfPCell(new Phrase(i.getInfo(), normalFont)));
            if (i.getRespuesta().equals("Si")){
                tableInformacion.addCell(new PdfPCell(new Phrase("x", normalFont)));
            }else{
                tableInformacion.addCell(new PdfPCell(new Phrase("", normalFont)));
            }
        }

        document.add(tableInformacion);
        document.add(new Paragraph(" ")); // Espacio en blanco

        // Firmas
        document.add(new Paragraph("Nombre del colaborador: __"+BSC.getColaboradorConsInduc().getNombre()+"__  Firma: _"+BSC.getColaboradorConsInduc().getFirma()+"_", normalFont));
        document.add(new Paragraph(" ")); // Espacio en blanco
        document.add(new Paragraph("Nombre y firma de los responsables que proporcionan inducción:", normalFont));
        document.add(new Paragraph(" ")); // Espacio en blanco

        List<ColaboradoresConsInduDTO> col = BSC.getColaboradoresConsIndus();

        // Tabla de Firmas
        PdfPTable tableFirmas = new PdfPTable(3); // 3 columnas: Nombre, Puesto, Firma
        tableFirmas.setWidthPercentage(100);
        tableFirmas.setWidths(new float[]{3f, 3f, 2f}); // Anchos relativos

        tableFirmas.addCell(new PdfPCell(new Phrase("NOMBRE", sectionFont)));
        tableFirmas.addCell(new PdfPCell(new Phrase("PUESTO", sectionFont)));
        tableFirmas.addCell(new PdfPCell(new Phrase("FIRMA", sectionFont)));

        for (ColaboradoresConsInduDTO co: col){
            // Ejemplo de firma
            tableFirmas.addCell(new PdfPCell(new Phrase(co.getNombre(), normalFont)));
            tableFirmas.addCell(new PdfPCell(new Phrase(co.getPuesto(), normalFont)));
            tableFirmas.addCell(new PdfPCell(new Phrase(co.getFirma(), normalFont))); // Espacio para la firma
        }
        document.add(tableFirmas);



        document.close();

        return byteArrayOutputStream.toByteArray();

    }
}
