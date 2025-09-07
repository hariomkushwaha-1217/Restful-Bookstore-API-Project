package dao;

import db.DatabaseConnection;
import model.Course;
import java.sql.*;
import java.util.*;

public class CourseDAO {
    public Course getCourseById(int id) {
        try (Connection con = DatabaseConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Courses WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Course(rs.getInt("id"), rs.getString("name"), rs.getInt("cutoff"));
            }
        } catch (Exception e) { 
        	e.printStackTrace(); 
        }
        return null;
    }
}
