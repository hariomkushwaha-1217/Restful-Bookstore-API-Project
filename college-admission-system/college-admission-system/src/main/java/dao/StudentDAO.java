package dao;

import db.DatabaseConnection;
import model.Student;
import java.sql.*;
import java.util.*;

public class StudentDAO {
    public void addStudent(Student student) {
        try (Connection con = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO Students(name,email,marks) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setInt(3, student.getMarks());
            ps.executeUpdate();
            System.out.println("Student registered successfully!");
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Student getStudentById(int id) {
        try (Connection con = DatabaseConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Students WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Student(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getInt("marks"));
            }
        } 
        catch (Exception e) { 
        	e.printStackTrace(); 
        }
        return null;
    }
}
