package hajisu;

import java.sql.*;
import java.util.*;
import java.io.*;

public class StudentDAO {
    private Connection conn;

    public StudentDAO() throws Exception {
        Properties props = new Properties();
        FileInputStream fis = new FileInputStream("db.properties");
        props.load(fis);

        String url = props.getProperty("url");
        String user = props.getProperty("user");
        String password = props.getProperty("password");

        conn = DriverManager.getConnection(url, user, password);
    }

    public List<Student> getAllStudents() throws SQLException {
        List<Student> list = new ArrayList<>();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM student");

        while (rs.next()) {
            list.add(new Student(
                rs.getInt("stdno"),
                rs.getString("stdname"),
                rs.getString("phone"),
                rs.getString("email")
            ));
        }
        rs.close();
        stmt.close();
        return list;
    }

    public void updatePhone(String name, String newPhone) throws SQLException {
        String sql = "UPDATE student SET phone = ? WHERE stdname = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, newPhone);
        ps.setString(2, name);
        ps.executeUpdate();
        ps.close();
    }

    public void insertStudent(Student s) throws SQLException {
        String sql = "INSERT INTO student VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, s.getStdno());
        ps.setString(2, s.getStdname());
        ps.setString(3, s.getPhone());
        ps.setString(4, s.getEmail());
        ps.executeUpdate();
        ps.close();
    }

    public void deleteStudent(String name) throws SQLException {
        String sql = "DELETE FROM student WHERE stdname = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, name);
        ps.executeUpdate();
        ps.close();
    }

    public Student findByPhone(String phone) throws SQLException {
        String sql = "SELECT * FROM student WHERE phone = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, phone);
        ResultSet rs = ps.executeQuery();
        Student s = null;
        if (rs.next()) {
            s = new Student(
                rs.getInt("stdno"),
                rs.getString("stdname"),
                rs.getString("phone"),
                rs.getString("email")
            );
        }
        rs.close();
        ps.close();
        return s;
    }
}
