package com.app.setup.service;

import com.app.setup.entity.Cliente;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.LineSeparator;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PdfServiceCliente {

    public void generarReporte(List<Cliente> clientes) throws Exception {
        // Obtener la carpeta de Descargas del usuario
        String carpetaDestino = System.getProperty("user.home") + "/Downloads/";
        File directorio = new File(carpetaDestino);
        if (!directorio.exists()) {
            directorio.mkdirs(); // Crear la carpeta si no existe
        }

        String nombreArchivo = "reporte_clientes_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".pdf";
        String rutaArchivo = carpetaDestino + nombreArchivo;

        // Crear el archivo PDF
        Document document = new Document(PageSize.A4.rotate());
        PdfWriter.getInstance(document, new FileOutputStream(rutaArchivo));

        try {
            document.open();

            // Título
            Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
            Paragraph title = new Paragraph("Reporte de Clientes", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(20);
            document.add(title);

            // Crear tabla
            PdfPTable table = new PdfPTable(11);
            table.setWidthPercentage(100);

            // Encabezados
            String[] headers = {"ID", "Nombre", "Apellido Paterno", "Apellido Materno", "Población", "Código Postal",
                    "Dirección", "Teléfono", "Persona de Contacto", "Teléfono de Contacto", "Correo de Contacto"};
            Font headerFont = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.WHITE);
            for (String header : headers) {
                PdfPCell cell = new PdfPCell(new Phrase(header, headerFont));
                cell.setBackgroundColor(BaseColor.DARK_GRAY);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setPadding(8);
                table.addCell(cell);
            }

            // Datos de los clientes
            Font cellFont = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);
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
            }

            document.add(table);

            // Pie de página
            String fechaGeneracion = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
            Paragraph footer = new Paragraph("Generado el: " + fechaGeneracion, new Font(Font.FontFamily.HELVETICA, 8, Font.ITALIC));
            footer.setAlignment(Element.ALIGN_CENTER);
            document.add(footer);

        } finally {
            document.close();
        }
    }

    // Método auxiliar para crear celdas
    private PdfPCell createCell(String text, Font font, boolean isNumeric) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setBorderWidth(1);
        cell.setBorderColor(BaseColor.LIGHT_GRAY);
        cell.setHorizontalAlignment(isNumeric ? Element.ALIGN_CENTER : Element.ALIGN_LEFT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setPadding(8);
        return cell;
    }
}
