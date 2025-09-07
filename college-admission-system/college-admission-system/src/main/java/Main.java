import java.util.Scanner;
import dao.StudentDAO;
import dao.ApplicationDAO;
import service.AdmissionService;
import model.Student;
import util.CSVExporter;
import util.PDFExporter;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAO studentDAO = new StudentDAO();
        ApplicationDAO applicationDAO = new ApplicationDAO();
        AdmissionService admissionService = new AdmissionService();

        while (true) {
            System.out.println("\n--- College Admission System ---");
            System.out.println("1. Register Student");
            System.out.println("2. Apply for Course");
            System.out.println("3. Process Admission");
            System.out.println("4. View Applications");
            System.out.println("5. Export Admission List (CSV/PDF)");
            System.out.println("6. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.next();
                    System.out.print("Enter email: ");
                    String email = sc.next();
                    System.out.print("Enter marks: ");
                    int marks = sc.nextInt();
                    Student s = new Student();
                    s.setName(name); s.setEmail(email); s.setMarks(marks);
                    studentDAO.addStudent(s);
                    break;

                case 2:
                    System.out.print("Enter studentId: ");
                    int sid = sc.nextInt();
                    System.out.print("Enter courseId: ");
                    int cid = sc.nextInt();
                    applicationDAO.apply(sid, cid);
                    break;

                case 3:
                    System.out.print("Enter studentId: ");
                    int sid2 = sc.nextInt();
                    System.out.print("Enter courseId: ");
                    int cid2 = sc.nextInt();
                    admissionService.processApplication(sid2, cid2);
                    break;

                case 4:
                    applicationDAO.getAllApplications().forEach(app -> {
                        System.out.println(app.getId() + " | Student " + app.getStudentId() +
                                " | Course " + app.getCourseId() + " | Status " + app.getStatus());
                    });
                    break;

                case 5:
                    System.out.println("Export Options: 1. CSV  2. PDF");
                    int opt = sc.nextInt();
                    if (opt == 1) {
                        CSVExporter.exportApplicationsToCSV("admission_list.csv", applicationDAO);
                    } 
                    else if (opt == 2) {
                        PDFExporter.exportApplicationsToPDF("admission_list.pdf", applicationDAO);
                    }
                    break;

                case 6:
                    System.exit(0);
            }
        }
    }
}
