package com.api.login.Documentos.BalanceScoreCard.Service.Impl;

import com.api.login.Documentos.BalanceScoreCard.DTO.BalanceScoreCardDTO;
import com.api.login.Documentos.BalanceScoreCard.Mapper.BalanceScoreCardMapper;
import com.api.login.Documentos.BalanceScoreCard.Pojo.BalanceScoreCard;
import com.api.login.Documentos.BalanceScoreCard.Repository.BalanceScoreCardRepository;
import com.api.login.Documentos.BalanceScoreCard.Service.BalanceScoreCardService;
import com.api.login.Documentos.MinutaDeReunion.Service.Impl.HeaderFooterPageEventMinutaReunion;
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
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BalanceScoreCardServiceImpl implements BalanceScoreCardService {

    @Autowired
    private BalanceScoreCardRepository balanceScoreCardRepository;

    @Autowired
    private BalanceScoreCardMapper balanceScoreCardMapper;

    @Override
    public List<BalanceScoreCardDTO> findAll() {
        return balanceScoreCardRepository.findAll().stream()
                .map(balanceScoreCardMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BalanceScoreCardDTO findById(Long id) {
        BalanceScoreCard balanceScoreCard = balanceScoreCardRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Balance Score Card no encontrado"));
        return balanceScoreCardMapper.toDTO(balanceScoreCard);
    }

    @Override
    public BalanceScoreCardDTO save(BalanceScoreCardDTO balanceScoreCardDTO) {
        BalanceScoreCard balanceScoreCard = balanceScoreCardMapper.toEntity(balanceScoreCardDTO);
        BalanceScoreCard savedBalanceScoreCard = balanceScoreCardRepository.save(balanceScoreCard);
        return balanceScoreCardMapper.toDTO(savedBalanceScoreCard);
    }

    @Override
    public BalanceScoreCardDTO update(Long id, BalanceScoreCardDTO balanceScoreCardDTO) {
        BalanceScoreCard existingBalanceScoreCard = balanceScoreCardRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Balance Score Card no encontrado"));

        existingBalanceScoreCard.setCoDocumento(balanceScoreCardDTO.getCoDocumento());
        existingBalanceScoreCard.setNoRevision(balanceScoreCardDTO.getNoRevision());
        existingBalanceScoreCard.setFechaEmicion(balanceScoreCardDTO.getFechaEmicion());
        existingBalanceScoreCard.setFechaRevision(balanceScoreCardDTO.getFechaRevision());

        BalanceScoreCard updatedBalanceScoreCard = balanceScoreCardRepository.save(existingBalanceScoreCard);
        return balanceScoreCardMapper.toDTO(updatedBalanceScoreCard);
    }

    @Override
    public void deleteById(Long id) {
        balanceScoreCardRepository.deleteById(id);
    }

    @Override
    public byte[] generarBSCPdf(Long id) throws DocumentException {

        BalanceScoreCardDTO BSC = findById(id);

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
        HeaderFooterPageEventBalanceScoreCard event = new HeaderFooterPageEventBalanceScoreCard("BALANCE SCORE CARD",headerImage, BSC);
        writer.setPageEvent(event);


        document.open();

        // Formato de fuentes
        Font titleFont = new Font(Font.HELVETICA, 16, Font.BOLD);
        Font headerFont = new Font(Font.HELVETICA, 12, Font.BOLD);
        Font normalFont = new Font(Font.HELVETICA, 12, Font.NORMAL);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        document.add(new Paragraph(" Hola Mundo")); // Espacio en blanco



        // Crear una tabla con 4 columnas
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100); // Ancho al 100% de la página

        // Encabezados
        table.addCell("Prespectiva");
        table.addCell("Partes Interesadas");
        table.addCell("InteresPI");
        table.addCell("InfluenciaPI");

        // Primera fila con fusión vertical
        PdfPCell prespectivaCell = new PdfPCell(new Paragraph("Perspectiva A"));
        prespectivaCell.setRowspan(1); // Fusión en el eje Y (2 filas)
        table.addCell(prespectivaCell);

        // Celdas correspondientes a la primera fila
        table.addCell("Parte Interesada 1");
        table.addCell("Alto");
        table.addCell("Alta");

        // Segunda fila con celda fusionada
        table.addCell("Parte Interesada 2");
        table.addCell("Medio");
        table.addCell("Media");

        // Añadir más filas según sea necesario
        table.addCell("Perspectiva B");
        table.addCell("Parte Interesada 3");
        table.addCell("Bajo");
        table.addCell("Baja");

        document.add(table);


        document.close();

        return byteArrayOutputStream.toByteArray();
    }
}
