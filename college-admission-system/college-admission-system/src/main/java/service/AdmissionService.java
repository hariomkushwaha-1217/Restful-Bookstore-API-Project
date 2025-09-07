package service;

import dao.StudentDAO;
import dao.CourseDAO;
import dao.ApplicationDAO;
import model.Student;
import model.Course;

public class AdmissionService {
    private StudentDAO studentDAO = new StudentDAO();
    private CourseDAO courseDAO = new CourseDAO();
    private ApplicationDAO appDAO = new ApplicationDAO();

    public void processApplication(int studentId, int courseId) {
        Student student = studentDAO.getStudentById(studentId);
        Course course = courseDAO.getCourseById(courseId);
        if (student == null || course == null) {
            System.out.println("Invalid Student or Course!");
            return;
        }

        if (student.getMarks() >= course.getCutoff()) {
            appDAO.updateStatus(studentId, courseId, "APPROVED");
            System.out.println("Application approved for " + student.getName());
        } 
        else {
            appDAO.updateStatus(studentId, courseId, "REJECTED");
            System.out.println("Application rejected for " + student.getName());
        }
    }
}
