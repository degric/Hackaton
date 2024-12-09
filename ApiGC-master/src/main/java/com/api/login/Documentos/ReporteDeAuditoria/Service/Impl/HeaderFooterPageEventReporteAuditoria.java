package com.api.login.Documentos.ReporteDeAuditoria.Service.Impl;

import com.api.login.Documentos.Planauditoria.DTO.PlanAuditoriaDTO;
import com.api.login.Documentos.ReporteDeAuditoria.DTO.ReporteAuditoriaDTO;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfWriter;

public class HeaderFooterPageEventReporteAuditoria extends PdfPageEventHelper {

    private String headerText;
    private Image headerImage;
    private ReporteAuditoriaDTO listado;

    public HeaderFooterPageEventReporteAuditoria(String headerText, Image headerImage, ReporteAuditoriaDTO datos) {
        this.headerText = headerText;
        this.headerImage = headerImage;
        this.listado = datos;
    }

    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        addHeader(writer, document);
        // Si deseas agregar un pie de página, puedes llamar a un método addFooter aquí
    }

    private void addHeader(PdfWriter writer, Document document) {
        try {
            // Configurar la fuente y estilos
            Font headerFont = new Font(Font.HELVETICA, 12, Font.BOLD);

            // Crear una tabla para el encabezado
            PdfPTable headerTable = new PdfPTable(3);
            headerTable.setTotalWidth(document.getPageSize().getWidth() - document.leftMargin() - document.rightMargin());
            headerTable.setWidths(new int[]{1, 3,1});
            headerTable.setLockedWidth(true);

            //headerTable.getDefaultCell().setFixedHeight(30);//tamaño de la celdas
            //headerTable.getDefaultCell();
            //.setBorder(Rectangle.NO_BORDER)

            // Agregar imagen al encabezado (si existe)
            if (headerImage != null) {
                PdfPCell imageCell = new PdfPCell(headerImage, true);
                //imageCell.setBorder(Rectangle.NO_BORDER);
                imageCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                imageCell.setPadding(0);
                headerTable.addCell(imageCell);
            } else {
                // Si no hay imagen, agregar una celda vacía
                PdfPCell emptyCell = new PdfPCell();
                //emptyCell.setBorder(Rectangle.NO_BORDER);
                headerTable.addCell(emptyCell);
            }

            // Agregar texto al encabezado
            PdfPCell textCell = new PdfPCell(new Phrase(headerText, headerFont));
            //textCell.setBorder(Rectangle.NO_BORDER);
            textCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            textCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            //textCell.setPadding(0);
            headerTable.addCell(textCell);

            //PArte de datos extra
            PdfPTable Table = new PdfPTable(2);

            PdfPCell celda1 = new PdfPCell(new Phrase(listado.getCoDocumento()));
            celda1.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda1.setColspan(2);
            Table.addCell(celda1);


            PdfPCell celda2 = new PdfPCell(new Phrase("Emisión:"));
            Table.addCell(celda2);

            PdfPCell celda5 = new PdfPCell(new Phrase(listado.getFechaEmicion().toString()));
            Table.addCell(celda5);

            PdfPCell celda3 = new PdfPCell(new Phrase("Revisión:"));
            Table.addCell(celda3);
            PdfPCell celda4 = new PdfPCell(new Phrase(listado.getFechaRevision().toString()));
            Table.addCell(celda4);

            PdfPCell celda6 = new PdfPCell(new Phrase("No. de Revisión:"));
            Table.addCell(celda6);
            PdfPCell celda7 = new PdfPCell(new Phrase(listado.getNoRevision()));
            Table.addCell(celda7);



            // Agregar texto la tabla de datos
            PdfPCell textCell2 = new PdfPCell(Table);
            //textCell2.setBorder(Rectangle.NO_BORDER);
            textCell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            textCell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            //textCell2.setPadding(0);
            headerTable.addCell(textCell2);

            // Escribir la tabla en la posición del encabezado
            headerTable.writeSelectedRows(0, -1, document.leftMargin(), document.top() + headerTable.getTotalHeight(), writer.getDirectContent());

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
