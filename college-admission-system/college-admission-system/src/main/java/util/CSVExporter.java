package util;

import dao.ApplicationDAO;
import model.Application;
import java.io.FileWriter;
import java.util.List;

public class CSVExporter {
    public static void exportApplicationsToCSV(String filename, ApplicationDAO appDAO) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("ApplicationID,StudentID,CourseID,Status\n");
            List<Application> list = appDAO.getAllApplications();
            for (Application app : list) {
                writer.write(app.getId() + "," + app.getStudentId() + "," + app.getCourseId() + "," + app.getStatus() + "\n");
            }
            System.out.println("CSV file generated: " + filename);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
