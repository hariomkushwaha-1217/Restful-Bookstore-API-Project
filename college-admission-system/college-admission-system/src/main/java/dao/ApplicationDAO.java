package dao;

import db.DatabaseConnection;
import model.Application;
import java.sql.*;
import java.util.*;

public class ApplicationDAO {
    public void apply(int studentId, int courseId) {
        try (Connection con = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO Applications(student_id,course_id,status) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, studentId);
            ps.setInt(2, courseId);
            ps.setString(3, "PENDING");
            ps.executeUpdate();
            System.out.println("Application submitted!");
        } 
        catch (Exception e) { 
        	e.printStackTrace(); 
        }
    }

    public void updateStatus(int studentId, int courseId, String status) {
        try (Connection con = DatabaseConnection.getConnection()) {
            String sql = "UPDATE Applications SET status=? WHERE student_id=? AND course_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, status);
            ps.setInt(2, studentId);
            ps.setInt(3, courseId);
            ps.executeUpdate();
        } 
        catch (Exception e) { 
        	e.printStackTrace(); 
        }
    }

    public List<Application> getAllApplications() {
        List<Application> list = new ArrayList<>();
        try (Connection con = DatabaseConnection.getConnection()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Applications");
            while (rs.next()) {
                list.add(new Application(rs.getInt("id"), rs.getInt("student_id"), rs.getInt("course_id"), rs.getString("status")));
            }
        } 
        catch (Exception e) { 
        	e.printStackTrace(); 
        }
        return list;
    }
}
