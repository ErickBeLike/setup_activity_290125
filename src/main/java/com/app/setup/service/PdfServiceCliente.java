package com.app.setup.service;

import com.app.setup.entity.Cliente;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.LineSeparator;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PdfServiceCliente {

    public void generarReporte(List<Cliente> clientes, HttpServletResponse response) throws Exception {
        // Configuración de la respuesta HTTP para descargar el archivo
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=reporte_clientes.pdf");
        ServletOutputStream outputStream = response.getOutputStream();

        // Crear documento PDF con orientación horizontal (landscape)
        Document document = new Document(PageSize.A4.rotate());
        PdfWriter.getInstance(document, outputStream);
        document.open();

        // Título del PDF
        Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
        Paragraph title = new Paragraph("Reporte de Clientes", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        title.setSpacingAfter(20);
        document.add(title);

        // Crear tabla para mostrar los datos de los clientes
        PdfPTable table = new PdfPTable(12);  // 12 columnas
        table.setWidthPercentage(100);

        // Establecer la fuente para las celdas
        Font headerFont = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.WHITE);
        Font cellFont = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);

        // Encabezados de la tabla
        String[] headers = {"ID", "Nombre", "Apellido Paterno", "Apellido Materno", "Población", "Código Postal", "Dirección", "Teléfono", "Persona de Contacto", "Teléfono de Contacto", "Correo de Contacto", "Acciones"};
        for (String header : headers) {
            PdfPCell cell = new PdfPCell(new Phrase(header, headerFont));
            cell.setBackgroundColor(BaseColor.DARK_GRAY);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPadding(8);
            table.addCell(cell);
        }

        // Añadir los datos de cada cliente
        for (Cliente cliente : clientes) {
            table.addCell(createCell(String.valueOf(cliente.getIdCliente()), cellFont, true));
            table.addCell(createCell(cliente.getNombre(), cellFont, false));
            table.addCell(createCell(cliente.getApellidoPa(), cellFont, false));
            table.addCell(createCell(cliente.getApellidoMa(), cellFont, false));
            table.addCell(createCell(cliente.getPoblacion(), cellFont, false));
            table.addCell(createCell(cliente.getCodigoPostal(), cellFont, true));
            table.addCell(createCell(cliente.getDireccion(), cellFont, false));
            table.addCell(createCell(cliente.getTelefono(), cellFont, true));
            table.addCell(createCell(cliente.getPersonaContacto(), cellFont, false));
            table.addCell(createCell(cliente.getTelefonoContacto(), cellFont, true));
            table.addCell(createCell(cliente.getCorreoContacto(), cellFont, false));
            table.addCell(createCell("", cellFont, false));  // Columna de acciones
        }

        // Agregar la tabla al documento
        document.add(table);

        // Añadir una línea divisoria
        document.add(new Chunk(Chunk.NEWLINE));
        LineSeparator line = new LineSeparator();
        line.setPercentage(100);
        document.add(line);

        // Pie de página (fecha de generación del reporte)
        Paragraph footer = new Paragraph("Generado el: " + new java.util.Date(), new Font(Font.FontFamily.HELVETICA, 8, Font.ITALIC));
        footer.setAlignment(Element.ALIGN_CENTER);
        document.add(footer);

        // Cerrar el documento
        document.close();
    }

    // Método para crear celdas con bordes, alineación personalizada y sombra
    private PdfPCell createCell(String text, Font font, boolean isNumeric) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setBorderWidth(1);
        cell.setBorderColor(BaseColor.LIGHT_GRAY);
        cell.setHorizontalAlignment(isNumeric ? Element.ALIGN_CENTER : Element.ALIGN_LEFT);  // Numeros centrados
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setPadding(10);
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);  // Sombra ligera en las celdas
        return cell;
    }
}
