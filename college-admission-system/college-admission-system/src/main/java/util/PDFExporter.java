package util;

import dao.ApplicationDAO;
import model.Application;
import java.io.FileOutputStream;
import java.util.List;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFExporter {
    public static void exportApplicationsToPDF(String filename, ApplicationDAO appDAO) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(filename));
            document.open();
            document.add(new Paragraph("Admission Applications List"));
            document.add(new Paragraph(" "));

            PdfPTable table = new PdfPTable(4);
            table.addCell("ApplicationID");
            table.addCell("StudentID");
            table.addCell("CourseID");
            table.addCell("Status");

            List<Application> list = appDAO.getAllApplications();
            for (Application app : list) {
                table.addCell(String.valueOf(app.getId()));
                table.addCell(String.valueOf(app.getStudentId()));
                table.addCell(String.valueOf(app.getCourseId()));
                table.addCell(app.getStatus());
            }
            document.add(table);
            document.close();
            System.out.println("PDF file generated: " + filename);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
